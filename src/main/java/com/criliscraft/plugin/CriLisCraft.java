package com.criliscraft.plugin;

import com.criliscraft.plugin.commands.*;
import com.criliscraft.plugin.commands.rank.RankOne;
import com.criliscraft.plugin.listeners.BlockListener;
import com.criliscraft.plugin.listeners.PlayerListener;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;

public class CriLisCraft extends JavaPlugin {

    boolean clcCommand = this.getConfig().getBoolean("clcCommand");
    boolean hatCommand = this.getConfig().getBoolean("hatCommand");
    boolean kitCommand = this.getConfig().getBoolean("kitCommand");
    boolean dieCommand = this.getConfig().getBoolean("dieCommand");
    boolean stats = this.getConfig().getBoolean("stats");
    boolean debug = this.getConfig().getBoolean("debug");
    boolean playerListener = this.getConfig().getBoolean("playerListener");
    boolean blockListener = this.getConfig().getBoolean("blockListener");
    boolean mysql = this.getConfig().getBoolean("mysql");
    String mysqlHost = this.getConfig().getString("mysql-host");
    String mysqlPort = this.getConfig().getString("mysql-port");
    String mysqlDatabase = this.getConfig().getString("mysql-database");
    String mysqlUser = this.getConfig().getString("mysql-user");
    String mysqlPass = this.getConfig().getString("mysql-pass");
    Plugin plugin;

    /**public MySQL mySQL = new MySQL(plugin, mysqlHost, mysqlPort, mysqlDatabase, mysqlUser, mysqlPass);
    public Connection c = null;**/

    @Override
    public void onEnable() {

        /**this.getConfig().addDefault("clcCommand", true);
        this.getConfig().addDefault("hatCommand", true);
        this.getConfig().addDefault("kitCommand", true);
        this.getConfig().addDefault("dieCommand", true);
        this.getConfig().addDefault("stats", true);
        this.getConfig().addDefault("debug", false);
        this.getConfig().addDefault("playerListener", true);
        this.getConfig().addDefault("blockListener", true);
        this.getConfig().addDefault("mysql", true);
        this.getConfig().addDefault("mysql-host", "localhost");
        this.getConfig().addDefault("mysql-port", "3306");
        this.getConfig().addDefault("mysql-database", "clcpl");
        this.getConfig().addDefault("mysql-user", "minecraft");
        this.getConfig().addDefault("mysql-pass", "minecraft");
        this.getConfig().options().copyDefaults(true);
        saveConfig();**/

        if (stats == true) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                if (debug == true) {
                    getLogger().info("Metrics Loaded.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().severe("Failed To Submit Metrics");
                if (debug == true) {
                    getLogger().info("Metrics failed to start.");
                }
            }
        }

        if (playerListener == true) {
            new PlayerListener(this);
        }
        if (blockListener == true) {
            new BlockListener(this);
        }
        if (debug == true) {
            getLogger().info("Listeners Registered");
        }

        PluginManager pm = getServer().getPluginManager();
        Perms.init(pm);
        if (debug == true) {
            getLogger().info("Permissions Registered");
        }

        //Commands
        if (clcCommand == true) {
            this.getCommand("clc").setExecutor(new CLC(this));
        }
        if (hatCommand == true) {
            this.getCommand("hat").setExecutor(new Hat(this));
        }
        if (kitCommand == true) {
            this.getCommand("kit").setExecutor(new Kit(this));
        }
        if (dieCommand == true) {
            this.getCommand("die").setExecutor(new Die(this));
        }
        this.getCommand("rankone").setExecutor(new RankOne(this));
        if (debug == true) {
            getLogger().info("Commands Registered");
        }

        saveConfig();

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("Disabled");
    }
}
