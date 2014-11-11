package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author QKninja
 */
public class BlockFusionVat extends BlockUnobtainium implements ITileEntityProvider
{

    public BlockFusionVat()
    {
        super(Material.rock);
    }

    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityVat();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
    {
        TileEntityVat teVat = (TileEntityVat) world.getTileEntity(x, y, z);
        teVat.addClick();
        return true;
    }

}
