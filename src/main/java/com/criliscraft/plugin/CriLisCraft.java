package com.criliscraft.plugin;

import com.criliscraft.plugin.api.perm.PermLib;
import com.criliscraft.plugin.command.HatCommand;
import com.criliscraft.plugin.listener.BlockListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CriLisCraft extends JavaPlugin {

    private PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onEnable() {

        PermLib.init(this.pm);

        new BlockListener(this);

        this.getCommand("hat").setExecutor(new HatCommand(this));

        this.saveDefaultConfig();

        this.getLogger().log(Level.INFO, "Enabled");
    }

    @Override
    public void onDisable() {

        this.saveConfig();

        this.getLogger().log(Level.INFO, "Disabled");
    }
}
