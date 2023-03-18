package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CartographyInventory;
import org.bukkit.inventory.Inventory;

public class ArceusCartographyMenu extends ArceusMenu {

    public ArceusCartographyMenu(String title) {
        super(title, InventoryType.CARTOGRAPHY);
    }

    @Override
    public CartographyInventory getInventory() {
        return (CartographyInventory) super.getInventory();
    }

}
