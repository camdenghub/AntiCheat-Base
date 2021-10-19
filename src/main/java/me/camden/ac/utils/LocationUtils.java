package me.camden.ac.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

public class LocationUtils {

    public static Location getClosestBlockBelow(Player player) {
        final Location location = player.getLocation();
        for (double y = player.getLocation().getY(); y > 0.0D; y -= 0.1D) {
            final Block block = player.getWorld().getBlockAt(new Location(player.getWorld(), location.getX(), y, location.getZ()));
            if (!block.isPassable()) {
                return block.getLocation();
            }
        }
        return null;
    }


    public static Location getClosestBlockBelow(Player player, Location location) {
        for (double y = player.getLocation().getY(); y > 0.0D; y -= 0.1D) {
            final Location location1 = new Location(player.getWorld(), location.getX(), y, location.getZ());
            final Block block = player.getWorld().getBlockAt(location1);
            if (!block.isPassable()) {
                return location1;
            }
        }
        return null;
    }

    public static Location getClosestBlockBelowSkipLiquid(Player player, Location location) {
        for (double y = player.getLocation().getY(); y > 0.0D; y -= 0.1D) {
            final Block block = player.getWorld().getBlockAt(new Location(player.getWorld(), location.getX(), y, location.getZ()));

            if (block.isLiquid())
                return null;

            if (!block.isPassable()) {
                return block.getLocation();
            }
        }
        return null;
    }

    public static Location getClosestLiquid(Player player, Location location) {
        for (double y = player.getLocation().getY(); y > 0.0D; y -= 0.1D) {
            final Block block = player.getWorld().getBlockAt(new Location(player.getWorld(), location.getX(), y, location.getZ()));

            if (block.isLiquid()) {
                return block.getLocation();
            }
        }
        return null;
    }

    public static boolean isOnGround(Player player) {
        Location loc = player.getLocation();
        if (loc.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
            return true;
        }
        Location a = loc;
        a.setY(a.getY() - 0.5);
        if (a.getBlock().getType() != Material.AIR) {
            return true;
        }
        a = loc;
        a.setY(a.getY() + 0.5);
        return a.getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR;
    }
}
