package com.qkninja.unobtainium;

import com.qkninja.unobtainium.client.handler.KeyInputEventHandler;
import com.qkninja.unobtainium.handler.ConfigurationHandler;
import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.init.ModFluidBlocks;
import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.init.Recipes;
import com.qkninja.unobtainium.proxy.IProxy;
import com.qkninja.unobtainium.reference.Reference;
import com.qkninja.unobtainium.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author QKninja
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Unobtainium
{

    @Mod.Instance(Reference.MOD_ID)
    public static Unobtainium instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.registerKeyBindings();

        ModItems.init();

        ModBlocks.init();

        ModFluidBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        Recipes.init();
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");

    }

}
