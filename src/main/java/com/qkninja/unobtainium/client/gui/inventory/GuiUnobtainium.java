package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * Generic Gui class for Unobtainium.
 * @deprecated Not currently in use.
 */
public class GuiUnobtainium extends GuiContainer
{
    protected ResourceLocation guiTexture;

    public GuiUnobtainium(Container container)
    {
        super(container);
    }

    public GuiUnobtainium(Container container, String texture)
    {
        this(container, ResourceLocationHelper.getResourceLocation(texture));
    }

    public GuiUnobtainium(Container container, ResourceLocation guiTexture_)
    {
        super(container);
        this.guiTexture = guiTexture_;
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public void drawScreen(int x, int y, float partialTick)
    {
        super.drawGuiContainerForegroundLayer(x, y);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        super.drawGuiContainerForegroundLayer(x, y);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTick, int x, int y) {}

}
