package com.criliscraft.plugin;

import com.criliscraft.plugin.api.mysql.MySQLManager;
import com.criliscraft.plugin.api.perm.PermLib;
import com.criliscraft.plugin.command.HatCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.logging.Level;

public class CriLisCraft extends JavaPlugin {

    private PluginManager pm = this.getServer().getPluginManager();
    public MySQLManager mysql = new MySQLManager(this);

    @Override
    public void onEnable() {

        PermLib.init(this.pm);

        try {
            this.mysql.setupDatabase();
        } catch (SQLException e) {
            this.getLogger().log(Level.SEVERE, "Error while attempting to setup the database.");
            this.getLogger().log(Level.SEVERE, "Error:" + e);
            e.printStackTrace();
        }

        this.getConfig().addDefault("mysql.host", "127.0.0.1");
        this.getConfig().addDefault("mysql.port", "3306");
        this.getConfig().addDefault("mysql.database", "clc_plugin");
        this.getConfig().addDefault("mysql.username", "root");
        this.getConfig().addDefault("mysql.password", "root");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        this.getCommand("hat").setExecutor(new HatCommand(this));

        this.saveDefaultConfig();

        this.getLogger().log(Level.INFO, "Enabled");
    }

    @Override
    public void onDisable() {

        this.saveConfig();

        this.mysql.closeDatabase();

        this.getLogger().log(Level.INFO, "Disabled");
    }
}
