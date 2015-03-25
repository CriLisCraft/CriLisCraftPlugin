package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class ClearInv implements CommandExecutor {

    private final CriLisCraft plugin;

    public ClearInv(CriLisCraft plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ci") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcClearInv)) {
                PlayerInventory inv = player.getInventory();
                inv.clear();
                player.sendMessage(Info.CHAT_PREFIX + "Your inventory has been cleared.");
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
