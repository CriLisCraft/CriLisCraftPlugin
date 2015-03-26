package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rank implements CommandExecutor {

    private final CriLisCraft pl;

    public Rank(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rank") && sender instanceof Player) {
            Player player = (Player) sender;
                
            return true;
        }
        return false;
    }
}