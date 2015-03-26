package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.Title;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopAnnounce implements CommandExecutor {

    private final CriLisCraft plugin;

    public StopAnnounce(CriLisCraft plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("stopannounce")) {
            Player player = (Player) sender;
            int length = args.length;
            if (length == 2 && isInteger(args[0])) {
                if (args[1].equalsIgnoreCase("s")) {
                    if (player.hasPermission(Perms.clcStopAnnounce)) {
                        if (args[0].equalsIgnoreCase("1")) {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " second.");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);
                            title.broadcast();
                        } else {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " seconds");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);
                            title.broadcast();
                        }
                    } else {
                        Info.noPerms(player);
                    }
                } else if (args[1].equalsIgnoreCase("m")) {
                    if (player.hasPermission(Perms.clcStopAnnounce)) {
                        if (args[0].equalsIgnoreCase("1")) {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " minute.");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);
                            title.broadcast();
                        } else {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " minutes.");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);

                        }
                    } else {
                        Info.noPerms(player);
                    }
                } else if (args[1].equalsIgnoreCase("h")){
                    if (player.hasPermission(Perms.clcStopAnnounce)) {
                        if (args[0].equalsIgnoreCase("1")) {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " hour.");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);
                            title.broadcast();
                        } else {
                            Title title = new Title("Server Shutting Down!", "In, " + args[0] + " hours.");
                            title.setTitleColor(ChatColor.DARK_RED);
                            title.setSubtitleColor(ChatColor.RED);

                        }
                    } else {
                        Info.noPerms(player);
                    }
                }
            }
            return true;
        }
        return false;
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
