package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;

public class ArceusAnvilMenu extends ArceusMenu {

    public ArceusAnvilMenu(String title) {
        super(title, InventoryType.ANVIL);
    }

    @Override
    public AnvilInventory getInventory() {
        return (AnvilInventory) super.getInventory();
    }

}
