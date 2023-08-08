package com.github.mattyhd0.builder.gui;

import com.github.mattyhd0.builder.AbstractLayoutBuilder;
import com.github.mattyhd0.builder.IBuilder;
import com.github.mattyhd0.gui.component.api.Component;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.function.Consumer;

public abstract class AbstractMenuBuilderLayout<C, B extends IBuilder<C>> extends AbstractLayoutBuilder<C, B> {

    public abstract B title(String title);

    public abstract B rows(int rows);

    public abstract B inventoryType(InventoryType inventoryType);

    public abstract B component(int slot, Component component);

    public abstract B listener(Class<? extends InventoryEvent> clazz, Consumer<InventoryEvent> consumer);

}
