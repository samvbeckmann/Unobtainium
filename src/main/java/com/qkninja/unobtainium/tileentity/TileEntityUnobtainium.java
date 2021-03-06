package com.qkninja.unobtainium.tileentity;

import com.qkninja.unobtainium.network.DescriptionHandler;
import com.qkninja.unobtainium.reference.Names;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

/**
 * Generic tile entity class
 */
public class TileEntityUnobtainium extends TileEntity
{
    protected String customName;

    public TileEntityUnobtainium()
    {
        customName = "";
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public String getCustomName()
    {
        return customName;
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME))
        {
            this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName())
        {
            nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
        }
    }

    @Override
    public Packet getDescriptionPacket()
    {
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(xCoord);
        buf.writeInt(yCoord);
        buf.writeInt(zCoord);
        writeToPacket(buf);

        return new FMLProxyPacket(buf, DescriptionHandler.CHANNEL);
    }

    public void writeToPacket(ByteBuf buf)
    {

    }

    public void readFromPacket(ByteBuf buf)
    {

    }

}
