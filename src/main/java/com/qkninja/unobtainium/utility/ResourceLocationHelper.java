package com.qkninja.unobtainium.utility;

import com.qkninja.unobtainium.reference.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Various methods for getting a resources location from file name.
 */
public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
    }
}
