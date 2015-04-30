package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Color;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.inv.DonationInv;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                    player.sendMessage(Color.c("a") + "-- " + Color.c(3) + "Commands" + Color.c("a") + " ---");
                    player.sendMessage(Color.c(3) + "/clc" + Color.c("a") + " - The main command.");
                    if (player.hasPermission(Perms.clcHelp)) {
                        player.sendMessage(Color.c(3) + "/clc help" + Color.c("a") + " - Diaplay's all help info..");
                    }
                    if (player.hasPermission(Perms.clcHat)) {
                        player.sendMessage(Color.c(3) + "/hat" + Color.c("a") + " - Makes the item in your hand a hat.");
                    }
                    if (player.hasPermission(Perms.clcKit)) {
                        player.sendMessage(Color.c(3) + "/kit" + Color.c("a") + " - Gives you fancy kits :D.");
                    }
                    if (player.hasPermission(Perms.clcReload)) {
                        player.sendMessage(Color.c(3) + "/clc reload" + Color.c("a") + " - Reloads the config.");
                    }
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Perms.clcReload)) {
                    configGetter.reloadConfig();
                    player.sendMessage(Returns.CHAT_PREFIX + "Config Reloaded");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("buyinv")) {
                player.openInventory(DonationInv.inv);
                player.sendMessage(Returns.CHAT_PREFIX + "Opening the Donation Shop.");
            } else {
                player.sendMessage(Returns.CHAT_PREFIX + "Use " + Color.c(3) + "/clc help " + Color.c("a") + "for a valid list of sub commands.");
            }
            return true;
        }
        return false;
    }
}
