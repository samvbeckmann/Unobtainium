package com.qkninja.unobtainium.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Initializes standard crafting and furnaces recipes.
 */
public class Recipes
{
    public static void init()
    {
        // Material to Block (and back) Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mithril), "###", "###", "###", '#', new ItemStack(ModItems.mithrilIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.mithrilIngot, 9), new ItemStack(ModBlocks.mithril));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.galvorn), "###", "###", "###", '#', new ItemStack(ModItems.galvornIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.galvornIngot, 9), new ItemStack(ModBlocks.galvorn));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.orichalcum), "###", "###", "###", '#', new ItemStack(ModItems.orichalcumIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.orichalcumIngot, 9), new ItemStack(ModBlocks.orichalcum));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.cavorite), "###", "###", "###", '#', new ItemStack(ModItems.cavoriteIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cavoriteIngot, 9), new ItemStack(ModBlocks.cavorite));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.plastic), "##", "##", '#', new ItemStack(ModItems.plasticChunk));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.plasticChunk, 4), new ItemStack(ModBlocks.plastic));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.oilResin), "##", "##", '#', new ItemStack(ModItems.resinChunk));

        // Smelting Recipes
        GameRegistry.addSmelting(ModBlocks.mithrilOre, new ItemStack(ModItems.mithrilIngot), .1F);
        GameRegistry.addSmelting(ModItems.resinChunk, new ItemStack(ModItems.plasticChunk), .1F);
    }
}
