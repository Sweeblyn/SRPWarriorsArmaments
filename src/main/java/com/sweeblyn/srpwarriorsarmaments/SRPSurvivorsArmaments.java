package com.sweeblyn.srpwarriorsarmaments;

import com.sweeblyn.srpwarriorsarmaments.init.WAItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SRPSurvivorsArmaments.MOD_ID)
public class SRPSurvivorsArmaments {
    public static final String MOD_ID = "srpsurvivorsarmaments";

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        //STMaterials.init();
        MinecraftForge.EVENT_BUS.register(WAItems.class);
    }
}
