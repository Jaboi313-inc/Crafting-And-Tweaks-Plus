package com.jaboi313.craftingandtweaksplus.item;

import com.jaboi313.craftingandtweaksplus.config.ConfigManager;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.Equippable;

public class HarnessHelper {

    public static Item.Properties createSpeedHarness(DyeColor color, int level) {

        double speed = ConfigManager.getConfig()
                .harness
                .getSpeed(level) / 100.0;

        return new Item.Properties()
                .stacksTo(1)
                .component(
                        DataComponents.EQUIPPABLE,
                        Equippable.harness(color))
                .attributes(
                        ItemAttributeModifiers.builder()
                                .add(
                                        Attributes.FLYING_SPEED,
                                        new AttributeModifier(
                                                Identifier.fromNamespaceAndPath(
                                                        "crafting-and-tweaks-plus",
                                                        "speed_harness_" + level),
                                                speed,
                                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                        EquipmentSlotGroup.BODY)
                                .build());
    }
}