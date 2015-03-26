package com.criliscraft.plugin;

import com.criliscraft.plugin.commands.*;
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
        pm.addPermission(Perms.clcHat);
        pm.addPermission(Perms.clcPlaceTnt);
        pm.addPermission(Perms.clcRandom);
        pm.addPermission(Perms.clcCreativeOnJoin);
        pm.addPermission(Perms.clcReload);
        pm.addPermission(Perms.clcWellfare);
        pm.addPermission(Perms.clcHelp);
        pm.addPermission(Perms.clcBuy);
        pm.addPermission(Perms.clcKit);
        pm.addPermission(Perms.clcKitChaka);
        pm.addPermission(Perms.clcKitList);
        pm.addPermission(Perms.clcKitLegeis);
        pm.addPermission(Perms.clcKitStaff);
        pm.addPermission(Perms.clcKitTier1);
        pm.addPermission(Perms.clcKitTier2);
        pm.addPermission(Perms.clcKitTier3);
        pm.addPermission(Perms.clcKitTier4);
        pm.addPermission(Perms.clcKitTier5);
        pm.addPermission(Perms.clcMetaItem);
        pm.addPermission(Perms.clcDie);
        pm.addPermission(Perms.clcStopAnnounce);

        //Commands
        this.getCommand("clc").setExecutor(new CLC(this));
        this.getCommand("hat").setExecutor(new Hat(this));
        this.getCommand("random").setExecutor(new Random(this));
        this.getCommand("kit").setExecutor(new Kit(this));
        this.getCommand("buy").setExecutor(new Buy(this));
        this.getCommand("metaitem").setExecutor(new MetaItem(this));
        this.getCommand("die").setExecutor(new Die(this));
        this.getCommand("titletest").setExecutor(new TitleTest(this));
        this.getCommand("ci").setExecutor(new ClearInv(this));
        this.getCommand("stopannounce").setExecutor(new StopAnnounce(this));

        saveConfig();

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Disabled");
    }
}
