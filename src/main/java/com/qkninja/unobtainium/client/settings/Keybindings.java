package com.qkninja.unobtainium.client.settings;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Sam on 2014-10-20.
 */
public class Keybindings
{
    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);

}
