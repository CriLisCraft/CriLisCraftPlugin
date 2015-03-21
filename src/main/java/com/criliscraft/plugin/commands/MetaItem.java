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
import org.bukkit.inventory.PlayerInventory;

public class MetaItem implements CommandExecutor {

    private final CriLisCraft pl;

    public MetaItem(CriLisCraft pl) {
        this.pl = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("metaitem") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Perms.clcMetaItem)) {
                PlayerInventory inv = player.getInventory();
                ItemStack item = new ItemStack(Material.APPLE, 1);
                item.getItemMeta().setDisplayName("TESTING");

                inv.addItem(item);
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
