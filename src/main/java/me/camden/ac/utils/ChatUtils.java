package me.camden.ac.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ChatUtils {

    public static String getFromText(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void broadcastMessage(String message, String permission) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player.hasPermission(permission) || player.isOp()) player.sendMessage(message);
        });
    }
}
