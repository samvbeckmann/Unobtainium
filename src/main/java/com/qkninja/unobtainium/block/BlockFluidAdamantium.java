package com.qkninja.unobtainium.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

/**
 * @author QKninja
 */
public class BlockFluidAdamantium extends BlockFluidUnobtainiumMod
{
    public BlockFluidAdamantium(Fluid fluid, Material material)
    {
        super(fluid, material);
        quantaPerBlock = 2;
    }
}
