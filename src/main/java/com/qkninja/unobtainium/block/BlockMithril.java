package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;

/**
 * @author QKninja
 */

public class BlockMithril extends BlockUnobtainium
{
    public BlockMithril()
    {
        super(Material.iron);
        setBlockName(Names.Blocks.MITHRIL);
        setHardness(5.0F);
        setResistance(10.0F);
        setStepSound(soundTypeMetal);
    }
}
