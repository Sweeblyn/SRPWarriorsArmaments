package com.sweeblyn.srpwarriorsarmaments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import com.sweeblyn.srpwarriorsarmaments.DragonTweaksConfig;

import net.minecraft.entity.boss.dragon.phase.PhaseStrafePlayer;

@Mixin(PhaseStrafePlayer.class)
public abstract class MixinPhaseStrafePlayer {	
	@ModifyConstant(method = "doLocalUpdate()V", constant = @Constant(intValue = 5))
	private int dragontweaks_changeFireballFreq(int value) {
		  return DragonTweaksConfig.fireballFreq;
	}
}
