package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Color;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.util.Items;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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
                    PlayerInventory inv = player.getInventory();
                    inv.setItem(7, new ItemStack(Material.FEATHER));
                    inv.setItem(8, new ItemStack(Material.STICK));
                    player.sendMessage(Returns.CHAT_PREFIX + "Here is your 1337 staff kit :D");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("chaka")) {
                if (player.hasPermission(Perms.clcKitChaka)) {
                    PlayerInventory inv = player.getInventory();

                    ItemStack item = Items.chakaSword();
                    inv.addItem(new ItemStack(item));
                    player.sendMessage(Returns.CHAT_PREFIX + "You have been given the kit, " + Color.c(3) + "CHAKA");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("l1")) {
                if (player.hasPermission(Perms.clcKitEquip)) {
                    // 1 - stick 2- feather 3 - chaka 4- legeis
                    PlayerInventory inv = player.getInventory();

                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("legeis")) {
                if (player.hasPermission(Perms.clcKitLegeis)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.BOW);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Legeis Bow");
                    meta.setLore(Arrays.asList("The bow of the great Lord Legeis"));
                    meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
                    meta.addEnchant(Enchantment.ARROW_FIRE, 8, true);
                    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    meta.addEnchant(Enchantment.DURABILITY, 10, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    inv.addItem(new ItemStack(Material.ARROW));
                    player.sendMessage(Returns.CHAT_PREFIX + "You have been given the kit, " + Color.c(3) + "LEGEIS");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("list")) {
                if (player.hasPermission(Perms.clcKitList)) {
                    player.sendMessage(Color.c("a") + "--- " + Color.c(3) + "Kit List" + Color.c("a") + " ---");
                    player.sendMessage(Color.c("c") + "Use " + Color.c(3) + "/kit <kitname>");
                    player.sendMessage(Color.c(3) + "LIST " + Color.c("a") + "- The Command you just typed :D  It should be easy to see what it does.");
                    if (player.hasPermission(Perms.clcKitStaff)) {
                        player.sendMessage(Color.c(3) + "STAFF " + Color.c("a") + "- The Staff Kit");
                    }
                    if (player.hasPermission(Perms.clcKitChaka)) {
                        player.sendMessage(Color.c(3) + "CHAKA " + Color.c("a") + "- The Chaka Kit");
                    }
                    if (player.hasPermission(Perms.clcKitLegeis)) {
                        player.sendMessage(Color.c(3) + "LEGEIS " + Color.c("a") + "- The Legeis Kit");
                    }
                    if (player.hasPermission(Perms.clcKitEquip)) {
                        player.sendMessage(Color.c(3) + "L1 " + Color.c("a") + "- The l1 Kit");
                    }
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else {
                if (player.hasPermission(Perms.clcKit)) {
                    player.sendMessage(Returns.CHAT_PREFIX + "Use " + Color.c(3) + "/kit list " + Color.c("a") + "to see the kits you can use.");
                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            }
            return true;
        }
        return false;
    }
}
