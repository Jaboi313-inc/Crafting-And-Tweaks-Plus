package com.jaboi313.craftingandtweaksplus.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Block.class)
public class MiningMixin {


    @Inject(
        method = "playerDestroy",
        at = @At("HEAD")
    )
    private void onBlockBreak(
            Level level,
            Player player,
            BlockPos pos,
            BlockState state,
            BlockEntity blockEntity,
            ItemStack tool,
            CallbackInfo ci
    ) {


        if (level.isClientSide()) {
            return;
        }


        if (!player.getMainHandItem()
                .getHoverName()
                .getString()
                .contains("3x3 Pickaxe")) {

            return;
        }


        ServerLevel serverLevel = (ServerLevel) level;

        Direction direction = player.getDirection();

        float pitch = player.getXRot();



        boolean horizontal;

        if (pitch > 30 || pitch < -30) {

            horizontal = true;

        } else {

            horizontal = false;
        }



        for (int x = -1; x <= 1; x++) {

            for (int y = -1; y <= 1; y++) {


                if (x == 0 && y == 0) {
                    continue;
                }


                BlockPos target;



                if (horizontal) {

                    // grond/plafond
                    target = pos.offset(
                            x,
                            0,
                            y
                    );


                } else {


                    // muur

                    if (direction == Direction.NORTH ||
                        direction == Direction.SOUTH) {


                        target = pos.offset(
                                x,
                                y,
                                0
                        );


                    } else {


                        target = pos.offset(
                                0,
                                y,
                                x
                        );
                    }
                }



                if (!level.isEmptyBlock(target)) {


                    serverLevel.sendParticles(
                            ParticleTypes.PORTAL,
                            target.getX()+0.5,
                            target.getY()+0.5,
                            target.getZ()+0.5,
                            5,
                            0.2,
                            0.2,
                            0.2,
                            0.05
                    );


                    serverLevel.destroyBlock(
                            target,
                            true,
                            player
                    );
                }
            }
        }


        serverLevel.playSound(
                null,
                pos,
                SoundEvents.AMETHYST_BLOCK_CHIME,
                SoundSource.BLOCKS,
                2,
                1
        );
    }
}