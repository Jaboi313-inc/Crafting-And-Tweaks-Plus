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
                            .build());

    public static final DataComponentType<Boolean> FIVE_BY_FIVE =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath(CraftingAndTweaksPlus.MOD_ID, "five_by_five"),
                    DataComponentType.<Boolean>builder()
                            .persistent(Codec.BOOL)
                            .build());
                            
    public static final DataComponentType<Boolean> SEVEN_BY_SEVEN =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath(CraftingAndTweaksPlus.MOD_ID, "seven_by_seven"),
                    DataComponentType.<Boolean>builder()
                            .persistent(Codec.BOOL)
                            .build());

    public static final DataComponentType<Boolean> BEDROCK_BREAKER =
            Registry.register(
                    BuiltInRegistries.DATA_COMPONENT_TYPE,
                    Identifier.fromNamespaceAndPath(CraftingAndTweaksPlus.MOD_ID, "bedrock_breaker"),
                    DataComponentType.<Boolean>builder()
                            .persistent(Codec.BOOL)
                            .build());

    public static void initialize() {
    }
}