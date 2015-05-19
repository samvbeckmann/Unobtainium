package com.qkninja.unobtainium.client.model;

import com.qkninja.unobtainium.utility.ColorHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;

/**
 * Created by sam on 5/19/15.
 */
public class ModelWaterjetWater extends ModelBase
{
    public void render()
    {

        Tessellator tessellator = Tessellator.instance;

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        IIcon icon = FluidRegistry.WATER.getIcon();
        ColorHelper color = new ColorHelper(FluidRegistry.WATER.getColor());

        double length = 1.0;
        double width = 1.0;
        double x = 0 - width / 2;
        double y = 0;
        double z = 0 - length / 2;

        double minU = (double) icon.getMinU();
        double maxU = (double) icon.getMaxU();
        double minV = (double) icon.getMinV();
        double maxV = (double) icon.getMaxV();

        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(color.r, color.g, color.b, color.a);
        tessellator.addVertexWithUV(x + width, y, z + length, minU, minV);
        tessellator.addVertexWithUV(x + width, y, z, minU, maxV);
        tessellator.addVertexWithUV(x, y, z, maxU, maxV);
        tessellator.addVertexWithUV(x, y, z + length, maxU, minV);
        tessellator.draw();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
