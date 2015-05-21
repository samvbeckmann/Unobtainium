package com.qkninja.unobtainium.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * WaterRecycler - QK Ninja
 * Created using Tabula 4.1.1
 */
public class WaterRecyclerModel extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Boxthing;
    public ModelRenderer Smalltank;
    public ModelRenderer Smallbox;
    public ModelRenderer Pipeup;
    public ModelRenderer Pipeup_1;
    public ModelRenderer Pipeup_2;
    public ModelRenderer shape21;
    public ModelRenderer shape21_1;
    public ModelRenderer shape23;
    public ModelRenderer shape24;
    public ModelRenderer shape25;
    public ModelRenderer shape26;
    public ModelRenderer BottleTop;
    public ModelRenderer BottleMain;
    public ModelRenderer Pipeup_3;
    public ModelRenderer BottleTop_1;
    public ModelRenderer BottleMain_1;
    public ModelRenderer BottleTop_2;
    public ModelRenderer BottleMain_2;
    public ModelRenderer BottleTop_3;
    public ModelRenderer BottleMain_3;

    public WaterRecyclerModel() {
        this.textureWidth = 61;
        this.textureHeight = 22;
        this.shape23 = new ModelRenderer(this, 32, 11);
        this.shape23.setRotationPoint(-3.5F, 10.0F, 0.0F);
        this.shape23.addBox(-0.5F, 0.0F, -3.0F, 1, 1, 6, 0.0F);
        this.BottleTop_2 = new ModelRenderer(this, 0, 0);
        this.BottleTop_2.setRotationPoint(4.499999999999998F, 13.0F, 2.5F);
        this.BottleTop_2.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(BottleTop_2, 0.0F, 0.7853981633974483F, 0.0F);
        this.BottleMain_1 = new ModelRenderer(this, 48, 0);
        this.BottleMain_1.setRotationPoint(-0.3F, 14.0F, -2.5F);
        this.BottleMain_1.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(BottleMain_1, 0.0F, 0.7853981633974483F, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Base.addBox(-7.0F, 0.0F, -5.0F, 14, 1, 10, 0.0F);
        this.Smallbox = new ModelRenderer(this, 0, 3);
        this.Smallbox.setRotationPoint(-4.5F, 21.6F, -3.5F);
        this.Smallbox.addBox(-1.5F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.BottleTop_1 = new ModelRenderer(this, 0, 0);
        this.BottleTop_1.setRotationPoint(-0.3000000000000029F, 13.0F, -2.5F);
        this.BottleTop_1.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(BottleTop_1, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape26 = new ModelRenderer(this, 6, 0);
        this.shape26.setRotationPoint(-4.5F, 20.6F, -4.0F);
        this.shape26.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.BottleTop = new ModelRenderer(this, 0, 0);
        this.BottleTop.setRotationPoint(-0.3000000000000029F, 13.0F, 2.5F);
        this.BottleTop.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(BottleTop, 0.0F, 0.7853981633974483F, 0.0F);
        this.Pipeup_2 = new ModelRenderer(this, 0, 7);
        this.Pipeup_2.setRotationPoint(4.5F, 11.0F, 2.5F);
        this.Pipeup_2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.Pipeup = new ModelRenderer(this, 0, 7);
        this.Pipeup.setRotationPoint(4.5F, 11.0F, -2.5F);
        this.Pipeup.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.BottleMain_2 = new ModelRenderer(this, 48, 0);
        this.BottleMain_2.setRotationPoint(4.5F, 14.0F, 2.5F);
        this.BottleMain_2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(BottleMain_2, 0.0F, 0.7853981633974483F, 0.0F);
        this.Smalltank = new ModelRenderer(this, 14, 11);
        this.Smalltank.setRotationPoint(-3.8F, 18.0F, -0.7F);
        this.Smalltank.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Smalltank, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape21 = new ModelRenderer(this, 20, 11);
        this.shape21.setRotationPoint(1.0F, 10.0F, -2.5F);
        this.shape21.addBox(-4.0F, 0.0F, -0.5F, 8, 1, 1, 0.0F);
        this.BottleTop_3 = new ModelRenderer(this, 0, 0);
        this.BottleTop_3.setRotationPoint(4.499999999999998F, 13.0F, -2.5F);
        this.BottleTop_3.addBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(BottleTop_3, 0.0F, 0.7853981633974483F, 0.0F);
        this.Boxthing = new ModelRenderer(this, 0, 11);
        this.Boxthing.setRotationPoint(-4.7F, 17.0F, 3.0F);
        this.Boxthing.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 3, 0.0F);
        this.Pipeup_3 = new ModelRenderer(this, 0, 7);
        this.Pipeup_3.setRotationPoint(-0.3F, 11.0F, 2.5F);
        this.Pipeup_3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.BottleMain = new ModelRenderer(this, 48, 0);
        this.BottleMain.setRotationPoint(-0.3F, 14.0F, 2.5F);
        this.BottleMain.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(BottleMain, 0.0F, 0.7853981633974483F, 0.0F);
        this.shape25 = new ModelRenderer(this, 39, 5);
        this.shape25.setRotationPoint(-5.5F, 19.6F, -3.9F);
        this.shape25.addBox(1.0F, 0.0F, -0.1F, 1, 1, 3, 0.0F);
        this.shape24 = new ModelRenderer(this, 38, 0);
        this.shape24.setRotationPoint(-4.0F, 11.0F, -1.2F);
        this.shape24.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.shape21_1 = new ModelRenderer(this, 20, 11);
        this.shape21_1.setRotationPoint(1.0F, 10.0F, 2.5F);
        this.shape21_1.addBox(-4.0F, 0.0F, -0.5F, 8, 1, 1, 0.0F);
        this.Pipeup_1 = new ModelRenderer(this, 0, 7);
        this.Pipeup_1.setRotationPoint(-0.3F, 11.0F, -2.5F);
        this.Pipeup_1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.BottleMain_3 = new ModelRenderer(this, 48, 0);
        this.BottleMain_3.setRotationPoint(4.5F, 14.0F, -2.5F);
        this.BottleMain_3.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(BottleMain_3, 0.0F, 0.7853981633974483F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape23.render(f5);
        this.BottleTop_2.render(f5);
        this.BottleMain_1.render(f5);
        this.Base.render(f5);
        this.Smallbox.render(f5);
        this.BottleTop_1.render(f5);
        this.shape26.render(f5);
        this.BottleTop.render(f5);
        this.Pipeup_2.render(f5);
        this.Pipeup.render(f5);
        this.BottleMain_2.render(f5);
        this.Smalltank.render(f5);
        this.shape21.render(f5);
        this.BottleTop_3.render(f5);
        this.Boxthing.render(f5);
        this.Pipeup_3.render(f5);
        this.BottleMain.render(f5);
        this.shape25.render(f5);
        this.shape24.render(f5);
        this.shape21_1.render(f5);
        this.Pipeup_1.render(f5);
        this.BottleMain_3.render(f5);
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
