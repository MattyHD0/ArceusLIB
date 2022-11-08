package com.mattyhd0.gui.component;

import com.mattyhd0.gui.component.action.IInventoryClickAction;
import org.bukkit.event.inventory.ClickType;

import java.util.HashMap;

public class ClickComponent {

    private final HashMap<ClickType, IInventoryClickAction> inventoryClickActionHashMap;

    public ClickComponent(ClickType clickType, IInventoryClickAction action){
        inventoryClickActionHashMap = new HashMap<>();
    }

    public ClickComponent(IInventoryClickAction action){
        inventoryClickActionHashMap = new HashMap<>();

        for(ClickType clickType: ClickType.values()){
            inventoryClickActionHashMap.put(clickType, action);
        }
    }

    public HashMap<ClickType, IInventoryClickAction> getInventoryClickActionHashMap() {
        return inventoryClickActionHashMap;
    }

    public void setInventoryClickAction(ClickType clickType, IInventoryClickAction action) {
        inventoryClickActionHashMap.put(clickType, action);
    }
}
