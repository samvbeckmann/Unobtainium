package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.BlockMithrilOre;
import com.qkninja.unobtainium.block.BlockUnobtainium;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author QKninja
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockUnobtainium mithrilOre = new BlockMithrilOre();

    public static void init()
    {
        GameRegistry.registerBlock(mithrilOre, "mithrilOre");
    }
}
