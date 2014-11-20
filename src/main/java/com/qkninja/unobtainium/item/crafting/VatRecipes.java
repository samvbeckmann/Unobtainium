package com.qkninja.unobtainium.item.crafting;

import com.qkninja.unobtainium.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
    private Map vatList = new HashMap();

    /**
     * Used to call methods addVatRecipes and getVatResult
     */
    public static VatRecipes vat()
    {
        return vatBase;
    }

    private VatRecipes()
    {
        this.itemItemRecipe(Items.gold_ingot, ModItems.mithrilIngot, new ItemStack(ModItems.orichalcumIngot));
        this.itemItemRecipe(ModItems.orichalcumIngot, ModItems.galvornIngot, new ItemStack(ModItems.cavoriteIngot));
    }

    public void blockBlockRecipe(Block input1, Block input2, ItemStack output)
    {
        this.itemItemRecipe(Item.getItemFromBlock(input1), Item.getItemFromBlock(input2), output);
    }

    public void blockItemRecipe(Block input1, Item input2, ItemStack output)
    {
        this.itemItemRecipe(Item.getItemFromBlock(input1), input2, output);
    }

    public void itemBlockRecipe(Item input1, Block input2, ItemStack output)
    {
        this.blockItemRecipe(input2, input1, output);
    }

    public void itemItemRecipe(Item input1, Item input2, ItemStack output)
    {
        VatInputs inputs = new VatInputs(new ItemStack(input1, 1, 32767), new ItemStack(input2, 1, 32767));
        VatInputs inputsReverse = new VatInputs(new ItemStack(input2, 1, 32767), new ItemStack(input1, 1, 31767));
        this.addRecipe(inputs, output);
        this.addRecipe(inputsReverse, output);
    }

    public void addRecipe(VatInputs inputs, ItemStack output)
    {
        this.vatList.put(inputs, output);
    }

    public ItemStack getVatResult(ItemStack input1, ItemStack input2)
    {
        Iterator iterator = this.vatList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
                return null;

            entry = (Entry) iterator.next();

        } while (!this.isRecipe(new VatInputs(input1, input2), (VatInputs) entry.getKey()));

        return (ItemStack) entry.getValue();
    }

    public boolean isRecipe(VatInputs inputs, VatInputs entry)
    {
        return entry.getInput1().getItem() == inputs.getInput1().getItem()
                && entry.getInput2().getItem() == inputs.getInput2().getItem()
                && (entry.getInput1().getItemDamage() == 32767 || entry.getInput1().getItemDamage() == inputs.getInput1().getItemDamage())
                && (entry.getInput2().getItemDamage() == 32767 || entry.getInput2().getItemDamage() == inputs.getInput2().getItemDamage());
    }

    public Map getVatList()
    {
        return this.vatList;
    }
}
