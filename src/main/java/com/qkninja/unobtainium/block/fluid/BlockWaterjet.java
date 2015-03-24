package com.qkninja.unobtainium.block.fluid;

import com.qkninja.unobtainium.Unobtainium;
import com.qkninja.unobtainium.block.BlockUnobtainium;
import com.qkninja.unobtainium.reference.GUIs;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * Defines the waterjet block
 *
 * @author QK ninja
 */
public class BlockWaterjet extends BlockUnobtainium implements ITileEntityProvider
{
    public BlockWaterjet()
    {
        super(Material.rock);
        this.setBlockName(Names.Blocks.WATERJET);
        this.setHardness(2.0f);
    }

    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityWaterjet();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
    {
        if (entityPlayer.getHeldItem() != null && entityPlayer.getHeldItem().getItem() == (Items.water_bucket))
        {
            TileEntityWaterjet te = (TileEntityWaterjet) world.getTileEntity(x, y, z);
            if (te.getReservoirAmount() + 1000 < TileEntityWaterjet.TOTAL_RESERVOIR_SPACE)
            {
                te.fillResevoir(new FluidStack(FluidRegistry.WATER, 1000));
                if (!entityPlayer.capabilities.isCreativeMode)
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem,
                            new ItemStack(Items.bucket, 1));
            }
            return true;
        } else if (world.isRemote)
        {
            entityPlayer.openGui(Unobtainium.instance, GUIs.WATERJET.ordinal(), world, x, y, z);
            return true;
        } else
        {
            TileEntityWaterjet tileEntityWaterjet = (TileEntityWaterjet) world.getTileEntity(x, y, z);

            if (tileEntityWaterjet != null)
            {
                entityPlayer.openGui(Unobtainium.instance, GUIs.WATERJET.ordinal(), world, x, y, z);
            }
            return true;
        }
    }
}
