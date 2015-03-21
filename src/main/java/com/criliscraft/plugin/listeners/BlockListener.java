package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    public BlockListener(CriLisCraft pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }
    @EventHandler
    public void onTntPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (e.getBlock().getType() == Material.TNT) {
            if (!player.hasPermission("clc.place.tnt")) {
                player.sendMessage(Info.NO_PERMS_PLACE + e.getBlock().getType().toString());
                e.setCancelled(true);
            }
        }
    }
}
