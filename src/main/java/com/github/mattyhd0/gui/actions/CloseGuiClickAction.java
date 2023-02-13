package com.github.mattyhd0.gui.actions;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class CloseGuiClickAction implements Consumer<InventoryClickEvent> {

    @Override
    public void accept(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        player.closeInventory();
    }

}
