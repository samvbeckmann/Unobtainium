package com.qkninja.unobtainium.network;

import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Handler that contains the channel for Unobtainium
 *
 * @author QKninja
 */
public class NetworkHandler
{
    private static SimpleNetworkWrapper INSTANCE;

    public static void init()
    {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    }

    public static void sendToServer(IMessage message)
    {
        INSTANCE.sendToServer(message);
    }
}
