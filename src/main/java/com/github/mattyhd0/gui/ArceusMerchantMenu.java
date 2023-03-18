package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.LoomInventory;
import org.bukkit.inventory.MerchantInventory;

public class ArceusMerchantMenu extends ArceusMenu {

    public ArceusMerchantMenu(String title) {
        super(title, InventoryType.MERCHANT);
    }

    @Override
    public MerchantInventory getInventory() {
        return (MerchantInventory) super.getInventory();
    }

}
