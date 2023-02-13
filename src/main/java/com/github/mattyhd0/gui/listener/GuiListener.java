package com.github.mattyhd0.gui.listener;

import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.InventoryGui;
import com.github.mattyhd0.gui.component.InventoryEventListener;
import com.github.mattyhd0.gui.manager.GUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.function.Consumer;

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

        Consumer<InventoryClickEvent>[] inventoryClickActions = clickComponent.getClickActions().get(clickType);

        if(event.getClickedInventory() == player.getInventory()){
            return;
        }

        for(Consumer<InventoryClickEvent> action: inventoryClickActions){

            if(action == null){
                continue;
            }

            action.accept(event);

        }


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
