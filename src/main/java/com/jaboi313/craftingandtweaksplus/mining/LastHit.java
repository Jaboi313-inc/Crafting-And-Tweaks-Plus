package com.jaboi313.craftingandtweaksplus.mining;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;


public record LastHit(
        BlockPos pos,
        Direction side,
        long time
) {}