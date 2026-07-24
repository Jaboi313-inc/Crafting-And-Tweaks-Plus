package com.jaboi313.craftingandtweaksplus.config;

public class ModConfig {

    public HarnessConfig harness = new HarnessConfig();

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
}