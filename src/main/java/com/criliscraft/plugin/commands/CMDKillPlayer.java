package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDKillPlayer implements CommandExecutor {
    private final CriLisCraft pl;
    public CMDKillPlayer(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clc-kill") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("clc.cmd.kill")) {
                player.setHealth(0.0);
            } else {
                player.sendMessage(Info.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
