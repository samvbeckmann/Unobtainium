package com.qkninja.unobtainium.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Generic Message for Networking
 *
 * @author QKninja
 */
public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>
{
    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
     * is needed.
     *
     * @param message The message
     * @param ctx context of the message
     * @return an optional return message
     */
    public REQ onMessage(REQ message, MessageContext ctx)
    {
        if (ctx.side == Side.SERVER)
            handleServerSide(message, ctx.getServerHandler().playerEntity);
        else
            handleClientSide(message, null);

        return null;
    }

    public abstract void handleClientSide(REQ message, EntityPlayer player);

    public abstract void handleServerSide(REQ message, EntityPlayer player);
}
