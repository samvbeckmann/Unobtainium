package com.qkninja.unobtainium.proxy;

import com.qkninja.unobtainium.client.renderer.ECURenderer;
import com.qkninja.unobtainium.client.renderer.WaterRecyclerRenderer;
import com.qkninja.unobtainium.client.renderer.WaterjetRenderer;
import com.qkninja.unobtainium.client.settings.Keybindings;
import com.qkninja.unobtainium.tileentity.TileEntityECU;
import com.qkninja.unobtainium.tileentity.TileEntityWaterRecycler;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
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

    private void registerRenderers()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterRecycler.class, new WaterRecyclerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityECU.class, new ECURenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterjet.class, new WaterjetRenderer());
    }

    public void preInit()
    {
        registerKeyBindings();
        registerRenderers();
    }

    public void init()
    {

    }

    public void postInit()
    {

    }

    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().thePlayer;
    }
}
