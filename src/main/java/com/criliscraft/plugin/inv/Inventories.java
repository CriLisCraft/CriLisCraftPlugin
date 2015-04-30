package com.criliscraft.plugin.inv;

import com.criliscraft.plugin.api.chat.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Inventories {

    public static Inventory playerShop = Bukkit.createInventory(null, 27, Color.c(2) + "Player Shop");
    public static Inventory tier1Shop = Bukkit.createInventory(null, 27, Color.c(1) + "Tier1" + " " + Color.c(2) + "Shop");

    static {
        tier1Shop.setItem(0, new ItemStack(Material.FEATHER, 1));
    }
}
