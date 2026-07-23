package com.jaboi313.craftingandtweaksplus.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.resources.Identifier;

public class HarnessHelper {

    public static Item.Properties createSpeedHarness(DyeColor color, int level) {
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
                                Identifier.fromNamespaceAndPath("crafting-and-tweaks-plus", "speed_harness_" + level),
                                level,
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                            EquipmentSlotGroup.BODY)
                        .build()
                );
    }
}