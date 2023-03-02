package com.github.mattyhd0.gui.component;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.function.Consumer;

public class ClickComponent {

    private HashMap<ClickType, Consumer<InventoryClickEvent>[]> clickActions;

    public ClickComponent(){
        clickActions = new HashMap<>();
    }

    protected ClickComponent(ClickType clickType, Consumer<InventoryClickEvent>... actions){
        this();
        clickActions.put(clickType, actions);
    }

    protected ClickComponent(Consumer<InventoryClickEvent>... actions){
        this();
        for(ClickType clickType: ClickType.values()){
            clickActions.put(clickType, actions);
        }
    }

    public static ClickComponent of(ClickType clickType, Consumer<InventoryClickEvent> action){
        return new ClickComponent(clickType, action);
    }

    public static ClickComponent of(Consumer<InventoryClickEvent> action){
        return new ClickComponent(action);
    }

    public ClickComponent with(ClickType clickType, Consumer<InventoryClickEvent>... actions){
        clickActions.put(clickType, actions);
        return this;
    }

    public HashMap<ClickType, Consumer<InventoryClickEvent>[]> getClickActions() {
        return clickActions;
    }

}
