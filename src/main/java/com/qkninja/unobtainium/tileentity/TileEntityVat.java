package com.qkninja.unobtainium.tileentity;

import com.qkninja.unobtainium.init.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * @author QKninja
 */
public class TileEntityVat extends TileEntity
{

    private int clicked = 0;
    private static final String NBT_CLICK_AMOUNT = "ClickedAmount";

    public TileEntityVat()
    {
        super();
    }

    public void updateEntity()
    {
        if (clicked >= 10)
        {
            this.setClickAmount(0);
            worldObj.setBlock(xCoord, yCoord + 1, zCoord, ModBlocks.orichalcum);

        }
    }

    // Currently not used.
    public int getClickAmount()
    {
        return clicked;
    }

    public void setClickAmount(int newAmount)
    {
        clicked = newAmount;
    }

    public void addClick()
    {
        clicked++;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        clicked = nbt.getInteger(NBT_CLICK_AMOUNT);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger(NBT_CLICK_AMOUNT, clicked);
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound tileTag = new NBTTagCompound();
        this.writeToNBT(tileTag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tileTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        this.readFromNBT(pkt.func_148857_g());
    }
}
