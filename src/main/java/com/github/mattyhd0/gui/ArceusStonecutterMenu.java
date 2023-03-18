package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.StonecutterInventory;

public class ArceusStonecutterMenu extends ArceusMenu {

    public ArceusStonecutterMenu(String title) {
        super(title, InventoryType.STONECUTTER);
    }

    @Override
    public StonecutterInventory getInventory() {
        return (StonecutterInventory) super.getInventory();
    }

}
