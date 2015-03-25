package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
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
                    player.sendMessage(Info.CHAT_PREFIX + "Here is your 1337 staff kit :D");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("chaka")) {
                if (player.hasPermission(Perms.clcKitChaka)) {
                    PlayerInventory inv = player.getInventory();

                    ItemStack itemhead = new ItemStack(Material.SKULL_ITEM);
                    ItemMeta meta2 = itemhead.getItemMeta();

                    ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Chaka Sword");
                    meta.setLore(Arrays.asList("Feel the sharp sword slice thru your body."));
                    meta.setLore(Arrays.asList("This is the mighty sword of Lord Chaka"));
                    meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
                    meta.addEnchant(Enchantment.KNOCKBACK, 8, true);
                    meta.addEnchant(Enchantment.FIRE_ASPECT, 6, true);
                    meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 7, true);
                    meta.addEnchant(Enchantment.DURABILITY, 10, true);
                    item.setItemMeta(meta);
                    inv.addItem(new ItemStack(item));
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "CHAKA");
                } else {
                    Info.noPerms(player);
                }
                return true;
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
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "LEGEIS");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("tier1")) {
                if (player.hasPermission(Perms.clcKitTier1)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Donater Block" + Info.C3 + " Tier1");
                    meta.setLore(Arrays.asList("The kit for Tier1"));
                    meta.addEnchant(Enchantment.DURABILITY, 1000, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "TIER1");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("tier2")) {
                if (player.hasPermission(Perms.clcKitTier2)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Donater Block" + Info.C3 + " Tier2");
                    meta.setLore(Arrays.asList("The kit for Tier2"));
                    meta.addEnchant(Enchantment.DURABILITY, 2000, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "TIER2");
                } else {
                    Info.noPerms(player);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("tier3")) {
                if (player.hasPermission(Perms.clcKitTier3)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Donater Block" + Info.C3 + " Tier3");
                    meta.setLore(Arrays.asList("The kit for Tier3"));
                    meta.addEnchant(Enchantment.DURABILITY, 3000, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "TIER3");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("tier4")) {
                if (player.hasPermission(Perms.clcKitTier4)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Donater Block" + Info.C3 + " Tier4");
                    meta.setLore(Arrays.asList("The kit for Tier4"));
                    meta.addEnchant(Enchantment.DURABILITY, 4000, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "TIER4");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("tier5")) {
                if (player.hasPermission(Perms.clcKitTier1)) {
                    PlayerInventory inv = player.getInventory();
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("Donater Block" + Info.C3 + " Tier5");
                    meta.setLore(Arrays.asList("The kit for Tier5"));
                    meta.addEnchant(Enchantment.DURABILITY, 5000, true);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    player.sendMessage(Info.CHAT_PREFIX + "You have been given the kit, " + Info.C3 + "TIER5");
                } else {
                    Info.noPerms(player);
                }
                return true;
            } else if (length == 1 && args[0].equalsIgnoreCase("list")) {
                if (player.hasPermission(Perms.clcKitList)) {
                    player.sendMessage(Info.CA + "--- " + Info.C3 + "Kit List" + Info.CA + " ---");
                    player.sendMessage(Info.CC + "Use " + Info.C3 + "/kit (kitname)");
                    player.sendMessage(Info.C3 + "LIST " + Info.CA + "- The Command you just typed :D  It should be easy to see what it does.");
                    if (player.hasPermission(Perms.clcKitStaff)) {
                        player.sendMessage(Info.C3 + "STAFF " + Info.CA + "- The Staff Kit");
                    }
                    if (player.hasPermission(Perms.clcKitChaka)) {
                        player.sendMessage(Info.C3 + "CHAKA " + Info.CA + "- The Chaka Kit");
                    }
                    if (player.hasPermission(Perms.clcKitLegeis)) {
                        player.sendMessage(Info.C3 + "LEGEIS " + Info.CA + "- The Legeis Kit");
                    }
                    if (player.hasPermission(Perms.clcKitTier1)) {
                        player.sendMessage(Info.C3 + "TIER1 " + Info.CA + "- Donater Tier1 Kit");
                    }
                    if (player.hasPermission(Perms.clcKitTier2)) {
                        player.sendMessage(Info.C3 + "TIER2 " + Info.CA + "- Donater Tier2 Kit");
                    }
                    if (player.hasPermission(Perms.clcKitTier3)) {
                        player.sendMessage(Info.C3 + "TIER3 " + Info.CA + "- Donater Tier3 Kit");
                    }
                    if (player.hasPermission(Perms.clcKitTier4)) {
                        player.sendMessage(Info.C3 + "TIER4 " + Info.CA + "- Donater Tier4 Kit");
                    }
                    if (player.hasPermission(Perms.clcKitTier5)) {
                        player.sendMessage(Info.C3 + "TIER5 " + Info.CA + "- Donater Tier5 Kit");
                    }
                } else {
                    Info.noPerms(player);
                }
            } else {
                if (player.hasPermission(Perms.clcKit)) {
                    player.sendMessage(Info.CHAT_PREFIX + "Use " + Info.C3 + "/kit list " + Info.CA + "to see the kits you can use.");
                } else {
                    Info.noPerms(player);
                }
            }
            return true;
        }
        return false;
    }
}
