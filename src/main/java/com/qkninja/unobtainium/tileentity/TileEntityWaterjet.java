package com.qkninja.unobtainium.tileentity;

import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.item.crafting.WaterjetRecipe;
import com.qkninja.unobtainium.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

/**
 * Defines the processes associated with a waterjet
 *
 * @author QK ninja
 */
public class TileEntityWaterjet extends TileEntityUnobtainium implements ISidedInventory
{
    /**
     * Slots that can be accessed from the top and sides of the vat.
     */
    private static final int[] slotsTopSides = new int[]{0};

    /**
     * Solts that can be accessed from the bottom of the vat.
     */
    private static final int[] slotsBottom = new int[]{1};

    private FluidTank reservoir;

    private FluidTank byproduct;

    private ItemStack[] waterjetStacks = new ItemStack[2];

    public static final int TOTAL_RESERVOIR_SPACE = 50000;

    private static final int TOTAL_BYPRODUCT_SPACE = 1000;

    private static final int STANDARD_DRAIN_TICK = 1000;

    private int cutProgress;

    public TileEntityWaterjet()
    {
        super();
        reservoir = new FluidTank(null, TOTAL_RESERVOIR_SPACE);
        byproduct = new FluidTank(null, TOTAL_BYPRODUCT_SPACE);
    }

    @Override
    public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            boolean flag = false;

            if (this.canCut())
            {
                if (this.hasRecycler())
                    reservoir.drain(STANDARD_DRAIN_TICK / 10, true);
                else
                    reservoir.drain(STANDARD_DRAIN_TICK, true);

                this.cutProgress++;

                if (this.cutProgress >= this.getRecipeLength() && this.getRecipeLength() != -1)
                {
                    this.doCut();
                    flag = true;
                }
            }

            if (flag)
                this.markDirty();
        }
    }

    private boolean canCut()
    {
        if (waterjetStacks[0] == null) return false;

        WaterjetRecipe recipe = WaterjetRecipe.getRecipe(waterjetStacks[0]);

        if (recipe == null) return false;
        if (recipe.getInput().stackSize > waterjetStacks[0].stackSize) return false;
        if (recipe.getOutputFluid() != null)
        {
            if (recipe.getOutputFluid().amount + byproduct.getFluidAmount() > TOTAL_BYPRODUCT_SPACE) return false;
            if (recipe.getOutputFluid().getFluid() != byproduct.getFluid().getFluid()) return false;
        }
        if (waterjetStacks[1] != null)
        {
            if (waterjetStacks[1].getItem() != recipe.getOutputItem().getItem()
                    || waterjetStacks[1].stackSize + recipe.getOutputItem().stackSize > this.getInventoryStackLimit())
                return false;
        }
        return reservoir.getFluidAmount() >= (this.hasRecycler() ? STANDARD_DRAIN_TICK / 10 : STANDARD_DRAIN_TICK);
    }

    private boolean hasRecycler()
    {
        return worldObj.getBlock(xCoord, yCoord - 1, zCoord).equals(ModBlocks.waterRecycler);
    }

    private int getRecipeLength()
    {
        WaterjetRecipe recipe = WaterjetRecipe.getRecipe(waterjetStacks[0]);

        return (recipe == null ? -1 : recipe.getCutTime());
    }

    private void doCut()
    {
        WaterjetRecipe recipe = WaterjetRecipe.getRecipe(waterjetStacks[0]);

        if (this.waterjetStacks[1] == null)
            waterjetStacks[1] = recipe.getOutputItem().copy();
        else
            waterjetStacks[1].stackSize += recipe.getOutputItem().stackSize;

        this.waterjetStacks[0].stackSize -= recipe.getInput().stackSize;
        if (waterjetStacks[0].stackSize <= 0)
            waterjetStacks[0] = null;

        byproduct.fill(recipe.getOutputFluid(), true);

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public int getCutProgress()
    {
        return cutProgress;
    }

    public void setCutProgress(int cutProgress)
    {
        this.cutProgress = cutProgress;
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     *
     * @param side side to be checked (0 = bottom, 1 = top, 2-5 = sides)
     */
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return side == 0 ? slotsBottom : slotsTopSides;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot slot to insert into
     * @param item ItemStack to insert
     * @param side side to insert into
     */
    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
        return this.isItemValidForSlot(slot, item) && this.getAccessibleSlotsFromSide(side)[0] == slot;
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot slot to extract from
     * @param item ItemStack to extract
     * @param side side extracting from
     */
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        return this.getAccessibleSlotsFromSide(side)[0] == slot && item.getItem() == waterjetStacks[slot].getItem();
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return waterjetStacks.length;
    }

    /**
     * Returns the stack in slot i
     *
     * @param slot slot to get stack from
     */
    public ItemStack getStackInSlot(int slot)
    {
        return waterjetStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     *
     * @param slotIndex slot to remove from
     * @param numRemove Number of items to remove
     * @return ItemStack with the number item and number removed.
     */
    public ItemStack decrStackSize(int slotIndex, int numRemove)
    {
        if (this.waterjetStacks[slotIndex] != null)
        {
            ItemStack itemstack;

            if (this.waterjetStacks[slotIndex].stackSize <= numRemove)
            {
                itemstack = this.waterjetStacks[slotIndex];
                this.waterjetStacks[slotIndex] = null;
                return itemstack;
            } else
            {
                itemstack = this.waterjetStacks[slotIndex].splitStack(numRemove);

                if (this.waterjetStacks[slotIndex].stackSize == 0)
                {
                    this.waterjetStacks[slotIndex] = null;
                }

                return itemstack;
            }
        } else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     *
     * @param slot slot to get stack from
     */
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        return waterjetStacks[slot];
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param slot  slot to set inventory
     * @param stack ItemStack to set
     */
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        waterjetStacks[slot] = stack;
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomName() ? this.getCustomName() : Names.Containers.WATERJET;
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.hasCustomName();
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     *
     * @param entityPlayer Player trying to use
     */
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this &&
                entityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
                        (double) this.zCoord + 0.5D) <= 64.0D;
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
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot  slot to place item in
     * @param stack ItemStack containing the item to place
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return slot == 0;
    }

    public int getReservoirAmount()
    {
        return reservoir.getFluidAmount();
    }

    public int fillResevoir(FluidStack fluidStack)
    {
        return this.reservoir.fill(fluidStack, true);
    }
}
