package com.github.mattyhd0.gui.listener.arceus;

import com.github.mattyhd0.gui.component.arceus.DisplayItem;
import com.github.mattyhd0.gui.holder.ArceusInventoryHolder;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.function.Consumer;

public class ArceusPopulateInventoryListener implements Consumer<InventoryOpenEvent> {

    @Override
    public void accept(InventoryOpenEvent event) {

        Inventory inventory = event.getInventory();

        ArceusInventoryHolder arceusInventoryHolder = (ArceusInventoryHolder) event.getInventory().getHolder();

        for (int i = 0; i < inventory.getSize(); i++){
            DisplayItem button = arceusInventoryHolder.<DisplayItem>getComponents(i);
            inventory.setItem(i, button.getItemStack());
        }


    }
}
