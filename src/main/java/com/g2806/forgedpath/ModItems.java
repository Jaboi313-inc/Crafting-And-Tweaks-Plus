package com.g2806.forgedpath;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Upgrade Templates for Tools: wood -> stone -> copper -> iron -> gold -> diamond
    public static final Item STONE_UPGRADE_TEMPLATE = registerItem("stone_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "stone_upgrade_smithing_template")))
                    .maxCount(64)));

    public static final Item COPPER_UPGRADE_TEMPLATE = registerItem("copper_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "copper_upgrade_smithing_template")))
                    .maxCount(64)));

    public static final Item IRON_UPGRADE_TEMPLATE = registerItem("iron_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "iron_upgrade_smithing_template")))
                    .maxCount(64)));

    public static final Item GOLD_UPGRADE_TEMPLATE = registerItem("gold_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "gold_upgrade_smithing_template")))
                    .maxCount(64)));

    public static final Item DIAMOND_UPGRADE_TEMPLATE = registerItem("diamond_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "diamond_upgrade_smithing_template")))
                    .maxCount(64)));

    // Extra template for armor: chainmail
    public static final Item CHAINMAIL_UPGRADE_TEMPLATE = registerItem("chainmail_upgrade_smithing_template",
            new Item(new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ForgedPath.MOD_ID, "chainmail_upgrade_smithing_template")))
                    .maxCount(64)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ForgedPath.MOD_ID, name), item);
    }

    public static void registerItems() {
        ForgedPath.LOGGER.info("Registering Mod Items for " + ForgedPath.MOD_ID);

        // Add upgrade templates to creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(STONE_UPGRADE_TEMPLATE);
            entries.add(COPPER_UPGRADE_TEMPLATE);
            entries.add(IRON_UPGRADE_TEMPLATE);
            entries.add(CHAINMAIL_UPGRADE_TEMPLATE);
            entries.add(GOLD_UPGRADE_TEMPLATE);
            entries.add(DIAMOND_UPGRADE_TEMPLATE);
        });
    }
}
