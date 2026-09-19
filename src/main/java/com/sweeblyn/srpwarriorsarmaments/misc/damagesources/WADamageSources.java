package com.sweeblyn.srpwarriorsarmaments.misc.damagesources;

import net.minecraft.util.DamageSource;

public class WADamageSources extends DamageSource{
	 public static final DamageSource CONSECRATION = new WADamageSources("consecration").setDamageBypassesArmor();
	
	
	public WADamageSources(String damageTypeIn) {
		super(damageTypeIn);
		// TODO Auto-generated constructor stub
	}

}
