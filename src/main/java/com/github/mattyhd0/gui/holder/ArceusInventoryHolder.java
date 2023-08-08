package com.github.mattyhd0.gui.holder;

import com.github.mattyhd0.gui.component.api.ClickableComponent;
import com.github.mattyhd0.gui.component.api.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.PlayerInventory;

import java.util.*;
import java.util.function.Consumer;

public abstract class ArceusInventoryHolder implements InventoryHolder {

    protected final Inventory inventory;
    protected final HashMap<Class<? extends InventoryEvent>, List<Consumer<InventoryEvent>>> eventListeners;
    protected final HashMap<Integer, Component> components;

    protected ArceusInventoryHolder(
            String title,
            int rows,
            InventoryType inventoryType,
            HashMap<Integer, Component> components,
            HashMap<
                    Class<? extends InventoryEvent>,
                    List<Consumer<InventoryEvent>>
                    > eventListeners
    ){
        this.eventListeners = eventListeners;
        this.components = components;

        if(inventoryType == null){
            this.inventory = Bukkit.createInventory(this, rows*9, title);
        } else {
            this.inventory = Bukkit.createInventory(this, inventoryType, title);
        }

        registerEventListener(InventoryOpenEvent.class, event -> {
            draw();
        });

        registerEventListener(InventoryClickEvent.class, event -> {

            if(event.getClickedInventory() instanceof PlayerInventory){
                return;
            }

            int slot = event.getSlot();

            if(!components.containsKey(slot)){
                return;
            }
            Component component = components.get(slot);

            if(!(component instanceof ClickableComponent)){
                return;
            }

            ((ClickableComponent) component).click(event);

        });
    }

    public <T extends InventoryEvent> void registerEventListener(Class<T> clazz, Consumer<T> consumer){

        if(!eventListeners.containsKey(clazz)){
            eventListeners.put(clazz, new ArrayList<>());
        }

        eventListeners.get(clazz)
                .add((Consumer<InventoryEvent>) consumer);
    }

    public void runEvents(InventoryEvent event){

        if(!eventListeners.containsKey(event.getClass())){
            return;
        }

        for(Consumer<InventoryEvent> eventConsumer: eventListeners.get(event.getClass())){
            eventConsumer.accept(event);
        }

    }

    public void addComponent(int slot, Component component){
        components.put(slot, component);
    }

    public <T extends Component> T getComponents(int slot) {
        return components.containsKey(slot) ? (T) components.get(slot) : null;
    }

    public void fillInventory(Component component){
        for (int i = 0; i < getInventory().getSize(); i++){
            components.put(i, component);
        }
    }

    public void fillSlots(Component component, int startSlot, int endSlot){
        for (int i = startSlot; i < getInventory().getSize() && i <= endSlot; i++){
            components.put(i, component);
        }
    }

    public void setSlots(Component component, int... slots){
        for (int slot: slots){
            if (inventory.getSize() < slot){
                continue;
            }

            components.put(slot, component);
        }
    }

    public abstract void draw();

    @Override
    public Inventory getInventory() {
        return inventory;
    }

}
