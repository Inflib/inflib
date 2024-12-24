package net.infinitychances.inflib.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.infinitychances.inflib.InfLib;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;


public class InfRecipes extends FabricRecipeProvider {

    public InfRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        InfLib.LOGGER.warn("Do not use the generate method from InfRecipes!");

    }

    public static class ToolRecipes {
       public static CraftingRecipeJsonBuilder createSwordRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern(" i ").pattern(" i ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createPickaxeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern("iii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createAxeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern(" ii").pattern(" si").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createShovelRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern(" i ").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }

       public static CraftingRecipeJsonBuilder createHoeRecipe(ItemConvertible output, Ingredient input) {
           return ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, output)
                   .pattern(" ii").pattern(" s ").pattern(" s ")
                   .input('i', input).input('s', Items.STICK);
       }
   }

   public static class ArmorRecipes {
        public static CraftingRecipeJsonBuilder createHelmetRecipe(ItemConvertible output, Ingredient input) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                    .pattern("iii").pattern("i i").pattern("   ")
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
                   .pattern("   ").pattern("i i").pattern("i i")
                   .input('i', input);
       }
       public static CraftingRecipeJsonBuilder createShieldRecipe(ItemConvertible output, Ingredient input) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                    .pattern("pip").pattern("ppp").pattern(" p ")
                    .input('p', ItemTags.PLANKS).input('i', input);
       }
   }

    public static class CustomUseRecipes {
        public static CraftingRecipeJsonBuilder createSurroundingRecipe(RecipeCategory category,ItemConvertible output, Ingredient outsideInput, Ingredient insideInput) {
            return ShapedRecipeJsonBuilder.create(category, output)
                    .pattern("ooo").pattern("oio").pattern("ooo")
                    .input('o', outsideInput).input('i', insideInput);
        }
    }

}
