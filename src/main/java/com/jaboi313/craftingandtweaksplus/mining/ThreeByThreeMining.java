package com.jaboi313.craftingandtweaksplus.mining;

import java.util.*;

import com.jaboi313.craftingandtweaksplus.ModComponents;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ThreeByThreeMining {

    private static final Map<UUID, LastHit> LAST_HITS =
            new HashMap<>();

    private static final ThreadLocal<Boolean> BREAKING_EXTRA =
            ThreadLocal.withInitial(() -> false);

    public static void register() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
                    if (!world.isClientSide()
                            && player instanceof ServerPlayer) {

                        ItemStack tool = player.getItemInHand(hand);

                        if (is3x3Pickaxe(tool)) {

                            LAST_HITS.put(
                                    player.getUUID(),
                                    new LastHit(
                                            pos,
                                            direction,
                                            world.getGameTime()
                                    )
                            );
                        }
                    }
                    return InteractionResult.PASS;
                }
        );

        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
                    if (BREAKING_EXTRA.get())
                        return;

                    if (!(player instanceof ServerPlayer serverPlayer))
                        return;

                    ItemStack tool = serverPlayer.getMainHandItem();

                    if (!is3x3Pickaxe(tool))
                        return;

                    Direction side =
                            getMiningSide(
                                    serverPlayer,
                                    pos
                            );

                    ServerLevel level = (ServerLevel) serverPlayer.level();

                    level.getServer()
                            .execute(() ->
                                    breakExtraBlocks(
                                            serverPlayer,
                                            pos,
                                            side
                                    )
                            );
                }
        );
    }

    public static boolean is3x3Pickaxe(ItemStack stack) {
        return stack.getOrDefault(
                ModComponents.THREE_BY_THREE,
                false
        );
    }

    private static Direction getMiningSide(
            ServerPlayer player,
            BlockPos origin) {

        LastHit hit = LAST_HITS.get(player.getUUID());

        if (hit != null
                && hit.pos().equals(origin)
                && player.level().getGameTime()
                - hit.time() <= 20) {


            return hit.side();
        }

        float pitch = player.getXRot();

        if (pitch > 60)
            return Direction.DOWN;

        if (pitch < -60)
            return Direction.UP;

        return player.getDirection();
    }

    private static List<BlockPos> getBlocksToBreak(
            BlockPos origin,
            Direction side) {

        List<BlockPos> result = new ArrayList<>(9);

        switch (side.getAxis()) {


            case Y -> {
                for (int x = -1; x <= 1; x++) {
                    for (int z = -1; z <= 1; z++) {
                        result.add(
                                origin.offset(
                                        x,
                                        0,
                                        z
                                )
                        );
                    }
                }
            }

            case X -> {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        result.add(
                                origin.offset(
                                        0,
                                        y,
                                        z
                                )
                        );
                    }
                }
            }

            case Z -> {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        result.add(
                                origin.offset(
                                        x,
                                        y,
                                        0
                                )
                        );
                    }
                }
            }
        }

        return result;
    }

    private static void breakExtraBlocks(
            ServerPlayer player,
            BlockPos origin,
            Direction side) {

        ServerLevel level = (ServerLevel) player.level();

        ItemStack tool = player.getMainHandItem();

        for (BlockPos pos :
                getBlocksToBreak(origin, side)) {

            if (pos.equals(origin))
                continue;

            BlockState state = level.getBlockState(pos);

            if (state.isAir())
                continue;

            BlockEntity blockEntity = level.getBlockEntity(pos);

            List<ItemStack> drops =
                    Block.getDrops(
                            state,
                            level,
                            pos,
                            blockEntity,
                            player,
                            tool
                    );

            BREAKING_EXTRA.set(true);

            try {

                level.removeBlock(
                        pos,
                        false
                );
            } finally {
                BREAKING_EXTRA.set(false);
            }

            for (ItemStack drop : drops) {

                Block.popResource(
                        level,
                        pos,
                        drop
                );
            }
        }
    }

    private record LastHit(
            BlockPos pos,
            Direction side,
            long time
    ) {}

}