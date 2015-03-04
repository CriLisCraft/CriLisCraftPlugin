package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    public PlayerListener(CriLisCraft pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.DARK_PURPLE + "[WELCOME] " + ChatColor.LIGHT_PURPLE + "Welcome, " + ChatColor.DARK_AQUA + player.getName() + ChatColor.LIGHT_PURPLE + ", to the server!");

            Location teleportLocation = null;
            int x = -18;
            int y = 42;
            int z = 747;
            teleportLocation = new Location(player.getWorld(), x, y, z);
            player.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
        }
    }
}
