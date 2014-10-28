package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;

/**
 * @author QKninja
 */

public class BlockPlastic extends BlockUnobtainium
{
    public BlockPlastic()
    {
        super();
        setBlockName(Names.Blocks.PLASTIC);
        setHardness(2.0F);
        setResistance(7.0F);
        setStepSound(soundTypeSnow);
    }
}
