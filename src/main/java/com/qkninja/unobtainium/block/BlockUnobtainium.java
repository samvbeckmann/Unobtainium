package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.creativetab.CreativeTabUnobtainium;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * @author QKninja
 */

public class BlockUnobtainium extends Block
{
    public BlockUnobtainium(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabUnobtainium.UNOBTAINIUM_TAB);
        this.setStepSound(soundTypePiston);
    }

    public BlockUnobtainium()
    {
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
       blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }
}
