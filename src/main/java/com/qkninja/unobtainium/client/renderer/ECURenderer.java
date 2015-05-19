package com.qkninja.unobtainium.client.renderer;

import com.qkninja.unobtainium.client.model.ECUModel;
import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by sam on 5/19/15.
 */
public class ECURenderer extends TileEntitySpecialRenderer
{
    private final ECUModel model;

    public ECURenderer()
    {
        this.model = new ECUModel();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        ResourceLocation textures = ResourceLocationHelper.getResourceLocation("textures/blocks/waterRecycler.png"); // TODO
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    /* Perhaps makes the lighting right */
//    private void adjustLightFixture(World world, int i, int j, int k, Block block)
//    {
//        Tessellator tess = Tessellator.instance;
//        float brightness = block.getLightValue(world, i, j, k);
//        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
//        int modulousModifier = skyLight % 65536;
//        int divModifier = skyLight / 65536;
//        tess.setColorOpaque_F(brightness, brightness, brightness);
//        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
//    }
}
