package com.jaboi313.craftingandtweaksplus;

import com.jaboi313.craftingandtweaksplus.config.ConfigManager;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfigScreen {

    public static Screen create(Screen parent) {

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Crafting & Tweaks Plus Config"));


        ConfigCategory harness = builder.getOrCreateCategory(
                Component.literal("Harness")
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startTextDescription(
                                Component.literal(
                                        "Speed values are percentages.\n" +
                                        "100 = +100% flying speed (2x total speed).\n" +
                                        "Changes require a game restart to take effect!"
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
                        .setMax(1000)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel1 = value;
                            ConfigManager.save();
                        })
                        .build()
        );


        harness.addEntry(
                builder.entryBuilder()
                        .startIntField(
                                Component.literal("Speed Level 2 Harness"),
                                (int) ConfigManager.config.harness.speedLevel2
                        )
                        .setDefaultValue(50)
                        .setMin(1)
                        .setMax(1000)
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
                        .setMax(1000)
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
                        .setMax(1000)
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
                        .setMax(1000)
                        .setSaveConsumer(value -> {
                            ConfigManager.config.harness.speedLevel5 = value;
                            ConfigManager.save();
                        })
                        .build()
        );

        return builder.build();
    }
}