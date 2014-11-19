package com.qkninja.unobtainium.handler;

import com.qkninja.unobtainium.client.gui.inventory.GuiFusionVat;
import com.qkninja.unobtainium.inventory.ContainerFusionVat;
import com.qkninja.unobtainium.reference.GUIs;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author QKninja
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == GUIs.VAT.ordinal())
        {
            TileEntityVat tileEntityVat = (TileEntityVat) world.getTileEntity(x, y, z);
            return new ContainerFusionVat(entityPlayer.inventory, tileEntityVat);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == GUIs.VAT.ordinal())
        {
            TileEntityVat tileEntityVat = (TileEntityVat) world.getTileEntity(x, y, z);
            return new GuiFusionVat(entityPlayer.inventory, tileEntityVat);
        }

        return null;
    }
}
