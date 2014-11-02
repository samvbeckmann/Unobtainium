package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

/**
 * @author QKninja
 */
public class BlockFluidVibranium extends BlockFluidUnobtainiumMod
{
    public BlockFluidVibranium(Fluid fluid, Material material)
    {
        super(fluid, material);
        setBlockName(Names.Fluids.VIBRANIUM_FLUID);
        quantaPerBlock = 3;
    }
}
