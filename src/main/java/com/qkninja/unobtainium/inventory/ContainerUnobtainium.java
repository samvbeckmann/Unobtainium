package com.qkninja.unobtainium.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Generic Container Class.
 */
public abstract class ContainerUnobtainium extends Container
{
    protected static final int PLAYER_INVENTORY_ROWS = 3;
    protected static final int PLAYER_INVENTORY_COLUMNS = 9;

    public abstract boolean canInteractWith(EntityPlayer entityPlayer);

    protected void addPlayerSlots(InventoryPlayer inventoryPlayer, int x, int y)
    {
        // Add player slots to container
        for (int i = 0; i < PLAYER_INVENTORY_ROWS; ++i)
        {
            for (int j = 0; j < PLAYER_INVENTORY_COLUMNS; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer,
                        j + i * 9 + 9, x + j * 18, y + i * 18));
            }
        }

        // Add player hotbar to container
        for (int i = 0; i < PLAYER_INVENTORY_COLUMNS; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, x + i * 18, y + 58));
        }
    }
}
