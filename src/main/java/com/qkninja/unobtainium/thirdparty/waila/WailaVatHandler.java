package com.qkninja.unobtainium.thirdparty.waila;

import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Handles the Waila tooltip for Fusion Vats
 *
 * @author QK ninja
 */
public class WailaVatHandler implements IWailaDataProvider
{
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }

    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        TileEntityVat te = (TileEntityVat) accessor.getTileEntity();
        if (te.isFusing()) // TODO Broken before GUI is opened
        {
            currenttip.add(accessor.getNBTData().getInteger(PROGRESS) + I18n.format(Names.Waila.VAT_WAILA_PERCENT_FUSED));
        }
        int tankAmount = accessor.getNBTData().getInteger(TANK_AMOUNT);
        if (tankAmount > 0)
        {
            currenttip.add(I18n.format(Names.Waila.VAT_WAILA_TANK_STATS, tankAmount, accessor.getNBTData().getString(FLUID)));
        } else
            currenttip.add(I18n.format(Names.Waila.VAT_WAILA_TANK_EMPTY));
        return currenttip;
    }

    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z)
    {
        TileEntityVat tile = (TileEntityVat) te;
        tag.setInteger(PROGRESS, tile.getFuseProgressScaled(100));
        tag.setInteger(TANK_AMOUNT, tile.getTankAmount());
        tag.setString(FLUID, tile.getTankFluid().getLocalizedName());
        return tag;
    }

    private static final String PROGRESS = "progress";
    private static final String TANK_AMOUNT = "tankAmount";
    private static final String FLUID = "fluid";

}
