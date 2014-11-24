package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityECU;
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
    }

    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityECU();
    }
}
