package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.item.*;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Initializes all the items in the mod.
 * @author QKninja
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemUnobtainium lynguriumGem = new ItemLynguriumGem();
    public static final ItemUnobtainium mithrilIngot = new ItemMithrilIngot();
    public static final ItemUnobtainium galvornIngot = new ItemGalvornIngot();
    public static final ItemUnobtainium orichalcumIngot = new ItemOrichalcumIngot();
    public static final ItemUnobtainium cavoriteIngot = new ItemCavoriteIngot();
    public static final ItemResinChunk resinChunk = new ItemResinChunk();
    public static final ItemPlasticChunk plasticChunk = new ItemPlasticChunk();


    public static void init()
    {
        GameRegistry.registerItem(lynguriumGem, Names.Items.LYNGURIUM_GEM);
        GameRegistry.registerItem(mithrilIngot, Names.Items.MITHRIL_INGOT);
        GameRegistry.registerItem(galvornIngot, Names.Items.GALVORN_INGOT);
        GameRegistry.registerItem(orichalcumIngot, Names.Items.ORICHALCUM_INGOT);
        GameRegistry.registerItem(cavoriteIngot, Names.Items.CAVORITE_INGOT);
        GameRegistry.registerItem(resinChunk, Names.Items.RESIN_CHUNK);
        GameRegistry.registerItem(plasticChunk, Names.Items.PLASTIC_CHUNK);
    }
}
