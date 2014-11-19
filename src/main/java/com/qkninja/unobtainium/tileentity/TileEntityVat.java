package com.qkninja.unobtainium.tileentity;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * @author QKninja
 */
public class TileEntityVat extends TileEntityUnobtainium implements ISidedInventory
{


    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    private ItemStack[] vatItemStacks = new ItemStack[3];

    public TileEntityVat()
    {
        super();
    }

    public int getSizeInventory()
    {
        return this.vatItemStacks.length;
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public ItemStack getStackInSlot(int slotIndex)
    {
        if (slotIndex < vatItemStacks.length)
        {
            return this.vatItemStacks[slotIndex];
        } else
            return null;
    }

    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return !(slotIndex == 2);
    }

    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_)
    {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex)
    {
        if (this.vatItemStacks[slotIndex] != null)
        {
            ItemStack itemstack = this.vatItemStacks[slotIndex];
            this.vatItemStacks[slotIndex] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public ItemStack decrStackSize(int slotIndex, int numRemove)
    {
        if (this.vatItemStacks[slotIndex] != null)
        {
            ItemStack itemstack;

            if (this.vatItemStacks[slotIndex].stackSize <= numRemove)
            {
                itemstack = this.vatItemStacks[slotIndex];
                this.vatItemStacks[slotIndex] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.vatItemStacks[slotIndex].splitStack(numRemove);

                if (this.vatItemStacks[slotIndex].stackSize == 0)
                {
                    this.vatItemStacks[slotIndex] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    public boolean canExtractItem(int slotIndex, ItemStack itemStack, int side)
    {
        return true;
    }

    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        if (slotIndex < vatItemStacks.length)
        {
            this.vatItemStacks[slotIndex] = itemStack;
        } else
            return;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.VAT;
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.hasCustomName();
    }

    public void openInventory() {}

    public void closeInventory() {}

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList(Names.NBT.ITEMS, 10);
        vatItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < vatItemStacks.length)
            {
                vatItemStacks[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < vatItemStacks.length; ++currentIndex)
        {
            if (vatItemStacks[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                vatItemStacks[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag(Names.NBT.ITEMS, tagList);
    }
}
