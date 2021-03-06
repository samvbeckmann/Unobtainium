package com.qkninja.unobtainium.reference;

/**
 * Reference class for all the String names in the mod.
 */
public final class Names
{
    public static final class Keys
    {
        public static final String CATEGORY = "keys.unobtainium.category";
        public static final String CHARGE = "keys.unobtainium.charge";
        public static final String RELEASE = "keys.unobtainium.release";
    }

    public static final class Blocks
    {
        public static final String LYNGURIUM_ORE = "lynguriumOre";
        public static final String MITHRIL_ORE = "mithrilOre";
        public static final String ANTIMETAL_ORE = "antiMetalOre";
        public static final String MITHRIL = "mithril";
        public static final String ORICHALCUM = "orichalcum";
        public static final String GALVORN = "galvorn";
        public static final String CAVORITE = "cavorite";
        public static final String OIL_RESIN = "oilResin";
        public static final String PLASTIC = "plastic";
        public static final String FUSION_VAT = "fusionVat";
        public static final String ECU = "ECU";
        public static final String WATERJET = "waterjet";
        public static final String WATER_RECYCLER = "waterRecycler";
    }

    public static final class Items
    {
        public static final String LYNGURIUM_GEM = "lynguriumGem";
        public static final String MITHRIL_INGOT = "mithrilIngot";
        public static final String GALVORN_INGOT = "galvornIngot";
        public static final String ORICHALCUM_INGOT = "orichalcumIngot";
        public static final String CAVORITE_INGOT = "cavoriteIngot";
        public static final String RESIN_CHUNK = "resinChunk";
        public static final String PLASTIC_CHUNK = "plasticChunk";
        public static final String QUICKSILVER_BUCKET = "quicksilverBucket";
        public static final String VIBRANIUM_BUCKET = "vibraniumBucket";
        public static final String ADAMANTIUM_BUCKET = "adamantiumBucket";
    }

    public static final class Fluids
    {
        public static final String QUICKSILVER_FLUID = "fluidQuicksilver";
        public static final String VIBRANIUM_FLUID = "fluidVibranium";
        public static final String ADAMANTIUM_FLUID = "fluidAdamantium";
        public static final String UNOBTAINIUM_FLUID = "fluidUnobtainium";
    }

    public static final class TileEntities
    {
        public static final String TILE_FUSION_VAT = "tileEntityVat";
        public static final String TILE_ECU = "tileEntityECU";
        public static final String TILE_WATERJET = "tileEntityWaterjet";
        public static final String TILE_WATER_RECYCLER = "tileWaterRecycler";
    }

    public static final class NBT
    {
        public static final String ITEMS = "Items";
        public static final String CUSTOM_NAME = "CustomName";
        public static final String RESERVOIR = "Reservoir";
        public static final String BYPRODUCT = "Byproduct";
        public static final String PROGRESS = "Progress";
    }

    public static final class Containers
    {
        public static final String VAT = "container.unobtainium:" + Blocks.FUSION_VAT;
        public static final String WATERJET = "container.unobtainium:" + Blocks.WATERJET;
    }

    public static final class Channels
    {
        public static final String DESCRIPTION_CHANNEL = "Description";
    }

    public static final class GuiElements
    {
        public static final String GUI_PREFIX = "unobtainium.gui.";

        public static final String TANK_AMOUNT = GUI_PREFIX + "tankamount";
        public static final String TANK_EMPTY = GUI_PREFIX + "tankempty";
        public static final String ECU_ACTIVE = GUI_PREFIX + "ecuactive";
        public static final String RECYCLER_ACTIVE = GUI_PREFIX + "recycleractive";
    }

    public static final class Waila
    {
        public static final String WAILA_PERCENT_FUSED = "unobtainium.waila.percentfused";
        public static final String WAILA_TANK_STATS = "unobtainium.waila.tankstats";
        public static final String WAILA_PERCENT_CUT = "unobtainium.waila.percentcut";
        public static final String WAILA_RESERVOIR_STATS = "unobtainium.waila.reservoirstats";
    }
}
