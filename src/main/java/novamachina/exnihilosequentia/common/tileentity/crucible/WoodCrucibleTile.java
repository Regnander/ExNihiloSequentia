package novamachina.exnihilosequentia.common.tileentity.crucible;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.state.properties.BlockStateProperties;
import novamachina.exnihilosequentia.api.ExNihiloRegistries;
import novamachina.exnihilosequentia.common.init.ExNihiloTiles;
import novamachina.exnihilosequentia.common.utility.Config;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class WoodCrucibleTile extends BaseCrucibleTile {

    public WoodCrucibleTile() {
        super(ExNihiloTiles.CRUCIBLE_WOOD.get());
    }

    @Override
    public void tick() {
        if (level.isClientSide()) {
            return;
        }

        inventory.setCrucibleHasRoom(tank.getFluidAmount() < MAX_FLUID_AMOUNT);
        ticksSinceLast++;

        if (ticksSinceLast >= Config.getTicksBetweenMelts()) {
            ticksSinceLast = 0;

            int heat = getHeat();
            if (heat <= 0) {
                return;
            }
            if (solidAmount <= 0) {
                if (!inventory.getStackInSlot(0).isEmpty()) {
                    currentItem = inventory.getStackInSlot(0).copy();
                    inventory.getStackInSlot(0).shrink(1);

                    if (inventory.getStackInSlot(0).isEmpty()) {
                        inventory.setStackInSlot(0, ItemStack.EMPTY);
                    }

                    solidAmount = ExNihiloRegistries.CRUCIBLE_REGISTRY.findRecipeByItemStack(currentItem)
                        .getAmount();
                } else {
                    return;
                }
            }

            if (!inventory.getStackInSlot(0).isEmpty() && inventory.getStackInSlot(0)
                .sameItem(currentItem)) {
                while (heat > solidAmount && !inventory.getStackInSlot(0).isEmpty()) {
                    solidAmount += ExNihiloRegistries.CRUCIBLE_REGISTRY.findRecipeByItemStack(currentItem)
                        .getAmount();
                    inventory.getStackInSlot(0).shrink(1);

                    if (inventory.getStackInSlot(0).isEmpty()) {
                        inventory.setStackInSlot(0, ItemStack.EMPTY);
                    }
                }
            }

            if (heat > solidAmount) {
                heat = solidAmount;
            }

            if (heat > 0 && ExNihiloRegistries.CRUCIBLE_REGISTRY
                .isMeltableByItemStack(currentItem, getCrucibleType().getLevel())) {
                FluidStack fluidStack = new FluidStack(
                    ExNihiloRegistries.CRUCIBLE_REGISTRY.findRecipeByItemStack(currentItem).getResultFluid(), heat);
                int filled = tank.fill(fluidStack, FluidAction.EXECUTE);
                solidAmount -= filled;
            }
        }
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 2);
    }

    @Override
    public int getHeat() {
        return Math.max(super.getHeat(), Config.getWoodHeatRate());
    }

    @Override
    public CrucilbeTypeEnum getCrucibleType() {
        return CrucilbeTypeEnum.WOOD;
    }

    @Override
    public int getSolidAmount() {
        if(!currentItem.isEmpty()) {
            int itemCount = inventory.getStackInSlot(0).getCount();
            return solidAmount +
                    (itemCount * ExNihiloRegistries.CRUCIBLE_REGISTRY.findRecipeByItemStack(currentItem)
                            .getAmount());
        }
        return solidAmount;
    }

    @Override
    public boolean canAcceptFluidTemperature(FluidStack fluidStack) {
        return fluidStack.getFluid().getAttributes().getTemperature() <= Config.getWoodBarrelMaxTemp();
    }

}
