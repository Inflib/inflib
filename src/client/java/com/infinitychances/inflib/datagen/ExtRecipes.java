package com.infinitychances.inflib.datagen;

import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;


public class ExtRecipes {
    private ExtRecipes() {}

    public static class ToolRecipes {
        private ToolRecipes() {}

        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input) {
            return createSwordRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, count)
                   .pattern("i").pattern("i").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input) {
            return createPickaxeRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, count)
                   .pattern("iii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input) {
            return createAxeRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern("is").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input) {
            return createShovelRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, count)
                   .pattern("i").pattern("s").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }

        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input) {
            return createHoeRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern(" s").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

   }

    public static class ArmorRecipes {
        private ArmorRecipes() {}

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input) {
            return createHelmetRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                    .pattern("iii").pattern("i i")
                    .input('i', input);
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input) {
            return createChestplateRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("iii").pattern("iii")
                   .input('i', input);
       }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input) {
            return createLeggingsRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                   .pattern("iii").pattern("i i").pattern("i i")
                   .input('i', input);
       }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input) {
            return createBootsRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("i i")
                   .input('i', input);
       }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input) {
            return createShieldRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                    .pattern("pip").pattern("ppp").pattern(" p ")
                    .input('p', ItemTags.PLANKS).input('i', input);
       }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input) {
            return createHorseArmorRecipe(output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, count)
                    .pattern("i i").pattern("iii").pattern("i i")
                    .input('i', input);
       }

   }

    public static class SurroundingRecipes {
        private SurroundingRecipes() {}

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top) {
            return createItemTopRecipe(category, output, input, top, 1);
        }

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iti").pattern("iii").pattern("iii")
                    .input('i', input).input('t', top);
        }

        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside) {
            return createSurroundingRecipe(category, output, outside, inside, 1);
        }

        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("ooo").pattern("oio").pattern("ooo")
                    .input('o', outside).input('i', inside);
        }

        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside) {
            return createItemMiddleRecipe(category, output, outside, inside, 1);
        }

        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count) {
            return createSurroundingRecipe(category, output, outside, inside, count);
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom) {
            return createItemBottomRecipe(category, output, input, bottom, 1);
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("iii").pattern("ibi")
                    .input('i', input).input('b', bottom);
        }
    }

    public static class LineRecipes {
        private LineRecipes() {}

        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createTopLineRecipe(category, output, input, line, 1);
        }

        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("lll").pattern("iii").pattern("iii")
                    .input('i', input).input('l', line);
        }

        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createMiddleLineRecipe(category, output, input, line, 1);
        }

        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("lll").pattern("iii")
                    .input('i', input).input('l', line);
        }

        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createBottomLineRecipe(category, output, input, line, 1);
        }

        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("iii").pattern("lll")
                    .input('i', input).input('l', line);
        }
    }

    public static class SurroundedAirRecipes {
        private SurroundedAirRecipes() {}


        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirCenterRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("i i").pattern("iii")
                    .input('i', input);
        }

        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirTopRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("i i").pattern("iii").pattern("iii")
                    .input('i', input);
        }

        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirBottomRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("iii").pattern("i i")
                    .input('i', input);
        }
    }

    public static class LineAirRecipes {
        private LineAirRecipes() {}

        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createTopLineAirRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("   ").pattern("iii").pattern("iii")
                    .input('i', input);
        }

        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createMiddleLineAirRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("   ").pattern("iii")
                    .input('i', input);
        }

        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createBottomLineAirRecipe(category, output, input, 1);
        }

        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(category, output, count)
                    .pattern("iii").pattern("iii").pattern("   ")
                    .input('i', input);
        }
    }

}
