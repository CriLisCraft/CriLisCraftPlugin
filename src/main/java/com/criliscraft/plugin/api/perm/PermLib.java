package com.criliscraft.plugin.api.perm;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

public class PermLib {

    public static void init(PluginManager pm) {
        pm.addPermission(CMD_HAT);
        pm.addPermission(CMD_ETP);
        pm.addPermission(CMD_ATP);
        pm.addPermission(PLACE_SIGN);
        pm.addPermission(PLACE_TNT);
    }

    public static Permission CMD_HAT = new Permission("clc.cmd.hat");
    public static Permission CMD_ETP = new Permission("clc.cmd.etp");
    public static Permission CMD_ATP = new Permission("clc.cmd.atp");
    public static Permission PLACE_SIGN = new Permission("clc.place.sign");
    public static Permission PLACE_TNT = new Permission("clc.place.tnt");
}
