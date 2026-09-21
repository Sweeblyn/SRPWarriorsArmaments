package com.sweeblyn.srpwarriorsarmaments.items;

import com.dhanantry.scapeandrunparasites.block.BlockBase;
import com.dhanantry.scapeandrunparasites.block.IStagedBlock;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;


public class ItemBlazesteelMultitool extends ItemPaxel {
	public ItemBlazesteelMultitool(ToolMaterial material) {
		super(material, 12, -3.1f);
		this.setRegistryName("blazesteel_multitool");
        this.setTranslationKey("blazesteel_multitool");
        this.setCreativeTab(SRPWarriorsArmaments.tab);
	}

	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        System.out.println((state.getBlock() instanceof IStagedBlock) + "" + (state.getBlock() instanceof IStagedBlock ? this.efficiency*2 : this.efficiency));
        return state.getBlock() instanceof IStagedBlock ? this.efficiency*2 : this.efficiency;
    }
}
