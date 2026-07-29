package com.jaboi313.craftingandtweaksplus.mining;

import com.jaboi313.craftingandtweaksplus.ModComponents;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;


public class SpecialBlockBreakerHelper {


    public static void register() {

        PlayerBlockBreakEvents.BEFORE.register(
                (world, player, pos, state, blockEntity) -> {


                    ItemStack stack =
                            player.getMainHandItem();

                    if (!stack.getOrDefault(
                            ModComponents.SPECIAL_BLOCK_BREAKER,
                            false
                    )) {
                        return true;
                    }

                    if (!state.is(Blocks.BEDROCK)) {


                        if (player instanceof ServerPlayer serverPlayer) {

                            for (int i = 0; i < 5; i++) {
                                serverPlayer.connection.send(
                                    new ClientboundSetActionBarTextPacket(
                                        Component.literal(
                                            "The Special Block Breaker can not destroy normal blocks."
                                        ).withStyle(ChatFormatting.RED)
                                    )
                                );
                            }
                        }
                        return false;
                    }

                    return false;
                }
        );
    }
}