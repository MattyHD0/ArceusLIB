package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;

public class ArceusWorkbenchMenu extends ArceusMenu {

    public ArceusWorkbenchMenu(String title) {
        super(title, InventoryType.WORKBENCH);
    }

    @Override
    public CraftingInventory getInventory() {
        return (CraftingInventory) super.getInventory();
    }

}
