package com.qkninja.unobtainium.item.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * Object for outputs of a vat recipe
 *
 * @author QK ninja
 */
public class VatOutputs
{
    private ItemStack output;

    private FluidStack waste;

    public FluidStack getWaste()
    {
        return waste;
    }

    public ItemStack getOutput()
    {
        return output;
    }

    public VatOutputs(ItemStack output_, FluidStack waste_)
    {
        output = output_;
        waste = waste_;
    }
}
