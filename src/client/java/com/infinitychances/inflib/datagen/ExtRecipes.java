package com.infinitychances.inflib.datagen;

import com.infinitychances.inflib.exceptions.MissingValueException;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;


public class ExtRecipes {
    private ExtRecipes() {}
    
    static String modId;
    static RecipeGenerator generator;
    static RegistryWrapper.WrapperLookup lookup;
    
    public static void setModId(String id) {
        modId = id;
    }
    
    public static void setGenerator(RecipeGenerator recipeGenerator) {
        generator = recipeGenerator;
    }
    
    public static void setWrapperLookup(RegistryWrapper.WrapperLookup wrapperLookup) {
        lookup = wrapperLookup;
    }
    
    private static void handleModRecipes() {
        if(modId == null) {
            throw new MissingValueException("Missing Mod ID! Please make sure to set it!");
        }
        if(generator == null) {
            throw new MissingValueException("Missing Recipe Generator! Please make sure to set it!");
        }
    }
    
    private static void handleWrapper() {
        if(lookup == null) {
            throw new MissingValueException("Missing Wrapper Lookup! Please make sure to set it!");
        }
    }
    

    public static class ToolRecipes {
        private ToolRecipes() {}
        
        public void offerSwordRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerSwordRecipe(output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input) {
            return createSwordRecipe(output, input, 1);
        }
        
        public void offerSwordRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createSwordRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.MISC, output, count)
                   .pattern("i").pattern("i").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerPickaxeRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerPickaxeRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input) {
            return createPickaxeRecipe(output, input, 1);
        }
        
        public static void offerPickaxeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createPickaxeRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("iii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerAxeRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerAxeRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input) {
            return createAxeRecipe(output, input, 1);
        }
        
        public static void offerAxeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createAxeRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern("is").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerShovelRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerShovelRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input) {
            return createShovelRecipe(output, input, 1);
        }
        
        public static void offerShovelRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createShovelRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("i").pattern("s").pattern("s")
                   .input('i', input).input('s', Items.STICK);
       }
        
        public static void offerHoeRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerHoeRecipe(output, input, 1, exporter);
        }
       
        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input) {
            return createHoeRecipe(output, input, 1);
        }
        
        public static void offerHoeRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createHoeRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                   .pattern("ii").pattern(" s").pattern(" s")
                   .input('i', input).input('s', Items.STICK);
       }

        public static void offerBowRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerBowRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createBowRecipe(ItemConvertible output, Ingredient input) {
            return createBowRecipe(output, input, 1);
        }

        public static void offerBowRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createHoeRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createBowRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.TOOLS, output, count)
                    .pattern(" is").pattern("i s").pattern(" is")
                    .input('i', input).input('s', Items.STRING);
        }

   }

    public static class ArmorRecipes {
        private ArmorRecipes() {}
        
        public static void offerHelmetRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerHelmetRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input) {
            return createHelmetRecipe(output, input, 1);
        }
        
        public static void offerHelmetRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createHelmetRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("iii").pattern("i i")
                    .input('i', input);
        }
        
        public static void offerChestplateRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerChestplateRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input) {
            return createChestplateRecipe(output, input, 1);
        }
        
        public static void offerChestplateRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createChestplateRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createChestplateRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("iii").pattern("iii")
                   .input('i', input);
       }
        
        public static void offerLeggingsRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerLeggingsRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input) {
            return createLeggingsRecipe(output, input, 1);
        }
        
        public static void offerLeggingsRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createLeggingsRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createLeggingsRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("iii").pattern("i i").pattern("i i")
                   .input('i', input);
       }
        
        public static void offerBootsRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerBootsRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input) {
            return createBootsRecipe(output, input, 1);
        }
        
        public static void offerBootsRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createBootsRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createBootsRecipe(ItemConvertible output, Ingredient input, Integer count) {
           return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                   .pattern("i i").pattern("i i")
                   .input('i', input);
       }
        
        public static void offerShieldRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerShieldRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input) {
            return createShieldRecipe(output, input, 1);
        }
        
        public static void offerShieldRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createShieldRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("pip").pattern("ppp").pattern(" p ")
                    .input('p', ItemTags.PLANKS).input('i', input);
       }
        
        public static void offerHorseArmorRecipe(ItemConvertible output, Item input, RecipeExporter exporter) {
            offerHorseArmorRecipe(output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input) {
            return createHorseArmorRecipe(output, input, 1);
        }
        
        public static void offerHorseArmorRecipe(ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createHorseArmorRecipe(output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createHorseArmorRecipe(ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),RecipeCategory.COMBAT, output, count)
                    .pattern("i i").pattern("iii").pattern("i i")
                    .input('i', input);
       }

   }

    public static class SurroundingRecipes {
        private SurroundingRecipes() {}
        
        public static void offerItemTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Item top, RecipeExporter exporter) {
            offerItemTopRecipe(category, output, input, top, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top) {
            return createItemTopRecipe(category, output, input, top, 1);
        }
        
        public static void offerItemTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Item top, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createItemTopRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(top), count)
                    .criterion(RecipeGenerator.hasItem(top), generator.conditionsFromItem(top))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createItemTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient top, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iti").pattern("iii").pattern("iii")
                    .input('i', input).input('t', top);
        }
        
        public static void offerSurroundingRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, RecipeExporter exporter) {
            offerSurroundingRecipe(category, output, outside, inside, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside) {
            return createSurroundingRecipe(category, output, outside, inside, 1);
        }
        
        public static void offerSurroundingRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createSurroundingRecipe(category, output, Ingredient.ofItems(outside), Ingredient.ofItems(inside), count)
                    .criterion(RecipeGenerator.hasItem(inside), generator.conditionsFromItem(inside))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("ooo").pattern("oio").pattern("ooo")
                    .input('o', outside).input('i', inside);
        }
        
        public static void offerItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, RecipeExporter exporter) {
            offerSurroundingRecipe(category, output, outside, inside, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside) {
            return createItemMiddleRecipe(category, output, outside, inside, 1);
        }
        
        public static void offerItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Item outside, Item inside, Integer count, RecipeExporter exporter) {
            offerSurroundingRecipe(category, output, outside, inside, count, exporter);
        }

        public static CraftingRecipeJsonBuilder createItemMiddleRecipe(RecipeCategory category, ItemConvertible output, Ingredient outside, Ingredient inside, Integer count) {
            return createSurroundingRecipe(category, output, outside, inside, count);
        }
        
        public static void offerItemBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Item bottom, RecipeExporter exporter) {
            offerItemBottomRecipe(category, output, input, bottom, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom) {
            return createItemBottomRecipe(category, output, input, bottom, 1);
        }
        
        public static void offerItemBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Item bottom, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createSurroundingRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(bottom), count)
                    .criterion(RecipeGenerator.hasItem(bottom), generator.conditionsFromItem(bottom))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createItemBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient bottom, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("ibi")
                    .input('i', input).input('b', bottom);
        }
    }

    public static class LineRecipes {
        private LineRecipes() {}
        
        public static void offerTopLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter) {
            offerTopLineRecipe(category, output, input, line, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createTopLineRecipe(category, output, input, line, 1);
        }
        
        public static void offerTopLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createTopLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count)
                    .criterion(RecipeGenerator.hasItem(line), generator.conditionsFromItem(line))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }

        public static CraftingRecipeJsonBuilder createTopLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("lll").pattern("iii").pattern("iii")
                    .input('i', input).input('l', line);
        }
        
        public static void offerMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter) {
            offerMiddleLineRecipe(category, output, input, line, 1, exporter);
        }
       
        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createMiddleLineRecipe(category, output, input, line, 1);
        }
        
        public static void offerMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createMiddleLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count)
                    .criterion(RecipeGenerator.hasItem(line), generator.conditionsFromItem(line))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("lll").pattern("iii")
                    .input('i', input).input('l', line);
        }
        
        public static void offerBottomLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, RecipeExporter exporter) {
            offerBottomLineRecipe(category, output, input, line, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line) {
            return createBottomLineRecipe(category, output, input, line, 1);
        }
        
        public static void offerBottomLineRecipe(RecipeCategory category, ItemConvertible output, Item input, Item line, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createBottomLineRecipe(category, output, Ingredient.ofItems(input), Ingredient.ofItems(line), count)
                    .criterion(RecipeGenerator.hasItem(line), generator.conditionsFromItem(line))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Ingredient line, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("lll")
                    .input('i', input).input('l', line);
        }
    }

    public static class SurroundedAirRecipes {
        private SurroundedAirRecipes() {}
        
        public static void offerAirCenterRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerAirCenterRecipe(category, output, input, 1, exporter);
        }

        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirCenterRecipe(category, output, input, 1);
        }
        
        public static void offerAirCenterRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createAirCenterRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirCenterRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("i i").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerAirTopRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerAirTopRecipe(category, output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirTopRecipe(category, output, input, 1);
        }
        
        public static void offerAirTopRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createAirTopRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirTopRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("i i").pattern("iii").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerAirBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerAirBottomRecipe(category, output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createAirBottomRecipe(category, output, input, 1);
        }
        
        public static void offerAirBottomRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createAirBottomRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createAirBottomRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("i i")
                    .input('i', input);
        }
    }

    public static class LineAirRecipes {
        private LineAirRecipes() {}
        
        public static void offerTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerTopLineAirRecipe(category, output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createTopLineAirRecipe(category, output, input, 1);
        }
        
        public static void offerTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createTopLineAirRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createTopLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("   ").pattern("iii").pattern("iii")
                    .input('i', input);
        }
        
        public static void offerMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerMiddleLineAirRecipe(category, output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createMiddleLineAirRecipe(category, output, input, 1);
        }
        
        public static void offerMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createMiddleLineAirRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createMiddleLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("   ").pattern("iii")
                    .input('i', input);
        }

        public static void offerBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, RecipeExporter exporter) {
            offerBottomLineAirRecipe(category, output, input, 1, exporter);
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input) {
            return createBottomLineAirRecipe(category, output, input, 1);
        }
        
        public static void offerBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Item input, Integer count, RecipeExporter exporter) {
            handleModRecipes();
            createBottomLineAirRecipe(category, output, Ingredient.ofItems(input), count)
                    .criterion(RecipeGenerator.hasItem(input), generator.conditionsFromItem(input))
                    .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(modId, output.toString())));
        }
        
        public static CraftingRecipeJsonBuilder createBottomLineAirRecipe(RecipeCategory category, ItemConvertible output, Ingredient input, Integer count) {
            return ShapedRecipeJsonBuilder.create(lookup.getOrThrow(RegistryKeys.ITEM),category, output, count)
                    .pattern("iii").pattern("iii").pattern("   ")
                    .input('i', input);
        }
    }

}
