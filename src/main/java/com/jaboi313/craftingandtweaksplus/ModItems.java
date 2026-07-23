package com.jaboi313.craftingandtweaksplus;

import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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
                        -2.8F
                    )
                    .durability(2031)
                    .enchantable(15)
                    .rarity(Rarity.EPIC)
                    .stacksTo(1)
                    .component(
                        ModComponents.THREE_BY_THREE,
                        true
                    )
                    .component(
                        DataComponents.LORE,
                        new ItemLore(
                            List.of(
                                Component.literal("Mine 3x3")
                                    .withColor(0xAA00AA)
                            )
                        )
                    )
        );

    public static final Item BLACK_SPEED_1_HARNESS = register("black_speed_1_harness", new Item.Properties());
    public static final Item BLUE_SPEED_1_HARNESS = register("blue_speed_1_harness", new Item.Properties());
    public static final Item BROWN_SPEED_1_HARNESS = register("brown_speed_1_harness", new Item.Properties());
    public static final Item CYAN_SPEED_1_HARNESS = register("cyan_speed_1_harness", new Item.Properties());
    public static final Item GRAY_SPEED_1_HARNESS = register("gray_speed_1_harness", new Item.Properties());
    public static final Item GREEN_SPEED_1_HARNESS = register("green_speed_1_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_1_HARNESS = register("light_blue_speed_1_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_1_HARNESS = register("light_gray_speed_1_harness", new Item.Properties());
    public static final Item LIME_SPEED_1_HARNESS = register("lime_speed_1_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_1_HARNESS = register("magenta_speed_1_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_1_HARNESS = register("orange_speed_1_harness", new Item.Properties());
    public static final Item PINK_SPEED_1_HARNESS = register("pink_speed_1_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_1_HARNESS = register("purple_speed_1_harness", new Item.Properties());
    public static final Item RED_SPEED_1_HARNESS = register("red_speed_1_harness", new Item.Properties());
    public static final Item WHITE_SPEED_1_HARNESS = register("white_speed_1_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_1_HARNESS = register("yellow_speed_1_harness", new Item.Properties());
    
    public static final Item BLACK_SPEED_2_HARNESS = register("black_speed_2_harness", new Item.Properties());
    public static final Item BLUE_SPEED_2_HARNESS = register("blue_speed_2_harness", new Item.Properties());
    public static final Item BROWN_SPEED_2_HARNESS = register("brown_speed_2_harness", new Item.Properties());
    public static final Item CYAN_SPEED_2_HARNESS = register("cyan_speed_2_harness", new Item.Properties());
    public static final Item GRAY_SPEED_2_HARNESS = register("gray_speed_2_harness", new Item.Properties());
    public static final Item GREEN_SPEED_2_HARNESS = register("green_speed_2_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_2_HARNESS = register("light_blue_speed_2_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_2_HARNESS = register("light_gray_speed_2_harness", new Item.Properties());
    public static final Item LIME_SPEED_2_HARNESS = register("lime_speed_2_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_2_HARNESS = register("magenta_speed_2_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_2_HARNESS = register("orange_speed_2_harness", new Item.Properties());
    public static final Item PINK_SPEED_2_HARNESS = register("pink_speed_2_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_2_HARNESS = register("purple_speed_2_harness", new Item.Properties());
    public static final Item RED_SPEED_2_HARNESS = register("red_speed_2_harness", new Item.Properties());
    public static final Item WHITE_SPEED_2_HARNESS = register("white_speed_2_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_2_HARNESS = register("yellow_speed_2_harness", new Item.Properties());

    public static final Item BLACK_SPEED_3_HARNESS = register("black_speed_3_harness", new Item.Properties());
    public static final Item BLUE_SPEED_3_HARNESS = register("blue_speed_3_harness", new Item.Properties());
    public static final Item BROWN_SPEED_3_HARNESS = register("brown_speed_3_harness", new Item.Properties());
    public static final Item CYAN_SPEED_3_HARNESS = register("cyan_speed_3_harness", new Item.Properties());
    public static final Item GRAY_SPEED_3_HARNESS = register("gray_speed_3_harness", new Item.Properties());
    public static final Item GREEN_SPEED_3_HARNESS = register("green_speed_3_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_3_HARNESS = register("light_blue_speed_3_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_3_HARNESS = register("light_gray_speed_3_harness", new Item.Properties());
    public static final Item LIME_SPEED_3_HARNESS = register("lime_speed_3_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_3_HARNESS = register("magenta_speed_3_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_3_HARNESS = register("orange_speed_3_harness", new Item.Properties());
    public static final Item PINK_SPEED_3_HARNESS = register("pink_speed_3_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_3_HARNESS = register("purple_speed_3_harness", new Item.Properties());
    public static final Item RED_SPEED_3_HARNESS = register("red_speed_3_harness", new Item.Properties());
    public static final Item WHITE_SPEED_3_HARNESS = register("white_speed_3_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_3_HARNESS = register("yellow_speed_3_harness", new Item.Properties());

    public static final Item BLACK_SPEED_4_HARNESS = register("black_speed_4_harness", new Item.Properties());
    public static final Item BLUE_SPEED_4_HARNESS = register("blue_speed_4_harness", new Item.Properties());
    public static final Item BROWN_SPEED_4_HARNESS = register("brown_speed_4_harness", new Item.Properties());
    public static final Item CYAN_SPEED_4_HARNESS = register("cyan_speed_4_harness", new Item.Properties());
    public static final Item GRAY_SPEED_4_HARNESS = register("gray_speed_4_harness", new Item.Properties());
    public static final Item GREEN_SPEED_4_HARNESS = register("green_speed_4_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_4_HARNESS = register("light_blue_speed_4_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_4_HARNESS = register("light_gray_speed_4_harness", new Item.Properties());
    public static final Item LIME_SPEED_4_HARNESS = register("lime_speed_4_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_4_HARNESS = register("magenta_speed_4_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_4_HARNESS = register("orange_speed_4_harness", new Item.Properties());
    public static final Item PINK_SPEED_4_HARNESS = register("pink_speed_4_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_4_HARNESS = register("purple_speed_4_harness", new Item.Properties());
    public static final Item RED_SPEED_4_HARNESS = register("red_speed_4_harness", new Item.Properties());
    public static final Item WHITE_SPEED_4_HARNESS = register("white_speed_4_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_4_HARNESS = register("yellow_speed_4_harness", new Item.Properties());

    public static final Item BLACK_SPEED_5_HARNESS = register("black_speed_5_harness", new Item.Properties());
    public static final Item BLUE_SPEED_5_HARNESS = register("blue_speed_5_harness", new Item.Properties());
    public static final Item BROWN_SPEED_5_HARNESS = register("brown_speed_5_harness", new Item.Properties());
    public static final Item CYAN_SPEED_5_HARNESS = register("cyan_speed_5_harness", new Item.Properties());
    public static final Item GRAY_SPEED_5_HARNESS = register("gray_speed_5_harness", new Item.Properties());
    public static final Item GREEN_SPEED_5_HARNESS = register("green_speed_5_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_5_HARNESS = register("light_blue_speed_5_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_5_HARNESS = register("light_gray_speed_5_harness", new Item.Properties());
    public static final Item LIME_SPEED_5_HARNESS = register("lime_speed_5_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_5_HARNESS = register("magenta_speed_5_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_5_HARNESS = register("orange_speed_5_harness", new Item.Properties());
    public static final Item PINK_SPEED_5_HARNESS = register("pink_speed_5_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_5_HARNESS = register("purple_speed_5_harness", new Item.Properties());
    public static final Item RED_SPEED_5_HARNESS = register("red_speed_5_harness", new Item.Properties());
    public static final Item WHITE_SPEED_5_HARNESS = register("white_speed_5_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_5_HARNESS = register("yellow_speed_5_harness", new Item.Properties());

    public static final Item BLACK_SPEED_6_HARNESS = register("black_speed_6_harness", new Item.Properties());
    public static final Item BLUE_SPEED_6_HARNESS = register("blue_speed_6_harness", new Item.Properties());
    public static final Item BROWN_SPEED_6_HARNESS = register("brown_speed_6_harness", new Item.Properties());
    public static final Item CYAN_SPEED_6_HARNESS = register("cyan_speed_6_harness", new Item.Properties());
    public static final Item GRAY_SPEED_6_HARNESS = register("gray_speed_6_harness", new Item.Properties());
    public static final Item GREEN_SPEED_6_HARNESS = register("green_speed_6_harness", new Item.Properties());
    public static final Item LIGHT_BLUE_SPEED_6_HARNESS = register("light_blue_speed_6_harness", new Item.Properties());
    public static final Item LIGHT_GRAY_SPEED_6_HARNESS = register("light_gray_speed_6_harness", new Item.Properties());
    public static final Item LIME_SPEED_6_HARNESS = register("lime_speed_6_harness", new Item.Properties());
    public static final Item MAGENTA_SPEED_6_HARNESS = register("magenta_speed_6_harness", new Item.Properties());
    public static final Item ORANGE_SPEED_6_HARNESS = register("orange_speed_6_harness", new Item.Properties());
    public static final Item PINK_SPEED_6_HARNESS = register("pink_speed_6_harness", new Item.Properties());
    public static final Item PURPLE_SPEED_6_HARNESS = register("purple_speed_6_harness", new Item.Properties());
    public static final Item RED_SPEED_6_HARNESS = register("red_speed_6_harness", new Item.Properties());
    public static final Item WHITE_SPEED_6_HARNESS = register("white_speed_6_harness", new Item.Properties());
    public static final Item YELLOW_SPEED_6_HARNESS = register("yellow_speed_6_harness", new Item.Properties());

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
    }
}