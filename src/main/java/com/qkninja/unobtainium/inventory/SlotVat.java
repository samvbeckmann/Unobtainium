package com.qkninja.unobtainium.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Sam on 2014-11-19.
 */
public class SlotVat extends Slot
{
    public SlotVat(IInventory inventory, int slotNum, int x, int y)
    {
        super(inventory, slotNum, x, y);
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        return false;
    }
}
