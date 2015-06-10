package com.criliscraft.plugin.api.perm;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CMD_HAT);
    }

    public static Permission CMD_HAT = new Permission("clc.cmd.hat");
}
