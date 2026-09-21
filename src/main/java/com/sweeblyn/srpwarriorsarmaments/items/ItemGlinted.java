package com.sweeblyn.srpwarriorsarmaments.items;

import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGlinted extends Item {
	public ItemGlinted(String name)
    {
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setCreativeTab(SRPWarriorsArmaments.tab);
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
