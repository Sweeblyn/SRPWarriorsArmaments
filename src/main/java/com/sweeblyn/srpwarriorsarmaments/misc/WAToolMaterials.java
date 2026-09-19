package com.sweeblyn.srpwarriorsarmaments.misc;

import com.dhanantry.scapeandrunparasites.init.SRPItems;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.init.WAItems;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class WAToolMaterials {
	
    public static final Item.ToolMaterial SEMI_ORGANIC_SWORD;
    public static final Item.ToolMaterial GILDED_HIVE_BANE; 
    public static final Item.ToolMaterial BLAZESTEEL;
    public static final ItemArmor.ArmorMaterial SEMI_ORGANIC_ARMOR;
	
	static {
		SEMI_ORGANIC_SWORD = EnumHelper.addToolMaterial("SEMI_ORGANIC_SWORD", 0, 512, 0.0f, 3.5f, 14).setRepairItem(new ItemStack(SRPItems.semiorganicingot));
		GILDED_HIVE_BANE = EnumHelper.addToolMaterial("GILDED_HIVE_BANE", 0, 2048, 0.0f, 4.5f, 17).setRepairItem(new ItemStack(SRPItems.semiorganicingot));
		
		BLAZESTEEL = EnumHelper.addToolMaterial("BLAZESTEEL", 4, 2048, 10.0f, 9.5f, 15).setRepairItem(new ItemStack(WAItems.blazesteel));
		
		SEMI_ORGANIC_ARMOR = EnumHelper.addArmorMaterial(SRPWarriorsArmaments.MOD_ID + ":" + "semiorganic_armor", SRPWarriorsArmaments.MOD_ID + ":" + "semiorganic", 40, new int[]{4, 7, 9, 4}, 17, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 3);
	}
}

