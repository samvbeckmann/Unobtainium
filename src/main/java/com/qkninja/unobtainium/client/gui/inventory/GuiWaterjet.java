package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.inventory.ContainerWaterjet;
import com.qkninja.unobtainium.reference.Colors;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Textures;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Draws the waterjet Gui
 *
 * @author QK ninja
 */
public class GuiWaterjet extends GuiUnobtainium
{
    private TileEntityWaterjet te;

    private static final int PROGRESS_BAR_HEIGHT = 5;
    private static final int PROGRESS_BAR_WIDTH = 200;
    private static final int PROGRESS_BAR_STARTING_X = 6;
    private static final int PROGRESS_BAR_STARTING_Y = 72;

    private static final int WATER_TANK_HEIGHT_WIDTH = 50;
    private static final int WATER_TANK_STARTING_X = 71;
    private static final int WATER_TANK_STARTING_Y = 16;

    private static final int BYPRODUCT_HEIGHT = 51;
    private static final int BYPRODUCT_WIDTH = 6;
    private static final int BYPRODUCT_STARTING_X = 130;
    private static final int BYPRODUCT_STARTING_Y = 15;

    private static final int RECYCLE_HEIGHT_WIDTH = 21;
    private static final int RECYCLE_STARTING_X = 145;
    private static final int RECYCLE_STARTING_Y = 29;

    private static final int ENERGY_BAR_HEIGHT = 50;
    private static final int ENERGY_BAR_WIDTH = 23;
    private static final int ENERGY_BAR_STARTING_X = 9;
    private static final int ENERGY_BAR_STARTING_Y = 16;

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
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = StatCollector.translateToLocal(te.getInventoryName());
        this.fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 5, Colors.LIGHT_GREY);

        int k = (this.width - this.xSize) / 2; // X axis on GUI
        int l = (this.height - this.ySize) / 2; // Y axis on GUI

        int reservoirX = guiLeft + WATER_TANK_STARTING_X;
        int reservoirY = guiTop + WATER_TANK_STARTING_Y;

        int byproductX = guiLeft + BYPRODUCT_STARTING_X;
        int byproductY = guiTop + BYPRODUCT_STARTING_Y;

        int recycleX = guiLeft + RECYCLE_STARTING_X;
        int recycleY = guiTop + RECYCLE_STARTING_Y;

        /* Render Reservoir Hover Text */
        if (mouseX > reservoirX && mouseX < reservoirX + WATER_TANK_HEIGHT_WIDTH && mouseY > reservoirY &&
                mouseY < reservoirY + WATER_TANK_HEIGHT_WIDTH)
        {
            List<String> list = new ArrayList<String>();
            if (te.getReservoirAmount() != 0)
            {
                list.add(I18n.format(Names.GuiElements.TANK_AMOUNT, te.getReservoirAmount()));
            } else
            {
                list.add(I18n.format(Names.GuiElements.TANK_EMPTY));
            }
            this.drawHoveringText(list, mouseX - k, mouseY - l, this.fontRendererObj);
        }

        /* Render Byproduct Hover Text */
        if (mouseX > byproductX && mouseX < byproductX + BYPRODUCT_WIDTH && mouseY > byproductY &&
                mouseY < byproductY + BYPRODUCT_HEIGHT)
        {
            List<String> list = new ArrayList<String>();
            if (te.hasByproduct())
            {
                list.add(te.getByproductFluid().getLocalizedName());
                list.add(I18n.format(Names.GuiElements.TANK_AMOUNT, te.getByproductAmount()));
            } else
            {
                list.add(I18n.format(Names.GuiElements.TANK_EMPTY));
            }
            this.drawHoveringText(list, mouseX - k, mouseY - l, this.fontRendererObj);
        }

        /* Render Recycler Hover Text */
        if (mouseX > recycleX && mouseX < recycleX + RECYCLE_HEIGHT_WIDTH && mouseY > recycleY &&
                mouseY < recycleY + RECYCLE_HEIGHT_WIDTH)
        {
            if (te.hasRecycler())
            {
                List<String> list = new ArrayList<String>();
                list.add(I18n.format(Names.GuiElements.RECYCLER_ACTIVE));
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

        /* Drawing the Progress Bar */
        if (te.getCutProgress() > 0)
        {
            int cutProgress = this.te.getCutProgressScaled(PROGRESS_BAR_WIDTH);
            this.drawTexturedModalRect(guiLeft + PROGRESS_BAR_STARTING_X, guiTop + PROGRESS_BAR_STARTING_Y, 0, 166,
                    cutProgress + 1, PROGRESS_BAR_HEIGHT);
        }

        /* Drawing Water Tank */
        int waterScaled = te.getReservoirAmountScaled(WATER_TANK_HEIGHT_WIDTH); // Should be scaled value
        this.drawTexturedModalRect(guiLeft + WATER_TANK_STARTING_X,
                guiTop + WATER_TANK_STARTING_Y + WATER_TANK_HEIGHT_WIDTH - waterScaled, 176,
                WATER_TANK_HEIGHT_WIDTH - waterScaled, WATER_TANK_HEIGHT_WIDTH, waterScaled);

        /* Drawing Byproduct Bar */
        int byproductScaled = te.getByproductScaled(BYPRODUCT_HEIGHT);
        this.drawTexturedModalRect(guiLeft + BYPRODUCT_STARTING_X,
                guiTop + BYPRODUCT_STARTING_Y + BYPRODUCT_HEIGHT - byproductScaled, 226,
                BYPRODUCT_HEIGHT - byproductScaled, BYPRODUCT_WIDTH, byproductScaled);

        /* Drawing Recycle Symbol */
        if (te.hasRecycler())
        {
            this.drawTexturedModalRect(guiLeft + RECYCLE_STARTING_X, guiTop + RECYCLE_STARTING_Y, 176, 50,
                    RECYCLE_HEIGHT_WIDTH, RECYCLE_HEIGHT_WIDTH);
        }

        /* Drawing the Energy Bars */
        int energy = 0; // Should be a scaled value when energy is added
        this.drawTexturedModalRect(guiLeft + ENERGY_BAR_STARTING_X,
                guiTop + ENERGY_BAR_STARTING_Y + ENERGY_BAR_HEIGHT- energy, 232,
                ENERGY_BAR_HEIGHT - energy, ENERGY_BAR_WIDTH, energy);

        GL11.glDisable(GL11.GL_BLEND);
    }
}
