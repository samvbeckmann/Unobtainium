package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.reference.Names;
import net.minecraft.block.material.Material;

/**
 * @author QKninja
 */

public class BlockGalvorn extends BlockUnobtainium
{
    public BlockGalvorn()
    {
        super(Material.iron);
        setBlockName(Names.Blocks.GALVORN);
        setHardness(5.0F);
        setResistance(10.0F);
        setStepSound(soundTypeMetal);
    }
}
