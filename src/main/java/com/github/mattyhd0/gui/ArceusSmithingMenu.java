package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.SmithingInventory;

public class ArceusSmithingMenu extends ArceusMenu {

    public ArceusSmithingMenu(String title) {
        super(title, InventoryType.SMITHING);
    }

    @Override
    public SmithingInventory getInventory() {
        return (SmithingInventory) super.getInventory();
    }

}
