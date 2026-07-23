package com.jaboi313.craftingandtweaksplus.mining;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;


public record BrokenBlock(
        BlockState state,
        BlockPos pos
) {}