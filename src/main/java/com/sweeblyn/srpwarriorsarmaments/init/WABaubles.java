package com.sweeblyn.srpwarriorsarmaments.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.sweeblyn.srpwarriorsarmaments.ModelHelper;
import com.sweeblyn.srpwarriorsarmaments.items.baubles.ItemAmuletJustice;
import com.sweeblyn.srpwarriorsarmaments.items.baubles.ItemAmuletJusticeEye;
import com.sweeblyn.srpwarriorsarmaments.items.baubles.ItemHeadMask;
import com.sweeblyn.srpwarriorsarmaments.items.baubles.ItemTrinketBeckonPermit;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WABaubles {
	public static final Item amulet_justice = (Item) new ItemAmuletJustice("amulet_justice");
	public static final Item amulet_justice_eye = (Item) new ItemAmuletJusticeEye("amulet_justice_eye");

	public static final Item trinket_beckon_permit = (Item) new ItemTrinketBeckonPermit("trinket_beckon_permit");

	public static final Item head_mask = (Item) new ItemHeadMask("head_mask");

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> e) {
		for (Field f : WABaubles.class.getDeclaredFields()) {
			try {
				if (Modifier.isStatic(f.getModifiers()) && f.get(null) instanceof Item) {
					Item item = (Item) f.get(null);

					if (item.getTranslationKey().equals("item.null")) {
						ResourceLocation regName = item.getRegistryName();
						item.setTranslationKey(regName.getNamespace() + "." + regName.getPath());
					}

					e.getRegistry().register(item);
					ModelHelper.registerItemModel(item);
				}
			} catch (IllegalAccessException e1) {
			}
		}
	}
}
