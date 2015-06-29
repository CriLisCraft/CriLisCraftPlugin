package com.criliscraft.plugin.listener;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.perm.PermLib;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.logging.Level;

public class BlockListener implements Listener {

    private final CriLisCraft plugin;

    public BlockListener(CriLisCraft plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Material block = event.getBlock().getType();
        if (block == Material.SIGN || block == Material.SIGN_POST || block == Material.WALL_SIGN) {
            if (!(player.hasPermission(PermLib.PLACE_SIGN))) {
                plugin.getLogger().log(Level.INFO, "WARNING: " + player.getName() + " tried to place a sign at " + player.getLocation().getX() + ", " + player.getLocation().getY() + ", " + player.getLocation().getZ() + "!");
                player.sendMessage(ChatColor.RED + "You must be at the Newbie rank or higher to use signs.");
                player.sendMessage(ChatColor.RED + "This is to prevent players from using the sign hack.");
                event.setCancelled(true);
            }
        } else if (block == Material.TNT) {
            if (!(player.hasPermission(PermLib.PLACE_TNT))) {
                plugin.getLogger().log(Level.INFO, "WARNING: " + player.getName() + " tried to place tnt at " + player.getLocation().getX() + ", " + player.getLocation().getY() + ", " + player.getLocation().getZ() + "!");
                player.sendMessage(ChatColor.RED + "You must be at the Newbie rank or higher to use tnt.");
                event.setCancelled(true);
            }
        }
    }
}
