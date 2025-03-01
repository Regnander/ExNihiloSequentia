package novamachina.exnihilosequentia.common.item.mesh;

import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.fml.RegistryObject;
import novamachina.exnihilosequentia.common.utility.Config;

public enum EnumMesh implements IStringSerializable, IExtensibleEnum {
    NONE(0, "none", 0), STRING(1, "string", Config.getMeshStringValue()), FLINT(2, "flint", Config.getMeshFlintValue()), IRON(3, "iron", Config.getMeshIronValue()), DIAMOND(4, "diamond", Config.getMeshDiamondValue()), EMERALD(5, "emerald", Config.getMeshEmeraldValue()), NETHERITE(6, "netherite", Config.getMeshNetheriteValue());

    private final int id;
    private final int maxDamage;
    private final String name;
    private RegistryObject<Item> registryObject;

    EnumMesh(int id, String name, int maxDamage) {
        this.id = id;
        this.name = name;
        this.maxDamage = maxDamage;
    }

    public static EnumMesh create(String enumName, int id, String name, int maxDamage) {
        throw new IllegalStateException("Enum not extended");
    }

    public static EnumMesh getMeshFromName(String name) {
        for (EnumMesh mesh : EnumMesh.values()) {
            if (mesh.getName().equals(name)) {
                return mesh;
            }
        }
        return NONE;
    }

    public int getId() {
        return id;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public String getMeshName() {
        return "mesh_" + name;
    }

    public String getName() {
        return name;
    }

    public RegistryObject<Item> getRegistryObject() {
        return registryObject;
    }

    public void setRegistryObject(RegistryObject<Item> registryObject) {
        this.registryObject = registryObject;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
