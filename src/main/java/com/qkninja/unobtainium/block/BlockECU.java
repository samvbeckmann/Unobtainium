package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityECU;
import com.qkninja.unobtainium.tileentity.TileEntityWaterRecycler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockECU extends BlockUnobtainium implements ITileEntityProvider
{
    public BlockECU()
    {
        super(Material.rock);
        this.setBlockName(Names.Blocks.ECU);
        this.setHardness(2.0f);
        this.setBlockBounds(0.1825F, 0.0F, 0.0625F, 0.8125F, 0.85F, 0.9375F);
    }

    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityECU();
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
