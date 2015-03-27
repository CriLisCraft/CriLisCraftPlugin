package com.criliscraft.plugin.commands.rank;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Set implements CommandExecutor {

    private final CriLisCraft pl;

    public Set(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("set") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcRankSet)) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target + " group set " + args[1]);
                player.sendMessage(Info.CHAT_PREFIX + Info.C3 + target.getName() + Info.CA + ", Has been set to, " + Info.C3 + args[1] + Info.CA + ".");
                target.sendMessage(Info.CHAT_PREFIX + Info.C3 + player.getName() + Info.CA + ", Ypu have been set to, " + Info.C3 + args[1] + Info.CA + ".");
            } else {
                Info.noPerms(player);
            }
        }
        return false;
    }
}
