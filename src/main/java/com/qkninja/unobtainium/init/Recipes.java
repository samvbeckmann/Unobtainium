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
        GameRegistry.addRecipe(new ItemStack(ModItems.LynguriumGem), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
    }
}
