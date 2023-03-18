package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.PlayerInventory;

public class ArceusPlayerMenu extends ArceusMenu {

    public ArceusPlayerMenu(String title) {
        super(title, InventoryType.PLAYER);
    }

    @Override
    public PlayerInventory getInventory() {
        return (PlayerInventory) super.getInventory();
    }

}
