package com.criliscraft.plugin.util;

import com.criliscraft.plugin.api.Title;
import com.criliscraft.plugin.api.chat.Color;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Info {
    public static final String CHAT_PREFIX = "[" + Color.c(1) + "Cri" + Color.c(5) + "Lis " + Color.c(2) + "Craft" + Color.c("f") + "] " + Color.c("a");
    public static final String NO_PERMS = "[" + ChatColor.DARK_BLUE + "Cri" + ChatColor.DARK_PURPLE + "Lis " + ChatColor.DARK_GREEN + "Craft" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "Oh man, Im feeling sick.  Maybe I shouldn't type that command again...";
    public static final String NO_PERMS_PLACE = "[" + ChatColor.DARK_BLUE + "Cri" + ChatColor.DARK_PURPLE + "Lis " + ChatColor.DARK_GREEN + "Craft" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You do not have permission to place, " + ChatColor.RED;
    public static final String C1 = "" + ChatColor.DARK_BLUE;
    public static final String C2 = "" + ChatColor.DARK_GREEN;
    public static final String C3 = "" + ChatColor.DARK_AQUA;
    public static final String C4 = "" + ChatColor.DARK_RED;
    public static final String C5 = "" + ChatColor.DARK_PURPLE;
    public static final String C6 = "" + ChatColor.GOLD;
    public static final String C7 = "" + ChatColor.GRAY;
    public static final String C8 = "" + ChatColor.DARK_GRAY;
    public static final String C9 = "" + ChatColor.BLUE;
    public static final String C0 = "" + ChatColor.BLACK;
    public static final String CA = "" + ChatColor.GREEN;
    public static final String CB = "" + ChatColor.AQUA;
    public static final String CC = "" + ChatColor.RED;
    public static final String CD = "" + ChatColor.LIGHT_PURPLE;
    public static final String CE = "" + ChatColor.YELLOW;
    public static final String CF = "" + ChatColor.WHITE;
    public static final String CL = "" + ChatColor.BOLD;
    public static final String CK = "" + ChatColor.MAGIC;
    public static final String CO = "" + ChatColor.ITALIC;
    public static final String CN = "" + ChatColor.UNDERLINE;
    public static final String CM = "" + ChatColor.STRIKETHROUGH;
    public static final String CR = "" + ChatColor.RESET;
    public static void noPerms(Player player) {
        Title title = new Title("No Perms!", "so... have some effects >:)");
        title.setTitleColor(ChatColor.DARK_RED);
        title.setSubtitleColor(ChatColor.DARK_RED);
        title.send(player);
        player.sendMessage("sasd");
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 2));
        player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
    }
    public static void deathLocMessage(Player player, int x, int y, int z, String world) {
        player.sendMessage(CHAT_PREFIX + "You have died at, " + C3 + x + CA +  ", " + C3 + y + CA + ", " + C3 + z + CA + ", In world, " + C3 + world + CA + ".");
    }
}
