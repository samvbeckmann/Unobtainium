package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.inventory.ContainerFusionVat;
import com.qkninja.unobtainium.reference.Colors;
import com.qkninja.unobtainium.reference.Textures;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Creates the Gui for the Fusion Vat.
 */
public class GuiFusionVat extends GuiUnobtainium
{
    private TileEntityVat tileEntityVat;

    private static final int WASTE_SPHERE_SIZE = 29;

    public GuiFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat vat)
    {
        super(new ContainerFusionVat(inventoryPlayer, vat), Textures.Gui.VAT);
        tileEntityVat = vat;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = StatCollector.translateToLocal(tileEntityVat.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 4, Colors.LIGHT_GREY);
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

        GL11.glEnable(GL11.GL_BLEND);

        if (tileEntityVat.isFusing()) // Draw fusion progress bar
        {
            int fuseProgress = this.tileEntityVat.getFuseProgressScaled(31);
            this.drawTexturedModalRect(guiLeft + 78, guiTop + 22, 176, 55, 19, fuseProgress + 1);
        }

        // Draw Waste fill
        if (tileEntityVat.hasWaste())
        {
            int waste = tileEntityVat.getWasteScaled(WASTE_SPHERE_SIZE);
            this.drawTexturedModalRect(guiLeft + 129, guiTop + 43 + WASTE_SPHERE_SIZE - waste,
                    176, 86 + WASTE_SPHERE_SIZE - waste,
                    WASTE_SPHERE_SIZE, waste);
        }

        // Draw cooling icon
        if (tileEntityVat.hasECU())
            drawTexturedModalRect(guiLeft + 136, guiTop + 17, 195, 55, 14, 16);

        GL11.glDisable(GL11.GL_BLEND);

    }
}
