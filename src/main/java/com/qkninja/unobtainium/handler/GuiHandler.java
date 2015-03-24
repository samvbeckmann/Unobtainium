package com.qkninja.unobtainium.handler;

import com.qkninja.unobtainium.client.gui.inventory.GuiFusionVat;
import com.qkninja.unobtainium.client.gui.inventory.GuiWaterjet;
import com.qkninja.unobtainium.inventory.ContainerFusionVat;
import com.qkninja.unobtainium.inventory.ContainerWaterjet;
import com.qkninja.unobtainium.reference.GUIs;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Determines which gui/container to open when sent an id.
 */
public class GuiHandler implements IGuiHandler
{
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (GUIs.values()[ID])
        {
            case VAT:
                TileEntityVat tileEntityVat = (TileEntityVat) world.getTileEntity(x, y, z);
                return new ContainerFusionVat(player.inventory, tileEntityVat);
            case WATERJET:
                TileEntityWaterjet te = (TileEntityWaterjet) world.getTileEntity(x, y, z);
                return new ContainerWaterjet(player.inventory, te);

            default:
                throw new IllegalArgumentException("No GUI with ID " + ID);
        }
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (GUIs.values()[ID])
        {
            case VAT:
                TileEntityVat tileEntityVat = (TileEntityVat) world.getTileEntity(x, y, z);
                return new GuiFusionVat(player.inventory, tileEntityVat);
            case WATERJET:
                TileEntityWaterjet te = (TileEntityWaterjet) world.getTileEntity(x, y, z);
                return new GuiWaterjet(player.inventory, te);

            default:
                throw new IllegalArgumentException("No GUI with ID " + ID);
        }
    }
}
