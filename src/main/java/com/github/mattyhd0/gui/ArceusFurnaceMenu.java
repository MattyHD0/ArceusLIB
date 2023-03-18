package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Inventory;

public class ArceusFurnaceMenu extends ArceusMenu {

    public ArceusFurnaceMenu(String title) {
        super(title, InventoryType.FURNACE);
    }

    @Override
    public FurnaceInventory getInventory() {
        return (FurnaceInventory) super.getInventory();
    }

}
