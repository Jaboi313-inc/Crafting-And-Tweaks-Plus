package com.jaboi313.craftingandtweaksplus.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigManager {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private static final File FILE =
            new File("config/crafting-and-tweaks-plus.json");


    public static ModConfig config = new ModConfig();


    public static void load() {

        try {

            if (!FILE.exists()) {
                save();
                return;
            }

            FileReader reader = new FileReader(FILE);

            config = GSON.fromJson(reader, ModConfig.class);

            reader.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void save() {

        try {

            FILE.getParentFile().mkdirs();

            FileWriter writer = new FileWriter(FILE);

            GSON.toJson(config, writer);

            writer.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static ModConfig getConfig() {
        return config;
    }
}