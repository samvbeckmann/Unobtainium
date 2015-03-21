package com.qkninja.unobtainium.network;

import com.qkninja.unobtainium.Unobtainium;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Reference;
import com.qkninja.unobtainium.tileentity.TileEntityUnobtainium;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

/**
 * @author QK ninja
 */
@ChannelHandler.Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>
{
    public static final String CHANNEL = Reference.MOD_ID + Names.Channels.DESCRIPTION_CHANNEL;

    static
    {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());

    }

    public static void init()
    {
        // NOOP
    }

    /**
     * @param ctx the {@link io.netty.channel.ChannelHandlerContext} which this {@link io.netty.channel.SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception
    {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = Unobtainium.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
        if (te instanceof TileEntityUnobtainium)
        {
            ((TileEntityUnobtainium)te).readFromPacket(buf);
        }
    }
}
