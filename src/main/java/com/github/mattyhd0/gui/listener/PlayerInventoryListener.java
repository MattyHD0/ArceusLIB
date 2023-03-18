package com.github.mattyhd0.gui.listener;

import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.ArceusMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.List;
import java.util.function.Consumer;

public class PlayerInventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        if (event.getClickedInventory() == null){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();

        if (!(inventory.getHolder() instanceof ArceusMenu)){
               return;
        }

        ArceusMenu arceusMenu = (ArceusMenu) inventory.getHolder();

        ClickType clickType = event.getClick();

        arceusMenu.getEventComponents().forEach(eventComponent -> {

            Consumer<InventoryClickEvent> eventConsumer = eventComponent.getConsumers(InventoryClickEvent.class);
            if(eventConsumer != null){
                eventConsumer.accept(event);
            }

        });


        List<ClickComponent> clickComponents = arceusMenu.getClickComponents(event.getSlot());

        /*if(clickComponents == null){
            return;
        }*/

        if(event.getClickedInventory() == player.getInventory()){
            return;
        }

        for (ClickComponent component: clickComponents){
            Consumer<InventoryClickEvent> consumer = component.getClickActions().get(clickType);
            if(consumer != null){
                consumer.accept(event);
            }
        }

    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event){

        Inventory inventory = event.getInventory();
        InventoryHolder inventoryHolder = inventory.getHolder();

        if(!(inventoryHolder instanceof ArceusMenu)){
            return;
        }

        ArceusMenu arceusMenu = (ArceusMenu) inventoryHolder;


        arceusMenu.getEventComponents().forEach(eventComponent -> {

            Consumer<InventoryOpenEvent> eventConsumer = eventComponent.getConsumers(InventoryOpenEvent.class);
            if(eventConsumer != null){
                eventConsumer.accept(event);
            }

        });

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){

        Inventory inventory = event.getInventory();
        InventoryHolder inventoryHolder = inventory.getHolder();

        if(!(inventoryHolder instanceof ArceusMenu)){
            return;
        }

        ArceusMenu arceusMenu = (ArceusMenu) inventoryHolder;


        arceusMenu.getEventComponents().forEach(eventComponent -> {

            Consumer<InventoryCloseEvent> eventConsumer = eventComponent.getConsumers(InventoryCloseEvent.class);
            if(eventConsumer != null){
                eventConsumer.accept(event);
            }

        });

    }

}
