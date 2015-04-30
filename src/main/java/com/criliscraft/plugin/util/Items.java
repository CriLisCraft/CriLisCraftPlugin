package com.criliscraft.plugin.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Items {

    public static ItemStack chakaSword() {

        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("Chaka Sword");
        meta.setLore(Arrays.asList("Feel the sharp sword slice thru your body."));
        meta.setLore(Arrays.asList("This is the mighty sword of Lord Chaka"));
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 8, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 6, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 7, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.setItemMeta(meta);

        return item;
    }
}
