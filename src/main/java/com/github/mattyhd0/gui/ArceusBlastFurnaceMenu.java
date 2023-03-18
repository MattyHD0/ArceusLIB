package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.FurnaceInventory;

public class ArceusBlastFurnaceMenu extends ArceusMenu {

    public ArceusBlastFurnaceMenu(String title) {
        super(title, InventoryType.BARREL);
    }

    @Override
    public FurnaceInventory getInventory() {
        return (FurnaceInventory) super.getInventory();
    }

}
