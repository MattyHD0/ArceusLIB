package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;

public class ArceusCraftingMenu extends ArceusMenu {

    public ArceusCraftingMenu(String title) {
        super(title, InventoryType.CRAFTING);
    }

    @Override
    public CraftingInventory getInventory() {
        return (CraftingInventory) super.getInventory();
    }

}
