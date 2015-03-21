package com.qkninja.unobtainium.client.gui.inventory;

import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Generic Gui class for Unobtainium.
 */
public abstract class GuiUnobtainium extends GuiContainer
{
    private ResourceLocation guiTexture;

    /**
     * Constructor with texture given as String.
     *
     * @param container The container for which the gui is being constructed.
     * @param texture   A string that contains the location of the gui texture.
     */
    public GuiUnobtainium(Container container, String texture)
    {
        this(container, ResourceLocationHelper.getResourceLocation(texture));
    }

    /**
     * Constructor with texture given as ResourceLocation.
     *
     * @param container   The container for with the gui is being constructed
     * @param guiTexture_ A ResourceLocation of the the gui texture
     */
    public GuiUnobtainium(Container container, ResourceLocation guiTexture_)
    {
        super(container);
        this.guiTexture = guiTexture_;
    }

    protected void drawGuiContainerBackgroundLayer(float partialTick, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(guiTexture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }

}
