package com.github.mattyhd0.gui.component;

import org.bukkit.event.inventory.*;

import java.util.HashMap;
import java.util.function.Consumer;

public class InventoryEventComponent implements ArceusComponent {

    private HashMap<Class<? extends InventoryEvent>, Consumer<? extends InventoryEvent>> consumers;

    private InventoryEventComponent(){
        consumers = new HashMap<>();
    }

    public static InventoryEventComponent create(){
        return new InventoryEventComponent();
    }

    public final InventoryEventComponent any(Consumer<InventoryClickEvent> consumer){
        this.consumers.put(InventoryClickEvent.class, consumer);
        return this;
    }

    public final InventoryEventComponent open(Consumer<InventoryOpenEvent> consumer){
        this.consumers.put(InventoryOpenEvent.class, consumer);
        return this;
    }

    public final InventoryEventComponent close(Consumer<InventoryCloseEvent> consumer){
        this.consumers.put(InventoryCloseEvent.class, consumer);
        return this;
    }

    public final InventoryEventComponent click(Consumer<InventoryClickEvent> consumer){
        this.consumers.put(InventoryClickEvent.class, consumer);
        return this;
    }

    public HashMap<Class<? extends InventoryEvent>, Consumer<? extends InventoryEvent>> getConsumers() {
        return consumers;
    }

    public <T extends InventoryEvent> Consumer<T> getConsumers(Class<T> clazz){
        return (Consumer<T>) consumers.get(clazz);
    }

}
