package com.qkninja.unobtainium.proxy;

import com.qkninja.unobtainium.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Contains methods for client-side proxy operations.
 */
public class ClientProxy extends CommonProxy
{
    private void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

    @Override
    public void preInit()
    {
        registerKeyBindings();
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }
}
