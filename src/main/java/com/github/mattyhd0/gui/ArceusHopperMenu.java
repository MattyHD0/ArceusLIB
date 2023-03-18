package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class ArceusHopperMenu extends ArceusMenu {

    public ArceusHopperMenu(String title) {
        super(title, InventoryType.HOPPER);
    }

    @Override
    public Inventory getInventory() {
        return (Inventory) super.getInventory();
    }

}
