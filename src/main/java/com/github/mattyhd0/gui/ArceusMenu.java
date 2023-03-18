package com.github.mattyhd0.gui;

import com.github.mattyhd0.gui.component.ArceusComponent;
import com.github.mattyhd0.gui.component.ClickComponent;
import com.github.mattyhd0.gui.component.InventoryEventComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArceusMenu implements InventoryHolder {

    private Inventory inventory;
    private List<ArceusComponent> components;

    public ArceusMenu(){
        this.inventory = Bukkit.createInventory(this, 3*9, "Arceus Inventory");
        this.components = new ArrayList<>();
    }

    public ArceusMenu(String title, InventoryType inventoryType){
        this();
        this.inventory = Bukkit.createInventory(this, inventoryType, title);
    }

    public ArceusMenu(String title, int rows){
        this();
        this.inventory = Bukkit.createInventory(this, rows*9, title);
    }

    public void addComponent(ArceusComponent component){
        components.add(component);
    }

    public void addComponents(ArceusComponent... components){
        this.components.addAll(Arrays.asList(components));
    }

    public List<ArceusComponent> getComponents() {
        return components;
    }

    public List<ClickComponent> getClickComponents(){
        return components.stream()
                .filter(ClickComponent.class::isInstance)
                .map(component -> (ClickComponent) component)
                .collect(Collectors.toList());
    }

    public List<ClickComponent> getClickComponents(int slot){
        return components.stream()
                .filter(component -> component instanceof ClickComponent && ((ClickComponent) component).getSlot() == slot)
                .map(component -> (ClickComponent) component)
                .collect(Collectors.toList());
    }

    public List<InventoryEventComponent> getEventComponents(){
        return components.stream()
                .filter(InventoryEventComponent.class::isInstance)
                .map(component -> (InventoryEventComponent) component)
                .collect(Collectors.toList());
    }

    public void fillInventory(ItemStack itemStack){
        for (int i = 0; i < getInventory().getSize(); i++){
            inventory.setItem(i, itemStack);
        }
    }

    public void fillSlots(ItemStack itemStack, int start, int end){
        for (int i = start; i < getInventory().getSize() && i <= end; i++){
            inventory.setItem(i, itemStack);
        }
    }

    public void setSlots(ItemStack itemStack, int[] slots){
        for (int slot: slots){
            if (inventory.getSize() < slot){
                continue;
            }

            getInventory().setItem(slot, itemStack);
        }
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

}
