package com.criliscraft.plugin.commands.rank;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Color;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.api.pex.Groups;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RankOne implements CommandExecutor {

    private final CriLisCraft plugin;

    public RankOne(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender source, Command cmd, String tstring, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("rankone")) {

            if (length == 1) {

                if (source.hasPermission(Perms.clcRankOne)) {

                    PermissionUser user = PermissionsEx.getUser(args[0]);

                    Bukkit.broadcastMessage(Returns.CHAT_PREFIX + Color.c(3) + args[0] + ", Has just donated for Tier1!");
                    source.sendMessage(Returns.CHAT_PREFIX + Color.c(3) + args[0] + Color.c("a") + ", Has just donated for Tier1.");
                    source.sendMessage(Returns.CHAT_PREFIX + "Checking Users Ranks.");

                    if (user.inGroup(Groups.GUEST)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&6[1Y]&1$&f", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&6[2Y]&1$&f", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Guest.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&1$&f", "");
                        }
                    } else if (user.inGroup(Groups.PEASANT)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Peasant");
                            user.setPrefix("&6[1Y]&1$&6", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Peasant");
                            user.setPrefix("&6[2Y]&1$&6", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Peasant.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Peasant");
                            user.setPrefix("&1$&6", "");
                        }
                    } else if (user.inGroup(Groups.CITIZEN)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Citizen");
                            user.setPrefix("&6[1Y]&1$&a", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Citizen");
                            user.setPrefix("&6[2Y]&1$&a", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Citizen.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Citizen");
                            user.setPrefix("&1$&a", "");
                        }
                    } else if (user.inGroup(Groups.SQUIRE)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Squire.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Squire with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Squire");
                            user.setPrefix("&6[1Y]&1$&2", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Squire with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Squire");
                            user.setPrefix("&6[2Y]&1$&2", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Squire.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Squire");
                            user.setPrefix("&1$&2", "");
                        }
                    } else if (user.inGroup(Groups.KNIGHT)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Knight.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Knight with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Knight");
                            user.setPrefix("&6[1Y]&1$&9", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Knight with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Knight");
                            user.setPrefix("&6[2Y]&1$&9", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Knight.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Knight");
                            user.setPrefix("&1$&9", "");
                        }
                    } else if (user.inGroup(Groups.SIR)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Sir.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Sir with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Sir");
                            user.setPrefix("&6[1Y]&1$&1", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Sir with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Sir");
                            user.setPrefix("&6[2Y]&1$&1", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Sir.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Sir");
                            user.setPrefix("&1$&1", "");
                        }

                    } else if (user.inGroup(Groups.LORD)) {

                        source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Lord.");

                        if (user.inGroup("1Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Lord with 1Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Lord");
                            user.setPrefix("&6[1Y]&1$&5", "");

                        } else if (user.inGroup("2Year")) {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Lord with 2Year.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Lord");
                            user.setPrefix("&6[2Y]&1$&5", "");

                        } else {

                            source.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Lord.");

                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(source, "pex user " + args[0] + " group add Lord");
                            user.setPrefix("&1$&5", "");
                        }
                    }

                    Bukkit.dispatchCommand(source, "pex reload");
                    source.sendMessage(Returns.CHAT_PREFIX + "Users group and prefix updated, Permissions Reloaded.");
                } else {

                    source.sendMessage(Returns.NO_PERMS);
                }
            }
            return true;
        }
        return false;
    }
}
