package com.criliscraft.plugin.inv;

import com.criliscraft.plugin.api.chat.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DonationInv {

    public static Inventory inv = Bukkit.createInventory(null, 9, Color.c(2) + "Donation Shop");

    static {
        inv.setItem(0, new ItemStack(Material.FEATHER, 1));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (inventory.getName().equals(inv.getName())) {
            if (clicked.getType() == Material.FEATHER) {
                event.setCancelled(true);
                player.closeInventory();
                player.getInventory().addItem(new ItemStack(Material.FEATHER));
            }
        }
    }
}
