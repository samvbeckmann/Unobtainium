package com.qkninja.unobtainium.reference;

import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

/**
 * Contains asset locations for various textures.
 */
public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = "textures/gui/";
        public static final ResourceLocation VAT = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "vat.png");
    }
}
