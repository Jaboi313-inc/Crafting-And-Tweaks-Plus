package com.g2806.forgedpath.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.component.type.AttributeModifierSlot;

import java.util.List;

/**
 * Mixin to modify gold item properties after construction
 * Modifies durability, armor values, attack damage, and mining speed
 */
@Mixin(Item.class)
public abstract class ItemMixin {
    
    @Shadow
    @Final
    @Mutable
    private ComponentMap components;
    
    @Shadow
    public abstract String getTranslationKey();
    
    @Inject(method = "<init>", at = @At("RETURN"))
    private void modifyGoldItemProperties(Item.Settings settings, CallbackInfo ci) {
        String translationKey = this.getTranslationKey();
        
        if (translationKey == null) return;
        
        ComponentMap.Builder builder = ComponentMap.builder();
        builder.addAll(this.components);
        boolean modified = false;
        
        // Golden Helmet: durability 250, armor 2, armor toughness 1
        if (translationKey.contains("golden_helmet")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 250);
            AttributeModifiersComponent existing = this.components.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            builder.add(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifyArmorAttributes(existing, 2.0, 1.0, AttributeModifierSlot.HEAD));
            modified = true;
        }
        // Golden Chestplate: durability 342, armor 7, armor toughness 1
        else if (translationKey.contains("golden_chestplate")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 342);
            AttributeModifiersComponent existing = this.components.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            builder.add(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifyArmorAttributes(existing, 7.0, 1.0, AttributeModifierSlot.CHEST));
            modified = true;
        }
        // Golden Leggings: durability 385, armor 3, armor toughness 1
        else if (translationKey.contains("golden_leggings")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 385);
            AttributeModifiersComponent existing = this.components.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            builder.add(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifyArmorAttributes(existing, 3.0, 1.0, AttributeModifierSlot.LEGS));
            modified = true;
        }
        // Golden Boots: durability 298, armor 2, armor toughness 1
        else if (translationKey.contains("golden_boots")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 298);
            AttributeModifiersComponent existing = this.components.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            builder.add(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifyArmorAttributes(existing, 2.0, 1.0, AttributeModifierSlot.FEET));
            modified = true;
        }
        // Golden Pickaxe: durability 500, damage +2, mining speed +6
        else if (translationKey.contains("golden_pickaxe")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 500);
            AttributeModifiersComponent existing = this.components.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
            builder.add(DataComponentTypes.ATTRIBUTE_MODIFIERS, modifyToolAttributes(existing, 2.0, 6.0));
            modified = true;
        }
        // Other gold tools: durability 500, damage +2
        else if (translationKey.contains("golden_sword") || translationKey.contains("golden_axe") || 
                 translationKey.contains("golden_shovel") || translationKey.contains("golden_hoe")) {
            builder.add(DataComponentTypes.MAX_DAMAGE, 500);
            modified = true;
        }
        
        if (modified) {
            this.components = builder.build();
        }
    }
    
    private static AttributeModifiersComponent modifyArmorAttributes(AttributeModifiersComponent existing, 
                                                                    double armorValue, double toughness, 
                                                                    AttributeModifierSlot slot) {
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        
        // Try to find and get armor attributes
        try {
            RegistryEntry<EntityAttribute> armorAttr = Registries.ATTRIBUTE.getEntry(
                Identifier.ofVanilla("generic.armor")).orElse(null);
            RegistryEntry<EntityAttribute> toughnessAttr = Registries.ATTRIBUTE.getEntry(
                Identifier.ofVanilla("generic.armor_toughness")).orElse(null);
            
            if (armorAttr != null) {
                builder.add(
                    armorAttr,
                    new EntityAttributeModifier(
                        Identifier.of("forged-path", "armor_mod"),
                        armorValue,
                        EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    slot
                );
            }
            
            if (toughnessAttr != null) {
                builder.add(
                    toughnessAttr,
                    new EntityAttributeModifier(
                        Identifier.of("forged-path", "toughness_mod"),
                        toughness,
                        EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    slot
                );
            }
        } catch (Exception e) {
            // If attributes don't exist, just return existing
            return existing;
        }
        
        return builder.build();
    }
    
    private static AttributeModifiersComponent modifyToolAttributes(AttributeModifiersComponent existing,
                                                                   double damageBonus, double miningSpeed) {
        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        
        // Copy existing modifiers first
        for (var entry : existing.modifiers()) {
            builder.add(entry.attribute(), entry.modifier(), entry.slot());
        }
        
        // Try to add mining efficiency bonus
        try {
            RegistryEntry<EntityAttribute> damageAttr = Registries.ATTRIBUTE.getEntry(
                Identifier.ofVanilla("generic.attack_damage")).orElse(null);
            RegistryEntry<EntityAttribute> miningAttr = Registries.ATTRIBUTE.getEntry(
                Identifier.ofVanilla("player.mining_efficiency")).orElse(null);
            
            if (damageAttr != null) {
                builder.add(
                    damageAttr,
                    new EntityAttributeModifier(
                        Identifier.of("forged-path", "damage_bonus"),
                        damageBonus,
                        EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    AttributeModifierSlot.MAINHAND
                );
            }
            
            if (miningAttr != null && miningSpeed > 0) {
                builder.add(
                    miningAttr,
                    new EntityAttributeModifier(
                        Identifier.of("forged-path", "mining_speed"),
                        miningSpeed,
                        EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    AttributeModifierSlot.MAINHAND
                );
            }
        } catch (Exception e) {
            // If attributes don't exist, just return existing
            return existing;
        }
        
        return builder.build();
    }
}
