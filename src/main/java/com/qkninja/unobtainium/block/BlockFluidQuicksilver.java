package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.init.ModFluidBlocks;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;
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
}
