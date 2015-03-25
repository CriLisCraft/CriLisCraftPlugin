package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.Title;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopAnnounce implements CommandExecutor {

    private final CriLisCraft plugin;

    public StopAnnounce(CriLisCraft plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("stopannounce")) {
            Title title = new Title("Server Shutting Down, In", "30 Seconds");
            title.setTitleColor(ChatColor.DARK_RED);
            title.setSubtitleColor(ChatColor.RED);
            title.broadcast();
            return true;
        }
        return false;
    }
}
