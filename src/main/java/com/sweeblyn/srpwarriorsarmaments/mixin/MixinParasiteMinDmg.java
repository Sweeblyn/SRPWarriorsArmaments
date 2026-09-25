//package com.sweeblyn.srpwarriorsarmaments.mixin;
//
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
//
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.world.World;
//
//public abstract class MixinParasiteMinDmg extends EntityParasiteBase{
//	private MixinParasiteMinDmg(World worldIn) {
//		super(worldIn);
//	}
//	
//	@Inject(at = @At("HEAD"), method = "attackEntityAsMobMinimum(dhanantry.scapeandrunparasites.entity.ai.misc)", cancellable = true)
//	private void srpwarriorsarmaments_minDamageEdit(EntityLivingBase target, CallbackInfo ci) {
//		
//	}
//}
