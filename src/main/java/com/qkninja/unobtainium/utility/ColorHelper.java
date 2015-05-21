package com.qkninja.unobtainium.utility;

/**
 * Helper class for transforming int colors to rgb values.
 *
 * Thanks to the Ex Nihilo code for help with bitwise shift operators
 */
public class ColorHelper
{
    public float r;
    public float g;
    public float b;
    public float a;

    public ColorHelper(float red, float green, float blue, float alpha)
    {
        this.r = red;
        this.g = green;
        this.b = blue;
        this.a = alpha;
    }

    public ColorHelper(int color)
    {
        this.a = 1.0F;
        this.r = (float) (color >> 16 & 255) / 255.0F;
        this.g = (float) (color >> 8 & 255) / 255.0F;
        this.b = (float) (color & 255) / 255.0F;
    }

    public ColorHelper (String hexValue)
    {
        this(Integer.parseInt(hexValue, 16));
    }
}
