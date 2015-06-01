package com.qkninja.unobtainium.handler;

import com.qkninja.unobtainium.reference.ConfigValues;
import com.qkninja.unobtainium.reference.Messages;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

/**
 * Sets up the configuration file.
 *
 * @author QKninja
 */
public class ConfigurationHandler
{
    public static Configuration configuration;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        ConfigValues.waterjetDrainTick = configuration.getInt(Messages.Configuration.WATERJET_DRAIN_TICK,
                Configuration.CATEGORY_GENERAL, 1000, 1, Integer.MAX_VALUE, Messages.Configuration.WATERJET_DRAIN_TICK_DESCRIPTION);
        ConfigValues.recyclermulitplier = configuration.getFloat(Messages.Configuration.RECYCLER_MULTIPLIER,
                Configuration.CATEGORY_GENERAL, .1F, 0F, 1F, Messages.Configuration.RECYCLER_MULTIPLIER_DESCRIPTION);

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
