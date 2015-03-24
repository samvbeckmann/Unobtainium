package com.qkninja.unobtainium.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a rcipe for the Waterjet
 *
 * @author QK ninja
 */
public class WaterjetRecipe
{
    private ItemStack input;
    private ItemStack outputItem;
    private FluidStack outputFluid;
    private int cutTime;

    /**
     * List of all recipes for the fusion vat.
     */
    public static final List<WaterjetRecipe> recipes = new ArrayList<WaterjetRecipe>();

    private WaterjetRecipe(ItemStack input, ItemStack outputItem, FluidStack outputFluid, int cutTime)
    {
        this.input = input;
        this.outputItem = outputItem;
        this.outputFluid = outputFluid;
        this.cutTime = cutTime;
    }

    public static void addRecipe(ItemStack input, ItemStack outputItem, FluidStack outputFluid, int cutTime)
    {
        recipes.add(new WaterjetRecipe(input, outputItem, outputFluid, cutTime));
    }

    public static void addRecipe(ItemStack input, ItemStack outputItem, int cutTime)
    {
        recipes.add(new WaterjetRecipe(input, outputItem, null, cutTime));
    }

    public static WaterjetRecipe getRecipe(ItemStack input)
    {
        for (WaterjetRecipe recipe : recipes)
        {
            if (recipe.input.getItem() == input.getItem())
                return recipe;
        }

        // Recipe doesn't exist.
        return null;
    }

    public ItemStack getInput()
    {
        return input;
    }

    public ItemStack getOutputItem()
    {
        return outputItem;
    }

    public FluidStack getOutputFluid()
    {
        return outputFluid;
    }

    public int getCutTime()
    {
        return cutTime;
    }
}
