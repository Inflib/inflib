package com.infinitychances.inflib.datagen;

import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;


public class InfRecipes {

    public static class ToolRecipes {
       public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("i").pattern("i").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("iii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("ii").pattern("is").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("i").pattern("s").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("ii").pattern(" s").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

   }

   public static class ArmorRecipes {
        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                    .pattern("iii").pattern("i i")
                    .input('i', input);
        }

       public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                   .pattern("i i").pattern("iii").pattern("iii")
                   .input('i', input);
       }

       public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                   .pattern("iii").pattern("i i").pattern("i i")
                   .input('i', input);
       }

       public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                   .pattern("i i").pattern("i i")
                   .input('i', input);
       }

       public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                    .pattern("pip").pattern("ppp").pattern(" p ")
                    .input('p', ItemTags.PLANKS).input('i', input);
       }

       public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                    .pattern("i i").pattern("iii").pattern("i i")
                    .input('i', input);
       }

   }

    public static class CenteredRecipes {

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("iti").pattern("iii").pattern("iii")
                    .input('i', input).input('t', top);
        }

        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outsideInput, Ingredient insideInput) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("ooo").pattern("oio").pattern("ooo")
                    .input('o', outsideInput).input('i', insideInput);
        }

        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outsideInput, Ingredient insideInput) {
            return createSurroundingRecipe(category, output, outsideInput, insideInput);
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("iii").pattern("iii").pattern("ibi")
                    .input('i', input).input('b', bottom);
        }
    }

    public static class LineRecipes {

        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("lll").pattern("iii").pattern("iii")
                    .input('i', input).input('l', line);
        }

        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("iii").pattern("lll").pattern("iii")
                    .input('i', input).input('l', line);
        }

        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("iii").pattern("iii").pattern("lll")
                    .input('i', input).input('l', line);
        }
    }

}
