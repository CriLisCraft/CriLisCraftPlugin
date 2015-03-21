package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Kit implements CommandExecutor {

    private final CriLisCraft pl;

    public Kit(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        int length = args.length;
        if (cmd.getName().equalsIgnoreCase("kit") && sender instanceof Player) {
            Player player = (Player) sender;
            if (length == 1 && args[0].equalsIgnoreCase("staff")) {
                if (player.hasPermission(Perms.clcKitStaff)) {
                    PlayerInventory inventory = player.getInventory();
                    inventory.setItem(7, new ItemStack(Material.FEATHER));
                    inventory.setItem(8, new ItemStack(Material.STICK));
                    player.sendMessage(Info.CHAT_PREFIX + "Here is your 1337 staff kit :D");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("tier1")) {
                if (player.hasPermission(Perms.clcKitTier1)) {
                    PlayerInventory inventory = player.getInventory();
                    inventory.addItem(new ItemStack(Material.EMERALD_BLOCK));
                    player.sendMessage(Info.CHAT_PREFIX + "Uhh, Have a donater thing :D");
                } else {
                    Info.noPerms(player);
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
