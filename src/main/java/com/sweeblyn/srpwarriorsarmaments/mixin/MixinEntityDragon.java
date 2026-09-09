package com.sweeblyn.srpwarriorsarmaments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.sweeblyn.srpwarriorsarmaments.DragonTweaksConfig;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseChargingPlayer;
import net.minecraft.entity.boss.dragon.phase.PhaseLanding;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

@Mixin(EntityDragon.class)
public abstract class MixinEntityDragon extends EntityLivingBase {
	private MixinEntityDragon(World worldIn) {
		super(worldIn);
	}

	@Redirect(method = "onLivingUpdate()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/boss/EntityDragon;move(Lnet/minecraft/entity/MoverType;DDD)V"), require = 2)
	private void dragontweaks_changeSpeed(EntityDragon $this, MoverType type, double x, double y, double z) {
	    if (type != MoverType.SELF) {
	        $this.move(type, x, y, z);
	    } else {
	    	IPhase curPhase = $this.getPhaseManager().getCurrentPhase();
	    	final double speedMult = DragonTweaksConfig.dragonSpeed;
	    	final double actualSpeedMult;
	    	if (curPhase instanceof PhaseLanding) {
	    		actualSpeedMult = DragonTweaksConfig.dragonSpeedPerch;
	    	}
	    	else if (curPhase instanceof PhaseChargingPlayer) {
	    		actualSpeedMult = DragonTweaksConfig.dragonSpeedCharge;
	    	}
	    	else {
	    		actualSpeedMult = speedMult;
	  
	        $this.move(type, x * actualSpeedMult, y * actualSpeedMult, z * actualSpeedMult);
	    	}
	    }
	}
	
	@ModifyConstant(method = "applyEntityAttributes()V", constant = @Constant(doubleValue = 200.0D)) //updateDragonEnderCrystal()
	private double dragontweaks_changeHealth(double value) {
		  return DragonTweaksConfig.dragonMaxHealth;
	}
	
	@ModifyConstant(method = "collideWithEntities(Ljava/util/List;)V", constant = @Constant(floatValue = 5.0F))
	private float dragontweaks_changeWingDamage(float value) {
		  return DragonTweaksConfig.dragonDmg / 2;
	}
	
	@ModifyConstant(method = "attackEntitiesInList(Ljava/util/List;)V", constant = @Constant(floatValue = 10.0F))
	private float dragontweaks_changeHeadDamage(float value) {
		  return DragonTweaksConfig.dragonDmg;
	}
	
	@ModifyConstant(method = "updateDragonEnderCrystal()V", constant = @Constant(floatValue = 1.0F)) //attackEntityFrom
	private float dragontweaks_changeCrystalHealing(float value) {
		  return DragonTweaksConfig.crystalHealing;
	}
	
	@ModifyConstant(method = "attackEntityFromPart(Lnet/minecraft/entity/MultiPartEntityPart;Lnet/minecraft/util/DamageSource;F)Z", constant = @Constant(floatValue = 4.0F))
	private float dragontweaks_changeBodyDamage(float value) {
		  return DragonTweaksConfig.bodyDmgReduction;
	}
	
	@Inject(at = @At("HEAD"), method = "attackEntityFromPart(Lnet/minecraft/entity/MultiPartEntityPart;Lnet/minecraft/util/DamageSource;F)Z", cancellable = true)
	private void dragontweaks_explosionImmunityCheck(MultiPartEntityPart part, DamageSource source, float damage, CallbackInfoReturnable<Boolean> ci) {
		if (source.isExplosion() && DragonTweaksConfig.explosionImmunity) {
			ci.cancel();
		}
	}
	
	@Inject(at = @At("HEAD"), method = "addPotionEffect(Lnet/minecraft/potion/PotionEffect;)V", cancellable = true)
	private void dragontweaks_potionImmunityCheck(PotionEffect potioneffectIn, CallbackInfo ci) {
		if (!(DragonTweaksConfig.potionImmunity))
			super.addPotionEffect(potioneffectIn);
	}
}
