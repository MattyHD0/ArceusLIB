package com.github.mattyhd0.gui.component;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public interface IInventoryEvent {

    void onOpen(InventoryOpenEvent event);

    void onClick(InventoryClickEvent event);

    void onClose(InventoryCloseEvent event);

}
