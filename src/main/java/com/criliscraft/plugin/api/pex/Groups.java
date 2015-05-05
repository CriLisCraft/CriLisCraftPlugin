package com.criliscraft.plugin.api.pex;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Groups {

    //Default Groups
    public static final String GUEST = "Guest";
    public static final String PEASANT = "Peasant";
    public static final String CITIZEN = "Citizen";
    public static final String SQUIRE = "Squire";
    public static final String KNIGHT = "Knight";
    public static final String SIR = "Sir";
    public static final String LORD = "Lord";

    //Donation Groups
    public static final String TIER1 = "Tier1";
    public static final String TIER2 = "Tier2";
    public static final String TIER3 = "Tier3";
    public static final String TIER4 = "Tier4";
    public static final String TIER5 = "Tier5";
    public static final String SUPPORTER = "Supporter";

    //Special Groups
    public static final String ADULT_CHAT_USER = "AdultChatUser";
    public static final String YEAR1 = "1Year";
    public static final String YEAR2 = "2Year";

    //Staff Groups
    public static final String MODERATOR = "Moderator";
    public static final String CRILIS_MOD = "CriLisMod";
    public static final String LIMITED_ADMIN  = "LimitedAdmin";
    public static final String ADMIN = "Admin";

    private static void setRank(CommandSender source, String name, String group) {
        Bukkit.dispatchCommand(source, "pex user " + name + " group set " + group);
    }

    private static void setRank(CommandSender source, String name, String group, int time) {
        Bukkit.dispatchCommand(source, "pex user " + name + " group set " + group + " \"\" " + time);
    }
}
