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
                    player.sendMessage(Info.CA + "-- " + Info.C3 + "Commands" + Info.CA + " ---");
                    player.sendMessage(Info.C3 + "/clc" + Info.CA + " - The Main Command.");
                    if (player.hasPermission(Perms.clcHelp)) {
                        player.sendMessage(Info.C3 + "/clc help" + Info.CA + " - Diaplay's All Help Info.");
                    }
                    if (player.hasPermission(Perms.clcHat)) {
                        player.sendMessage(Info.C3 + "/hat" + Info.CA + " - Makes the item in your hand a hat.");
                    }
                    if (player.hasPermission(Perms.clcRandom)) {
                        player.sendMessage(Info.C3 + "/random" + Info.CA + " - Teleports you to a random location.");
                    }
                    if (player.hasPermission(Perms.clcBuy)) {
                        player.sendMessage(Info.C3 + "/buy" + Info.CA + " - The CriLis Craft buy command.");
                    }
                    if (player.hasPermission(Perms.clcKit)) {
                        player.sendMessage(Info.C3 + "/kit" + Info.CA + " - Gives you fancy kits :D.");
                    }
                    if (player.hasPermission(Perms.clcReload)) {
                        player.sendMessage(Info.C3 + "/clc reload" + Info.CA + " - Reloads the config.");
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
            } else {
                player.sendMessage(Info.CHAT_PREFIX + "Use " + Info.C3 + "/clc help " + Info.CA + "for a valid list of sub commands.");
            }
            return true;
        }
        return false;
    }
}
