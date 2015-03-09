package com.criliscraft.plugin.gui;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.util.Info;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WellfareGUI implements Listener {
    public WellfareGUI(CriLisCraft pl) {
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }
    public Inventory inv;
    private String invName = ChatColor.DARK_GREEN + "Wellfare";
    public void openGUI(Player player) {
        inv = Bukkit.createInventory(null, 9, invName);
        inv.setItem(5, new ItemStack(Material.EMERALD_BLOCK));
        player.openInventory(inv);
    }
    public void inventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().contains(invName)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            } else if (e.getCurrentItem().getType() == Material.EMERALD_BLOCK) {
                player.sendMessage(Info.CHAT_PREFIX + "Here is your wellfare");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "money give " + player.getName() + " 100");
            }
        }
    }
}
