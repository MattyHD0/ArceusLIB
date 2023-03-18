package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.SmithingInventory;

public class ArceusSmokerMenu extends ArceusMenu {

    public ArceusSmokerMenu(String title) {
        super(title, InventoryType.SMOKER);
    }

    @Override
    public FurnaceInventory getInventory() {
        return (FurnaceInventory) super.getInventory();
    }

}
