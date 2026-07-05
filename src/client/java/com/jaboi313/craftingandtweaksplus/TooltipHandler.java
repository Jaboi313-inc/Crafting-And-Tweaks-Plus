package com.jaboi313.craftingandtweaksplus;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class TooltipHandler {

    private static ChatFormatting getFormattingForTooltip(int maxDurability, int currentDurability) {
        if (currentDurability >= maxDurability * 0.66f) {
            return ChatFormatting.GREEN;
        } else if (currentDurability >= maxDurability * 0.33f) {
            return ChatFormatting.YELLOW;
        }

        return ChatFormatting.RED;
    }

    public static Component getTooltip(ItemStack stack) {
        int maxDurability = stack.getMaxDamage();
        int currentDurability = maxDurability - stack.getDamageValue();

        Component current = Component.literal(String.valueOf(currentDurability))
                .withStyle(getFormattingForTooltip(maxDurability, currentDurability));

        Component slash = Component.literal(" / ")
                .withStyle(ChatFormatting.GRAY);

        Component max = Component.literal(String.valueOf(maxDurability))
                .withStyle(ChatFormatting.GRAY);

        return current.copy().append(slash).append(max);
    }
}