package com.qkninja.unobtainium.item.crafting;

import net.minecraft.item.ItemStack;

/**
 * Data type to hold the inputs for a Fusion Vat recipe.
 */
public class VatInputs
{
    private ItemStack input1;

    private ItemStack input2;

    public ItemStack getInput2()
    {
        return input2;
    }

    public ItemStack getInput1()
    {
        return input1;
    }

    public VatInputs(ItemStack in1, ItemStack in2)
    {
        input1 = in1;
        input2 = in2;
    }
}
