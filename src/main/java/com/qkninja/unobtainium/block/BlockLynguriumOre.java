package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.Unobtainium;
import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.item.ItemLynguriumGem;
import com.qkninja.unobtainium.item.ItemUnobtainium;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Sam on 2014-10-22.
 */
public class BlockLynguriumOre extends BlockUnobtainium
{
    public BlockLynguriumOre()
    {
        super();
        this.setBlockName(Names.Blocks.LYNGURIUM_ORE);
        this.setHardness(1.0F); //temporary

    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return this == ModBlocks.lynguriumOre ? ModItems.LynguriumGem : Item.getItemFromBlock(this);
    }
}
