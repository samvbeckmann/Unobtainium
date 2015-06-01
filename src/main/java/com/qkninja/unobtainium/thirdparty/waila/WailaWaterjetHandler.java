package com.qkninja.unobtainium.thirdparty.waila;

import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityWaterjet;
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
 * Handles the Waila tooltip for Waterjets
 *
 * @author QKninja
 */
public class WailaWaterjetHandler implements IWailaDataProvider
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
        TileEntityWaterjet te = (TileEntityWaterjet) accessor.getTileEntity();
        if (te.getCutProgress() != 0)
        {
            currenttip.add(accessor.getNBTData().getInteger(PROGRESS) + I18n.format(Names.Waila.WAILA_PERCENT_CUT));
        }
        int tankAmount = accessor.getNBTData().getInteger(RESERVOIR_AMOUNT);
        currenttip.add(I18n.format(Names.Waila.WAILA_RESERVOIR_STATS, tankAmount));
        int byProductAmount = accessor.getNBTData().getInteger(BYPRODUCT_AMOUNT);
        if (byProductAmount != 0)
            currenttip.add(I18n.format(Names.Waila.WAILA_TANK_STATS, byProductAmount, accessor.getNBTData().getString(BYPRODUCT_FLUID)));

        return currenttip;
    }

    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z)
    {
        TileEntityWaterjet tile = (TileEntityWaterjet) te;
        tag.setInteger(PROGRESS, tile.getCutProgressScaled(100));
        tag.setInteger(RESERVOIR_AMOUNT, tile.getReservoirAmount());
        int byproductAmount = tile.getByproductAmount();
        tag.setInteger(BYPRODUCT_AMOUNT, byproductAmount);
        if (byproductAmount != 0)
            tag.setString(BYPRODUCT_FLUID, tile.getByproductFluid().getLocalizedName());
        else
            tag.setString(BYPRODUCT_FLUID, "");
        return tag;
    }

    private static final String PROGRESS = "progress";
    private static final String RESERVOIR_AMOUNT = "tankAmount";
    private static final String BYPRODUCT_AMOUNT = "byproductAmount";
    private static final String BYPRODUCT_FLUID = "fluid";
}
