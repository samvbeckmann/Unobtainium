package com.qkninja.unobtainium.item.crafting;

import com.qkninja.unobtainium.init.ModFluidBlocks;
import com.qkninja.unobtainium.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Defines the recipes used by the Fusion Vat.
 */
public class VatRecipes
{
    private static final VatRecipes vatBase = new VatRecipes();

    /** The list of vat results */
    private Map<VatInputs, VatOutputs> vatList = new HashMap<VatInputs, VatOutputs>();

    /**
     * Used to call methods addVatRecipes and getVatResult
     */
    public static VatRecipes vat()
    {
        return vatBase;
    }

    /**
     * Initializes recipes for the vat.
     */
    private VatRecipes()
    {
        this.itemItemRecipe(Items.gold_ingot, ModItems.mithrilIngot,
                new ItemStack(ModItems.orichalcumIngot), new FluidStack(ModFluidBlocks.quicksilver, 50));
        this.itemItemRecipe(ModItems.orichalcumIngot, ModItems.galvornIngot,
                new ItemStack(ModItems.cavoriteIngot), new FluidStack(ModFluidBlocks.quicksilver, 50));
    }

    public void blockBlockRecipe(Block input1, Block input2, ItemStack output, FluidStack waste)
    {
        this.itemItemRecipe(Item.getItemFromBlock(input1), Item.getItemFromBlock(input2), output, waste);
    }

    public void blockItemRecipe(Block input1, Item input2, ItemStack output, FluidStack waste)
    {
        this.itemItemRecipe(Item.getItemFromBlock(input1), input2, output, waste);
    }

    public void itemBlockRecipe(Item input1, Block input2, ItemStack output, FluidStack waste)
    {
        this.blockItemRecipe(input2, input1, output, waste);
    }

    public void itemItemRecipe(Item input1, Item input2, ItemStack output, FluidStack waste)
    {
        VatInputs inputs = new VatInputs(new ItemStack(input1, 1, 32767), new ItemStack(input2, 1, 32767));
        VatInputs inputsReverse = new VatInputs(new ItemStack(input2, 1, 32767), new ItemStack(input1, 1, 31767));
        VatOutputs outputs = new VatOutputs(output, waste);
        this.addRecipe(inputs, outputs);
        this.addRecipe(inputsReverse, outputs);
    }

    public void addRecipe(VatInputs inputs, VatOutputs outputs)
    {
        this.vatList.put(inputs, outputs);
    }

    public VatOutputs getVatResult(ItemStack input1, ItemStack input2)
    {
        Iterator<Entry<VatInputs, VatOutputs>> iterator = this.vatList.entrySet().iterator();
        Entry<VatInputs, VatOutputs> entry;

        do
        {
            if (!iterator.hasNext())
                return null;

            entry = iterator.next();

        } while (!this.isRecipe(new VatInputs(input1, input2), entry.getKey()));

        return entry.getValue();
    }

    public boolean isRecipe(VatInputs inputs, VatInputs entry)
    {
        return entry.getInput1().getItem() == inputs.getInput1().getItem()
                && entry.getInput2().getItem() == inputs.getInput2().getItem()
                && (entry.getInput1().getItemDamage() == 32767
                ||entry.getInput1().getItemDamage() == inputs.getInput1().getItemDamage())
                && (entry.getInput2().getItemDamage() == 32767
                || entry.getInput2().getItemDamage() == inputs.getInput2().getItemDamage());
    }

    public Map<VatInputs, VatOutputs> getVatList()
    {
        return this.vatList;
    }
}
