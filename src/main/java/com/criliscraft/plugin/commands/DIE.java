package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Die implements CommandExecutor {

    private final CriLisCraft pl;

    public Die(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("die") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcDie)) {
                player.sendRawMessage(player.getName() + " has chosen the easy way out.");
                player.sendMessage(Info.CHAT_PREFIX + "Your on your way on a long journey.  Farewell my friend.");
                player.setHealth(0);
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
