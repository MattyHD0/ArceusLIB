package com.github.mattyhd0.gui.context;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Set;
import java.util.stream.Collectors;

public class MenuClickContext {

    private InventoryClickEvent event;

    public MenuClickContext(InventoryClickEvent from){
        this.event = from;
    }

    public Player getClicker(){
        return (Player) event.getWhoClicked();
    }

    public ClickType getClickType(){
        return event.getClick();
    }

    public InventoryType.SlotType getSlotType(){
        return event.getSlotType();
    }

    public Inventory getInventory(){
        return event.getInventory();
    }

    public int getSlot(){
        return event.getSlot();
    }

    public ItemStack getCurrentItem(){
        return event.getCurrentItem();
    }

    public ItemStack getCursor(){
        return event.getCursor();
    }

    public int getRawSlot(){
        return event.getRawSlot();
    }

    public int getHotbarButton(){
        return event.getHotbarButton();
    }

    public InventoryView getInventoryView(){
        return event.getView();
    }

    public Set<Player> getInventoryViewers(){
        return event.getViewers()
                .stream()
                .map(human -> (Player) human)
                .collect(Collectors.toSet());
    }

}
