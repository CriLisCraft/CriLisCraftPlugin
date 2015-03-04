package com.criliscraft.plugin;

import com.criliscraft.plugin.listeners.BlockListener;
import com.criliscraft.plugin.listeners.EntityListener;
import com.criliscraft.plugin.listeners.PlayerListener;
import com.criliscraft.plugin.util.ChatPrefix;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class CriLisCraft extends JavaPlugin {

    public Permission clcSphatPerm = new Permission("clc.cmd.sphat");
    public Permission clcHat = new Permission("clc.cmd.hat");
    public Permission clcPlaceTnt = new Permission("clc.place.tnt");
    public Permission clcRandom = new Permission("clc.cmd.random");
    public Permission clcVanish = new Permission("clc.cmd.vanish");

    @Override
    public void onEnable() {
        new PlayerListener(this);
        new BlockListener(this);
        //new EntityListener(this);
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(clcSphatPerm);
        pm.addPermission(clcHat);
        pm.addPermission(clcPlaceTnt);
        pm.addPermission(clcRandom);
        pm.addPermission(clcVanish);
        this.getConfig().addDefault("statsenabled", true);
        this.getConfig().addDefault("playerkills", 0);
        this.getConfig().addDefault("zombiekills", 0);
        this.getConfig().addDefault("creeperkills", 0);
        this.getConfig().addDefault("skeletonkills", 0);
        this.getConfig().addDefault("spiderkills", 0);
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String [] args) {
        if (cmd.getName().equalsIgnoreCase("clc") && sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "Use /clc-help for a list of commands!");
            return true;
        } else if (cmd.getName().equalsIgnoreCase("clc-help") && sender instanceof  Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "Command List");
            player.sendMessage(ChatColor.RED + "/clc" + ChatColor.DARK_AQUA + " - The Main Command");
            player.sendMessage(ChatColor.RED + "/clc-help" + ChatColor.DARK_AQUA + " - Diaplay's All Help Info");
            player.sendMessage(ChatColor.RED + "/clc-sphat" + ChatColor.DARK_AQUA + " - Saint Patricks Day Hat!");
            player.sendMessage(ChatColor.RED + "/clc-hat" + ChatColor.DARK_AQUA + " - Makes the item in your hand a hat");
            player.sendMessage(ChatColor.RED + "/clc-random" + ChatColor.DARK_AQUA + " - Teleports you to a random location");
            player.sendMessage(ChatColor.RED + "/clc-reload" + ChatColor.DARK_AQUA + " - Reloads the config");
            return true;
        } else if (cmd.getName().equalsIgnoreCase("clc-sphat") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("clc.cmd.sphat")) {
                player.getInventory().setHelmet(new ItemStack(Material.EMERALD_BLOCK));
                player.sendMessage(ChatPrefix.CHAT_PREFIX + ChatColor.DARK_GREEN + "Have fun with your new hat!");
            } else {
                player.sendMessage(ChatPrefix.NO_PERMS);
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("clc-hat") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("clc.cmd.hat")) {
                if (player.getItemInHand().getType() != Material.AIR) {
                    ItemStack itemHand = player.getItemInHand();
                    PlayerInventory inventory = player.getInventory();
                    ItemStack itemHead = inventory.getHelmet();
                    inventory.removeItem(new ItemStack[] { itemHand });
                    inventory.setHelmet(itemHand);
                    inventory.setItemInHand(itemHead);
                    player.sendMessage(ChatPrefix.CHAT_PREFIX + "Yey a hat!");
                } else {
                        player.sendMessage(ChatPrefix.CHAT_PREFIX + ChatColor.DARK_RED + "You must have something in your hand!");
                }
            } else {
                player.sendMessage(ChatPrefix.NO_PERMS);
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("clc-random") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("clc.cmd.random")) {
                Location originalLocation = player.getLocation();
                Random random = new Random();
                Location teleportLocation = null;
                int x = random.nextInt(5000) + 1;
                int y = 150;
                int z = random.nextInt(5000) + 1;
                boolean isOnLand = false;
                while (isOnLand == false) {
                    teleportLocation = new Location(player.getWorld(), x, y, z);
                    if (teleportLocation.getBlock().getType() != Material.AIR && teleportLocation.getBlock().getType() != Material.STONE) {
                        isOnLand = true;
                    } else y--;
                    player.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
                    player.sendMessage(ChatPrefix.CHAT_PREFIX + "You have been teleported " + (int)teleportLocation.distance(originalLocation) + " blocks away!");
                }
            } else {
                player.sendMessage(ChatPrefix.NO_PERMS);
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("clc-reload") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("clc.cmd.reload")) {
                reloadConfig();
                player.sendMessage(ChatPrefix.CHAT_PREFIX + "Config Successfully Reloaded!");
            } else {
                player.sendMessage(ChatPrefix.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
