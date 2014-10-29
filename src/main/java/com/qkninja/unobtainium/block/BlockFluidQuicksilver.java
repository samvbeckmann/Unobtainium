package com.qkninja.unobtainium.block;

import com.qkninja.unobtainium.creativetab.CreativeTabUnobtainium;
import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * @author QKninja
 */

public class BlockFluidQuicksilver extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;

    public BlockFluidQuicksilver(Fluid fluid, Material material)
    {
        super(fluid, material);
        setCreativeTab(CreativeTabUnobtainium.UNOBTAINIUM_TAB);
        setBlockName(Names.Fluids.QUICKSILVER_FLUID);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return (side == 0 || side == 1) ? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        stillIcon = register.registerIcon(Reference.MOD_ID + ":" + Names.Fluids.QUICKSILVER_STILL);
        flowingIcon = register.registerIcon(Reference.MOD_ID + ":" + Names.Fluids.QUICKSILVER_FLOWING);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        byte flowDecayChangePerBlock = 7;
        if (canDisplace(world, x, y + densityDir, z))
        {
            flowIntoBlock(world, x, y + densityDir, z, 1);
        }
    }
}
