package com.criliscraft.plugin.commands.rank;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.Color;
import com.criliscraft.plugin.api.chat.Returns;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class RankT1 implements CommandExecutor {

    private final CriLisCraft plugin;

    public RankT1(CriLisCraft plugin) {

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        int lengh = args.length;
        if (cmd.getName().equalsIgnoreCase("rankone")) {
            if (lengh == 1) {
                if (sender.hasPermission(Perms.clcRankOne)) {
                    PermissionUser user = PermissionsEx.getUser(args[0]);
                    Bukkit.broadcastMessage(Returns.CHAT_PREFIX + Color.c(3) + args[0] + ", Has just donated for Tier1!");
                    sender.sendMessage(Returns.CHAT_PREFIX + Color.c(3) + args[0] + Color.c("a") + ", Has just donated for Tier1.");
                    sender.sendMessage(Returns.CHAT_PREFIX + "Checking Users Ranks.");
                    if (user.inGroup("Guest")) {
                        sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest.");
                        if (user.inGroup("1Year")) {
                            sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest with 1Year.");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 1Year");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&6[1Y]&1$&f", "");
                        } else if (user.inGroup("2Year")) {
                            sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest with 2Year.");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 2Year");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&6[2Y]&1$&f", "");
                        } else {
                            sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Guest guest.");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                            Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Guest");
                            user.setPrefix("&1$&f", "");
                        }
                    } else if (user.inGroup("Peasant")) {
                        if (user.inGroup("1Year")) {
                            sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant.");
                            if (user.inGroup("1Year")) {
                                sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant with 1Year.");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 1Year");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Peasant");
                                user.setPrefix("&6[1Y]&1$&6", "");
                            } else if (user.inGroup("2Year")) {
                                sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Peasant with 2Year.");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 2Year");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Peasant");
                                user.setPrefix("&6[2Y]&1$&6", "");
                            } else {
                                sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Peasant.");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Peasant");
                                user.setPrefix("&1$&6", "");
                            }
                    } else if (user.inGroup("Citizen")) {
                            if (user.inGroup("1Year")) {
                                sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen.");
                                if (user.inGroup("1Year")) {
                                    sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen with 1Year.");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 1Year");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Citizen");
                                    user.setPrefix("&6[1Y]&1$&a", "");
                                } else if (user.inGroup("2Year")) {
                                    sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a Citizen with 2Year.");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add 2Year");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Citizen");
                                    user.setPrefix("&6[2Y]&1$&a", "");
                                } else {
                                    sender.sendMessage(Color.c(3) + args[0] + Color.c("a") + ", Is a plain Citizen.");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group set Tier1");
                                    Bukkit.dispatchCommand(sender, "pex user " + args[0] + " group add Citizen");
                                    user.setPrefix("&1$&a", "");
                                }
                            }
                    } else if (user.inGroup("Squire")) {

                        if (user.inGroup("1Year")) {

                            user.removeGroup("Squire");
                            user.removeGroup("1Year");

                            user.addGroup("Tier1");
                            user.addGroup("1Year");
                            user.addGroup("Squire");

                            user.setPrefix("&6[1Y]&1$&2", "");

                        } else if (user.inGroup("2Year")) {

                            user.removeGroup("Squire");
                            user.removeGroup("2Year");

                            user.addGroup("Tier1");
                            user.addGroup("2Year");
                            user.addGroup("Squire");

                            user.setPrefix("&6[2Y]&1$&2", "");
                        } else {

                            user.removeGroup("Squire");

                            user.addGroup("Tier1");
                            user.addGroup("Squire");

                            user.setPrefix("&1$&2", "");
                        }

                    } else if (user.inGroup("Knight")) {

                        if (user.inGroup("1Year")) {

                            user.removeGroup("Knight");
                            user.removeGroup("1Year");

                            user.addGroup("Tier1");
                            user.addGroup("1Year");
                            user.addGroup("Knight");

                            user.setPrefix("&6[1Y]&1$&9", "");

                        } else if (user.inGroup("2Year")) {

                            user.removeGroup("Knight");
                            user.removeGroup("2Year");

                            user.addGroup("Tier1");
                            user.addGroup("2Year");
                            user.addGroup("Knight");

                            user.setPrefix("&6[2Y]&1$&9", "");
                        } else {

                            user.removeGroup("Knight");

                            user.addGroup("Tier1");
                            user.addGroup("Knight");

                            user.setPrefix("&1$&9", "");
                        }

                    } else if (user.inGroup("Sir")) {

                        if (user.inGroup("1Year")) {

                            user.removeGroup("Sir");
                            user.removeGroup("1Year");

                            user.addGroup("Tier1");
                            user.addGroup("1Year");
                            user.addGroup("Sir");

                            user.setPrefix("&6[1Y]&1$", "");

                        } else if (user.inGroup("2Year")) {

                            user.removeGroup("Sir");
                            user.removeGroup("2Year");

                            user.addGroup("Tier1");
                            user.addGroup("2Year");
                            user.addGroup("Sir");

                            user.setPrefix("&6[2Y]&1$", "");
                        } else {

                            user.removeGroup("Sir");

                            user.addGroup("Tier1");
                            user.addGroup("Sir");

                            user.setPrefix("&1$", "");
                        }

                    } else if (user.inGroup("Lord")) {

                        if (user.inGroup("1Year")) {

                            user.removeGroup("Lord");
                            user.removeGroup("1Year");

                            user.addGroup("Tier1");
                            user.addGroup("1Year");
                            user.addGroup("Lord");

                            user.setPrefix("&6[1Y]&1$&5", "");

                        } else if (user.inGroup("2Year")) {

                            user.removeGroup("Lord");
                            user.removeGroup("2Year");

                            user.addGroup("Tier1");
                            user.addGroup("2Year");
                            user.addGroup("Lord");

                            user.setPrefix("&6[2Y]&1$&5", "");
                        } else {

                            user.removeGroup("Lord");

                            user.addGroup("Tier1");
                            user.addGroup("Lord");

                            user.setPrefix("&1$&5", "");
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
