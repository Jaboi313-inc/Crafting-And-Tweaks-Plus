package com.g2806.forgedpath.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin to allow normally incompatible enchantments to work together:
 * - All protection types can be combined (Protection, Fire Protection, Blast Protection, Projectile Protection)
 * - Infinity and Mending can be combined on bows/crossbows
 */
@Mixin(Enchantment.class)
public class EnchantmentCompatibilityMixin {

    @Inject(method = "canBeCombined", at = @At("HEAD"), cancellable = true)
    private static void allowCombinedEnchantments(RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second, CallbackInfoReturnable<Boolean> cir) {
        if (first.equals(second)) {
            return; // Let vanilla handle same enchantment check
        }

        String firstName = first.getIdAsString();
        String secondName = second.getIdAsString();

        // Allow all protection types to be combined
        if (isProtectionEnchantment(firstName) && isProtectionEnchantment(secondName)) {
            cir.setReturnValue(true);
            return;
        }

        // Allow Infinity and Mending to be combined
        if ((isInfinity(firstName) && isMending(secondName)) ||
            (isMending(firstName) && isInfinity(secondName))) {
            cir.setReturnValue(true);
            return;
        }
    }

    private static boolean isProtectionEnchantment(String name) {
        return name.contains("protection") ||
               name.contains("fire_protection") ||
               name.contains("blast_protection") ||
               name.contains("projectile_protection");
    }

    private static boolean isInfinity(String name) {
        return name.contains("infinity");
    }

    private static boolean isMending(String name) {
        return name.contains("mending");
    }
}
