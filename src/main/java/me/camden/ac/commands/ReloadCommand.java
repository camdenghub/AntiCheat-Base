package me.camden.ac.commands;

import me.camden.ac.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.command.*;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("anticheat.perms") || sender instanceof ConsoleCommandSender) {
            Configuration.reload();

            sender.sendMessage(ChatColor.RED + "Reloaded AntiCheat!");
        }
        return true;
    }
}
