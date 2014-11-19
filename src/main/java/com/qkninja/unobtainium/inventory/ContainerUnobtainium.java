package com.qkninja.unobtainium.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Generic Container Class.
 */
public class ContainerUnobtainium extends Container
{
    protected final int PLAYER_INVENTORY_ROWS = 3;
    protected final int PLAYER_INVENTORY_COLUMNS = 9;

    @Override public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return true;
    }
}
