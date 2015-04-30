package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.api.pex.Groups;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.PermissionsUserData;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Rank implements CommandExecutor {

    private final CriLisCraft plugin;

    public Rank(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        int length = args.length;
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ranktone")) {
            if (player.hasPermission(Perms.clcRankOne)) {

                int online = Bukkit.getOnlinePlayers().size();

                for (Player player1; Bukkit.getOnlinePlayers()) {
                    
                }

                PermissionUser user = PermissionsEx.getUser();

                if (user.inGroup(Groups.GUEST)) {

                    String[] guest = {"Guest", "Tier1"};
                    String[] guest1Y = {"Guest", "Tier1", "1Year"};
                    String[] guest2Y = {"Guest", "Tier1", "2Year"};

                    if (user.inGroup(Groups.YEAR1)) {
                        user.setPrefix("&6[1Y]&1$&f", "");
                        user.setGroups(guest1Y);
                    } else if (user.inGroup(Groups.YEAR2)) {
                        user.setPrefix("&6[2Y]&1$&f", "");
                        user.setGroups(guest2Y);
                    } else {
                        user.setPrefix("&1$&f", "");
                        user.setGroups(guest);
                    }
                } else if (user.inGroup(Groups.PEASANT)) {

                    String[] peasant = {"Peasant", "Tier1"};
                    String[] peasant1Y = {"Peasant", "Tier1", "1Year"};
                    String[] peasant2Y = {"Peasant", "Tier1", "2Year"};

                    if (user.inGroup(Groups.YEAR1)) {
                        user.setPrefix("&6[1Y]&1$&6", "");
                        user.setGroups(peasant1Y);
                    } else if (user.inGroup(Groups.YEAR2)) {
                        user.setPrefix("&6[2Y]&1$&6", "");
                        user.setGroups(peasant2Y);
                    } else {
                        user.setPrefix("&1$&6", "");
                        user.setGroups(peasant);
                    }
                } else if (user.inGroup(Groups.CITIZEN)) {
                    if (user.inGroup(Groups.YEAR1)) {
                        user.removeGroup("1Year");
                        user.removeGroup("Citizen");
                        user.addGroup("Tier1");
                        user.addGroup("1Year");
                        user.addGroup("Citizen");
                        user.setPrefix("&6[1Y]&1$&a", "");
                    } else if (user.inGroup(Groups.YEAR2)) {

                    } else {
                        user.removeGroup("Citizen");
                        user.addGroup("Tier1");
                        user.addGroup("Citizen");
                        user.setPrefix("&1$&a", "");
                    }
                } else if (user.inGroup(Groups.SQUIRE)) {
                    if (user.inGroup(Groups.YEAR1)) {

                    } else if (user.inGroup(Groups.YEAR2)) {

                    } else {

                    }
                } else if (user.inGroup(Groups.KNIGHT)) {
                    if (user.inGroup(Groups.YEAR1)) {

                    } else if (user.inGroup(Groups.YEAR2)) {

                    } else {

                    }
                } else if (user.inGroup(Groups.SIR)) {
                    if (user.inGroup(Groups.YEAR1)) {

                    } else if (user.inGroup(Groups.YEAR2)) {

                    } else {

                    }
                } else if (user.inGroup(Groups.LORD)) {
                    if (user.inGroup(Groups.YEAR1)) {

                    } else if (user.inGroup(Groups.YEAR2)) {

                    } else {

                    }
                }
            } else {
                player.sendMessage(Returns.NO_PERMS);
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("rankttwo")) {

        } else if (cmd.getName().equalsIgnoreCase("ranktthree")) {

        } else if (cmd.getName().equalsIgnoreCase("ranktfour")) {

        } else if (cmd.getName().equalsIgnoreCase("ranktfive")) {

        } else if (cmd.getName().equalsIgnoreCase("rank")) {

        }
        return false;
    }
}
