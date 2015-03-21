package com.qkninja.unobtainium.client.handler;

import com.qkninja.unobtainium.client.settings.Keybindings;
import com.qkninja.unobtainium.reference.Key;

/**
 * Handles key presses, allowing easy access when a set keybinding is pressed.
 */
public class KeyInputEventHandler
{
    /**
     * When sent a key input event, returns the key that is pressed.
     * @return The Key pressed by the user.
     */
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
/*
    Below code would print each keypress to the log.
 */
//    @SubscribeEvent
//    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
//    {
//        LogHelper.info(getPressedKeybinding());
//    }
}
