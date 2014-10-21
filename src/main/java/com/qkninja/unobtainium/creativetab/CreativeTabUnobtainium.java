package com.qkninja.unobtainium.creativetab;

import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Sam on 2014-10-20.
 */
public class CreativeTabUnobtainium
{
    public static final CreativeTabs UNOBTAINIUM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.LynguriumGem;
        }
    };
}
