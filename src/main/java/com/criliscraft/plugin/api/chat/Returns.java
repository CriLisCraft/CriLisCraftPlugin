package com.criliscraft.plugin.api.chat;

import org.bukkit.entity.Player;

public class Returns {
    public static final String CHAT_PREFIX = "[" + Color.c(1) + "CriLis" + Color.c(2) + " Craft" + Color.f("r") + "] " + Color.c("a");
    public static final String NO_PERMS = CHAT_PREFIX + Color.c(5) + "You have not learned that spell yet!";
    public static final String NO_PERMS_PLACE = CHAT_PREFIX + Color.c(4) + "You do not have permission to use " + Color.c("c");

    public static void deathLocMessage(Player player, int x, int y, int z, String world) {
        player.sendMessage(CHAT_PREFIX + "You have died at, " + Color.c(3) + x + Color.c("a") +  ", " + Color.c(3) + y + Color.c("a") + ", " + Color.c(3) + z + Color.c("a") + ", In world, " + Color.c(3) + world + Color.c("a") + ".");
    }
}
