package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import com.criliscraft.plugin.api.Title;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TitleTest implements CommandExecutor {

    private final CriLisCraft pl;

    public TitleTest(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("titletest") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcTitleTest)) {
                player.sendMessage(Info.CHAT_PREFIX + "Testing A Title :D");

                Title title = new Title("Hello, " + player.getName());
                title.setTitleColor(ChatColor.DARK_AQUA);
                title.send(player);
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
