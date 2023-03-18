package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.BrewerInventory;

public class ArceusBrewingStandMenu extends ArceusMenu {

    public ArceusBrewingStandMenu(String title) {
        super(title, InventoryType.BARREL);
    }

    @Override
    public BrewerInventory getInventory() {
        return (BrewerInventory) super.getInventory();
    }

}
