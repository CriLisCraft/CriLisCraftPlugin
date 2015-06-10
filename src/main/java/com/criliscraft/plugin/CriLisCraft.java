package com.criliscraft.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CriLisCraft extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getLogger().log(Level.INFO, "Enabled");
    }

    @Override
    public void onDisable() {

        this.getLogger().log(Level.INFO, "Disabled");
    }
}
