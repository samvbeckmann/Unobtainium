package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.BlockFluidQuicksilver;
import com.qkninja.unobtainium.client.handler.BucketHandler;
import com.qkninja.unobtainium.item.ItemQuicksilverBucket;
import com.qkninja.unobtainium.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Registers fluids and their associated blocks and buckets.
 * @author QKninja
 */

public class ModFluidBlocks
{
    public static final Fluid quicksilver = new Fluid(Names.Fluids.QUICKSILVER_FLUID).setUnlocalizedName(Names.Fluids.QUICKSILVER_FLUID).setViscosity(500).setDensity(10000);
    public static Block blockQuicksilver;
    public static Item quicksilverBucket;



    public static void init()
    {
        FluidRegistry.registerFluid(quicksilver);
        blockQuicksilver = new BlockFluidQuicksilver(quicksilver, Material.water).setBlockName(Names.Fluids.QUICKSILVER_FLUID);
        GameRegistry.registerBlock(blockQuicksilver, Names.Fluids.QUICKSILVER_FLUID);
        quicksilverBucket = new ItemQuicksilverBucket(blockQuicksilver).setContainerItem(Items.bucket).setUnlocalizedName(Names.Items.QUICKSILVER_BUCKET);
        GameRegistry.registerItem(quicksilverBucket, Names.Items.QUICKSILVER_BUCKET);
        FluidContainerRegistry.registerFluidContainer(quicksilver, new ItemStack(quicksilverBucket), new ItemStack(Items.bucket));

        BucketHandler.INSTANCE.buckets.put(blockQuicksilver, quicksilverBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }

}
