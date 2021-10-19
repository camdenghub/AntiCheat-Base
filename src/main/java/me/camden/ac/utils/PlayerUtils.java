package me.camden.ac.utils;

import org.bukkit.entity.Player;

public class PlayerUtils {

    public static boolean isInLiquid(Player player) {
        return player.getLocation().getBlock().isLiquid() || player.getLocation().add(0,1,0).getBlock().isLiquid();
    }
}
