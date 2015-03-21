package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Random implements CommandExecutor {

    private final CriLisCraft pl;

    public Random(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("random") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcRandom)) {
                Location originalLocation = player.getLocation();
                java.util.Random random = new java.util.Random();
                Location teleportLocation = null;
                int x = random.nextInt(5000) + 1;
                int y = 150;
                int z = random.nextInt(5000) + 1;
                boolean isOnLand = false;
                while (isOnLand == false) {
                    teleportLocation = new Location(player.getWorld(), x, y, z);
                    if (teleportLocation.getBlock().getType() != Material.AIR && teleportLocation.getBlock().getType() != Material.STONE) {
                        isOnLand = true;
                    } else y--;
                    player.teleport(new Location(player.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1, teleportLocation.getZ()));
                    player.sendMessage(Info.CHAT_PREFIX + "You have been teleported " + (int)teleportLocation.distance(originalLocation) + " blocks away!");
                }
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
