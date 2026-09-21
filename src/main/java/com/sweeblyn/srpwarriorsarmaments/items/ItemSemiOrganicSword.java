package com.sweeblyn.srpwarriorsarmaments.items;

import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.misc.WAToolMaterials;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;


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
	
	private boolean shouldApply(EntityPlayer player) {
		return player instanceof EntityPlayer && player.getCooledAttackStrength(0) > 0.9;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer attacker, Entity target)
    {
		if (target instanceof EntityParasiteBase) {
			//EntityPlayer player = (EntityPlayer)player;
			if (shouldApply(attacker)) {
				final int hurtResistantTime = target.hurtResistantTime;
	            target.hurtResistantTime = 0;
				target.attackEntityFrom(DamageSource.MAGIC, 7.5f);
	            target.hurtResistantTime = hurtResistantTime;
	            target.world.playSound(null, attacker.posX, attacker.posY, attacker.posZ, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.7F, 2F);
			}
        }
		return super.onLeftClickEntity(stack, attacker, target);
    }
}
