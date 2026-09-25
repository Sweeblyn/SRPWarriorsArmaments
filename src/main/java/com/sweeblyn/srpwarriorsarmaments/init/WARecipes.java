package com.sweeblyn.srpwarriorsarmaments.init;

import com.dhanantry.scapeandrunparasites.init.SRPItems;
import com.dhanantry.scapeandrunparasites.recipes.InfuserFurnaceRecipe;
import com.dhanantry.scapeandrunparasites.recipes.InfuserFurnaceRecipes;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WARecipes {
	//public static final IRecipe semiorganic_sword;
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> e) {
		InfuserFurnaceRecipes.add(new InfuserFurnaceRecipe(
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(WAItems.blazesteel_dormant) }),
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(SRPItems.ahull_drop) }),
				new ItemStack(WAItems.blazesteel, 2), ItemStack.EMPTY, 200));
		
		InfuserFurnaceRecipes.add(new InfuserFurnaceRecipe(
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(WAItems.blazesteel_dormant) }),
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(SRPItems.acanra_drop) }),
				new ItemStack(WAItems.blazesteel, 2), ItemStack.EMPTY, 200));

		InfuserFurnaceRecipes.add(new InfuserFurnaceRecipe(
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(WAItems.hivesilver_tainted) }),
				Ingredient.fromStacks(new ItemStack[] { new ItemStack(WAItems.quench_super) }),
				new ItemStack(WAItems.hivesilver), ItemStack.EMPTY, 200));
		
		//example recipe from srp
//		InfuserFurnaceRecipes.add(new InfuserFurnaceRecipe(
//				Ingredient.fromStacks(new ItemStack[] { new ItemStack(Items.IRON_INGOT) }),
//				Ingredient.fromStacks(new ItemStack[] { new ItemStack(SRPItems.DEADBLOOD_FLUID) }),
//				new ItemStack(SRPItems.semiorganicingot, 1), new ItemStack(Items.GLASS_BOTTLE, 1), 200));
	}
	static {
		//semiorganic_sword = RecipeHelper.createRecipe();
	}
}
