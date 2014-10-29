package com.qkninja.unobtainium.item;

import com.qkninja.unobtainium.creativetab.CreativeTabUnobtainium;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

/**
 * @author QKninja
 */
public class ItemQuicksilverBucket extends ItemBucket
{
    public ItemQuicksilverBucket(Block fluid)
    {
        super(fluid);
        setUnlocalizedName(Names.Items.QUICKSILVER_BUCKET);
        setCreativeTab(CreativeTabUnobtainium.UNOBTAINIUM_TAB);

    }
}
