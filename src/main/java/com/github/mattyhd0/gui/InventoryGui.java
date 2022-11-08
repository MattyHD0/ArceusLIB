package com.github.mattyhd0.gui;

import com.github.mattyhd0.gui.component.IInventoryEvent;
import com.github.mattyhd0.gui.component.ClickComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryGui {

    private byte inventorySize;
    private InventoryType inventoryType;
    private String title;
    private HashMap<Byte, ClickComponent> clickComponentHashMap;
    private HashMap<Byte, ItemStack> inventoryData;
    private List<IInventoryEvent> inventoryEvents;
    private boolean cancelGuiClick;
    private boolean cancelInventoryClick;
    public InventoryGui(InventoryType inventoryType, String title){
        this.inventoryType = inventoryType;
        this.title = title;
        this.clickComponentHashMap = new HashMap<>();
        this.inventoryData = new HashMap<>();
        this.cancelGuiClick = false;
        this.cancelInventoryClick = false;
        this.inventoryEvents = new ArrayList<>();
    }

    public InventoryGui(byte inventorySize, String title){
        this(null, title);
        this.inventorySize = inventorySize;
    }

    public InventoryGui(InventoryType inventoryType, String title, boolean cancelGuiClick, boolean cancelInventoryClick){
        this(inventoryType, title);
        this.cancelGuiClick = cancelGuiClick;
        this.cancelInventoryClick = cancelInventoryClick;
    }

    public void setSlot(int slot, ItemStack itemStack, ClickComponent clickComponent){
        setClickComponent(slot, clickComponent);
        setItemStack(slot, itemStack);
    }

    public void setClickComponent(int slot, ClickComponent clickComponent){
        clickComponentHashMap.put((byte)slot, clickComponent);
    }

    public void setItemStack(int slot, ItemStack itemStack){
        inventoryData.put((byte)slot, itemStack);
    }

    public ClickComponent getClickComponent(int slot){
        return clickComponentHashMap.get((byte)slot);
    }

    public HashMap<Byte, ClickComponent> getClickComponentHashMap() {
        return clickComponentHashMap;
    }

    public List<IInventoryEvent> getInventoryEvents() {
        return inventoryEvents;
    }

    public boolean isCancelGuiClick() {
        return cancelGuiClick;
    }

    public boolean isCancelInventoryClick() {
        return cancelInventoryClick;
    }

    public Inventory getInventory(){

        Inventory inventory;

        if(inventoryType == null){
            inventory = Bukkit.createInventory(null, inventorySize, title);
        } else {
            inventory = Bukkit.createInventory(null, inventoryType, title);
        }

        for (Map.Entry<Byte, ItemStack> entry: inventoryData.entrySet()){

            byte slot = entry.getKey();
            ItemStack itemStack = entry.getValue();

            inventory.setItem(slot, itemStack);

        }

        return inventory;

    }
}
