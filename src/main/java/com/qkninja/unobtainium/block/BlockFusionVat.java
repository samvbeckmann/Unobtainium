package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.Unobtainium;
import com.qkninja.unobtainium.reference.GUIs;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFusionVat extends BlockUnobtainium implements ITileEntityProvider
{

    public BlockFusionVat(int meta)
    {
        super(Material.rock);
        this.setBlockName(Names.Blocks.FUSION_VAT);
        this.setHardness(2.0f);
    }

    /**
     * Makes the block indestructible if metadata is 1
     *
     * @param world
     * @param x
     * @param y
     * @param z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        int metadata = world.getBlockMetadata(x, y, z);
        if (metadata == 1)
            this.setHardness(-1);
        else
            this.setHardness(2.0f);
    }


    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityVat();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            entityPlayer.openGui(Unobtainium.instance, GUIs.VAT.ordinal(), world, x, y, z);
            return true;
        }
        else
        {
            TileEntityVat tileEntityVat = (TileEntityVat) world.getTileEntity(x, y, z);

            if (tileEntityVat != null)
            {
                entityPlayer.openGui(Unobtainium.instance, GUIs.VAT.ordinal(), world, x, y, z);
            }
            return true;
        }
    }

}
