package com.criliscraft.plugin.api.pex;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionsGroupData;

public class Groups {

    private static PermissionsGroupData data;
    private static PermissionManager permManager;

    //Default Groups
    public static final PermissionGroup GUEST = new PermissionGroup("Guest", data, permManager);
    public static final PermissionGroup PEASANT = new PermissionGroup("Peasant", data, permManager);
    public static final PermissionGroup CITIZEN = new PermissionGroup("Citizen", data, permManager);
    public static final PermissionGroup SQUIRE = new PermissionGroup("Squire", data, permManager);
    public static final PermissionGroup KNIGHT = new PermissionGroup("Knight", data, permManager);
    public static final PermissionGroup SIR = new PermissionGroup("Sir", data, permManager);
    public static final PermissionGroup LORD = new PermissionGroup("Lord", data, permManager);

    //Donation Groups
    public static final PermissionGroup TIER1 = new PermissionGroup("Tier1", data, permManager);
    public static final PermissionGroup TIER2 = new PermissionGroup("Tier2", data, permManager);
    public static final PermissionGroup TIER3 = new PermissionGroup("Tier3", data, permManager);
    public static final PermissionGroup TIER4 = new PermissionGroup("Tier4", data, permManager);
    public static final PermissionGroup TIER5 = new PermissionGroup("Tier5", data, permManager);
    public static final PermissionGroup SUPPORTER = new PermissionGroup("Supporter", data, permManager);

    //Special Groups
    public static final PermissionGroup ADULT_CHAT_USER = new PermissionGroup("AdultChatUser", data, permManager);
    public static final PermissionGroup YEAR1 = new PermissionGroup("1Year", data, permManager);
    public static final PermissionGroup YEAR2 = new PermissionGroup("2Year", data, permManager);

    //Staff Groups
    public static final PermissionGroup MODERATOR = new PermissionGroup("Moderator", data, permManager);
    public static final PermissionGroup CRILIS_MOD = new PermissionGroup("CriLisMod", data, permManager);
    public static final PermissionGroup LIMITED_ADMIN  = new PermissionGroup("LimitedAdmin", data, permManager);
    public static final PermissionGroup ADMIN = new PermissionGroup("ADMIN", data, permManager);
}
