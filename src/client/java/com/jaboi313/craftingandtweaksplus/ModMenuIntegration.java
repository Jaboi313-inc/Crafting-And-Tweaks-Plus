package com.jaboi313.craftingandtweaksplus;

import com.jaboi313.craftingandtweaksplus.config.ConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigScreen::create;
    }
}
