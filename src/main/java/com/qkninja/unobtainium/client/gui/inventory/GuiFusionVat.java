package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.inventory.ContainerFusionVat;
import com.qkninja.unobtainium.reference.Colors;
import com.qkninja.unobtainium.reference.Textures;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Creates the Gui for the Fusion Vat.
 */
public class GuiFusionVat extends GuiUnobtainium
{
    private TileEntityVat tileEntityVat;

    public GuiFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat vat)
    {
        super(new ContainerFusionVat(inventoryPlayer, vat), Textures.Gui.VAT);
        tileEntityVat = vat;
    }

    // Everything rendered in front of the items
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = StatCollector.translateToLocal(tileEntityVat.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 3, Colors.LIGHT_GREY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        super.drawGuiContainerBackgroundLayer(opacity, x, y);

        if (tileEntityVat.isFusing())
        {
            int fuseProgress = this.tileEntityVat.getFuseProgressScaled(31);
            this.drawTexturedModalRect(guiLeft + 78, guiTop + 22, 176, 55, 19, fuseProgress + 1);
        }

        if (tileEntityVat.hasWaste())
        {
            int waste = tileEntityVat.getWasteScaled(30);
            this.drawTexturedModalRect(guiLeft + 100, guiTop + 20 + 30 - waste, 176, 80, 30, waste);
        }
    }
}
