package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * @author QKninja
 */

public class BlockLynguriumOre extends BlockUnobtainium
{
    public BlockLynguriumOre()
    {
        super();
        setBlockName(Names.Blocks.LYNGURIUM_ORE);
        setHardness(3.0F);
        setResistance(5.0F);

    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return this == ModBlocks.lynguriumOre ? ModItems.lynguriumGem : Item.getItemFromBlock(this);
    }
}
