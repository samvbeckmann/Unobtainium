package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;

/**
 * @author QKninja
 */

public class BlockOrichalcum extends BlockUnobtainium
{
    public BlockOrichalcum()
    {
        super(Material.iron);
        setBlockName(Names.Blocks.ORICHALCUM);
        setHardness(3.0F);
        setResistance(10.0F);
        setStepSound(soundTypeMetal);
    }
}
