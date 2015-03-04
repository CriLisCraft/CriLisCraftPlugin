package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.ChatPrefix;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityListener implements Listener {
    CriLisCraft configGetter;
    public EntityListener(CriLisCraft pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
        configGetter = pl;
    }
    @EventHandler
    public void onEntityKill(EntityDeathEvent e) {
        Entity deadEntity = e.getEntity();
        Entity killer = e.getEntity().getKiller();
        if (killer instanceof Player && deadEntity instanceof Player) {
            Player player = (Player) killer;
            int killcount = configGetter.getConfig().getInt("playerkills");
            configGetter.getConfig().set("playerkills", killcount + 1);
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "You Have Killed a Player");
        } else if (killer instanceof Player && deadEntity instanceof Zombie) {
            Player player = (Player) killer;
            int killcount = configGetter.getConfig().getInt("zombiekills");
            configGetter.getConfig().set("zombiekills", killcount + 1);
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "You Have Killed a Zombie");
        } else if (killer instanceof Player && deadEntity instanceof Creeper) {
            Player player = (Player) killer;
            int killcount = configGetter.getConfig().getInt("creeperkills");
            configGetter.getConfig().set("creeperkills", killcount + 1);
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "You have killed a Creeper");
        } else if (killer instanceof Player && deadEntity instanceof Skeleton) {
            Player player = (Player) killer;
            int killcount = configGetter.getConfig().getInt("skeletonkills");
            configGetter.getConfig().set("skeletonkills", killcount + 1);
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "You have killed a Skeleton");
        } else if (killer instanceof Player && deadEntity instanceof  Spider) {
            Player player = (Player) killer;
            int killcount = configGetter.getConfig().getInt("spiderkills");
            configGetter.getConfig().set("spiderkills", killcount + 1);
            player.sendMessage(ChatPrefix.CHAT_PREFIX + "You have killed a Spider");
        }
    }
}
