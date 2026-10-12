package com.sweeblyn.srpwarriorsarmaments.items;

import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.init.WABaubles;
import com.sweeblyn.srpwarriorsarmaments.init.WAPotions;

import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSemiOrganicArmor extends ItemArmor {
	public ItemSemiOrganicArmor(String regName, ArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
		super(material, 0, equipmentSlot);
		
		this.setRegistryName(regName);
		this.setTranslationKey(regName);
		
		this.setCreativeTab(SRPWarriorsArmaments.tab);
	}
	
	
    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack stack) {
        if (world.isRemote) {
            return;
        }
        int numPieces = getTotalPieces(player);
        if (player.ticksExisted % 600 == 0) {
        	if (numPieces > (player.isPotionActive(WAPotions.DIVINE) ? player.getActivePotionEffect(WAPotions.DIVINE).getAmplifier() : 0)) {
        		player.addPotionEffect(new PotionEffect(WAPotions.DIVINE, 590 , player.isPotionActive(WAPotions.DIVINE) ? 1+player.getActivePotionEffect(WAPotions.DIVINE).getAmplifier() : 0  , false, true));
        	}
        }
    }
    
    
    private int getTotalPieces(EntityPlayer player)
    {
        int amount = 0;
        for (ItemStack armorPiece : player.getArmorInventoryList())
        {
            if (armorPiece.getItem() instanceof ItemSemiOrganicArmor) {
            	amount++;
            } else if (BaublesApi.isBaubleEquipped(player, WABaubles.charm_emblem) != -1) {
            	amount++;
            }
        }

        return amount;
    }
}
