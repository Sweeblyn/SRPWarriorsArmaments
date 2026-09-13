package com.sweeblyn.srpwarriorsarmaments.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DisplayTooltipsHandler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onItemTooltip(ItemTooltipEvent e) {
		try {
			ItemStack stack = e.getItemStack();

			if (!stack.getItem().getRegistryName().getNamespace().equals(SRPWarriorsArmaments.MOD_ID))
				return;

			List<String> tooltip = e.getToolTip();

			int indexToInsert = tooltip.isEmpty() ? 0 : 1;

			String key = stack.getItem().getTranslationKey() + ".desc";

			if (I18n.canTranslate(key)) {
				String translation = I18n.translateToLocal(key);
				if (!translation.contains("--null")) {
					List<String> toAdd = smartSplitString(translation, 100000);
					if (tooltip.size() > indexToInsert + 1 && !tooltip.get(indexToInsert + 1).isEmpty()) {
						toAdd.add("");
					}
					Collections.reverse(toAdd);
					toAdd.forEach(t -> tooltip.add(indexToInsert, t));

				}
			}
		} catch (Exception er) {
		}
	}

	private static List<String> smartSplitString(String toSplit, int max) {
		List<String> ret = new ArrayList<String>();

		if (toSplit.indexOf("\\n") >= 0) {
			String[] newlined = toSplit.split("\\\\n");
			for (String n : newlined) {
				ret.addAll(smartSplitString(n, max));
			}
		} else {

			String temp = "";
			for (String s : toSplit.split(" ")) {
				if (temp.replace("%s%", " ").length() + s.replace("%s%", " ").length() > max) {
					ret.add(temp.trim().replace("%s%", " "));
					temp = s + " ";
				} else {
					temp += s + " ";
				}
			}
			ret.add("" + temp.trim().replace("%s%", " "));
		}
		return ret;
	}
}
