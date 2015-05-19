package com.qkninja.unobtainium.thirdparty.waila;

import com.qkninja.unobtainium.block.BlockFusionVat;
import com.qkninja.unobtainium.block.BlockWaterjet;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by sam on 3/29/15.
 */
public class Waila
{
    public static void onWailaCall(IWailaRegistrar registrar)
    {
        registrar.registerStackProvider(new WailaVatHandler(), BlockFusionVat.class);
        registrar.registerBodyProvider(new WailaVatHandler(), BlockFusionVat.class);
        registrar.registerNBTProvider(new WailaVatHandler(), BlockFusionVat.class);

        registrar.registerStackProvider(new WailaWaterjetHandler(), BlockWaterjet.class);
        registrar.registerBodyProvider(new WailaWaterjetHandler(), BlockWaterjet.class);
        registrar.registerNBTProvider(new WailaWaterjetHandler(), BlockWaterjet.class);
    }
}
