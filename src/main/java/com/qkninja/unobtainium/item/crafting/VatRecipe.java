package com.qkninja.unobtainium.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles Recipes for the Fusion Vat.
 *
 * @author QK ninja
 */
public class VatRecipe
{
    private ItemStack input1;
    private ItemStack input2;
    private ItemStack outputItem;
    private FluidStack outputFluid;

    /**
     * List of all recipes for the fusion vat.
     */
    public static final List<VatRecipe> recipes = new ArrayList<VatRecipe>();

    private VatRecipe(ItemStack input1, ItemStack input2, ItemStack outputItem, FluidStack outputFluid)
    {
        this.input1 = input1;
        this.input2 = input2;
        this.outputItem = outputItem;
        this.outputFluid = outputFluid;
    }

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack outputItem, FluidStack outputFluid)
    {
        recipes.add(new VatRecipe(input1, input2, outputItem, outputFluid));
    }

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack outputItem)
    {
        recipes.add(new VatRecipe(input1, input2, outputItem, null));
    }

    public static VatRecipe getRecipe(ItemStack input1, ItemStack input2)
    {
        for (VatRecipe recipe : recipes)
        {
            if (recipe.input1.getItem() == input1.getItem()
                    && recipe.input2.getItem() == input2.getItem())
            {
                return recipe;
            } else if (recipe.input1.getItem() == input2.getItem()
                    && recipe.input2.getItem() == input1.getItem())
            {
                return recipe;
            }
        }

        // Recipe doesn't exist.
        return null;
    }

    public ItemStack getInput1()
    {
        return input1;
    }

    public ItemStack getInput2()
    {
        return input2;
    }

    public ItemStack getOutputItem()
    {
        return outputItem;
    }

    public FluidStack getOutputFluid()
    {
        return outputFluid;
    }
}
