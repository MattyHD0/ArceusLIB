package com.github.mattyhd0.gui;

import com.github.mattyhd0.builder.gui.AbstractMenuBuilderLayout;
import com.github.mattyhd0.gui.component.api.Component;
import com.github.mattyhd0.gui.holder.ArceusInventoryHolder;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ArceusMenu extends ArceusInventoryHolder {

    protected ArceusMenu(Builder builder) {
        super(
                builder.title,
                builder.rows,
                builder.inventoryType,
                builder.components,
                builder.listeners
        );
    }

    public ArceusMenu(
            String title,
            int rows,
            InventoryType inventoryType,
            HashMap<Integer, Component> components,
            HashMap<Class<? extends InventoryEvent>, List<Consumer<InventoryEvent>>> listeners
    ) {
        super(title, rows, inventoryType, components, listeners);
    }

    @Override
    public void draw() {
        for (Map.Entry<Integer, Component> componentEntry : components.entrySet()) {

            int slot = componentEntry.getKey();
            Component component = componentEntry.getValue();

            component.drawItem(this.inventory, slot);
        }
    }

    public static class Builder extends AbstractMenuBuilderLayout<ArceusMenu, Builder> {

        private String title;
        private int rows;
        private InventoryType inventoryType;
        private final HashMap<Integer, Component> components;
        private final HashMap<
                Class<? extends InventoryEvent>,
                List<Consumer<InventoryEvent>>
                > listeners;

        public Builder() {
            components = new HashMap<>();
            listeners = new HashMap<>();
        }

        public Builder title(String title) {
            this.title = title;
            return self();
        }

        public Builder rows(int rows) {
            this.rows = rows;
            return self();
        }

        public Builder inventoryType(InventoryType inventoryType) {
            this.inventoryType = inventoryType;
            return self();
        }

        public Builder component(int slot, Component component) {
            this.components.put(slot, component);
            return self();
        }

        public Builder listener(Class<? extends InventoryEvent> clazz, Consumer<InventoryEvent> consumer) {
            if (!this.listeners.containsKey(clazz)) {
                this.listeners.put(clazz, new ArrayList<>());
            }
            this.listeners.get(clazz).add(consumer);
            return self();
        }

        public ArceusMenu build() {
            return new ArceusMenu(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

}
