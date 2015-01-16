package com.qkninja.unobtainium.tileentity;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.ArrayList;
import java.util.List;

/**
 * ECU speeds up various processes and can rapidly cool down materials.
 */
public class TileEntityECU extends TileEntityUnobtainium
{
    private List<BlockPosition> activeBlocks = new ArrayList<BlockPosition>();

    public TileEntityECU()
    {
        super();
    }

    @Override
    public void updateEntity()
    {
        List<BlockPosition> newActiveBlocks = new ArrayList<BlockPosition>();

        // Checks all the blocks around the initial tileEntity
        if (checkBlockForLava(xCoord-1, yCoord, zCoord))
            newActiveBlocks.add(new BlockPosition(xCoord-1, yCoord, zCoord));
        if (checkBlockForLava(xCoord+1, yCoord, zCoord))
            newActiveBlocks.add(new BlockPosition(xCoord+1, yCoord, zCoord));
        if (checkBlockForLava(xCoord, yCoord-1, zCoord))
            newActiveBlocks.add(new BlockPosition(xCoord, yCoord-1, zCoord));
        if (checkBlockForLava(xCoord, yCoord+1, zCoord))
            newActiveBlocks.add(new BlockPosition(xCoord, yCoord+1, zCoord));
        if (checkBlockForLava(xCoord, yCoord, zCoord-1))
            newActiveBlocks.add(new BlockPosition(xCoord, yCoord, zCoord-1));
        if (checkBlockForLava(xCoord, yCoord, zCoord+1))
            newActiveBlocks.add(new BlockPosition(xCoord, yCoord, zCoord+1));

        // Checks all the blocks around all the active blocks
        for(BlockPosition blockToCheck : activeBlocks)
        {
            int x = blockToCheck.getX();
            int y = blockToCheck.getY();
            int z = blockToCheck.getZ();

            if (checkBlockForLava(x-1, y, z))
                newActiveBlocks.add(new BlockPosition(x-1, y, z));
            if (checkBlockForLava(x+1, y, z))
                newActiveBlocks.add(new BlockPosition(x+1, y, z));
            if (checkBlockForLava(x, y-1, z))
                newActiveBlocks.add(new BlockPosition(x, y-1, z));
            if (checkBlockForLava(x, y+1, z))
                newActiveBlocks.add(new BlockPosition(x, y+1, z));
            if (checkBlockForLava(x, y, z-1))
                newActiveBlocks.add(new BlockPosition(x, y, z-1));
            if (checkBlockForLava(x, y, z+1))
                newActiveBlocks.add(new BlockPosition(x, y, z+1));
        }

        activeBlocks = newActiveBlocks;
    }

    private boolean checkBlockForLava(int x, int y, int z)
    {
        Block locBlock = worldObj.getBlock(x, y, z);
        Material block = locBlock.getMaterial();

        if (block == Material.lava)
        {
            worldObj.setBlock(x, y, z, Blocks.obsidian);
            return true;
        } else return false;
    }

//    @Override
//    public void readFromNBT(NBTTagCompound nbtTagCompound)
//    {
//        super.readFromNBT(nbtTagCompound);
//
//        // Read the Active Blocks list from NBT
//        NBTTagList tagList = nbtTagCompound.getTagList(Names.NBT.ACTIVE_BLOCKS, 10);
//        activeBlocks = new ArrayList<BlockPosition>();
//        for (int i = 0; i < tagList.tagCount(); ++i)
//        {
//            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
//            short BlockIndex = tagCompound.getShort("Block");
//            if (BlockIndex >= 0 && BlockIndex < activeBlocks.size())
//            {
//                activeBlocks.add(BlockPosition.loadItemStackFromNBT(tagCompound));
//            }
//        }
//    }
//
//    @Override
//    public void writeToNBT(NBTTagCompound nbtTagCompound)
//    {
//        super.writeToNBT(nbtTagCompound);
//
//        // Write the Active Blocks list to NBT
//        NBTTagList tagList = new NBTTagList();
//        for (int index = 0; index < activeBlocks.size(); index++)
//        {
//                NBTTagCompound tagCompound = new NBTTagCompound();
//                tagCompound.setByte("Block", (byte) index);
//                activeBlocks.get(index).writeToNBT(tagCompound);
//                tagList.appendTag(tagCompound);
//        }
//        nbtTagCompound.setTag(Names.NBT.ACTIVE_BLOCKS, tagList);
//    }

}
