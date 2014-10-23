package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.*;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author QKninja
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockUnobtainium mithrilOre = new BlockMithrilOre();
    public static final BlockUnobtainium lynguriumOre = new BlockLynguriumOre();
    public static final BlockUnobtainium antiMetalOre = new BlockAntiMetalOre();
    public static final BlockUnobtainium mithril = new BlockMithril();
    public static final BlockUnobtainium orichalcum = new BlockOrichalcum();
    public static final BlockUnobtainium galvorn = new BlockGalvorn();
    public static final BlockUnobtainium cavorite = new BlockCavorite();



    public static void init()
    {
        GameRegistry.registerBlock(mithrilOre, Names.Blocks.MITHRIL_ORE);
        GameRegistry.registerBlock(lynguriumOre, Names.Blocks.LYNGURIUM_ORE);
        GameRegistry.registerBlock(antiMetalOre, Names.Blocks.ANTIMETAL_ORE);
        GameRegistry.registerBlock(mithril, Names.Blocks.MITHRIL);
        GameRegistry.registerBlock(orichalcum, Names.Blocks.ORICHALCUM);
        GameRegistry.registerBlock(galvorn, Names.Blocks.GALVORN);
        GameRegistry.registerBlock(cavorite, Names.Blocks.CAVORITE);
    }
}
