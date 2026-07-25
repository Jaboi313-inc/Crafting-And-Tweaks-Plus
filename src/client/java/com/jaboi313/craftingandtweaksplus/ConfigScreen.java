package com.jaboi313.craftingandtweaksplus;

import java.net.URI;

import com.jaboi313.craftingandtweaksplus.config.ConfigManager;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;

public class ConfigScreen {

    public static Screen create(Screen parent) {

        boolean progressionLoaded = FabricLoader.getInstance()
        .isModLoaded("progression-plus");

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Crafting & Tweaks Plus Config"));


        ConfigCategory harness = builder.getOrCreateCategory(
                Component.literal("Speed Harness")
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startTextDescription(
                                Component.literal("Speed values are always added to the default speed.\n")
                                        .withStyle(style -> style.withColor(0xFFFFFF))
                                        .append(
                                                Component.literal("0 = default speed.\n")
                                                        .withStyle(style -> style.withColor(0x55FF55))
                                        )
                                        .append(
                                                Component.literal("100 = +100% flying speed (2x total speed).\n")
                                                        .withStyle(style -> style.withColor(0x55FF55))
                                        )
                                        .append(
                                                Component.literal("Changes require a game restart to take effect!")
                                                        .withStyle(style -> style.withColor(0xFF5555))
                                        )
                        )
                        .build()
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 1 Harness"),
                                (int) ConfigManager.config.harness.speedLevel1
                        )
                        .setDefaultValue(25)
                        .setMin(1)
                        .setMax(10000)
                        .requireRestart()
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel1 = value;
                            ConfigManager.save();
                        })
                        .build()
        );

        if (!progressionLoaded) {

                harness.addEntry(
                        builder.entryBuilder()
                                .startTextDescription(
                                        Component.literal("Progression Plus is required for higher speed levels.\n")
                                                .withStyle(style -> style.withColor(0xFF5555))
                                                .append(
                                                        Component.literal("Download it here")
                                                                .withStyle(style -> style
                                                                        .withColor(0x55FFFF)
                                                                        .withUnderlined(true)
                                                                        .withClickEvent(
                                                                                new ClickEvent.OpenUrl(
                                                                                        URI.create(
                                                                                        "https://modrinth.com/mod/progressionplusmod"
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                )
                                )
                                .build()
                );
                }


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 2 Harness"),
                                (int) ConfigManager.config.harness.speedLevel2
                        )
                        .setDefaultValue(50)
                        .setMin(1)
                        .setMax(10000)
                        .requireRestart()
                        .setRequirement(() -> progressionLoaded)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel2 = value;
                            ConfigManager.save();
                        })
                        .build()
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 3 Harness"),
                                (int) ConfigManager.config.harness.speedLevel3
                        )
                        .setDefaultValue(75)
                        .setMin(1)
                        .setMax(10000)
                        .requireRestart()
                        .setRequirement(() -> progressionLoaded)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel3 = value;
                            ConfigManager.save();
                        })
                        .build()
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 4 Harness"),
                                (int) ConfigManager.config.harness.speedLevel4
                        )
                        .setDefaultValue(100)
                        .setMin(1)
                        .setMax(10000)
                        .requireRestart()
                        .setRequirement(() -> progressionLoaded)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel4 = value;
                            ConfigManager.save();
                        })
                        .build()
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 5 Harness"),
                                (int) ConfigManager.config.harness.speedLevel5
                        )
                        .setDefaultValue(150)
                        .setMin(1)
                        .setMax(10000)
                        .requireRestart()
                        .setRequirement(() -> progressionLoaded)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel5 = value;
                            ConfigManager.save();
                        })
                        .build()
        );

        return builder.build();
    }
}