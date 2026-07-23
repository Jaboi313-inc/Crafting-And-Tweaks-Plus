package com.jaboi313.craftingandtweaksplus.item;

import java.util.function.Consumer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class ThreeByThreePickaxeItem extends Item {

    public ThreeByThreePickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            TooltipContext context,
            TooltipDisplay display,
            Consumer<Component> tooltip,
            TooltipFlag flag
    ) {

        tooltip.accept(
            Component.literal("Mine 3x3")
                .withStyle(style -> style
                    .withColor(0xAA00AA)
                )
        );

        super.appendHoverText(
                stack,
                context,
                display,
                tooltip,
                flag
        );
    }
}