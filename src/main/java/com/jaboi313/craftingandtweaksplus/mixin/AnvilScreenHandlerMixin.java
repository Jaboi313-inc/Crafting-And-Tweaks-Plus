package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({AnvilMenu.class})
public abstract class AnvilScreenHandlerMixin extends ItemCombinerMenu {
   public AnvilScreenHandlerMixin(@Nullable MenuType<?> type, int syncId, Inventory playerInventory, ContainerLevelAccess context, ItemCombinerMenuSlotDefinition forgingSlotsManager) {
      super(type, syncId, playerInventory, context, forgingSlotsManager);
   }

   @ModifyConstant(
      method = {"createResult()V"},
      constant = {@Constant(
   intValue = 40,
   ordinal = 2
)}
   )
   public int modifyXPLevelCap(int xpLevel) {
      return Integer.MAX_VALUE;
   }
}
