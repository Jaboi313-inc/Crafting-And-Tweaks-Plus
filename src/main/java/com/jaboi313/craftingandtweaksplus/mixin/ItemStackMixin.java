package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import net.minecraft.network.chat.Component;

import net.minecraft.ChatFormatting;

import net.minecraft.world.item.Rarity;

import net.minecraft.world.item.component.ItemLore;
import net.minecraft.resources.Identifier;

import java.util.List;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.entity.EquipmentSlotGroup;


@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    
    @Inject(method = "getComponents", at = @At("RETURN"), cancellable = true)
    private void modifyComponents(CallbackInfoReturnable<DataComponentMap> cir) {

        DataComponentMap original = cir.getReturnValue();

        ItemStack stack = (ItemStack)(Object)this;
        String translationKey = stack.getItem().getDescriptionId();

        DataComponentMap.Builder builder = DataComponentMap.builder();
        builder.addAll(original);
        boolean modified = false;
        
        // Stone upgrade template:
        if (translationKey.contains("stone_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Wooden Tools").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Stone").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }
        // Copper upgrade template:
        if (translationKey.contains("copper_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Stone Tools & Leather Armor").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Copper Ingot").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }
        // Chainmail upgrade template:
        if (translationKey.contains("chainmail_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Copper Armor").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Iron Chain").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }
        // Iron upgrade template:
        if (translationKey.contains("iron_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Copper Tools & Chainmail Armor").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Iron Ingot").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }
        // Gold upgrade template:
        if (translationKey.contains("gold_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Iron Equipment").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Gold Ingot").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }
        // Diamond upgrade template:
        if (translationKey.contains("diamond_upgrade_smithing_template")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            builder.set(DataComponents.LORE, new ItemLore(List.of( Component.literal("Smithing Template").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.empty(),
                                                                            Component.literal("Applies to:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Gold Equipment").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal("Ingredients:").withStyle(ChatFormatting.GRAY).withStyle(style -> style.withItalic(false)),
                                                                            Component.literal(" Diamond").withStyle(ChatFormatting.BLUE).withStyle(style -> style.withItalic(false)))));
            modified = true;
        }

        // Leather Helmet:
        if (translationKey.contains("leather_helmet")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_head"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Leather Chestplate:
        if (translationKey.contains("leather_chestplate")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_chest"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Leather Leggings:
        if (translationKey.contains("leather_leggings")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_legs"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Leather Boots:
        if (translationKey.contains("leather_boots")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_feet"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }

        // Copper Helmet:
        if (translationKey.contains("copper_helmet")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_head"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Copper Chestplate:
        if (translationKey.contains("copper_chestplate")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_chest"), 3.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Copper Leggings:
        if (translationKey.contains("copper_leggings")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_legs"), 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Copper Boots:
        if (translationKey.contains("copper_boots")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_feet"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }

        // Chainmail Helmet:
        if (translationKey.contains("chainmail_helmet")) {
            builder.set(DataComponents.RARITY, Rarity.COMMON);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_head"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Chainmail Chestplate:
        if (translationKey.contains("chainmail_chestplate")) {
            builder.set(DataComponents.RARITY, Rarity.COMMON);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_chest"), 4.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Chainmail Leggings:
        if (translationKey.contains("chainmail_leggings")) {
            builder.set(DataComponents.RARITY, Rarity.COMMON);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_legs"), 3.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Chainmail Boots:
        if (translationKey.contains("chainmail_boots")) {
            builder.set(DataComponents.RARITY, Rarity.COMMON);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_feet"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }

        // Iron Helmet:
        if (translationKey.contains("iron_helmet")) {
            builder.set(DataComponents.MAX_DAMAGE, 200);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_head"), 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Iron Chestplate:
        if (translationKey.contains("iron_chestplate")) {
            builder.set(DataComponents.MAX_DAMAGE, 300);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_chest"), 5.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Iron Leggings:
        if (translationKey.contains("iron_leggings")) {
            builder.set(DataComponents.MAX_DAMAGE, 280);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_legs"), 4.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Iron Boots:
        if (translationKey.contains("iron_boots")) {
            builder.set(DataComponents.MAX_DAMAGE, 230);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_feet"), 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }

        // Golden Helmet:
        if (translationKey.contains("golden_helmet")) {
            builder.set(DataComponents.MAX_DAMAGE, 280);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_head"), 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_head"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HEAD);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Chestplate:
        if (translationKey.contains("golden_chestplate")) {
            builder.set(DataComponents.MAX_DAMAGE, 380);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_chest"), 7.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_chest"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Leggings:
        if (translationKey.contains("golden_leggings")) {
            builder.set(DataComponents.MAX_DAMAGE, 350);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_legs"), 5.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_legs"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Boots:
        if (translationKey.contains("golden_boots")) {
            builder.set(DataComponents.MAX_DAMAGE, 300);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_feet"), 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_feet"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Horse Armor:
        if (translationKey.contains("golden_horse_armor")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_body"), 7.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_body"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Nautilus Armor:
        if (translationKey.contains("golden_nautilus_armor")) {
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "armor_body"), 7.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY);
            attr.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "toughness_body"), 1.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        
        // Golden Spear:
        if (translationKey.contains("golden_spear")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 2.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -3.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Sword:
        if (translationKey.contains("golden_sword")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 5.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Axe:
        if (translationKey.contains("golden_axe")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 8.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -3.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.MINING_EFFICIENCY, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "mining_efficiency"), -5.95, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Pickaxe:
        if (translationKey.contains("golden_pickaxe")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 3.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -2.8, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.MINING_EFFICIENCY, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "mining_efficiency"), -5.95, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Shovel:
        if (translationKey.contains("golden_shovel")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 4.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -3.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.MINING_EFFICIENCY, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "mining_efficiency"), -5.95, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }
        // Golden Hoe:
        if (translationKey.contains("golden_hoe")) {
            builder.set(DataComponents.MAX_DAMAGE, 810);
            ItemAttributeModifiers.Builder attr = ItemAttributeModifiers.builder();
            attr.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 0.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -0.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            attr.add(Attributes.MINING_EFFICIENCY, new AttributeModifier(Identifier.fromNamespaceAndPath("progression-plus", "mining_efficiency"), -5.95, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
            builder.set(DataComponents.ATTRIBUTE_MODIFIERS, attr.build());
            modified = true;
        }

        if (modified) {
            cir.setReturnValue(builder.build());
        }
    }
}
