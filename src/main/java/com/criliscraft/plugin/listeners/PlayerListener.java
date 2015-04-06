package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
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
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        int[] playerDeathLoc = {0,0,0};
        String deathWorld;
        playerDeathLoc[0] = player.getLocation().getBlockX();
        playerDeathLoc[1] = player.getLocation().getBlockY();
        playerDeathLoc[2] = player.getLocation().getBlockZ();
        deathWorld = player.getLocation().getWorld().getName();
        Info.deathLocMessage(player, playerDeathLoc[0], playerDeathLoc[1], playerDeathLoc[2], deathWorld);
    }
}
