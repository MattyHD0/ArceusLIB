package com.github.mattyhd0.gui;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.GrindstoneInventory;

public class ArceusGrindstoneMenu extends ArceusMenu {

    public ArceusGrindstoneMenu(String title) {
        super(title, InventoryType.GRINDSTONE);
    }

    @Override
    public GrindstoneInventory getInventory(){
        return (GrindstoneInventory) super.getInventory();
    }

}
