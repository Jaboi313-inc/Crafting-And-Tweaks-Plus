package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({AnvilScreen.class})
public abstract class AnvilScreenMixin extends ItemCombinerScreen<AnvilMenu> {
   public AnvilScreenMixin(AnvilMenu menu, Inventory inventory, Component title, Identifier menuResource) {
      super(menu, inventory, title, menuResource);
   }

   @ModifyConstant(
      method = {"extractLabels(Lnet/minecraft/client/gui/GuiGraphicsExtractor;II)V"},
      constant = {@Constant(
   intValue = 40,
   ordinal = 0
)}
   )
   public int modifyXPLevelCheck(int xpLevel) {
      return Integer.MAX_VALUE;
   }
}
