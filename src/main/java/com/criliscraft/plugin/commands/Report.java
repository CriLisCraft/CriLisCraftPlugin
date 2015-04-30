package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.api.sql.MySQLAPI;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Report implements CommandExecutor {

    private final CriLisCraft pl;

    public Report(CriLisCraft pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {



        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("report") && sender instanceof Player) {
            Player player = (Player) sender;
            //TODO take coords and time

            int[] location = {0,0,0};
            String locationWorld = "Varden";
            long time = 0;

            if (length == 1 && args[0].equalsIgnoreCase("grief")) {

                if (player.hasPermission(Perms.clcReport)) {

                    location[0] = player.getLocation().getBlockX();
                    location[1] = player.getLocation().getBlockY();
                    location[3] = player.getLocation().getBlockZ();
                    locationWorld = player.getLocation().getWorld().getName();

                    time = System.currentTimeMillis();


                } else {
                    player.sendMessage(Returns.NO_PERMS);
                }
            } else if (length == 1 && args[0].equalsIgnoreCase("stealing")) {

            } else {

            }
        }
        return false;
    }
}
