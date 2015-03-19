package com.qkninja.unobtainium.block.fluid;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

/**
 * Unobtainium Fluid Block
 *
 * @author QKninja
 */
public class BlockFluidUnobtainium extends BlockFluidUnobtainiumMod
{
    public BlockFluidUnobtainium(Fluid fluid, Material material)
    {
        super(fluid, material);
        setBlockName(Names.Fluids.UNOBTAINIUM_FLUID);
        quantaPerBlock = 1;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity player)
    {
        if (player instanceof EntityLivingBase)
        {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.poison.getId(), 3000, 20));
        }
    }
}
