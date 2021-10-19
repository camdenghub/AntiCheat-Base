package me.camden.ac;

import me.camden.ac.check.CheckManager;
import me.camden.ac.commands.ReloadCommand;
import me.camden.ac.listeners.PlayerListener;
import me.camden.ac.utils.ChatUtils;
import net.b0at.api.event.Event;
import net.b0at.api.event.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class AntiCheatPlugin extends JavaPlugin {

    private static AntiCheatPlugin instance;

    private final CheckManager checkManager = new CheckManager();

    public final Logger LOGGER = Logger.getLogger("AC");

    public final String PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "AC" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;

    public final EventManager<Event> bus = new EventManager<>(Event.class);

    @Override
    public void onEnable() {
        instance = this;
        saveConfig();
        Configuration.init();

        getCheckManager().initChecks();

        getCommand("acreload").setExecutor(new ReloadCommand());

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        Bukkit.getLogger().log(Level.INFO, ChatUtils.getFromText("&4AntiCheat enabled"));
    }

    public static AntiCheatPlugin getInstance() {
        return instance;
    }


    public CheckManager getCheckManager() {
        return checkManager;
    }
}
