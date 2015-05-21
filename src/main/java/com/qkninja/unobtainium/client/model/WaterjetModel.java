package com.qkninja.unobtainium.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Waterjet - QK ninja
 * Created using Tabula 4.1.1
 */
public class WaterjetModel extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Leg;
    public ModelRenderer Leg_1;
    public ModelRenderer Leg_2;
    public ModelRenderer Leg_3;
    public ModelRenderer Body;
    public ModelRenderer Lip;
    public ModelRenderer Lip_1;
    public ModelRenderer Lip_2;
    public ModelRenderer Lip_3;
    public ModelRenderer Armattachment;
    public ModelRenderer Armbase;
    public ModelRenderer Armprimary;
    public ModelRenderer Armsecondary;
    public ModelRenderer endcap;
    public ModelRenderer Tip;

    public WaterjetModel() {
        this.textureWidth = 60;
        this.textureHeight = 50;
        this.endcap = new ModelRenderer(this, 0, 18);
        this.endcap.setRotationPoint(-0.7F, 13.1F, -3.6F);
        this.endcap.addBox(-0.5F, -0.5F, 4.8F, 2, 2, 1, 0.0F);
        this.setRotateAngle(endcap, 0.8196066167365371F, -0.5462880558742251F, 0.0F);
        this.Leg_3 = new ModelRenderer(this, 0, 0);
        this.Leg_3.setRotationPoint(5.0F, 21.0F, -5.0F);
        this.Leg_3.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Armattachment = new ModelRenderer(this, 12, 39);
        this.Armattachment.setRotationPoint(0.0F, 8.0F, 5.5F);
        this.Armattachment.addBox(-6.0F, 0.0F, -1.0F, 12, 3, 2, 0.0F);
        this.Lip = new ModelRenderer(this, 0, 35);
        this.Lip.setRotationPoint(0.0F, 14.0F, -7.0F);
        this.Lip.addBox(-7.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F);
        this.Leg_2 = new ModelRenderer(this, 0, 0);
        this.Leg_2.setRotationPoint(-5.0F, 21.0F, -5.0F);
        this.Leg_2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Armprimary = new ModelRenderer(this, 42, 0);
        this.Armprimary.setRotationPoint(2.6F, 8.8F, -1.8F);
        this.Armprimary.addBox(0.0F, 0.0F, 0.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(Armprimary, -0.18203784098300857F, -0.31869712141416456F, 0.7853981633974483F);
        this.Armsecondary = new ModelRenderer(this, 0, 15);
        this.Armsecondary.setRotationPoint(-2.5F, 10.6F, -2.3F);
        this.Armsecondary.addBox(0.0F, 0.0F, 0.0F, 5, 2, 1, 0.0F);
        this.setRotateAngle(Armsecondary, 0.5462880558742251F, -0.40980330836826856F, -0.22759093446006054F);
        this.Leg = new ModelRenderer(this, 0, 0);
        this.Leg.setRotationPoint(5.0F, 21.0F, 5.0F);
        this.Leg.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Tip = new ModelRenderer(this, 0, 21);
        this.Tip.setRotationPoint(-0.7F, 13.1F, -3.6F);
        this.Tip.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(Tip, 0.8196066167365371F, -0.5462880558742251F, 0.0F);
        this.Lip_2 = new ModelRenderer(this, 0, 39);
        this.Lip_2.setRotationPoint(-7.0F, 14.0F, 0.0F);
        this.Lip_2.addBox(0.0F, 0.0F, -6.0F, 1, 1, 10, 0.0F);
        this.Lip_3 = new ModelRenderer(this, 0, 39);
        this.Lip_3.setRotationPoint(6.0F, 14.0F, 0.0F);
        this.Lip_3.addBox(0.0F, 0.0F, -6.0F, 1, 1, 10, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Base.addBox(-7.0F, 0.0F, -7.0F, 14, 1, 14, 0.0F);
        this.Body = new ModelRenderer(this, 0, 15);
        this.Body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.Body.addBox(-7.0F, 0.0F, -7.0F, 14, 6, 14, 0.0F);
        this.Leg_1 = new ModelRenderer(this, 0, 0);
        this.Leg_1.setRotationPoint(-5.0F, 21.0F, 5.0F);
        this.Leg_1.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.Lip_1 = new ModelRenderer(this, 0, 35);
        this.Lip_1.setRotationPoint(0.0F, 14.0F, 4.0F);
        this.Lip_1.addBox(-7.0F, 0.0F, 0.0F, 14, 1, 3, 0.0F);
        this.Armbase = new ModelRenderer(this, 0, 9);
        this.Armbase.setRotationPoint(0.0F, 11.0F, 5.0F);
        this.Armbase.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.endcap.render(f5);
        this.Leg_3.render(f5);
        this.Armattachment.render(f5);
        this.Lip.render(f5);
        this.Leg_2.render(f5);
        this.Armprimary.render(f5);
        this.Armsecondary.render(f5);
        this.Leg.render(f5);
        this.Tip.render(f5);
        this.Lip_2.render(f5);
        this.Lip_3.render(f5);
        this.Base.render(f5);
        this.Body.render(f5);
        this.Leg_1.render(f5);
        this.Lip_1.render(f5);
        this.Armbase.render(f5);
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
