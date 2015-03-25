package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Buy implements CommandExecutor {

    private final CriLisCraft pl;

    public Buy(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("buy") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcBuy)) {
                player.sendMessage(Info.CHAT_PREFIX + "Our donation shop is under construction.");
                player.sendMessage(Info.CHAT_PREFIX + "Please feel free to visit our website for more info.");
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
