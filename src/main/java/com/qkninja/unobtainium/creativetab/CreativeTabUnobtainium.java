package com.qkninja.unobtainium.creativetab;

import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Defines a new tab in the creative menu
 */
public class CreativeTabUnobtainium
{
    public static final CreativeTabs UNOBTAINIUM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.lynguriumGem;
        }
    };
}
