package com.criliscraft.plugin.command;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.ChatLib;
import com.criliscraft.plugin.api.perm.PermLib;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EtpCommand implements CommandExecutor {

    private final CriLisCraft plugin;

    public EtpCommand(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("etp")) {
            if (!(source instanceof Player)) {
                return true;
            }
            if (source.hasPermission(PermLib.CMD_ETP)) {
                Player player = (Player) source;
                player.
            } else {
                source.sendMessage(ChatLib.NO_PERMS);
            }
        }
        return false;
    }
}
