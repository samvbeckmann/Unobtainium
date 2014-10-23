package com.qkninja.unobtainium.client.handler;

import com.qkninja.unobtainium.client.settings.Keybindings;
import com.qkninja.unobtainium.reference.Key;
import com.qkninja.unobtainium.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

/**
 * Created by Sam on 2014-10-20.
 */

public class KeyInputEventHandler
{
    private static Key getPressedKeybinding()
    {
        if (Keybindings.charge.isPressed())
        {
            return Key.CHARGE;
        }
        else if (Keybindings.release.isPressed())
        {
            return Key.RELEASE;
        }

        return Key.UNKNOWN;
    }

//    @SubscribeEvent
//    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
//    {
//        LogHelper.info(getPressedKeybinding());
//    }
}
