package com.criliscraft.plugin;

import com.criliscraft.plugin.commands.CLC;
import com.criliscraft.plugin.commands.Hat;
import com.criliscraft.plugin.commands.Random;
import com.criliscraft.plugin.listeners.BlockListener;
import com.criliscraft.plugin.listeners.PlayerListener;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class CriLisCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("Failed To Submit Metrics");
        }
        new PlayerListener(this);
        new BlockListener(this);
        //new EntityListener(this);
        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(Perms.clcSphatPerm);
        pm.addPermission(Perms.clcHat);
        pm.addPermission(Perms.clcPlaceTnt);
        pm.addPermission(Perms.clcRandom);
        pm.addPermission(Perms.clcCreativeOnJoin);
        pm.addPermission(Perms.clcReload);
        pm.addPermission(Perms.clcWellfare);
        pm.addPermission(Perms.clcHelp);
        this.getConfig().addDefault("statsenabled", true);
        this.getConfig().addDefault("playerkills", 0);
        this.getConfig().addDefault("zombiekills", 0);
        this.getConfig().addDefault("creeperkills", 0);
        this.getConfig().addDefault("skeletonkills", 0);
        this.getConfig().addDefault("spiderkills", 0);
        this.getConfig().options().copyDefaults(true);

        //Commands
        this.getCommand("clc").setExecutor(new CLC(this));
        this.getCommand("hat").setExecutor(new Hat(this));
        this.getCommand("random").setExecutor(new Random(this));

        saveConfig();

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Disabled");
    }
}
