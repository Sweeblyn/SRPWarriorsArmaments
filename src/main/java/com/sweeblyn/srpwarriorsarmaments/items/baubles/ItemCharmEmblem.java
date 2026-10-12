package com.sweeblyn.srpwarriorsarmaments.items.baubles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
import com.dhanantry.scapeandrunparasites.init.SRPPotions;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.init.WABaubles;
import com.sweeblyn.srpwarriorsarmaments.init.WAPotions;
import com.sweeblyn.srpwarriorsarmaments.items.ItemSemiOrganicArmor;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemCharmEmblem extends Item implements IBauble {

	public static final Item RING = null;

	public ItemCharmEmblem(String name) {

		super();
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(SRPWarriorsArmaments.tab);
	}

	@Override
	public BaubleType getBaubleType(ItemStack item) {
		return BaubleType.CHARM;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (!player.getEntityWorld().isRemote) {
			int numPieces = getTotalPieces((EntityPlayer) player);
			if (player.ticksExisted % 600 == 0) {
				System.out.println(numPieces+" "+(player.isPotionActive(WAPotions.DIVINE) ? player.getActivePotionEffect(WAPotions.DIVINE).getAmplifier()+1: "potion isnt applied yet"));
				if (numPieces > (player.isPotionActive(WAPotions.DIVINE)
						? player.getActivePotionEffect(WAPotions.DIVINE).getAmplifier()+1
						: 0)) {
					player.addPotionEffect(new PotionEffect(WAPotions.DIVINE, 590,
							player.isPotionActive(WAPotions.DIVINE)
									? 1 + player.getActivePotionEffect(WAPotions.DIVINE).getAmplifier()
									: 0,
							false, true));
				}
			}
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for (int i = 0; i < baubles.getSlots(); i++)
				if ((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty())
						&& baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
					baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
					if (!player.capabilities.isCreativeMode) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					}
					onEquipped(player.getHeldItem(hand), player);
					break;
				}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	private int getTotalPieces(EntityPlayer player) {
		int amount = 0;
		for (ItemStack armorPiece : player.getArmorInventoryList()) {
			if (armorPiece.getItem() instanceof ItemSemiOrganicArmor) {
				amount++;
			}
		}
		
		if (BaublesApi.isBaubleEquipped(player, WABaubles.charm_emblem) != -1) {
			amount++;
		}

		return amount;
	}
}
