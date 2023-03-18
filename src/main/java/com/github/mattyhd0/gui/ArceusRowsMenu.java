package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;

public class ArceusRowsMenu extends ArceusMenu {

    public ArceusRowsMenu(String title, int rows) {
        super(title, InventoryType.WORKBENCH);
    }

    @Override
    public CraftingInventory getInventory() {
        return (CraftingInventory) super.getInventory();
    }

}
