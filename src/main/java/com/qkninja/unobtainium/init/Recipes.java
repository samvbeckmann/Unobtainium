package com.qkninja.unobtainium.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author QKninja
 */

public class Recipes
{
    public static void init()
    {
        // Temporary
        GameRegistry.addRecipe(new ItemStack(ModItems.lynguriumGem), " s ", "sss", " s ", 's', new ItemStack(Items.stick));

        // Material to Block (and back) Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mithril), "###", "###", "###", '#', new ItemStack(ModItems.mithrilIngot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.galvorn), "###", "###", "###", '#', new ItemStack(ModItems.galvornIngot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.orichalcum), "###", "###", "###", '#', new ItemStack(ModItems.orichalcumIngot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.cavorite), "###", "###", "###", '#', new ItemStack(ModItems.cavoriteIngot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.oilResin), "##", "##", '#', new ItemStack(ModItems.resinChunk));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.plastic), "##", "##", '#', new ItemStack(ModItems.plasticChunk));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plasticChunk, 4), new ItemStack(ModBlocks.plastic));

        // Smelting Recipes
        GameRegistry.addSmelting(ModBlocks.mithrilOre, new ItemStack(ModItems.mithrilIngot), .1F);
        GameRegistry.addSmelting(ModItems.resinChunk, new ItemStack(ModItems.plasticChunk), .1F);
    }
}
