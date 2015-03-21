package com.qkninja.unobtainium.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import java.util.Random;

/**
 * ECU speeds up various processes and can rapidly cool down materials.
 */
public class TileEntityECU extends TileEntityUnobtainium
{
    private Random rnd = new Random();

    public TileEntityECU()
    {
        super();
    }

    @Override
    public void updateEntity()
    {
        int yOffset = rnd.nextInt(10) - 5;
        int xOffset = rnd.nextInt(10) - 5;
        int zOffset = rnd.nextInt(10) - 5;

        if ((xOffset != 0 || yOffset != 0 || zOffset != 0) &&
                (Math.abs(xOffset) + Math.abs(yOffset) + Math.abs(zOffset) <= 5))
        {
            checkAndReplaceLava(xCoord + xOffset, yCoord + yOffset, zCoord + zOffset);
        }
    }

    /**
     * Checks given block to see if it's lava. If so, replaces that block with the appropriate cooled material.
     * @param x x coord
     * @param y y coord
     * @param z z coord
     */
    private void checkAndReplaceLava(int x, int y, int z) // TODO: a bit buggy
    {
        Block block = worldObj.getBlock(x, y, z);

        if (block.getMaterial() == Material.lava)
        {
            if (block.equals(Blocks.flowing_lava))
            {
                worldObj.setBlock(x, y, z, Blocks.stone);
            } else if (block.equals(Blocks.lava))
                worldObj.setBlock(x, y, z, Blocks.obsidian);
        }
    }
}
