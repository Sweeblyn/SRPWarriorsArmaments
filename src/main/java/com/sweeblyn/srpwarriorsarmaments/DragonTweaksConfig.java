package com.sweeblyn.srpwarriorsarmaments;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

@Config(modid = SRPSurvivorsArmaments.MOD_ID)
public class DragonTweaksConfig {
	@Name("Dragon Speed Multiplier")
	@Comment("What should the Ender Dragon speed multiplier be? (Recommended to not use values above 3.0, as dragon may exit render distance) (default: 1.0)")
	public static double dragonSpeed = 1.0;
	
	@Name("Dragon Speed to Perch Multiplier")
	@Comment("What should the Ender Dragon speed multiplier be while its trying to perch? (Recommended to not use values above 2.0, as dragon may get stuck while trying to perch) (default: 1.0)")
	public static double dragonSpeedPerch = 1.0;
	
	@Name("Dragon Speed to Charge Multiplier")
	@Comment("What should the Ender Dragon speed multiplier be while its charging at a player? (default: 1.0)")
	public static double dragonSpeedCharge = 1.0;
	
	@Name("Dragon Health")
	@Comment("What should the Ender Dragon Max Health be? (default: 200.0)")
	public static double dragonMaxHealth = 200.0;
	
	@Name("Dragon Damage")
	@Comment("What should the Ender Dragon Base Damage be? (default: 10.0)")
	public static float dragonDmg = 10.0f;
	
	@Name("Crystal Healing")
	@Comment("How much should the dragon heal from crystals? (default: 1.0)")
	public static float crystalHealing = 1.0f;
	
	@Name("Fireball Frequency")
	@Comment("How often should the dragon shoot fireballs? Lower values increase frequency. (default: 5)")
	public static int fireballFreq = 5;
	
	@Name("Explosion Immunity")
	@Comment("Should the dragon be immune to explosion damage, including beds? (default: false)")
	public static boolean explosionImmunity = false;
	
	@Name("Potion Effect Immunity")
	@Comment("Should the dragon be immune to all status effects? (default: true)")
	public static boolean potionImmunity = true;
	
	@Name("Body hit damage reduction")
	@Comment("If an attack hits anywhere but the head, Damage / This number = New Damage (default: 4.0)")
	public static float bodyDmgReduction = 4.0f;
}

