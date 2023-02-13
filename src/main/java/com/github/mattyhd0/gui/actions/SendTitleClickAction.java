package com.github.mattyhd0.gui.actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class SendTitleClickAction implements Consumer<InventoryClickEvent> {

    private String title;
    private String subtitle;

    public SendTitleClickAction(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public void accept(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        player.sendTitle(
                ChatColor.translateAlternateColorCodes('&', title),
                ChatColor.translateAlternateColorCodes('&', subtitle)
                );
    }

}
