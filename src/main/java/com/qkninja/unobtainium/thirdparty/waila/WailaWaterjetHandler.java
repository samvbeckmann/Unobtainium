package com.qkninja.unobtainium.thirdparty.waila;

import com.qkninja.unobtainium.reference.Names;
import com.qkninja.unobtainium.tileentity.TileEntityVat;
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
 * Created by sam on 5/8/15.
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
        if (te.getCutProgress() != 0) // TODO Broken before GUI is opened
        {
            currenttip.add(accessor.getNBTData().getInteger(PROGRESS) + I18n.format(Names.Waila.WATERJET_WAILA_PERCENT_CUT));
        }
        int tankAmount = accessor.getNBTData().getInteger(TANK_AMOUNT);
        currenttip.add(I18n.format(Names.Waila.VAT_WAILA_TANK_STATS, tankAmount, accessor.getNBTData().getString(FLUID)));

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
        tag.setInteger(TANK_AMOUNT, tile.getReservoirAmount());
        tag.setString(FLUID, tile.getByproductFluid().getLocalizedName());
        return tag;
    }

    private static final String PROGRESS = "progress";
    private static final String TANK_AMOUNT = "tankAmount";
    private static final String FLUID = "fluid";
}
