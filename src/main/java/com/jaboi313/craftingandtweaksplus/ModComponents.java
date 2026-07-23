package com.jaboi313.craftingandtweaksplus;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModComponents {

    public static final DataComponentType<Boolean> THREE_BY_THREE =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath(CraftingAndTweaksPlus.MOD_ID, "three_by_three"),
                    DataComponentType.<Boolean>builder()
                            .persistent(Codec.BOOL)
                            .build()
            );


    public static void initialize() {
    }
}