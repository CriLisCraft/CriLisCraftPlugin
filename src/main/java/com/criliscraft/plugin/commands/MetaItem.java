package com.criliscraft.plugin.commands;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import com.criliscraft.plugin.util.Perms;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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
                ItemStack item = new ItemStack(Material.BOW, 0);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Chaka Bow");
                meta.setLore(Arrays.asList("The bow of the great lord Chaka"));
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
                meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 10, true);
                meta.addEnchant(Enchantment.ARROW_FIRE, 8, true);
                meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                meta.addEnchant(Enchantment.DURABILITY, 10, true);
                item.setItemMeta(meta);

                inv.addItem(new ItemStack(item));

                inv.addItem(item);
            } else {
                Info.noPerms(player);
            }
            return true;
        }
        return false;
    }
}
