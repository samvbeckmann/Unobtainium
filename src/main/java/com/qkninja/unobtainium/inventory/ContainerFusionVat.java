package com.qkninja.unobtainium.inventory;

import com.qkninja.unobtainium.tileentity.TileEntityVat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Define the inventory of the Fusion Vat.
 *
 * @author QKninja
 */
public class ContainerFusionVat extends ContainerUnobtainium
{
    private final TileEntityVat tileEntityVat;
    private int lastCookTime = -1;
    private int lastWasteAmount = -1;

    public ContainerFusionVat(InventoryPlayer inventoryPlayer, TileEntityVat tileEntityVat)
    {
        this.tileEntityVat = tileEntityVat;

        // Add Three Vat slots to the container
        this.addSlotToContainer(new Slot(tileEntityVat, 0, 60, 16)); // Input 1
        this.addSlotToContainer(new Slot(tileEntityVat, 1, 100, 16)); // Input 2
        this.addSlotToContainer(new SlotOutput(tileEntityVat, 2, 80, 55)); // Output

        addPlayerSlots(inventoryPlayer, 8, 84);
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tileEntityVat.vatCookTime);
        crafting.sendProgressBarUpdate(this, 1, this.tileEntityVat.getTankAmount());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     * (Called by server to update clients)
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting iCrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.tileEntityVat.vatCookTime)
            {
                iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityVat.vatCookTime);
            }

            if(this.lastWasteAmount != this.tileEntityVat.getTankAmount())
            {
                iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityVat.getTankAmount());
            }
        }

        this.lastCookTime = this.tileEntityVat.vatCookTime;
        this.lastWasteAmount = this.tileEntityVat.getTankAmount();
    }

    /**
     * Updates data on the client side.
     *
     * @param id What piece of data is being received
     * @param value Value of the piece of data being received
     */
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value)
    {
        if (id == 0)
        {
            this.tileEntityVat.vatCookTime = value;
        }
        if (id == 1)
        {
            this.tileEntityVat.setTankAmount(value);
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

        // Tests if there is an itemStack in the slot. If so, places it into the newItemStack
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            // Merges from the tileEntity to the player inventory
            if (slotIndex < 3)
            {
                if (!this.mergeItemStack(itemStack, inventorySlots.size() - 9, inventorySlots.size(), false))
                {
                    if (!this.mergeItemStack(itemStack, 3, inventorySlots.size() - 9, false))
                        return null;
                }
            } else if (!this.mergeItemStack(itemStack, 0, 2, false))
                return null;

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }

            slot.onPickupFromSlot(entityPlayer, itemStack);
        }

        return newItemStack;
    }

    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return tileEntityVat.isUseableByPlayer(entityPlayer);
    }
}
