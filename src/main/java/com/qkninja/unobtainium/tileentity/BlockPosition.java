package com.qkninja.unobtainium.tileentity;

/**
 * Data type that contains x, y, and z coordinates.
 *
 * @deprecated
 */
public class BlockPosition
{
    private int x;
    private int y;
    private int z;

    public BlockPosition(int x_, int y_, int z_)
    {
        x = x_;
        y = y_;
        z = z_;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }

//    /**
//     * Write the position fields to a NBT object. Return the new NBT object.
//     */
//    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound)
//    {
//        nbtTagCompound.setShort("X", (short) this.x);
//        nbtTagCompound.setShort("Y", (short) this.y);
//        nbtTagCompound.setShort("Z", (short) this.z);
//
//        return nbtTagCompound;
//    }
//
//    public static BlockPosition loadItemStackFromNBT(NBTTagCompound nbtTagCompound)
//    {
//        BlockPosition blockPosition = new BlockPosition();
//        itemstack.readFromNBT(nbtTagCompound);
//        return itemstack.getItem() != null ? itemstack : null;
//    }
}
