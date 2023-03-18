package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.BeaconInventory;

public class ArceusBeaconMenu extends ArceusMenu {

    public ArceusBeaconMenu(String title) {
        super(title, InventoryType.BARREL);
    }

    @Override
    public BeaconInventory getInventory() {
        return (BeaconInventory) super.getInventory();
    }

}
