package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.Inventory;

public class ArceusEnchantingMenu extends ArceusMenu {

    public ArceusEnchantingMenu(String title) {
        super(title, InventoryType.ENCHANTING);
    }

    @Override
    public EnchantingInventory getInventory() {
        return (EnchantingInventory) super.getInventory();
    }

}
