package com.jaboi313.craftingandtweaksplus.mining.pickaxes;

import com.jaboi313.craftingandtweaksplus.ModComponents;
import com.jaboi313.craftingandtweaksplus.mining.AreaMiningHelper;

public class SevenBySevenMining {

    public static void register() {

        new AreaMiningHelper(3, ModComponents.SEVEN_BY_SEVEN).register();

    }
}