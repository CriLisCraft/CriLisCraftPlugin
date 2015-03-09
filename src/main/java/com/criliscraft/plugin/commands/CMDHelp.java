package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDHelp implements CommandExecutor {
    private final CriLisCraft pl;
    public CMDHelp(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clc-help") && sender instanceof  Player) {
            Player player = (Player) sender;
            player.sendMessage(Info.CHAT_PREFIX + "Command List");
            player.sendMessage(ChatColor.RED + "/clc" + ChatColor.DARK_AQUA + " - The Main Command");
            player.sendMessage(ChatColor.RED + "/clc-help" + ChatColor.DARK_AQUA + " - Diaplay's All Help Info");
            player.sendMessage(ChatColor.RED + "/clc-sphat" + ChatColor.DARK_AQUA + " - Saint Patricks Day Hat!");
            player.sendMessage(ChatColor.RED + "/clc-hat" + ChatColor.DARK_AQUA + " - Makes the item in your hand a hat");
            player.sendMessage(ChatColor.RED + "/clc-random" + ChatColor.DARK_AQUA + " - Teleports you to a random location");
            player.sendMessage(ChatColor.RED + "/clc-reload" + ChatColor.DARK_AQUA + " - Reloads the config");
            return true;
        }
        return false;
    }
}
