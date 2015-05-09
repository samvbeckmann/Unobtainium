package com.qkninja.unobtainium.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * WaterRecycler - QK Ninja
 * Created using Tabula 4.1.1
 */
public class WaterRecyclerModel extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape2_1;
    public ModelRenderer shape2_2;
    public ModelRenderer shape2_3;
    public ModelRenderer shape7;
    public ModelRenderer shape8;

    public WaterRecyclerModel() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.shape2_1 = new ModelRenderer(this, 0, 0);
        this.shape2_1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.shape2_1.addBox(7.0F, -4.0F, -8.0F, 1, 4, 16, 0.0F);
        this.setRotateAngle(shape2_1, 0.0F, 4.71238898038469F, 0.0F);
        this.shape2_2 = new ModelRenderer(this, 0, 0);
        this.shape2_2.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.shape2_2.addBox(7.0F, -4.0F, -8.0F, 1, 4, 16, 0.0F);
        this.setRotateAngle(shape2_2, 0.0F, 3.141592653589793F, 0.0F);
        this.shape8 = new ModelRenderer(this, 0, 0);
        this.shape8.setRotationPoint(4.0F, 8.0F, 4.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.shape1.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(3.0F, 22.0F, 3.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.shape2_3 = new ModelRenderer(this, 0, 0);
        this.shape2_3.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.shape2_3.addBox(7.0F, -4.0F, -8.0F, 1, 4, 16, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.shape2.addBox(7.0F, -4.0F, -8.0F, 1, 4, 16, 0.0F);
        this.setRotateAngle(shape2, 0.0F, 1.5707963267948966F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape2_1.render(f5);
        this.shape2_2.render(f5);
        this.shape8.render(f5);
        this.shape1.render(f5);
        this.shape7.render(f5);
        this.shape2_3.render(f5);
        this.shape2.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
