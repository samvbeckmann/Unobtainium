package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.BlockFluidQuicksilver;
import com.qkninja.unobtainium.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Registers fluids and their associated blocks and buckets.
 * @author QKninja
 */

public class ModFluidBlocks
{
    public static final Fluid quicksilver = new Fluid(Names.Fluids.QUICKSILVER_FLUID).setUnlocalizedName(Names.Fluids.QUICKSILVER_FLUID);
    public static Block blockQuicksilver;



    public static void init()
    {
        FluidRegistry.registerFluid(quicksilver);
        blockQuicksilver = new BlockFluidQuicksilver(quicksilver, Material.water).setBlockName(Names.Fluids.QUICKSILVER_FLUID);
        GameRegistry.registerBlock(blockQuicksilver, Names.Fluids.QUICKSILVER_FLUID);
    }

}
