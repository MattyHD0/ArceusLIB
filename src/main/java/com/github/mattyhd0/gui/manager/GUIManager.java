package com.github.mattyhd0.gui.manager;

import com.github.mattyhd0.gui.InventoryGui;
import com.github.mattyhd0.gui.listener.GuiListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class GUIManager {

    private GuiListener guiListener;
    public HashMap<UUID, InventoryGui> inventoryGuiHashMap;

    public GUIManager(Plugin plugin){
        this.guiListener = new GuiListener(this);
        this.inventoryGuiHashMap = new HashMap<>();
        plugin.getServer().getPluginManager().registerEvents(guiListener, plugin);
    }

    public GuiListener getGuiListener() {
        return guiListener;
    }

    public void openGui(InventoryGui gui, Player player){

        player.openInventory(gui.getInventory());
        inventoryGuiHashMap.put(player.getUniqueId(), gui);

    }

    public HashMap<UUID, InventoryGui> getInventoryGuiHashMap() {
        return inventoryGuiHashMap;
    }

}
