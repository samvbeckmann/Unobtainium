package com.qkninja.unobtainium.utility;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fluids.FluidStack;

/**
 * Helper Methods for the byte buffer
 *
 * @author QKninja
 */
public class ByteBufHelper
{
    /**
     * Writes the FluidStack's FluidID(short) and amount(short)
     *
     * @param to Byte Buffer to be written to
     * @param fluidStack Stack to write
     */
    public static void writeFluidStack(ByteBuf to, FluidStack fluidStack)
    {

            if (fluidStack == null)
                to.writeShort(-1);
            else
            {
                to.writeShort(fluidStack.fluidID);
                to.writeShort(fluidStack.amount);
            }
    }

    /**
     * Read an {@link FluidStack} from the byte buffer provided. It uses the Minecraft encoding.
     *
     * @param from The buffer to read from
     * @return The fluidStack read
     */
    public static FluidStack readFluidStack(ByteBuf from)
    {
        FluidStack stack = null;
        short short1 = from.readShort();

        if (short1 >= 0)
        {
            short short2 = from.readShort();
            stack = new FluidStack(short1, short2);
        }

        return stack;
    }
}
