package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * @author QKninja
 */

public class BlockOilResin extends BlockUnobtainium
{
    public BlockOilResin()
    {
        super(Material.clay);
        setBlockName(Names.Blocks.OIL_RESIN);
        setHardness(1.0F);
        setResistance(2.0F);
        setStepSound(soundTypeGravel);
        setHarvestLevel("shovel", 0);


    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return this == ModBlocks.oilResin ? ModItems.resinChunk : Item.getItemFromBlock(this);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 4;
    }
}
