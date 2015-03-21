package com.criliscraft.plugin.util;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Info {
    public static final String CHAT_PREFIX = "[" + ChatColor.DARK_BLUE + "Cri" + ChatColor.DARK_PURPLE + "Lis " + ChatColor.DARK_GREEN + "Craft" + ChatColor.WHITE + "] " + ChatColor.GREEN;
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
    public static final String CA = "" + ChatColor.GREEN;
    public static final String CD = "" + ChatColor.LIGHT_PURPLE;
    public static final String CF = "" + ChatColor.WHITE;
    public static final String CL = "" + ChatColor.BOLD;
    public static final String CK = "" + ChatColor.MAGIC;
    public static final String CO = "" + ChatColor.ITALIC;
    public static final String CN = "" + ChatColor.UNDERLINE;
    public static final String CM = "" + ChatColor.STRIKETHROUGH;
    public static final String CR = "" + ChatColor.RESET;
    public static void noPerms(Player player) {
        player.sendMessage(Info.NO_PERMS);
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
        player.playSound(player.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
    }
}
