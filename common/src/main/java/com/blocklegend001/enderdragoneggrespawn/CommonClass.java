package com.blocklegend001.enderdragoneggrespawn;

import com.blocklegend001.enderdragoneggrespawn.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;

public class CommonClass {

    public static void init() {
        if (Services.PLATFORM.isModLoaded("enderdragoneggrespawn")) {
            Constants.LOG.info("EnderDragonEggRespawn Loaded!");
        }
    }
}
