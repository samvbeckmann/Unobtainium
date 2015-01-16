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
public class GuiFusionVat extends GuiContainer
{
    private TileEntityVat tileEntityVat;

    public GuiFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat vat)
    {
        super(new ContainerFusionVat(inventoryPlayer, vat));
        tileEntityVat = vat;
    }

    // Everything rendered in front of the items
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = StatCollector.translateToLocal(tileEntityVat.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, Colors.VERY_DARK_GREY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(Textures.Gui.VAT);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

        if (tileEntityVat.isFusing())
        {
            int progress = this.tileEntityVat.getFuseProgressScaled(24);
            this.drawTexturedModalRect(xStart + 79, yStart + 34, 176, 14, progress+1, 16);
        }
    }
}
