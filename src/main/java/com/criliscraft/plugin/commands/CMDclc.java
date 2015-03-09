package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDCLC implements CommandExecutor {

    private final CriLisCraft pl;

    public CMDCLC(CriLisCraft pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("clc") && sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(Info.CHAT_PREFIX + "Use /clc-help for a list of commands!");
            return true;
        }
        return false;
    }
}
