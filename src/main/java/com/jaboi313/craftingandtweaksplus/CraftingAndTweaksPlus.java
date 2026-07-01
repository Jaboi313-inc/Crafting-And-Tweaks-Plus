package com.jaboi313.craftingandtweaksplus;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftingAndTweaksPlus implements ModInitializer {
	public static final String MOD_ID = "crafting-and-tweaks-plus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer SERVER;

	@Override
	public void onInitialize() {
		LOGGER.info("Crafting and Tweaks Plus: Initializing tool and armor progression mod!");

		LOGGER.info("Crafting and Tweaks Plus: Initialization complete!");
	}
}
