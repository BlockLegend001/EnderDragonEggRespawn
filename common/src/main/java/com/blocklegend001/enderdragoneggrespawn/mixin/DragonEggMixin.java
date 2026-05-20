package com.blocklegend001.enderdragoneggrespawn.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.end.EnderDragonFight;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.EndPodiumFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonFight.class)
public class DragonEggMixin {
    @Shadow @Final
    private ServerLevel level;

    @Unique
    public boolean enderDragonEggRespawn$isPreviouslyKilled() {
        return hasPreviouslyKilledDragon;
    }

    @Shadow @Final
    private BlockPos origin;

    @Shadow
    private boolean hasPreviouslyKilledDragon;

    @Inject(method = "setDragonKilled", at = @At("HEAD"))
    private void onDragonKilled(EnderDragon dragon, CallbackInfo ci) {
        if (hasPreviouslyKilledDragon) {
            BlockPos pos = level.getHeightmapPos(
                    Heightmap.Types.MOTION_BLOCKING,
                    EndPodiumFeature.getLocation(origin)
            ).above();
            if (level.getBlockState(pos).isAir()) {
                level.setBlockAndUpdate(pos, Blocks.DRAGON_EGG.defaultBlockState());
            }
        }
    }
}