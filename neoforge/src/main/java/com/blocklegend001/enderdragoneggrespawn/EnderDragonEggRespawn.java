package com.blocklegend001.enderdragoneggrespawn;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class EnderDragonEggRespawn {

    public EnderDragonEggRespawn(IEventBus eventBus) {
        CommonClass.init();
    }
}
