package com.jaboi313.craftingandtweaksplus;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;


public class ModCreativeTabs {

    public static final ResourceKey<CreativeModeTab> PICKAXE_TAB_KEY =
            ResourceKey.create(
                    BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    Identifier.fromNamespaceAndPath(
                            CraftingAndTweaksPlus.MOD_ID,
                            "pickaxes"
                    )
            );


    public static final ResourceKey<CreativeModeTab> SPEED_HARNESS_TAB_KEY =
            ResourceKey.create(
                    BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    Identifier.fromNamespaceAndPath(
                            CraftingAndTweaksPlus.MOD_ID,
                            "speed_harnesses"
                    )
            );


    public static final CreativeModeTab PICKAXE_TAB =
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.THREE_BY_THREE_PICKAXE))
                    .title(Component.literal("OP Pickaxes"))
                    .displayItems((params, output) -> {

                        output.accept(ModItems.THREE_BY_THREE_PICKAXE);

                    })
                    .build();



    public static final CreativeModeTab SPEED_HARNESS_TAB =
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SPEED_HARNESSES.get("black_speed_6_harness")))
                    .title(Component.literal("Speed Harnesses"))
                    .displayItems((params, output) -> {

                        ModItems.SPEED_HARNESSES
                                .values()
                                .forEach(output::accept);

                    })
                    .build();



    public static void initialize() {


        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                PICKAXE_TAB_KEY,
                PICKAXE_TAB
        );


        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                SPEED_HARNESS_TAB_KEY,
                SPEED_HARNESS_TAB
        );



        // Voeg alleen de beste harnesses toe aan vanilla Tools & Utilities
        CreativeModeTabEvents.modifyOutputEvent(
                CreativeModeTabs.TOOLS_AND_UTILITIES
        ).register(tab -> {


            tab.accept(ModItems.THREE_BY_THREE_PICKAXE);


            ModItems.SPEED_HARNESSES.entrySet()
                    .stream()
                    .filter(entry ->
                            entry.getKey().endsWith("_speed_6_harness")
                    )
                    .forEach(entry ->
                            tab.accept(entry.getValue())
                    );

        });

    }
}