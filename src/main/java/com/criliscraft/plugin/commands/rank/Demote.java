package com.criliscraft.plugin.commands.rank;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Demote implements CommandExecutor {

    private final CriLisCraft pl;

    public Demote(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("demote") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcRankDemote)) {
                Player target = Bukkit.getServer().getPlayer(args[1]);
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex demote " + target);
                player.sendMessage(Info.CHAT_PREFIX + Info.C3 + target.getName() + Info.CA + ", Has been demoted.");
                target.sendMessage(Info.CHAT_PREFIX + Info.C3 + player.getName() + Info.CA + ", Has just demoted you.  This is a warning! Next time it will be a ban!");
            } else {
                Info.noPerms(player);
            }
        }
        return false;
    }
}
