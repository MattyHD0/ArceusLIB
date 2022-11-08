package com.mattyhd0.gui.listener;

import com.mattyhd0.gui.component.ClickComponent;
import com.mattyhd0.gui.InventoryGui;
import com.mattyhd0.gui.component.action.IInventoryClickAction;
import com.mattyhd0.gui.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GuiListener implements Listener {

    private GUIManager guiManager;

    public GuiListener(GUIManager guiManager){
        this.guiManager = guiManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        if (event.getClickedInventory() == null){
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if (!guiManager.getInventoryGuiHashMap().containsKey(player.getUniqueId())){
               return;
        }

        ClickType clickType = event.getClick();
        InventoryGui inventoryGui = guiManager.getInventoryGuiHashMap().get(player.getUniqueId());

        inventoryGui.getInventoryEvents().forEach(inventoryEvent -> {
            inventoryEvent.onClick(event);
        });

        if(event.getClickedInventory() == event.getInventory() && inventoryGui.isCancelGuiClick()){
            event.setCancelled(true);
        }

        if(event.getClickedInventory() == player.getInventory() && inventoryGui.isCancelInventoryClick()){
            event.setCancelled(true);
        }

        ClickComponent clickComponent = inventoryGui.getClickComponent(event.getSlot());

        if(clickComponent == null){
            return;
        }

        IInventoryClickAction inventoryClickAction = clickComponent.getInventoryClickActionHashMap().get(clickType);

        if(inventoryClickAction == null){
            return;
        }

        if(event.getClickedInventory() == player.getInventory()){
            return;
        }

        inventoryClickAction.onClick(event);


    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event){
        Player player = (Player) event.getPlayer();
        InventoryGui inventoryGui = guiManager.getInventoryGuiHashMap().get(player.getUniqueId());

        if(inventoryGui == null){
            return;
        }

        inventoryGui.getInventoryEvents().forEach(inventoryEvent -> {
            inventoryEvent.onOpen(event);
        });

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        InventoryGui inventoryGui = guiManager.getInventoryGuiHashMap().get(player.getUniqueId());

        if(inventoryGui == null){
            return;
        }

        inventoryGui.getInventoryEvents().forEach(inventoryEvent -> {
            inventoryEvent.onClose(event);
        });

        guiManager.getInventoryGuiHashMap().remove(player.getUniqueId());
    }

}
