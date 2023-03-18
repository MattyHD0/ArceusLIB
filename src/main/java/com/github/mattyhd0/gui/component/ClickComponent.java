package com.github.mattyhd0.gui.component;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.function.Consumer;

public class ClickComponent implements ArceusComponent {

    private int slot;
    private HashMap<ClickType, Consumer<InventoryClickEvent>> actions;

    private ClickComponent(int slot){
        this.slot = slot;
        actions = new HashMap<>();
    }

    public static ClickComponent create(int slot){
        return new ClickComponent(slot);
    }

    public final ClickComponent any(Consumer<InventoryClickEvent> action){
        for (ClickType type: ClickType.values()){
            this.actions.put(type, action);
        }
        return this;
    }

    public final ClickComponent left(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.LEFT, action);
        return this;
    }

    public final ClickComponent shiftLeft(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.SHIFT_LEFT, action);
        return this;
    }

    public final ClickComponent right(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.RIGHT, action);
        return this;
    }

    public final ClickComponent shiftRight(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.SHIFT_RIGHT, action);
        return this;
    }

    public final ClickComponent middle(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.MIDDLE, action);
        return this;
    }

    public final ClickComponent doubleClick(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.DOUBLE_CLICK, action);
        return this;
    }

    public final ClickComponent controlDrop(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.CONTROL_DROP, action);
        return this;
    }

    public final ClickComponent drop(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.DROP, action);
        return this;
    }

    public final ClickComponent numberKey(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.NUMBER_KEY, action);
        return this;
    }

    public final ClickComponent unknown(Consumer<InventoryClickEvent> action){
        this.actions.put(ClickType.UNKNOWN, action);
        return this;
    }

    public int getSlot() {
        return slot;
    }

    public HashMap<ClickType, Consumer<InventoryClickEvent>> getClickActions() {
        return actions;
    }

}
