package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.item.ItemLynguriumGem;
import com.qkninja.unobtainium.item.ItemUnobtainium;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author QKninja
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemUnobtainium LynguriumGem = new ItemLynguriumGem();

    public static void init()
    {
        GameRegistry.registerItem(LynguriumGem, "lyguriumGem");
    }
}
