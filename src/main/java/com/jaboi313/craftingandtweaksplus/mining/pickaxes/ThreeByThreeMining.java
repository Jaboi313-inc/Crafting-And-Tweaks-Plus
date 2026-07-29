package com.jaboi313.craftingandtweaksplus.mining.pickaxes;

import com.jaboi313.craftingandtweaksplus.ModComponents;
import com.jaboi313.craftingandtweaksplus.mining.AreaMiningHelper;

public class ThreeByThreeMining {

    public static void register() {

        new AreaMiningHelper(1, ModComponents.THREE_BY_THREE).register();

    }
}