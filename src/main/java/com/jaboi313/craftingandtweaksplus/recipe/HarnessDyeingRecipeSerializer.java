package com.jaboi313.craftingandtweaksplus.recipe;

import com.mojang.serialization.MapCodec;

import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class HarnessDyeingRecipeSerializer {

    public static final RecipeSerializer<HarnessDyeingRecipe> INSTANCE =
            new RecipeSerializer<>(
                    MapCodec.unit(new HarnessDyeingRecipe()),
                    StreamCodec.unit(new HarnessDyeingRecipe())
            );

}