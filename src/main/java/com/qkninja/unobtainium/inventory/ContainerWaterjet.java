package com.qkninja.unobtainium.inventory;

import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Container for a Waterjet
 *
 * @author QK ninja
 */
public class ContainerWaterjet extends ContainerUnobtainium
{
    private final TileEntityWaterjet te;
    private int lastCutTime = -1;

    public ContainerWaterjet(InventoryPlayer player, TileEntityWaterjet te)
    {
        this.te = te;

        this.addSlotToContainer(new Slot(te, 0, 42, 15));
        this.addSlotToContainer(new SlotOutput(te, 1, 42, 51));

        addPlayerSlots(player, 8, 89);
    }

    @Override
    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.te.getCutProgress());
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     * (Called by server to update clients)
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (Object crafter : this.crafters)
        {
            ICrafting iCrafting = (ICrafting) crafter;

            if (this.lastCutTime != this.te.getCutProgress())
            {
                iCrafting.sendProgressBarUpdate(this, 0, this.te.getCutProgress());
            }
        }

        this.lastCutTime = this.te.getCutProgress();
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
            this.te.setCutProgress(value);
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);
        te.closeInventory();
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
            if (slotIndex < 2)
            {
                if (!this.mergeItemStack(itemStack, inventorySlots.size() - 9, inventorySlots.size(), false))
                {
                    if (!this.mergeItemStack(itemStack, 3, inventorySlots.size() - 9, false))
                        return null;
                }
            } else if (!this.mergeItemStack(itemStack, 0, 1, false))
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

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return te.isUseableByPlayer(entityPlayer);
    }
}
