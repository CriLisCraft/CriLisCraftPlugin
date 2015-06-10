package com.criliscraft.plugin.command;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.api.chat.ChatLib;
import com.criliscraft.plugin.api.perm.PermLib;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatCommand implements CommandExecutor {

    private final CriLisCraft plugin;

    public HatCommand(CriLisCraft plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender source, Command cmd, String alias, String[] args) {

        int length = args.length;

        if (cmd.getName().equalsIgnoreCase("hat")) {
            if (!(source instanceof Player)) {
                return true;
            }
            if (source.hasPermission(PermLib.CMD_HAT)) {
                if (length > 0) {
                    source.sendMessage(ChatLib.CHAT_PREFIX + "Too many arguments.");
                } else {
                    Player player = (Player) source;
                    if (player.getItemInHand().getType() != Material.AIR) {
                        ItemStack itemHand = player.getItemInHand();
                        PlayerInventory inventory = player.getInventory();
                        ItemStack itemHead = inventory.getHelmet();
                        inventory.removeItem(new ItemStack[] { itemHand });
                        inventory.setHelmet(itemHand);
                        inventory.setItemInHand(itemHead);
                        player.sendMessage(ChatLib.CHAT_PREFIX + "Enjoy your new hat.");
                    } else {
                        player.sendMessage(ChatLib.CHAT_PREFIX + "You must be holding the item you want on your head.");
                    }
                }
            } else {
                source.sendMessage(ChatLib.NO_PERMS);
            }
            return true;
        }
        return false;
    }
}
