package com.qkninja.unobtainium.tileentity;

import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.item.crafting.VatOutputs;
import com.qkninja.unobtainium.item.crafting.VatRecipes;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

/**
 * Defines the processes associated with a fusion vat.
 *
 * @author QK ninja
 */
public class TileEntityVat extends TileEntityUnobtainium implements ISidedInventory, IFluidTank
{
    /**
     * Slots that can be accessed from the top of the vat.
     */
    private static final int[] slotsTop = new int[]{0, 1};

    /**
     * Solts that can be accessed from the bottom of the vat.
     */
    private static final int[] slotsBottom = new int[]{2};

    /**
     * Slots that can be accessed from the sides of the vat.
     */
    private static final int[] slotsSides = new int[]{0, 1};

    private FluidTank currentWaste;

    public boolean isWasteEmpty;

    private ItemStack[] vatItemStacks = new ItemStack[3];
    public int vatCookTime;
    private static final int TOTAL_COOK_TIME = 1000;
    private static final int TOTAL_WASTE_SPACE = 1000;

    public TileEntityVat()
    {
        super();
        isWasteEmpty = true;
        currentWaste = new FluidTank(null, TOTAL_WASTE_SPACE);
    }

    @Override
    public void updateEntity()
    {
        boolean flag = false;

        if (!this.worldObj.isRemote)
        {
            if (this.canCombine())
            {
                if (hasECU())
                    this.vatCookTime += 5;
                else
                    ++this.vatCookTime;

                if (this.vatCookTime >= TOTAL_COOK_TIME)
                {
                    this.vatCookTime = 0;
                    this.fusion();
                    flag = true;
                }
            } else
            {
                this.vatCookTime = 0;
            }
        }

        if (flag)
        {
            this.markDirty();
        }
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
        return this.vatItemStacks[slotIndex];
    }

    public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack)
    {
        return !(slotIndex == 2);
    }

    public boolean canInsertItem(int slot, ItemStack itemStack, int side)
    {
        return this.isItemValidForSlot(slot, itemStack);
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
        } else
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
            } else
            {
                itemstack = this.vatItemStacks[slotIndex].splitStack(numRemove);

                if (this.vatItemStacks[slotIndex].stackSize == 0)
                {
                    this.vatItemStacks[slotIndex] = null;
                }

                return itemstack;
            }
        } else
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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this &&
                entityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
                        (double) this.zCoord + 0.5D) <= 64.0D;
    }

    public void setInventorySlotContents(int slotIndex, ItemStack itemStack)
    {
        this.vatItemStacks[slotIndex] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    public String getInventoryName()
    {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.VAT;
    }

    public boolean hasCustomInventoryName()
    {
        return this.hasCustomName();
    }

    public void openInventory()
    {
        // NOOP
    }

    public void closeInventory()
    {
        // NOOP
    }

    /**
     * Returns true if the vat can smelt the two items in the input slots.
     */
    private boolean canCombine()
    {
        if (this.vatItemStacks[0] == null || this.vatItemStacks[1] == null)
        {
            return false;
        } else
        {
            VatOutputs outputs = VatRecipes.vat().getVatResult(this.vatItemStacks[0], this.vatItemStacks[1]);
            if (outputs == null) return false;
            if (!outputs.getWaste().isFluidEqual(currentWaste.getFluid())) return false;
            if (outputs.getWaste().amount + currentWaste.getFluidAmount() > TOTAL_WASTE_SPACE) return false;
            if (this.vatItemStacks[2] == null) return true;
            if (!this.vatItemStacks[2].isItemEqual(outputs.getOutput())) return false;
            int result = vatItemStacks[2].stackSize + outputs.getOutput().stackSize;
            return result <= getInventoryStackLimit() && result <= this.vatItemStacks[2].getMaxStackSize();
        }
    }

    /**
     * Fuses the two inputs, and produces outputs from recipe.
     */
    public void fusion()
    {
        if (this.canCombine())
        {
            VatOutputs result = VatRecipes.vat().getVatResult(this.vatItemStacks[0], this.vatItemStacks[1]);
            ItemStack output = result.getOutput();
            FluidStack waste = result.getWaste();

            if (this.vatItemStacks[2] == null)
            {
                this.vatItemStacks[2] = output.copy();
            } else if (this.vatItemStacks[2].getItem() == output.getItem())
            {
                this.vatItemStacks[2].stackSize += output.stackSize;
            }

            --this.vatItemStacks[0].stackSize;
            --this.vatItemStacks[1].stackSize;

            if (this.vatItemStacks[0].stackSize <= 0)
            {
                this.vatItemStacks[0] = null;
            }

            if (this.vatItemStacks[1].stackSize <= 0)
            {
                this.vatItemStacks[1] = null;
            }

            fill(waste, true);
        }
    }

    public boolean isFusing()
    {
        return this.vatCookTime > 0;
    }

    public boolean hasWaste()
    {
        return currentWaste.getFluidAmount() != 0;
    }


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

        currentWaste.readFromNBT(nbtTagCompound);
    }

    public boolean hasECU()
    {
        return worldObj.getBlock(xCoord, yCoord - 1, zCoord) == ModBlocks.externalCoolingUnit;
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

        currentWaste.writeToNBT(nbtTagCompound);
    }

    public FluidStack getFluid()
    {
        return currentWaste.getFluid();
    }

    public int getFluidAmount()
    {
        return currentWaste.getFluidAmount();
    }

    public int getCapacity()
    {
        return TOTAL_WASTE_SPACE;
    }

    public FluidTankInfo getInfo()
    {
        return new FluidTankInfo(currentWaste);
    }

    public int fill(FluidStack resource, boolean doFill)
    {
        return currentWaste.fill(resource, doFill);
    }

    public FluidStack drain(int maxDrain, boolean doDrain)
    {
        return currentWaste.drain(maxDrain, doDrain);
    }

    public int getFuseProgressScaled(int pixels)
    {
        return this.vatCookTime * pixels / TOTAL_COOK_TIME;
    }

    public int getWasteScaled(int pixels)
    {
        return currentWaste.getFluidAmount() * pixels / TOTAL_WASTE_SPACE;
    }

    public int getWasteAmount()
    {
        return currentWaste.getFluidAmount();
    }

    public void setWasteAmount(int amount)
    {
        currentWaste.getFluid().amount = amount;
    }
}
