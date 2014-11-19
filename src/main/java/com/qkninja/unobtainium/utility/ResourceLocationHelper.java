package com.qkninja.unobtainium.utility;

import com.qkninja.unobtainium.reference.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * @author QKninja
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
