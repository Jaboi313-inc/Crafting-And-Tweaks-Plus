package com.jaboi313.craftingandtweaksplus.mining.pickaxes;

import com.jaboi313.craftingandtweaksplus.ModComponents;
import com.jaboi313.craftingandtweaksplus.mining.AreaMiningHelper;

public class FiveByFiveMining {

    public static void register() {

        new AreaMiningHelper(2, ModComponents.FIVE_BY_FIVE).register();

    }
}