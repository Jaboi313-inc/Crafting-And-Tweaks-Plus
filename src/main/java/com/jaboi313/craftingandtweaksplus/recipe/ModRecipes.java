package com.jaboi313.craftingandtweaksplus.recipe;

import com.jaboi313.craftingandtweaksplus.CraftingAndTweaksPlus;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipes {

    public static RecipeSerializer<HarnessDyeingRecipe> HARNESS_DYEING;

    public static void initialize() {

        HARNESS_DYEING = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                Identifier.fromNamespaceAndPath(CraftingAndTweaksPlus.MOD_ID, "harness_dyeing"
                ),
                HarnessDyeingRecipeSerializer.INSTANCE
        );
    }
}