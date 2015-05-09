package com.qkninja.unobtainium.client.renderer;

import com.qkninja.unobtainium.client.model.WaterRecyclerModel;
import com.qkninja.unobtainium.utility.ResourceLocationHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by sam on 5/8/15.
 */
public class WaterRecyclerRenderer
{
    private final WaterRecyclerModel model;

    public WaterRecyclerRenderer()
    {
        this.model = new WaterRecyclerModel();
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        ResourceLocation textures = ResourceLocationHelper.getResourceLocation("textures/blocks/waterRecycler.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    private void adjustLightFixture(World world, int i, int j, int k, Block block)
    {

    }
}
