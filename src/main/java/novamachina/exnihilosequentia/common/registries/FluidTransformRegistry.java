package novamachina.exnihilosequentia.common.registries;

import net.minecraft.util.IItemProvider;
import novamachina.exnihilosequentia.api.crafting.fluidtransform.FluidTransformRecipe;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import novamachina.exnihilosequentia.api.registry.IFluidTransformRegistry;
import novamachina.exnihilosequentia.common.utility.ExNihiloLogger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FluidTransformRegistry implements IFluidTransformRegistry {
    private static final ExNihiloLogger logger = new ExNihiloLogger(LogManager.getLogger());

    private final List<FluidTransformRecipe> recipeList = new ArrayList<>();

    private final Map<FluidStack, Map<IItemProvider, Fluid>> fluidResultCache = new HashMap<>();

    @Override
    public boolean isValidRecipe(Fluid fluidInTank, IItemProvider catalyst) {
        return getResult(fluidInTank, catalyst) != Fluids.EMPTY;
    }

    @Override
    public Fluid getResult(Fluid fluidInTank, IItemProvider catalyst) {
        final FluidStack fluidStack = new FluidStack(fluidInTank, FluidAttributes.BUCKET_VOLUME);
        return fluidResultCache
                .computeIfAbsent(fluidStack, k -> new HashMap<>())
                .computeIfAbsent(catalyst.asItem(), k -> {
                    final ItemStack itemStack = new ItemStack(catalyst);
                    return recipeList
                            .stream()
                            .filter(fluidTransformRecipe -> fluidTransformRecipe.getFluidInTank().isFluidEqual(fluidStack))
                            .filter(fluidTransformRecipe -> fluidTransformRecipe.getCatalyst().test(itemStack))
                            .findFirst()
                            .map(FluidTransformRecipe::getResult)
                            .map(FluidStack::getFluid)
                            .orElse(Fluids.EMPTY);
                });
    }

    @Override
    public List<FluidTransformRecipe> getRecipeList() {
        return recipeList;
    }

    @Override
    public void setRecipes(List<FluidTransformRecipe> recipes) {
        logger.debug("Fluid Transform Registry recipes: " + recipes.size());
        recipeList.addAll(recipes);

        fluidResultCache.clear();
    }

    @Override
    public void clearRecipes() {
        recipeList.clear();

        fluidResultCache.clear();
    }
}
