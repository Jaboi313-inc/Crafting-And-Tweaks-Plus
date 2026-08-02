package com.jaboi313.craftingandtweaksplus.config;

import java.util.ArrayList;
import java.util.List;

public class ModConfig {

    public HarnessConfig harness = new HarnessConfig();

    public SpecialBlockBreakerConfig specialBlockBreaker =
            new SpecialBlockBreakerConfig();


    public static List<BreakableBlock> createDefaultBlocks() {
        List<BreakableBlock> blocks = new ArrayList<>();

        blocks.add(new BreakableBlock(
                "minecraft:bedrock",
                100
        ));

        blocks.add(new BreakableBlock(
                "minecraft:end_portal_frame",
                100
        ));

        blocks.add(new BreakableBlock(
                "minecraft:end_portal",
                100
        ));

        blocks.add(new BreakableBlock(
                "minecraft:end_gateway",
                100
        ));

        blocks.add(new BreakableBlock(
                "minecraft:nether_portal",
                100
        ));

        return blocks;
    }


    public static class HarnessConfig {

        public double speedLevel1 = 25;
        public double speedLevel2 = 50;
        public double speedLevel3 = 75;
        public double speedLevel4 = 100;
        public double speedLevel5 = 150;


        public double getSpeed(int level) {
            return switch (level) {
                case 1 -> speedLevel1;
                case 2 -> speedLevel2;
                case 3 -> speedLevel3;
                case 4 -> speedLevel4;
                case 5 -> speedLevel5;
                default -> 0;
            };
        }
    }


    public static class SpecialBlockBreakerConfig {

        public List<BreakableBlock> blocks =
                ModConfig.createDefaultBlocks();


        public SpecialBlockBreakerConfig() {

        }


        public int getBreakTime(String blockId) {

            for (BreakableBlock block : blocks) {

                if (block.blockId.equals(blockId)) {
                    return block.breakTime;
                }
            }

            return -1;
        }
    }


    public static class BreakableBlock {

        public String blockId;
        public int breakTime;


        public BreakableBlock() {

        }


        public BreakableBlock(
                String blockId,
                int breakTime
        ) {

            this.blockId = blockId;
            this.breakTime = breakTime;
        }


        @Override
        public String toString() {
            return blockId + " (" + breakTime + ")";
        }
    }
}