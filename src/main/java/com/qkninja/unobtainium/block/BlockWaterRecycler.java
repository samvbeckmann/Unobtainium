package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;

/**
 * Defines the Water Recycler Block
 *
 * @author QK ninja
 */
public class BlockWaterRecycler extends BlockUnobtainium
{
    public BlockWaterRecycler()
    {
        super(Material.rock);
        this.setBlockName(Names.Blocks.WATER_RECYCLER);
        this.setHardness(2.0f);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
