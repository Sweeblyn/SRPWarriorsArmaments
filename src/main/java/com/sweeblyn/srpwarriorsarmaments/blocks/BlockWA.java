package com.sweeblyn.srpwarriorsarmaments.blocks;

import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWA extends Block{

	public BlockWA(String name, Material materialIn) {
		super(materialIn);
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setCreativeTab(SRPWarriorsArmaments.tab);
		
		
	}
	
}
