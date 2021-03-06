package com.qkninja.unobtainium.init;

import com.qkninja.unobtainium.block.*;
import com.qkninja.unobtainium.block.BlockWaterjet;
import com.qkninja.unobtainium.item.ItemBlockECU;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Reference;
import com.qkninja.unobtainium.tileentity.TileEntityECU;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import com.qkninja.unobtainium.tileentity.TileEntityWaterRecycler;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Initializes the blocks and tile entities in the mod.
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
    public static final BlockUnobtainium oilResin = new BlockOilResin();
    public static final BlockUnobtainium plastic = new BlockPlastic();
    public static final BlockUnobtainium fusionVat = new BlockFusionVat(0);
    public static final BlockUnobtainium externalCoolingUnit = new BlockECU();
    public static final BlockUnobtainium waterjet = new BlockWaterjet();
    public static final BlockUnobtainium waterRecycler = new BlockWaterRecycler();



    public static void init()
    {
        GameRegistry.registerBlock(mithrilOre, Names.Blocks.MITHRIL_ORE);
        GameRegistry.registerBlock(lynguriumOre, Names.Blocks.LYNGURIUM_ORE);
        GameRegistry.registerBlock(antiMetalOre, Names.Blocks.ANTIMETAL_ORE);
        GameRegistry.registerBlock(mithril, Names.Blocks.MITHRIL);
        GameRegistry.registerBlock(orichalcum, Names.Blocks.ORICHALCUM);
        GameRegistry.registerBlock(galvorn, Names.Blocks.GALVORN);
        GameRegistry.registerBlock(cavorite, Names.Blocks.CAVORITE);
        GameRegistry.registerBlock(oilResin, Names.Blocks.OIL_RESIN);
        GameRegistry.registerBlock(plastic, Names.Blocks.PLASTIC);
        GameRegistry.registerBlock(fusionVat, Names.Blocks.FUSION_VAT);
        GameRegistry.registerTileEntity(TileEntityVat.class, Names.TileEntities.TILE_FUSION_VAT);
        GameRegistry.registerBlock(externalCoolingUnit, ItemBlockECU.class, Names.Blocks.ECU);
        GameRegistry.registerTileEntity(TileEntityECU.class, Names.TileEntities.TILE_ECU);
        GameRegistry.registerBlock(waterjet, Names.Blocks.WATERJET);
        GameRegistry.registerTileEntity(TileEntityWaterjet.class, Names.TileEntities.TILE_WATERJET);
        GameRegistry.registerBlock(waterRecycler, Names.Blocks.WATER_RECYCLER);
        GameRegistry.registerTileEntity(TileEntityWaterRecycler.class, Names.TileEntities.TILE_WATER_RECYCLER);
    }
}
