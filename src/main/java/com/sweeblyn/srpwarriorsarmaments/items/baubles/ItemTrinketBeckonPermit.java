package com.sweeblyn.srpwarriorsarmaments.items.baubles;

import com.dhanantry.scapeandrunparasites.entity.ai.misc.EntityParasiteBase;
import com.dhanantry.scapeandrunparasites.init.SRPPotions;
import com.sweeblyn.srpwarriorsarmaments.SRPWarriorsArmaments;
import com.sweeblyn.srpwarriorsarmaments.init.WAPotions;

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

public class ItemTrinketBeckonPermit extends Item implements IBauble {

	public static final Item RING = null;

	public ItemTrinketBeckonPermit(String name) {

		super();
		this.setRegistryName(name);
		this.setTranslationKey(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(SRPWarriorsArmaments.tab);
	}

	@Override
	public BaubleType getBaubleType(ItemStack item) {
		return BaubleType.TRINKET;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (player.ticksExisted % 19 == 0) {
			Vec3d center = player.getPositionVector();
			AxisAlignedBB box = new AxisAlignedBB(center.x, center.y, center.z, center.x, center.y, center.z).grow(10);
			for (EntityLivingBase entity : player.world.getEntitiesWithinAABB(EntityLivingBase.class, box,
					e -> !(e instanceof EntityPlayer))) {
				if (entity instanceof EntityParasiteBase && entity.isPotionActive(SRPPotions.DEBAR_E)) {
					entity.removeActivePotionEffect(SRPPotions.DEBAR_E);
					entity.addPotionEffect(new PotionEffect(SRPPotions.RAGE_E, 2000, 2, false, true));
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
}
