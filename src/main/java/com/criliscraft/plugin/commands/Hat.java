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
import org.bukkit.inventory.PlayerInventory;

public class Hat implements CommandExecutor {

    private final CriLisCraft pl;

    public Hat(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("hat") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcHat)) {
                if (player.getItemInHand().getType() != Material.AIR) {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHead = inventory.getHelmet();
                    inventory.removeItem(new ItemStack[] { itemHand });
                    inventory.setHelmet(itemHand);
                    inventory.setItemInHand(itemHead);
                    player.sendMessage(Info.CHAT_PREFIX + "Yay a hat!");
                } else {
                    player.sendMessage(Info.CHAT_PREFIX + ChatColor.DARK_RED + "You must have something in your hand!");
                }
            } else {
                player.sendMessage(Info.NO_PERMS);
                player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
            }
            return true;
        }
        return false;
    }
}
