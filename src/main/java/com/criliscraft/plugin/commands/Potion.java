package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Potion implements CommandExecutor {

    private final CriLisCraft plugin;

    public Potion(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("potion")) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcPotion)) {
                ItemStack p1 = new ItemStack(Material.POTION);
                ItemMeta m1 = p1.getItemMeta();
                m1.setDisplayName("I AM A GOD!");
                m1.setLore(Arrays.asList("Words"));

            } else {
                Info.noPerms(player);
            }
        }
        return false;
    }
}
