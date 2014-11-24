package com.qkninja.unobtainium.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Used for adding tooltip to a block
 */
public class ItemBlockECU extends ItemBlock
{
    public ItemBlockECU(Block block)
    {
        super(block);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
    {
        list.add("\u00A7cWarning: Don't place");
        list.add("\u00A7cnear large bodies of lava");
    }
}
