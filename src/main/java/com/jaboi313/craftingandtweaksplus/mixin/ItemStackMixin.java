package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;

import net.minecraft.world.item.Rarity;


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
        
        // Speed 1 harness (all colors):
        if (translationKey.contains("_speed_1_harness")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            modified = true;
        }

        // Speed 2 harness (all colors):
        if (translationKey.contains("_speed_2_harness")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            modified = true;
        }

        // Speed 3 harness (all colors):
        if (translationKey.contains("_speed_3_harness")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            modified = true;
        }

        // Speed 4 harness (all colors):
        if (translationKey.contains("_speed_4_harness")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            modified = true;
        }

        // Speed 5 harness (all colors):
        if (translationKey.contains("_speed_5_harness")) {
            builder.set(DataComponents.RARITY, Rarity.UNCOMMON);
            modified = true;
        }

        if (modified) {
            cir.setReturnValue(builder.build());
        }
    }
}
