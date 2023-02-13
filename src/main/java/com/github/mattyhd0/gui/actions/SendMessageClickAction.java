package com.github.mattyhd0.gui.actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class SendMessageClickAction implements Consumer<InventoryClickEvent> {

    private String message;

    public SendMessageClickAction(String message){
        this.message = message;
    }

    @Override
    public void accept(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
