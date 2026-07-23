package com.jaboi313.craftingandtweaksplus;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jaboi313.craftingandtweaksplus.mining.ThreeByThreeMining;

public class CraftingAndTweaksPlus implements ModInitializer {
	public static final String MOD_ID = "crafting-and-tweaks-plus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer SERVER;
	public static final TagKey<TrimMaterial> DISTRACTING_TRIM;

	static {
      DISTRACTING_TRIM = TagKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath("distractingtrims", "distracts_piglins"));
   }

	@Override
	public void onInitialize() {
		LOGGER.info("Crafting and Tweaks Plus: Initializing tool and armor progression mod!");

		ModComponents.initialize();
    	ModItems.initialize();

		ThreeByThreeMining.register();

		LOGGER.info("Crafting and Tweaks Plus: Initialization complete!");
	}
}
