package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.LoomInventory;

public class ArceusLoomMenu extends ArceusMenu {

    public ArceusLoomMenu(String title) {
        super(title, InventoryType.LOOM);
    }

    @Override
    public LoomInventory getInventory() {
        return (LoomInventory) super.getInventory();
    }

}
