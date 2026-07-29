package com.jaboi313.craftingandtweaksplus.mining;

import java.util.*;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class AreaMiningHelper {


    private final int radius;

    private final DataComponentType<Boolean> component;



    private final Map<UUID, LastHit> lastHits =
            new HashMap<>();


    private final ThreadLocal<Boolean> breakingExtra =
            ThreadLocal.withInitial(() -> false);



    public AreaMiningHelper(
            int radius,
            DataComponentType<Boolean> component
    ) {

        this.radius = radius;
        this.component = component;

    }




    public void register() {


        AttackBlockCallback.EVENT.register(
                (player, world, hand, pos, direction) -> {


                    if (!world.isClientSide()
                            && player instanceof ServerPlayer) {


                        ItemStack tool =
                                player.getItemInHand(hand);


                        if (isMiningTool(tool)) {


                            lastHits.put(
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





        PlayerBlockBreakEvents.AFTER.register(
                (world, player, pos, state, blockEntity) -> {


                    if (breakingExtra.get())
                        return;



                    if (!(player instanceof ServerPlayer serverPlayer))
                        return;



                    ItemStack tool =
                            serverPlayer.getMainHandItem();



                    if (!isMiningTool(tool))
                        return;



                    Direction side =
                            getMiningSide(
                                    serverPlayer,
                                    pos
                            );



                    ServerLevel level =
                            (ServerLevel) serverPlayer.level();



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







    private boolean isMiningTool(ItemStack stack) {

        return stack.getOrDefault(
                component,
                false
        );
    }








    private Direction getMiningSide(
            ServerPlayer player,
            BlockPos origin
    ) {


        LastHit hit =
                lastHits.get(
                        player.getUUID()
                );



        if (hit != null
                && hit.pos().equals(origin)
                && player.level().getGameTime()
                - hit.time() <= 20) {


            return hit.side();
        }




        float pitch =
                player.getXRot();



        if (pitch > 60)
            return Direction.DOWN;



        if (pitch < -60)
            return Direction.UP;



        return player.getDirection();
    }









    private List<BlockPos> getBlocksToBreak(
            BlockPos origin,
            Direction side
    ) {


        List<BlockPos> result =
                new ArrayList<>(
                        (radius * 2 + 1)
                        *
                        (radius * 2 + 1)
                );



        switch (side.getAxis()) {


            case Y -> {

                for (int x = -radius; x <= radius; x++) {

                    for (int z = -radius; z <= radius; z++) {


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

                for (int y = -radius; y <= radius; y++) {

                    for (int z = -radius; z <= radius; z++) {


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

                for (int x = -radius; x <= radius; x++) {

                    for (int y = -radius; y <= radius; y++) {


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









    private void breakExtraBlocks(
            ServerPlayer player,
            BlockPos origin,
            Direction side
    ) {


        ServerLevel level =
                (ServerLevel) player.level();



        ItemStack tool =
                player.getMainHandItem();





        for (BlockPos pos :
                getBlocksToBreak(origin, side)) {



            if (pos.equals(origin))
                continue;



            BlockState state = level.getBlockState(pos);


            if (state.isAir())
                continue;

            if (state.getDestroySpeed(level, pos) < 0)
                continue;

            if (!player.hasCorrectToolForDrops(state))
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




            breakingExtra.set(true);



            try {

                level.removeBlock(
                        pos,
                        false
                );


            } finally {

                breakingExtra.set(false);

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