package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.BlockFluidAdamantium;
import com.qkninja.unobtainium.block.BlockFluidQuicksilver;
import com.qkninja.unobtainium.block.BlockFluidVibranium;
import com.qkninja.unobtainium.handler.BucketHandler;
import com.qkninja.unobtainium.item.ItemAdamantiumBucket;
import com.qkninja.unobtainium.item.ItemQuicksilverBucket;
import com.qkninja.unobtainium.item.ItemVibraniumBucket;
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
 */
public class ModFluidBlocks
{
    public static final Fluid quicksilver = new Fluid(Names.Fluids.QUICKSILVER_FLUID)
            .setUnlocalizedName(Names.Fluids.QUICKSILVER_FLUID).setViscosity(500);
    public static Block blockQuicksilver;
    public static Item quicksilverBucket;

    public static final Fluid vibranium = new Fluid(Names.Fluids.VIBRANIUM_FLUID)
        .setUnlocalizedName(Names.Fluids.VIBRANIUM_FLUID).setViscosity(5000);
    public static Block blockVibranium;
    public static Item vibraniumBucket;

    public static final Fluid adamantium = new Fluid(Names.Fluids.ADAMANTIUM_FLUID)
            .setUnlocalizedName(Names.Fluids.ADAMANTIUM_FLUID).setViscosity(10000);
    public static Block blockAdamantium;
    public static Item adamantiumBucket;


    public static void init()
    {
        FluidRegistry.registerFluid(quicksilver);
        FluidRegistry.registerFluid(vibranium);
        FluidRegistry.registerFluid(adamantium);

        blockQuicksilver = new BlockFluidQuicksilver(quicksilver, Material.water)
                .setBlockName(Names.Fluids.QUICKSILVER_FLUID);
        blockVibranium = new BlockFluidVibranium(vibranium, Material.lava)
                .setBlockName(Names.Fluids.VIBRANIUM_FLUID);
        blockAdamantium = new BlockFluidAdamantium(adamantium, Material.lava)
                .setBlockName(Names.Fluids.ADAMANTIUM_FLUID);

        GameRegistry.registerBlock(blockQuicksilver, Names.Fluids.QUICKSILVER_FLUID);
        GameRegistry.registerBlock(blockVibranium, Names.Fluids.VIBRANIUM_FLUID);
        GameRegistry.registerBlock(blockAdamantium, Names.Fluids.ADAMANTIUM_FLUID);

        quicksilverBucket = new ItemQuicksilverBucket(blockQuicksilver)
                .setContainerItem(Items.bucket).setUnlocalizedName(Names.Items.QUICKSILVER_BUCKET);
        vibraniumBucket = new ItemVibraniumBucket(blockVibranium)
                .setContainerItem(Items.bucket).setUnlocalizedName(Names.Items.VIBRANIUM_BUCKET);
        adamantiumBucket = new ItemAdamantiumBucket(blockAdamantium)
                .setContainerItem(Items.bucket).setUnlocalizedName(Names.Items.ADAMANTIUM_BUCKET);

        GameRegistry.registerItem(quicksilverBucket, Names.Items.QUICKSILVER_BUCKET);
        GameRegistry.registerItem(vibraniumBucket, Names.Items.VIBRANIUM_BUCKET);
        GameRegistry.registerItem(adamantiumBucket, Names.Items.ADAMANTIUM_BUCKET);

        FluidContainerRegistry.registerFluidContainer(quicksilver, new ItemStack(quicksilverBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(vibranium, new ItemStack(vibraniumBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(adamantium, new ItemStack(adamantiumBucket), new ItemStack(Items.bucket));

        BucketHandler.INSTANCE.buckets.put(blockQuicksilver, quicksilverBucket);
        BucketHandler.INSTANCE.buckets.put(blockVibranium, vibraniumBucket);
        BucketHandler.INSTANCE.buckets.put(blockAdamantium, adamantiumBucket);

        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }

}
