package com.sweeblyn.srpwarriorsarmaments.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.sweeblyn.srpwarriorsarmaments.ModelHelper;
import com.sweeblyn.srpwarriorsarmaments.blocks.BlockWA;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WABlocks {
	
	public static final Block blazesteel_block = (Block)new BlockWA("blazesteel_block", Material.IRON);
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Block> e) {
		for (Field f : WABlocks.class.getDeclaredFields()) {
			try {
				if (Modifier.isStatic(f.getModifiers()) && f.get(null) instanceof Block) {
					Block item = (Block) f.get(null);

					System.out.println(item.getTranslationKey());
					
					if (item.getTranslationKey().equals("item.null")) {
						ResourceLocation regName = item.getRegistryName();
						item.setTranslationKey(regName.getNamespace() + "." + regName.getPath());
					}

					
					
					e.getRegistry().register(item);
					ModelHelper.registerBlockModel(item);
				}
			} catch (IllegalAccessException e1) {
			}
		}
	}
}
