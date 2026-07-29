package com.jaboi313.craftingandtweaksplus.config;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jaboi313.craftingandtweaksplus.config.ModConfig.BreakableBlock;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.gui.entries.MultiElementListEntry;
import me.shedaniel.clothconfig2.gui.entries.NestedListListEntry;
import me.shedaniel.clothconfig2.impl.builders.DropdownMenuBuilder.CellCreatorBuilder;
import me.shedaniel.clothconfig2.impl.builders.DropdownMenuBuilder.TopCellElementBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

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

        ConfigCategory specialBreaker =
        builder.getOrCreateCategory(
                Component.literal("Special Block Breaker")
        );


        specialBreaker.addEntry(
                builder.entryBuilder()
                        .startTextDescription(
                                Component.literal("Blocks that the")
                                        .withStyle(style -> style.withColor(0xFFFFFF))
                                        .append(
                                                Component.literal(" Special Block Breaker ")
                                                        .withStyle(style -> style.withColor(0x55FFFF))
                                        )
                                        .append(
                                                Component.literal("can destroy.\n")
                                                        .withStyle(style -> style.withColor(0xFFFFFF))
                                        )
                                        .append(
                                                Component.literal("Break time is in ticks.\n")
                                                        .withStyle(style -> style.withColor(0x55FF55))
                                        )
                                        .append(
                                                Component.literal("20 ticks = 1 second.\n")
                                                        .withStyle(style -> style.withColor(0x55FF55))
                                        )
                        )
                        .build()
        );



        NestedListListEntry blockList =
                new NestedListListEntry(
                        Component.literal("Breakable Blocks"),

                        ConfigManager.config
                                .specialBlockBreaker
                                .blocks,

                        false,


                        Optional::empty,


                        list -> {

                        List<BreakableBlock> newList =
                                new ArrayList<>((List<BreakableBlock>) list);


                        boolean duplicateFound = false;
                        String duplicateBlockId = null;

                        var seen = new java.util.HashSet<String>();

                        for (int i = newList.size() - 1; i >= 0; i--) {

                                BreakableBlock block = newList.get(i);

                                if (!seen.add(block.blockId)) {

                                        duplicateFound = true;
                                        duplicateBlockId = block.blockId;

                                        newList.remove(i);
                                }
                        }


                        if (duplicateFound) {

                                Screen previousScreen = Minecraft.getInstance().gui.screen();

                                Component message = Component.literal(capitalize(getBlockName(duplicateBlockId)))
                                        .withStyle(style -> style.withColor(0x55FF55))
                                        .append(
                                                Component.literal(" is already in the list!")
                                                        .withStyle(style -> style.withColor(0xFFFFFF))
                                        );

                                Minecraft.getInstance().execute(() -> {

                                        Minecraft.getInstance().gui.setScreen(
                                                new AlertScreen(
                                                        () -> Minecraft.getInstance().gui.setScreen(previousScreen),
                                                        Component.literal("Duplicate block!").withStyle(style -> style.withColor(0xFF5555)),
                                                        message
                                                )
                                        );

                                });
                                }


                        newList.removeIf(block ->
                                block.blockId == null ||
                                block.blockId.isEmpty()
                        );


                        ConfigManager.config.specialBlockBreaker.blocks.clear();
                        ConfigManager.config.specialBlockBreaker.blocks.addAll(newList);

                        ConfigManager.save();
                        },


                        () -> {

                        ArrayList<BreakableBlock> defaults =
                                new ArrayList<>();

                        defaults.add(new BreakableBlock("minecraft:bedrock", 100));
                        defaults.add(new BreakableBlock("minecraft:end_portal_frame", 100));
                        defaults.add(new BreakableBlock("minecraft:end_portal", 100));
                        defaults.add(new BreakableBlock("minecraft:end_gateway", 100));
                        defaults.add(new BreakableBlock("minecraft:nether_portal", 100));

                        return defaults;
                        },


                        builder.entryBuilder()
                                .getResetButtonKey(),


                        true,

                        true,


                        (element, entry) -> {

                        BreakableBlock block;

                        if (element == null) {


                                block = new BreakableBlock(
                                        "minecraft:",
                                        60
                                );

                        } else {

                                block = (BreakableBlock) element;

                        }

                                        return new MultiElementListEntry(
                        Component.literal(
                                capitalize(getBlockName(block.blockId)) + " (" + block.breakTime + ")"
                        ),
                        block,

                        Minecraft.getInstance().level != null

                        ? List.of(

                                builder.entryBuilder()
                                        .startDropdownMenu(
                                                Component.literal("Block"),
                                                TopCellElementBuilder.ofBlockObject(
                                                BuiltInRegistries.BLOCK
                                                        .getOptional(Identifier.parse(block.blockId))
                                                        .orElse(net.minecraft.world.level.block.Blocks.STONE)
                                                ),
                                                CellCreatorBuilder.ofBlockObject()
                                        )
                                        .setSelections(
                                                BuiltInRegistries.BLOCK
                                                        .stream()
                                                        .filter(blockEntry -> {

                                                        String id =
                                                                BuiltInRegistries.BLOCK
                                                                        .getKey(blockEntry)
                                                                        .toString();


                                                        return ConfigManager.config.specialBlockBreaker.blocks
                                                                .stream()
                                                                .noneMatch(other ->
                                                                        other.blockId.equals(id) &&
                                                                        !other.blockId.equals(block.blockId)
                                                                );

                                                        })
                                                        .sorted(
                                                                Comparator.comparing(Block::toString)
                                                        )
                                                        .collect(
                                                                Collectors.toCollection(
                                                                        LinkedHashSet::new
                                                                )
                                                        )
                                        )
                                        .setSaveConsumer(blockValue -> {

                                        String id = BuiltInRegistries.BLOCK
                                                .getKey(blockValue)
                                                .toString();


                                        boolean duplicate =
                                        ConfigManager.config.specialBlockBreaker.blocks
                                                .stream()
                                                .anyMatch(other ->
                                                        other != block &&
                                                        other.blockId.equals(id)
                                                );

                                        if (duplicate) {
                                                return;
                                        }


                                        block.blockId = id;

                                        ConfigManager.save();

                                        })
                                        .build(),


                                builder.entryBuilder()
                                        .startIntField(
                                                Component.literal("Break Time"),
                                                block.breakTime
                                        )
                                        .setMin(1)
                                        .setMax(72000)
                                        .setSaveConsumer(value -> {

                                                block.breakTime = value;
                                                ConfigManager.save();

                                        })
                                        .build()

                        )

                        :

                        List.of(

                                builder.entryBuilder()
                                        .startStrField(
                                                Component.literal("Block ID"),
                                                block.blockId
                                        )
                                        .setSaveConsumer(value -> {

                                                block.blockId = value;
                                                ConfigManager.save();

                                        })
                                        .build(),


                                builder.entryBuilder()
                                        .startIntField(
                                                Component.literal("Break Time"),
                                                block.breakTime
                                        )
                                        .setMin(1)
                                        .setMax(72000)
                                        .setSaveConsumer(value -> {

                                                block.breakTime = value;
                                                ConfigManager.save();

                                        })
                                        .build()
                        ),

                        true
                );
                        }
                );

        blockList.setExpanded(true);

        specialBreaker.addEntry(
                blockList
        );

        return builder.build();
    }

        private static String getBlockName(String blockId) {

                if (blockId == null || blockId.isEmpty() || blockId == "minecraft:") {
                        return "Select Block";
                }

                int colon = blockId.indexOf(':');

                if (colon >= 0 && colon < blockId.length() - 1) {
                        return blockId.substring(colon + 1)
                                .replace("_", " ");
                }

                return blockId.replace("_", " ");
        }

        private static String capitalize(String text) {
                if (text == null || text.isEmpty()) {
                        return text;
                }

                return text.substring(0, 1).toUpperCase() + text.substring(1);
        }
}