package com.qkninja.unobtainium.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Generic Output Slot, no item can be inserted by players
 *
 * @author QK ninja
 */
public class SlotOutput extends Slot
{
    public SlotOutput(IInventory inventory, int slotNum, int x, int y)
    {
        super(inventory, slotNum, x, y);
    }

    public boolean isItemValid(ItemStack itemStack)
    {
        return false;
    }
}
