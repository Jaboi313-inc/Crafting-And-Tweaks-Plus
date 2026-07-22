package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BlockEntityType.class})
public class BlockEntityTypeMixin {
   public BlockEntityTypeMixin() {
   }

   @Inject(
        method = "onlyOpCanSetNbt", 
        at = @At("HEAD"), 
        cancellable = true)
        
private void silkspawners$allowSpawnerDataForEveryone(CallbackInfoReturnable<Boolean> cir) {
    BlockEntityType<?> type = (BlockEntityType<?>)(Object)this;

    if (type == BlockEntityTypes.MOB_SPAWNER) {
        cir.setReturnValue(false);
    }
}
}
