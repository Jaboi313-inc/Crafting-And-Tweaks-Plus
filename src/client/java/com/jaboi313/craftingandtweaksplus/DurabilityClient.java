package com.jaboi313.craftingandtweaksplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DurabilityClient implements ClientModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("crafting-and-tweaks-plus");

    @Override
    public void onInitializeClient() {

        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, TooltipFlag type, List<Component> lines) -> {

            if (stack.getMaxDamage() == 0) {
                return;
            }

            lines.add(Component.empty());
            lines.add(TooltipHandler.getTooltip(stack));
        });

        LOGGER.info("[CraftingAndTweaksPlus] Mod loaded!");
    }
}