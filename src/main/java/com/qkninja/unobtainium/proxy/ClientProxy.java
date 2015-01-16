package com.qkninja.unobtainium.proxy;

import com.qkninja.unobtainium.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

/**
 * Contains methods for client-side proxy operations.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
