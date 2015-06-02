package com.qkninja.unobtainium.reference;

/**
 * Created by SAM on 6/1/2015.
 */
public final class Messages
{
    public static final class Configuration // TODO See if these can be localized
    {
        public static final String WATERJET_DRAIN_TICK = "waterjetDrainTick";
        public static final String WATERJET_DRAIN_TICK_DESCRIPTION = "How much water (mb) the Waterjet uses in one operation tick";

        public static final String RECYCLER_MULTIPLIER = "recyclerMultiplier";
        public static final String RECYCLER_MULTIPLIER_DESCRIPTION = "Uses that require water are multiplied by this factor when a water recycler is in use";

        public static final String WATERJET_RESERVOIR_SIZE = "waterjetReservoirSize";
        public static final String WATERJET_RESERVOIR_SIZE_DESCRIPTION = "How much water (mb) the waterjet's reservoir can hold";

        public static final String WATERJET_BYPRODUCT_SIZE = "waterjetByproductSize";
        public static final String WATERJET_BYPRODUCT_SIZE_DESCRIPTION = "How large (mb) the waterjet's byproduct tank is";

        public static final String VAT_COOK_TIME = "vatCookTime";
        public static final String VAT_COOK_TIME_DESCRIPTION = "Number of ticks a vat takes to perform an operation";

        public static final String VAT_TANK_SIZE = "vatTankSize";
        public static final String VAT_TANK_SIZE_DESCRIPTION = "How large (mb) the vat's tank is";

        public static final String ECU_MULTIPLIER = "ecuMulitplier";
        public static final String ECU_MULTIPLIER_DESCRIPTION = "Processes aided by ECU are speed up by this factor when it is active";
    }
}
