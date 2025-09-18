package com.infinitychances.inflib.datagen;

import com.infinitychances.inflib.exceptions.MissingValueException;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;


public class ExtRecipes {
    private ExtRecipes() {}
    
    private static String modId;
    
    public static void setModId(String id) {
        modId = id;
    }
    
    private static void handleModRecipes() {
        if(modId == null) {
            throw new MissingValueException("Missing Mod ID! Please make sure to set it!");
        }
    }


    public static class ToolRecipes {
        private ToolRecipes() {}
        
        public void offerSwordRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerSwordRecipe(output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createSwordRecipe(output, input, 1, lookup);
        }
        
        public void offerSwordRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createSwordRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.MISC, output, count)
                   .pattern("i").pattern("i").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerPickaxeRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerPickaxeRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createPickaxeRecipe(output, input, 1, lookup);
        }
        
        public static void offerPickaxeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createPickaxeRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("iii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerAxeRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerAxeRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createAxeRecipe(output, input, 1, lookup);
        }
        
        public static void offerAxeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createAxeRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern("is").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerShovelRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerShovelRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createShovelRecipe(output, input, 1, lookup);
        }
        
        public static void offerShovelRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createShovelRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("i").pattern("s").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerHoeRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerHoeRecipe(output, input, 1, exporter, lookup);
        }
       
        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createHoeRecipe(output, input, 1, lookup);
        }
        
        public static void offerHoeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createHoeRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern(" s").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

        public static void offerBowRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerBowRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createBowRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createBowRecipe(output, input, 1, lookup);
        }

        public static void offerBowRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createHoeRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createBowRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                    .pattern(" is").pattern("i s").pattern(" is")
                    .input('i', input).input('s', Items.STRING);
        }

   }

    public static class ArmorRecipes {
        private ArmorRecipes() {}
        
        public static void offerHelmetRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerHelmetRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createHelmetRecipe(output, input, 1, lookup);
        }
        
        public static void offerHelmetRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createHelmetRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("iii").pattern("i i")
                    .input('i', input);
        }
        
        public static void offerChestplateRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerChestplateRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createChestplateRecipe(output, input, 1, lookup);
        }
        
        public static void offerChestplateRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createChestplateRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("iii").pattern("iii")
                   .input('i', input);
       }
        
        public static void offerLeggingsRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerLeggingsRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createLeggingsRecipe(output, input, 1, lookup);
        }
        
        public static void offerLeggingsRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createLeggingsRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("iii").pattern("i i").pattern("i i")
                   .input('i', input);
       }
        
        public static void offerBootsRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerBootsRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createBootsRecipe(output, input, 1, lookup);
        }
        
        public static void offerBootsRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createBootsRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("i i")
                   .input('i', input);
       }
        
        public static void offerShieldRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerShieldRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createShieldRecipe(output, input, 1, lookup);
        }
        
        public static void offerShieldRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createShieldRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("pip").pattern("ppp").pattern(" p ")
                    .input('p', ItemTags.PLANKS).input('i', input);
       }
        
        public static void offerHorseArmorRecipe(ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerHorseArmorRecipe(output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createHorseArmorRecipe(output, input, 1, lookup);
        }
        
        public static void offerHorseArmorRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createHorseArmorRecipe(output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("i i").pattern("iii").pattern("i i")
                    .input('i', input);
       }

   }

    public static class SurroundingRecipes {
        private SurroundingRecipes() {}
        
        public static void offerItemTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Item top, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerItemTopRecipe(category, output, input, top, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top, RegistryWrapper.WrapperLookup lookup) {
            return createItemTopRecipe(category, output, input, top, 1, lookup);
        }
        
        public static void offerItemTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Item top, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createItemTopRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(top), count, lookup)
                    .criterion(RecipeGenerator.hasItem(top), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),top)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iti").pattern("iii").pattern("iii")
                    .input('i', input).input('t', top);
        }
        
        public static void offerSurroundingRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerSurroundingRecipe(category, output, outside, inside, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, RegistryWrapper.WrapperLookup lookup) {
            return createSurroundingRecipe(category, output, outside, inside, 1, lookup);
        }
        
        public static void offerSurroundingRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createSurroundingRecipe(category, output, Ingredient.ofItems(outside), Ingredient.ofItems(inside), count, lookup)
                    .criterion(RecipeGenerator.hasItem(inside), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),inside)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("ooo").pattern("oio").pattern("ooo")
                    .input('o', outside).input('i', inside);
        }
        
        public static void offerItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerSurroundingRecipe(category, output, outside, inside, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, RegistryWrapper.WrapperLookup lookup) {
            return createItemMiddleRecipe(category, output, outside, inside, 1, lookup);
        }
        
        public static void offerItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerSurroundingRecipe(category, output, outside, inside, count, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return createSurroundingRecipe(category, output, outside, inside, count, lookup);
        }
        
        public static void offerItemBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Item bottom, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerItemBottomRecipe(category, output, input, bottom, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom, RegistryWrapper.WrapperLookup lookup) {
            return createItemBottomRecipe(category, output, input, bottom, 1, lookup);
        }

        public static void offerItemBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Item bottom, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createSurroundingRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(bottom), count, lookup)
                    .criterion(RecipeGenerator.hasItem(bottom), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),bottom)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("ibi")
                    .input('i', input).input('b', bottom);
        }
    }

    public static class LineRecipes {
        private LineRecipes() {}
        
        public static void offerTopLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerTopLineRecipe(category, output, input, line, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, RegistryWrapper.WrapperLookup lookup) {
            return createTopLineRecipe(category, output, input, line, 1, lookup);
        }
        
        public static void offerTopLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createTopLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count, lookup)
                    .criterion(RecipeGenerator.hasItem(line), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),line)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("lll").pattern("iii").pattern("iii")
                    .input('i', input).input('l', line);
        }
        
        public static void offerMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerMiddleLineRecipe(category, output, input, line, 1, exporter, lookup);
        }
       
        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, RegistryWrapper.WrapperLookup lookup) {
            return createMiddleLineRecipe(category, output, input, line, 1, lookup);
        }
        
        public static void offerMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createMiddleLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count, lookup)
                    .criterion(RecipeGenerator.hasItem(line), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),line)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("lll").pattern("iii")
                    .input('i', input).input('l', line);
        }
        
        public static void offerBottomLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerBottomLineRecipe(category, output, input, line, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, RegistryWrapper.WrapperLookup lookup) {
            return createBottomLineRecipe(category, output, input, line, 1, lookup);
        }
        
        public static void offerBottomLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createBottomLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count, lookup)
                    .criterion(RecipeGenerator.hasItem(line), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM),line)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("lll")
                    .input('i', input).input('l', line);
        }
    }

    public static class SurroundedAirRecipes {
        private SurroundedAirRecipes() {}
        
        public static void offerAirCenterRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerAirCenterRecipe(category, output, input, 1, exporter, lookup);
        }

        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createAirCenterRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerAirCenterRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createAirCenterRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("i i").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerAirTopRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerAirTopRecipe(category, output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createAirTopRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerAirTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createAirTopRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("i i").pattern("iii").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerAirBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerAirBottomRecipe(category, output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createAirBottomRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerAirBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createAirBottomRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("i i")
                    .input('i', input);
        }
    }

    public static class LineAirRecipes {
        private LineAirRecipes() {}
        
        public static void offerTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerTopLineAirRecipe(category, output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createTopLineAirRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createTopLineAirRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("   ").pattern("iii").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerMiddleLineAirRecipe(category, output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createMiddleLineAirRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createMiddleLineAirRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("   ").pattern("iii")
                    .input('i', input);
        }

        public static void offerBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            offerBottomLineAirRecipe(category, output, input, 1, exporter, lookup);
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, RegistryWrapper.WrapperLookup lookup) {
            return createBottomLineAirRecipe(category, output, input, 1, lookup);
        }
        
        public static void offerBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter, RegistryWrapper.WrapperLookup lookup) {
            handleModRecipes();
            createBottomLineAirRecipe(category, output, Ingredient.ofItems(input), count, lookup)
                    .criterion(RecipeGenerator.hasItem(input), RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(lookup.getOrThrow(RegistryKeys.ITEM), input)))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count, RegistryWrapper.WrapperLookup lookup) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("   ")
                    .input('i', input);
        }
    }

}
