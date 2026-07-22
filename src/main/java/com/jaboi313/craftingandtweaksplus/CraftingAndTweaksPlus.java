package com.jaboi313.craftingandtweaksplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.resources.Identifier;

import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftingAndTweaksPlus implements ModInitializer {
	public static final String MOD_ID = "crafting-and-tweaks-plus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer SERVER;
	public static final TagKey<TrimMaterial> DISTRACTING_TRIM;

	static {
      DISTRACTING_TRIM = TagKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath("distractingtrims", "distracts_piglins"));
   }

	private static boolean hasSilkTouch(Level level, ItemStack stack) {
		Holder<Enchantment> silkTouch = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH);
		return EnchantmentHelper.getItemEnchantmentLevel(silkTouch, stack) > 0;
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Crafting and Tweaks Plus: Initializing tool and armor progression mod!");

    	ModItems.initialize();

		PlayerBlockBreakEvents.BEFORE.register((PlayerBlockBreakEvents.Before)(level, player, pos, state, blockEntity) -> {
			if (level.isClientSide()) {
				return true;
			} else if (!state.is(Blocks.SPAWNER)) {
				return true;
			} else if (player.isCreative()) {
				return true;
			} else {
				ItemStack tool = player.getMainHandItem();
				if (!tool.is(ItemTags.PICKAXES)) {
				return true;
				} else if (!hasSilkTouch(level, tool)) {
				return true;
				} else {
				ItemStack drop = new ItemStack(Items.SPAWNER);
				if (blockEntity != null) {
					CompoundTag tag = blockEntity.saveWithFullMetadata(level.registryAccess());
					tag.remove("x");
					tag.remove("y");
					tag.remove("z");
					tag.remove("id");
					drop.set(DataComponents.BLOCK_ENTITY_DATA, TypedEntityData.of(BlockEntityTypes.MOB_SPAWNER, tag));
				}

				Block.popResource(level, pos, drop);
				return true;
				}
			}
		});

		LOGGER.info("Crafting and Tweaks Plus: Initialization complete!");
	}
}
