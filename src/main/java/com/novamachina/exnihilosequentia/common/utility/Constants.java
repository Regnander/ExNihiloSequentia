package com.novamachina.exnihilosequentia.common.utility;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class Constants {

    public static class ModInfo {

        public static final String MOD_ID = "exnihilosequentia";
    }

    public static class Blocks {

        public static final String CRUSHED_ANDESITE = "crushed_andesite";
        public static final String CRUSHED_DIORITE = "crushed_diorite";
        public static final String CRUSHED_END_STONE = "crushed_end_stone";
        public static final String CRUSHED_GRANITE = "crushed_granite";
        public static final String CRUSHED_NETHERRACK = "crushed_netherrack";
        public static final String DUST = "dust";
        public static final String END_CAKE = "end_cake";
        public static final String SIEVE = "sieve";
        public static final String WITCH_WATER = "witchwater";
        public static final String INFESTING_LEAVES = "infesting_leaves";
        public static final String INFESTED_LEAVES = "infested_leaves";
        public static final String CRUCIBLE_UNFIRED = "crucible_unfired";
        public static final String CRUCIBLE_FIRED = "crucible_fired";
        public static final String CRUCIBLE_WOOD = "crucible_wood";
        public static final String BARREL_WOOD = "barrel_wood";
        public static final String SEA_WATER = "sea_water";
    }

    public static class Items {

        public static final String CROOK_WOOD = createCrookName("wood");
        public static final String CROOK_STONE = createCrookName("stone");
        public static final String CROOK_ANDESITE = createCrookName("andesite");
        public static final String CROOK_GRANITE = createCrookName("granite");
        public static final String CROOK_DIORITE = createCrookName("diorite");
        public static final String CROOK_GOLD = createCrookName("gold");
        public static final String CROOK_IRON = createCrookName("iron");
        public static final String CROOK_DIAMOND = createCrookName("diamond");
        public static final String CROOK_BONE = createCrookName("bone");
        public static final String CROOK_CLAY_UNCOOKED = createCrookName("clay_uncooked");
        public static final String CROOK_CLAY = createCrookName("clay");
        public static final String CROOK_PRISMARINE = createCrookName("prismarine");
        public static final String CROOK_NETHERRACK = createCrookName("netherrack");
        public static final String CROOK_PURPUR = createCrookName("purpur");
        public static final String CROOK_BLAZE = createCrookName("blaze");
        public static final String SILKWORM = "silkworm";
        public static final String HAMMER_WOOD = createHammerName("wood");
        public static final String HAMMER_STONE = createHammerName("stone");
        public static final String HAMMER_IRON = createHammerName("iron");
        public static final String HAMMER_DIAMOND = createHammerName("diamond");
        public static final String HAMMER_GOLD = createHammerName("gold");
        public static final String SEED_OAK = "oak";
        public static final String SEED_SPRUCE = "spruce";
        public static final String SEED_BIRCH = "birch";
        public static final String SEED_JUNGLE = "jungle";
        public static final String SEED_ACACIA = "acacia";
        public static final String SEED_DARK_OAK = "darkoak";
        public static final String SEED_CACTUS = "cactus";
        public static final String SEED_SUGARCANE = "sugarcane";
        public static final String SEED_CARROT = "carrot";
        public static final String SEED_POTATO = "potato";
        public static final String SEED_SWEET_BERRY = "berry";
        public static final String ANCIENT_SPORE = "ancient_spores";
        public static final String GRASS_SEED = "grass_seeds";
        public static final String COOKED_SILKWORM = "cooked_silkworm";
        public static final String PORCELAIN_CLAY = "porcelain_clay";
        public static final String PEBBLE_STONE = createPebbleName("stone");
        public static final String PEBBLE_GRANITE = createPebbleName("granite");
        public static final String PEBBLE_DIORITE = createPebbleName("diorite");
        public static final String PEBBLE_ANDESITE = createPebbleName("andesite");
        public static final String WITCH_WATER_BUCKET = "bucket_witchwater";
        public static final String CRAFTING_DOLL = "doll_crafting";
        public static final String SEED_KELP = "kelp";
        public static final String SEED_PICKLE = "pickle";
        public static final String SEA_WATER_BUCKET = "bucket_sea_water";
        public static final String BLUE_CORAL_SEED = "seed_blue_coral";
        public static final String PINK_CORAL_SEED = "seed_pink_coral";
        public static final String PURPLE_CORAL_SEED = "seed_purple_coral";
        public static final String RED_CORAL_SEED = "seed_red_coral";
        public static final String YELLOW_CORAL_SEED = "seed_yellow_coral";
        public static final String SEED_BAMBOO = "bamboo";
        public static final String BEEHIVE_FRAME = "beehive_frame";

        private static String createHammerName(String name) {
            return "hammer_" + name;
        }

        private static String createCrookName(String name) {
            return "crook_" + name;
        }

        private static String createPebbleName(String name) {
            return "pebble_" + name;
        }
    }

    public static class Ore {

        public static final String GOLD = "gold";
        public static final String IRON = "iron";
        public static final String COPPER = "copper";
    }

    public static class Fluids {

        public static final String WITCH_WATER = "witchwater";
        public static final String WITCH_WATER_FLOW = "witchwater_flow";
        public static final String SEA_WATER = "sea_water";
        public static final String SEA_WATER_FLOW = "sea_water_flow";
    }

    public static class BarrelModes {
        public static final String EMPTY = "empty";
        public static final String COMPOST = "compost";
        public static final String FLUID = "fluid";
        public static final String BLOCK = "block";
        public static final String MOB = "mob";
        public static final String TRANSFORM = "transform";
    }

    public static class Json {
        public static final Path baseJsonPath = FMLPaths.getOrCreateGameRelativePath(FMLPaths.CONFIGDIR.get()
            .resolve("exnihilosequentia"), "Ex Nihilo: Sequentia Json folder");
        public static String COMPOST_FILE = "CompostRegistry.json";
        public static String FLUID_BLOCK_FILE = "FluidBlockTransformRegistry.json";
        public static String FLUID_TRANSFORM_FILE = "FluidTransformRegistry.json";
        public static String FLUID_ON_TOP_FILE = "FluidOnTopRegistry.json";
        public static String HEAT_FILE = "HeatRegistry.json";
        public static String WOOD_CRUCIBLE_FILE = "WoodCrucibleRegistry.json";
        public static String FIRED_CRUCIBLE_FILE = "FiredCrucibleRegistry.json";
        public static String SIEVE_FILE = "SieveRegistry.json";
        public static String CROOK_FILE = "CrookRegistry.json";
        public static String HAMMER_FILE = "HammerRegistry.json";
    }
}
