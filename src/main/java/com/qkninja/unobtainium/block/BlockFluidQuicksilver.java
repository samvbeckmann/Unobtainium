package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.init.ModFluidBlocks;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * @author QKninja
 */
public class BlockFluidQuicksilver extends BlockFluidUnobtainiumMod
{

    public BlockFluidQuicksilver(Fluid fluid, Material material)
    {
        super(fluid, material);
        setBlockName(Names.Fluids.QUICKSILVER_FLUID);
        quantaPerBlock = 1;
    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (canDisplace(world, x, y + densityDir, z))
        {
            world.setBlock(x, y+ densityDir, z, ModFluidBlocks.blockQuicksilver);
            world.setBlockToAir(x, y, z);
        }
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity player)
    {
        if (player instanceof EntityLivingBase)
        {
            ((EntityLivingBase)player).addPotionEffect(new PotionEffect(Potion.poison.getId(), 400, 2));
        }
    }
}
