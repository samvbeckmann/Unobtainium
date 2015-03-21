package com.qkninja.unobtainium.tileentity;

import net.minecraft.init.Blocks;

/**
 * ECU speeds up various processes and can rapidly cool down materials.
 */
public class TileEntityECU extends TileEntityUnobtainium
{
    public TileEntityECU()
    {
        super();
    }

    @Override
    public void updateEntity()
    {
        if (!worldObj.isRemote)
        {
            int yOffset = worldObj.rand.nextInt(10) - 5;
            int xOffset = worldObj.rand.nextInt(10) - 5;
            int zOffset = worldObj.rand.nextInt(10) - 5;

            if ((xOffset != 0 || yOffset != 0 || zOffset != 0) &&
                    (Math.abs(xOffset) + Math.abs(yOffset) + Math.abs(zOffset) <= 5))
            {
                checkAndReplaceLava(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);
                checkAndReplaceWater(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);
            }
        }
    }

    /**
     * Checks given block to see if it's lava. If so, replaces that block with the appropriate cooled material.
     *
     * @param x x coord
     * @param y y coord
     * @param z z coord
     */
    private void checkAndReplaceLava(int x, int y, int z)
    {
        if (worldObj.getBlock(x,y,z).equals(Blocks.lava))
        {
            if (worldObj.getBlockMetadata(x, y, z) == 0)
                worldObj.setBlock(x, y, z, Blocks.obsidian);
            else
                worldObj.setBlock(x,y,z, Blocks.stone);
        }
    }

    /**
     * Checks a given block to see if it's a water source block. If so, replaces that block with ice.
     *
     * @param x x coord
     * @param y y coord
     * @param z z coord
     */
    private void checkAndReplaceWater(int x, int y, int z)
    {
        if (worldObj.getBlock(x,y,z).equals(Blocks.water) && worldObj.getBlockMetadata(x,y,z) == 0)
            worldObj.setBlock(x,y,z, Blocks.ice);
    }
}
