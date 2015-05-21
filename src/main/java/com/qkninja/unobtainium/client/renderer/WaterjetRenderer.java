package com.qkninja.unobtainium.client.renderer;

import com.qkninja.unobtainium.client.model.ModelWaterjetWater;
import com.qkninja.unobtainium.client.model.WaterjetModel;
import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by sam on 5/19/15.
 */
public class WaterjetRenderer extends TileEntitySpecialRenderer
{
    private final WaterjetModel model;

    public WaterjetRenderer()
    {
        this.model = new WaterjetModel();
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
        drawWater(x, y, z, scale);

    }

    private void drawWater(double x, double y, double z, float scale)
    {
        ModelWaterjetWater water = new ModelWaterjetWater();

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.6F, (float) z + 0.45F);
        GL11.glScalef(0.8F, 1.0F, 0.7F);

        bindTexture(TextureMap.locationBlocksTexture);

        water.render();

        GL11.glPopMatrix();
    }
}
