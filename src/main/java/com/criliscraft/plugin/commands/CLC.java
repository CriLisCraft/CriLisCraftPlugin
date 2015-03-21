package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CLC implements CommandExecutor {

    private final CriLisCraft pl;
    CriLisCraft configGetter;

    public CLC(CriLisCraft pl) {
        this.pl = pl;
        configGetter = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        int length = args.length;
        if (cmd.getName().equalsIgnoreCase("clc") && sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(Info.CHAT_PREFIX + "Use /clc help for a list of commands!");
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
                    if (player.hasPermission("clc.cmd.random")) {
                        player.sendMessage(ChatColor.RED + "/clc random" + ChatColor.DARK_AQUA + " - Teleports you to a random location");
                    }
                    if (player.hasPermission("clc.cmd.reload")) {
                        player.sendMessage(ChatColor.RED + "/clc reload" + ChatColor.DARK_AQUA + " - Reloads the config");
                    }
                } else {
                    player.sendMessage(Info.NO_PERMS);
                    player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("sphat")) {
                if (player.hasPermission("clc.cmd.sphat") && sender instanceof Player) {
                    player.getInventory().setHelmet(new ItemStack(Material.EMERALD_BLOCK));
                    player.sendMessage(Info.CHAT_PREFIX + "Happy Saint Patrick's Day, Have a hat!");
                } else {
                    player.sendMessage(Info.NO_PERMS);
                    player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Perms.clcReload)) {
                    configGetter.reloadConfig();
                    player.sendMessage(Info.CHAT_PREFIX + "Config Reloaded");
                } else {
                    player.sendMessage(Info.NO_PERMS);
                    player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
                }
                return true;
            }
        } else {
            Player player = (Player) sender;
            player.sendMessage(Info.NO_PERMS);
            player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
        }
        return false;
    }
}
