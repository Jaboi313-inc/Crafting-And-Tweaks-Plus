package com.jaboi313.craftingandtweaksplus.mixin;

import com.jaboi313.craftingandtweaksplus.ModComponents;
import com.jaboi313.craftingandtweaksplus.config.ConfigManager;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundBlockDestructionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ServerPlayer.class)
public class SpecialBlockBreakerMixin {


    @Unique
    private int miningTicks;


    @Unique
    private BlockPos miningPos;



    @Inject(
            method = "tick",
            at = @At("HEAD")
    )
    private void tickBedrockBreaker(CallbackInfo ci) {


        ServerPlayer player =
                (ServerPlayer)(Object)this;


        ItemStack stack =
                player.getMainHandItem();



        if (!stack.getOrDefault(
                ModComponents.SPECIAL_BLOCK_BREAKER,
                false
        ))
            return;



        if (!player.swinging)
            return;



        ServerLevel level =
                (ServerLevel) player.level();



        if (!(player.pick(5, 0, false)
                instanceof BlockHitResult hit))
            return;



        BlockPos pos =
                hit.getBlockPos();



        BlockState state =
                level.getBlockState(pos);



        String blockId =
                BuiltInRegistries.BLOCK
                        .getKey(state.getBlock())
                        .toString();



        int maxTicks =
                ConfigManager.getConfig()
                        .specialBlockBreaker
                        .getBreakTime(blockId);



        if (maxTicks == -1)
            return;



        if (!pos.equals(miningPos)) {

            miningPos = pos;
            miningTicks = 0;
        }



        miningTicks++;



        int progress =
                Math.min(
                        9,
                        miningTicks * 10 / maxTicks
                );



        int id =
                pos.hashCode();



        for (ServerPlayer p : level.players()) {

            p.connection.send(
                    new ClientboundBlockDestructionPacket(
                            id,
                            pos,
                            progress
                    )
            );
        }



        if (miningTicks >= maxTicks) {


            level.destroyBlock(
                    pos,
                    false,
                    player
            );



            stack.hurtAndBreak(
                    1,
                    player,
                    EquipmentSlot.MAINHAND
            );



            miningTicks = 0;
            miningPos = null;
        }
    }
}