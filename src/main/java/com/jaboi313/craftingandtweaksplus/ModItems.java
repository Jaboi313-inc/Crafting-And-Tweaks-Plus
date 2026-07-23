package com.jaboi313.craftingandtweaksplus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jaboi313.craftingandtweaksplus.item.HarnessHelper;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemLore;

public class ModItems {

    public static final Item THREE_BY_THREE_PICKAXE =
        register(
            "3x3_pickaxe",
            new Item.Properties()
                    .pickaxe(
                        ToolMaterial.NETHERITE,
                        1.0F,
                        -2.8F)
                    .durability(2031)
                    .enchantable(15)
                    .rarity(Rarity.EPIC)
                    .stacksTo(1)
                    .component(
                        ModComponents.THREE_BY_THREE,
                        true)
                    .component(
                        DataComponents.LORE,
                        new ItemLore(List.of(
                                Component.literal("Mine 3x3").withColor(0xAA00AA)))
                    )
        );

    public static final Map<String, Item> SPEED_HARNESSES = new LinkedHashMap<>();

    private static void registerHarnesses() {
    for (DyeColor color : DyeColor.values()) {
        for (int level = 1; level <= 5; level++) {

            String name = color.getName()
                    + "_speed_" 
                    + level 
                    + "_harness";

            SPEED_HARNESSES.put(
                name,
                register(
                    name,
                    HarnessHelper.createSpeedHarness(color, level)
                )
            );
        }
    }
}

    private static Item register(String name, Item.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(
                CraftingAndTweaksPlus.MOD_ID,
                name
        );

        ResourceKey<Item> key = ResourceKey.create(
                BuiltInRegistries.ITEM.key(),
                id
        );

        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                new Item(properties.setId(key))
        );
        }

    public static void initialize() {
        registerHarnesses();
    }
}