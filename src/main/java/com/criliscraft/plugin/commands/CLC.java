package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CLC implements CommandExecutor {

    private final CriLisCraft pl;
    CriLisCraft configGetter;

    public CLC(CriLisCraft pl) {
        this.pl = pl;
        configGetter = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        int length = args.length;
        if (cmd.getName().equalsIgnoreCase("clc") && sender instanceof Player) {
            Player player = (Player) sender;
            if (length == 1 && args[0].equalsIgnoreCase("help")) {
                if (player.hasPermission(Perms.clcHelp)) {
                    player.sendMessage(Info.C3 + "-- " + Info.CA + "Commands" + Info.C3 + " ---");
                    player.sendMessage(ChatColor.RED + "/clc" + ChatColor.DARK_AQUA + " - The Main Command");
                    if (player.hasPermission(Perms.clcHelp)) {
                        player.sendMessage(ChatColor.RED + "/clc help" + ChatColor.DARK_AQUA + " - Diaplay's All Help Info");
                    }
                    if (player.hasPermission(Perms.clcSphatPerm)) {
                        player.sendMessage(ChatColor.RED + "/clc sphat" + ChatColor.DARK_AQUA + " - Saint Patricks Day Hat!");
                    }
                    if (player.hasPermission(Perms.clcHat)) {
                        player.sendMessage(ChatColor.RED + "/clc hat" + ChatColor.DARK_AQUA + " - Makes the item in your hand a hat");
                    }
                    if (player.hasPermission(Perms.clcRandom)) {
                        player.sendMessage(ChatColor.RED + "/clc random" + ChatColor.DARK_AQUA + " - Teleports you to a random location");
                    }
                    if (player.hasPermission(Perms.clcReload)) {
                        player.sendMessage(ChatColor.RED + "/clc reload" + ChatColor.DARK_AQUA + " - Reloads the config");
                    }
                } else {
                    Info.noPerms(player);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Perms.clcReload)) {
                    configGetter.reloadConfig();
                    player.sendMessage(Info.CHAT_PREFIX + "Config Reloaded");
                } else {
                    Info.noPerms(player);
                }
            }
            return true;
        }
        return false;
    }
}
