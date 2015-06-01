package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.inventory.ContainerFusionVat;
import com.qkninja.unobtainium.reference.Colors;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Textures;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates the Gui for the Fusion Vat.
 */
public class GuiFusionVat extends GuiUnobtainium
{
    private TileEntityVat tileEntityVat;

    private static final int TANK_SPHERE_SIZE = 29;
    private static final int TANK_STARTING_X = 129;
    private static final int TANK_STARTING_Y = 43;

    private static final int ECU_WIDTH = 14;
    private static final int ECU_HEIGHT = 16;
    private static final int ECU_STARTING_X = 137;
    private static final int ECU_STARTING_Y = 17;

    public GuiFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat vat)
    {
        super(new ContainerFusionVat(inventoryPlayer, vat), Textures.Gui.VAT);
        tileEntityVat = vat;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = StatCollector.translateToLocal(tileEntityVat.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 5, Colors.LIGHT_GREY);

        int k = (this.width - this.xSize) / 2; // X axis on GUI
        int l = (this.height - this.ySize) / 2; // Y axis on GUI

        int tankX = guiLeft + TANK_STARTING_X;
        int tankY = guiTop + TANK_STARTING_Y;

        int ecuX = guiLeft + ECU_STARTING_X;
        int ecuY = guiTop + ECU_STARTING_Y;

        // Render Tank Hover Text
        if (mouseX > tankX && mouseX < tankX + TANK_SPHERE_SIZE && mouseY > tankY && mouseY < tankY + TANK_SPHERE_SIZE)
        {
            List<String> list = new ArrayList<String>();
            if (tileEntityVat.hasFluid())
            {
                list.add(tileEntityVat.getTankFluid().getLocalizedName());
                list.add(I18n.format(Names.GuiElements.TANK_AMOUNT, tileEntityVat.getTankAmount()));
            } else
            {
                list.add(I18n.format(Names.GuiElements.TANK_EMPTY));
            }
            this.drawHoveringText(list, mouseX - k, mouseY - l, this.fontRendererObj);
        }

        // Render ECU_ACTIVE Hover Text
        if (mouseX > ecuX && mouseX < ecuX + ECU_WIDTH && mouseY > ecuY && mouseY < ecuY + ECU_HEIGHT)
        {
            if (tileEntityVat.hasECU())
            {
                List<String> list = new ArrayList<String>();
                list.add(I18n.format(Names.GuiElements.ECU_ACTIVE));
                this.drawHoveringText(list, mouseX - k, mouseY - l, this.fontRendererObj);
            }
        }
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

        // Draw Tank fill
        int tankScaled = tileEntityVat.getTankScaled(TANK_SPHERE_SIZE);
        this.drawTexturedModalRect(guiLeft + TANK_STARTING_X,
                guiTop + TANK_STARTING_Y + TANK_SPHERE_SIZE - tankScaled,
                176, 86 + TANK_SPHERE_SIZE - tankScaled,
                TANK_SPHERE_SIZE, tankScaled);

        // Draw cooling icon
        if (tileEntityVat.hasECU())
            drawTexturedModalRect(guiLeft + ECU_STARTING_X, guiTop + ECU_STARTING_Y, 195, 55, ECU_WIDTH, ECU_HEIGHT);

        GL11.glDisable(GL11.GL_BLEND);
    }
}
