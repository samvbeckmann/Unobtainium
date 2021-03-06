package com.qkninja.unobtainium;

import com.qkninja.unobtainium.client.handler.KeyInputEventHandler;
import com.qkninja.unobtainium.handler.ConfigurationHandler;
import com.qkninja.unobtainium.handler.GuiHandler;
import com.qkninja.unobtainium.init.ModBlocks;
import com.qkninja.unobtainium.init.ModFluidBlocks;
import com.qkninja.unobtainium.init.ModItems;
import com.qkninja.unobtainium.init.Recipes;
import com.qkninja.unobtainium.network.DescriptionHandler;
import com.qkninja.unobtainium.network.NetworkHandler;
import com.qkninja.unobtainium.proxy.CommonProxy;
import com.qkninja.unobtainium.reference.Reference;
import com.qkninja.unobtainium.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * <h1>Unobtainium</h1>
 * <br>Unobtainium is a mod about impossible materials.
 *
 * @author QKninja
 * @version 1.7.10-1.0
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Unobtainium
{

    @Mod.Instance(Reference.MOD_ID)
    public static Unobtainium instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        proxy.preInit();

        ModItems.init();

        ModBlocks.init();

        ModFluidBlocks.init();

        NetworkHandler.init();

        DescriptionHandler.init();

        FMLInterModComms.sendMessage("Waila", "register", "com.qkninja.unobtainium.thirdparty.waila.Waila.onWailaCall");

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        // Register the Gui Handler
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        proxy.init();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        Recipes.init();
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();

        LogHelper.info("Post Initialization Complete!");

    }

    @Mod.EventHandler
    public void onIMCMessages(FMLInterModComms.IMCEvent event)
    {

    }

}
