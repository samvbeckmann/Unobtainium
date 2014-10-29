package com.qkninja.unobtainium.client.handler;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QKninja
 */

public class BucketHandler
{
    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketHandler() {}

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        ItemStack result = fillCustomBucket(event.world, event.target);

        if (result == null)
            return;

        event.result = result;
        event.setResult(Event.Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition position)
    {
        Block block = world.getBlock(position.blockX, position.blockY, position.blockZ);

        Item bucket = buckets.get(block);
        if (bucket != null && world.getBlockMetadata(position.blockX, position.blockY, position.blockZ) == 0)
        {
            world.setBlockToAir(position.blockX, position.blockY, position.blockZ);
            return new ItemStack(bucket);
        } else
            return null;
    }
}
