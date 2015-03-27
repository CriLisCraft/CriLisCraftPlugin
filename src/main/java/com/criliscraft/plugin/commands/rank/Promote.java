package com.criliscraft.plugin.commands.rank;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Promote implements CommandExecutor {

    private final CriLisCraft pl;

    public Promote(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("promote") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcRankPromote)) {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex promote " + target);
                player.sendMessage(Info.CHAT_PREFIX + Info.C3 + target.getName() + Info.CA + ", Has been promoted.");
                target.sendMessage(Info.CHAT_PREFIX + Info.C3 + player.getName() + Info.CA + ", Has just personally promoted you.");
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
