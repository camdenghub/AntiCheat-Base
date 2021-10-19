package me.camden.ac;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class Configuration {

    private static AntiCheatPlugin plugin;
    private static FileConfiguration configuration;

    private static boolean shouldFlag, shouldOutput;

    private static final HashMap<String, Object> configKeys = new HashMap<>();

    static {
        configKeys.put("anticheat.shouldFlag", true);
        configKeys.put("anticheat.shouldOutput", false);
    }

    public static void init() {
        plugin = AntiCheatPlugin.getInstance();
        setup();
        reload();
    }

    public static void reload() {
        try {
            plugin.getConfig().load(plugin.getDataFolder() + "/config.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void save() {
        try {
            plugin.getConfig().save(plugin.getDataFolder() + "/config.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setup() {
        configuration = plugin.getConfig();
        configKeys.forEach((key, def) -> {
            if(!configuration.contains(key))
                configuration.set(key, def);
        });
        save();
    }

    public static AntiCheatPlugin getPlugin() {
        return plugin;
    }

    public static FileConfiguration getConfiguration() {
        return configuration;
    }

    public static boolean isShouldFlag() {
        return shouldFlag;
    }

    public static boolean isShouldOutput() {
        return shouldOutput;
    }
}
