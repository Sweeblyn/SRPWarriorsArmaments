package com.sweeblyn.srpwarriorsarmaments.items;

import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.misc.WAToolMaterials;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;


public class ItemSemiOrganicSword extends ItemSword {

	public ItemSemiOrganicSword() {
		super(WAToolMaterials.SEMI_ORGANIC_SWORD);
		this.setRegistryName("semiorganic_sword");
        this.setTranslationKey("semiorganic_sword");
	}
	
	public ItemSemiOrganicSword(ToolMaterial material) {
		super(material);
		this.setRegistryName("semiorganic_sword");
        this.setTranslationKey("semiorganic_sword");
        this.setCreativeTab(SRPWarriorsArmaments.tab);
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) { 
		if (target instanceof EntityParasiteBase) {
			//final DamageSource src = (attacker instanceof EntityPlayer) ? DamageSource.causePlayerDamage((EntityPlayer)attacker) : DamageSource.causeMobDamage(attacker);
            final int hurtResistantTime = target.hurtResistantTime;
            target.hurtResistantTime = 0;
			target.attackEntityFrom(DamageSource.MAGIC, 7.5f);
            target.hurtResistantTime = hurtResistantTime;
        }
		return super.hitEntity(stack, target, attacker);
	}
}
