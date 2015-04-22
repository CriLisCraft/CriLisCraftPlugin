package com.criliscraft.plugin.util;

import org.bukkit.Bukkit;
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
    }
    static public Permission clcHat = new Permission("clc.cmd.hat");
    static public Permission clcPlaceTnt = new Permission("clc.place.tnt");
    static public Permission clcReload = new Permission("clc.cmd.reload");
    static public Permission clcHelp = new Permission("clc.cmd.help");
    static public Permission clcDie = new Permission("clc.cmd.die");

    //Kits
    static public Permission clcKit = new Permission("clc.cmd.kit");
    static public Permission clcKitList = new Permission("clc.kit.list");
    static public Permission clcKitStaff = new Permission("clc.kit.staff");
    static public Permission clcKitChaka = new Permission("clc.kit.chaka");
    static public Permission clcKitLegeis = new Permission("clc.kit.legeis");
}
