//package com.sweeblyn.srpwarriorsarmaments.misc;
//
//import net.minecraft.item.*;
//import net.minecraft.util.*;
//import net.minecraftforge.oredict.*;
//import org.apache.commons.lang3.tuple.*;
//import net.minecraft.item.crafting.*;
//import net.minecraftforge.registries.*;
//import java.util.*;
//
//public class RecipeHelper
//{
//    public static IRecipe create9x9CompressRecipe(final String name, final Ingredient in, ItemStack out) {
//        out = out.copy();
//        out.setCount(1);
//        final IRecipe recipe = (IRecipe)new ShapelessRecipes(name, out.copy(), NonNullList.withSize(9, (Object)in)).setRegistryName(name);
//        return recipe;
//    }
//    
//    public static IRecipe create9x9DecompressRecipe(final String name, final Ingredient in, ItemStack out) {
//        out = out.copy();
//        out.setCount(9);
//        final IRecipe recipe = (IRecipe)new ShapelessRecipes(name, out.copy(), NonNullList.withSize(1, (Object)in)).setRegistryName(name);
//        return recipe;
//    }
//    
//    public static IRecipe[] create9x9BlockIngotNugget(final String name, final ItemStack in, final ItemStack ii, final ItemStack ib) {
//        final OreIngredient n = new OreIngredient("nugget" + capitalise(name));
//        final OreIngredient i = new OreIngredient("ingot" + capitalise(name));
//        final OreIngredient b = new OreIngredient("block" + capitalise(name));
//        final IRecipe[] recipes = { create9x9DecompressRecipe(name.toLowerCase() + "_ingot_to_nugget", (Ingredient)i, in), create9x9CompressRecipe(name.toLowerCase() + "_nugget_to_ingot", (Ingredient)n, ii), create9x9DecompressRecipe(name.toLowerCase() + "_block_to_ingot", (Ingredient)b, ii), create9x9CompressRecipe(name.toLowerCase() + "_ingot_to_block", (Ingredient)i, ib) };
//        return recipes;
//    }
//    
//    @SafeVarargs
//    public static IRecipe createRecipe(final String name, final ItemStack out, final String[] recipe, final Pair<Character, Ingredient>... key) {
//        final Map<Character, Ingredient> map = new HashMap<Character, Ingredient>();
//        final Ingredient ingredient;
//        Arrays.stream(key).forEach(p -> ingredient = map.put((Character)p.getKey(), (Ingredient)p.getValue()));
//        if (recipe.length > 3 || recipe.length <= 0 || !allEqualLength(recipe) || recipe[0].length() <= 0) {
//            throw new IllegalArgumentException("invalid length for recipe");
//        }
//        final NonNullList<Ingredient> list = (NonNullList<Ingredient>)NonNullList.create();
//        for (final String s : recipe) {
//            for (final char c : s.toCharArray()) {
//                list.add((Object)map.getOrDefault(c, Ingredient.EMPTY));
//            }
//        }
//        return (IRecipe)new ShapedRecipes(name, recipe[0].length(), recipe.length, (NonNullList)list, out).setRegistryName(GameData.checkPrefix(name, true));
//    }
//    
//    @SafeVarargs
//    public static IRecipe createRecipe(final String name, final ItemStack out, final Pair<Integer, Ingredient>... values) {
//        if (values.length > 9 || values.length <= 0) {
//            throw new IllegalArgumentException("invalid length for recipe");
//        }
//        final NonNullList<Ingredient> list = (NonNullList<Ingredient>)NonNullList.create();
//        for (final Pair<Integer, Ingredient> s : values) {
//            for (int i = 0; i < (int)s.getLeft(); ++i) {
//                list.add((Object)((s.getRight() == null) ? Ingredient.EMPTY : s.getRight()));
//            }
//        }
//        return (IRecipe)new ShapelessRecipes(name, out, (NonNullList)list).setRegistryName(GameData.checkPrefix(name, true));
//    }
//    
//    public static String capitalise(final String str) {
//        if (str == null) {
//            return null;
//        }
//        if (str.length() == 0) {
//            return "";
//        }
//        return new StringBuilder(str.length()).append(Character.toTitleCase(str.charAt(0))).append(str, 1, str.length()).toString();
//    }
//    
//    public static boolean allEqualLength(final String[] array) {
//        for (int i = 0; i < array.length - 1; ++i) {
//            if (array[i].length() != array[i + 1].length()) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
