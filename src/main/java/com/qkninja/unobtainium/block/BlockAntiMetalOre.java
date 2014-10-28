package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;

/**
 * @author QKninja
 */

public class BlockAntiMetalOre extends BlockUnobtainium
{
    public BlockAntiMetalOre()
    {
        super();
        setBlockName(Names.Blocks.ANTIMETAL_ORE);
        setBlockUnbreakable();
        setResistance(6000000.0F);
    }
}
