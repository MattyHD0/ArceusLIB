package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.LecternInventory;

public class ArceusLecternMenu extends ArceusMenu {

    public ArceusLecternMenu(String title) {
        super(title, InventoryType.LECTERN);
    }

    @Override
    public LecternInventory getInventory() {
        return (LecternInventory) super.getInventory();
    }

}
