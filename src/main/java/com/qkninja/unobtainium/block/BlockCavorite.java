package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;

/**
 * @author QKninja
 */

public class BlockCavorite extends BlockUnobtainium
{
    public BlockCavorite()
    {
        super(Material.iron);
        setBlockName(Names.Blocks.CAVORITE);
        setHardness(4.0F);
        setResistance(10.0F);
        setStepSound(soundTypeMetal);
    }
}
