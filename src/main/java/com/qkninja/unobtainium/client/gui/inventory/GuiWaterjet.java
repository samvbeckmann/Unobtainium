package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.inventory.ContainerWaterjet;
import com.qkninja.unobtainium.reference.Colors;
import com.qkninja.unobtainium.reference.Textures;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

/**
 * Draws the waterjet Gui
 *
 * @author QK ninja
 */
public class GuiWaterjet extends GuiUnobtainium
{
    private TileEntityWaterjet te;

    public GuiWaterjet(InventoryPlayer inventoryPlayer, TileEntityWaterjet waterjet)
    {
        super(new ContainerWaterjet(inventoryPlayer, waterjet), Textures.Gui.WATERJET);
        te = waterjet;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     *
     * @param mouseX x position of the mouse
     * @param mouseY y position of the mouse
     */
    @Override
    protected  void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = StatCollector.translateToLocal(te.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 5, Colors.LIGHT_GREY);
    }

    /**
     * Draws the background of the gui.
     *
     * @param opacity opacity that the background should be set at
     * @param x       X position of the mouse
     * @param y       Y position of hte mouse
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        super.drawGuiContainerBackgroundLayer(opacity, x, y);
    }
}
