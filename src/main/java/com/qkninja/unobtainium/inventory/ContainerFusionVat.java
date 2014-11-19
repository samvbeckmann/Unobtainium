package com.qkninja.unobtainium.inventory;

import com.qkninja.unobtainium.tileentity.TileEntityVat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author QKninja
 */
public class ContainerFusionVat extends ContainerUnobtainium
{
    private TileEntityVat tileEntityVat;

    public ContainerFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat tileEntityVat)
    {
        this.tileEntityVat = tileEntityVat;

        // Add Three Vat slots to the container
        this.addSlotToContainer(new Slot(tileEntityVat, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntityVat, 1, 56, 53));
        this.addSlotToContainer(new Slot(tileEntityVat, 2, 116, 35));

        // Add player slots to container
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(tileEntityVat, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Add player hotbar to container
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(tileEntityVat, i, 8 + i * 18, 142));
        }

    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);
        tileEntityVat.closeInventory();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        ItemStack newItemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            if (slotIndex < 3)
            {
                if (!this.mergeItemStack(itemStack, 3, inventorySlots.size(), false))
                {
                    return null;
                }
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return newItemStack;
    }
}
