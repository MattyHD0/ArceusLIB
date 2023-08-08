package com.github.mattyhd0.gui.listener.bukkit;

import com.github.mattyhd0.gui.holder.ArceusInventoryHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class PlayerInventoryListener implements Listener {

    private void runArceusEvents(InventoryEvent event){

        Inventory inventory = event.getInventory();
        InventoryHolder inventoryHolder = inventory.getHolder();

        if(!(inventoryHolder instanceof ArceusInventoryHolder)){
            return;
        }

        ArceusInventoryHolder arceusInventoryHolder = (ArceusInventoryHolder) inventoryHolder;

        arceusInventoryHolder.runEvents(event);

    }

    @EventHandler
    public void onInventoryEvent(InventoryEvent event){

        Inventory inventory = event.getInventory();
        InventoryHolder inventoryHolder = inventory.getHolder();

        if(!(inventoryHolder instanceof ArceusInventoryHolder)){
            return;
        }

        ArceusInventoryHolder arceusInventoryHolder = (ArceusInventoryHolder) inventoryHolder;

        arceusInventoryHolder.runEvents(event);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        runArceusEvents(event);
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event){
        runArceusEvents(event);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        runArceusEvents(event);
    }

}
