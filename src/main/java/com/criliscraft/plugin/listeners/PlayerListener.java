package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
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
            player.teleport(new Location(player.getWorld(), 105, 45, 98));
        }
        if (player.hasPermission("clc.creativeonjoin")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(Info.CHAT_PREFIX + "Your gamemode has been updated.");
        }
    }
    public void onPlayer(PlayerAchievementAwardedEvent e) {
        Player player = e.getPlayer();
    }
}