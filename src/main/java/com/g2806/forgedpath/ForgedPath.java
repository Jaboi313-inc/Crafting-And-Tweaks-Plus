package com.g2806.forgedpath;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgedPath implements ModInitializer {
	public static final String MOD_ID = "forged-path";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Forged Path: Initializing tool and armor progression mod!");

		// Register all upgrade template items
		ModItems.registerItems();

		// Register loot table modifications for Ocean Monuments and other structures
		registerLootTableModifications();

		LOGGER.info("Forged Path: Initialization complete!");
	}

	private void registerLootTableModifications() {
		// Add upgrade templates to various structure loot tables
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			// Only modify vanilla loot tables
			if (!source.isBuiltin()) {
				return;
			}

			// Add to Buried Treasure
			if (key.equals(LootTables.BURIED_TREASURE_CHEST)) {
				addUpgradeTemplatesToLoot(tableBuilder);
			}

			// Add to Simple Dungeon chests
			if (key.equals(LootTables.SIMPLE_DUNGEON_CHEST)) {
				addUpgradeTemplatesToLoot(tableBuilder);
			}

			// Add to Stronghold corridor chests
			if (key.equals(LootTables.STRONGHOLD_CORRIDOR_CHEST)) {
				addUpgradeTemplatesToLoot(tableBuilder);
			}
		});
	}

	private void addUpgradeTemplatesToLoot(net.minecraft.loot.LootTable.Builder tableBuilder) {
		LootPool.Builder poolBuilder = LootPool.builder()
				.with(ItemEntry.builder(ModItems.STONE_UPGRADE_TEMPLATE).weight(10))
				.with(ItemEntry.builder(ModItems.COPPER_UPGRADE_TEMPLATE).weight(10))
				.with(ItemEntry.builder(ModItems.IRON_UPGRADE_TEMPLATE).weight(8))
				.with(ItemEntry.builder(ModItems.CHAINMAIL_UPGRADE_TEMPLATE).weight(8))
				.with(ItemEntry.builder(ModItems.GOLD_UPGRADE_TEMPLATE).weight(6))
				.with(ItemEntry.builder(ModItems.DIAMOND_UPGRADE_TEMPLATE).weight(4))
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)));

		tableBuilder.pool(poolBuilder);
	}
}