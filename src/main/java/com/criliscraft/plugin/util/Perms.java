package com.criliscraft.plugin.util;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class Perms {

    public static void init(PluginManager pm) {

        pm.addPermission(clcHat);
        pm.addPermission(clcPlaceTnt);
        pm.addPermission(clcReload);
        pm.addPermission(clcHelp);
        pm.addPermission(clcDie);
        pm.addPermission(clcKit);
        pm.addPermission(clcKitList);
        pm.addPermission(clcKitStaff);
        pm.addPermission(clcKitChaka);
        pm.addPermission(clcKitLegeis);
        pm.addPermission(clcReport);
        pm.addPermission(clcReportMod);
        pm.addPermission(clcKitLegeis);
    }
    static public Permission clcHat = new Permission("clc.cmd.hat");
    static public Permission clcPlaceTnt = new Permission("clc.place.tnt");
    static public Permission clcReload = new Permission("clc.cmd.reload");
    static public Permission clcHelp = new Permission("clc.cmd.help");
    static public Permission clcDie = new Permission("clc.cmd.die");

    static public Permission clcReport = new Permission("clc.cmd.report");
    static public Permission clcReportMod = new Permission("clc.cmd.report.mod");

    static public Permission clcRank = new Permission("clc.cmd.rank");
    static public Permission clcRankOne = new Permission("clc.cmd.rank.one");
    static public Permission clcRankTwo = new Permission("clc.cmd.rank.two");
    static public Permission clcRankThree = new Permission("clc.cmd.rank.three");
    static public Permission clcRankFour = new Permission("clc.cmd.rank.four");
    static public Permission clcRankFive = new Permission("clc.cmd.rank.five");

    //Kits
    static public Permission clcKit = new Permission("clc.cmd.kit");
    static public Permission clcKitList = new Permission("clc.kit.list");
    static public Permission clcKitStaff = new Permission("clc.kit.staff");
    static public Permission clcKitChaka = new Permission("clc.kit.chaka");
    static public Permission clcKitLegeis = new Permission("clc.kit.legeis");
    static public Permission clcKitEquip = new Permission("clc.kit.equip");
}
