package com.sweeblyn.srpwarriorsarmaments.items;

import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;

import net.minecraft.item.Item;

public class ItemWA extends Item {
	public ItemWA(final String name) {
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setCreativeTab(SRPWarriorsArmaments.tab);
	}
}
