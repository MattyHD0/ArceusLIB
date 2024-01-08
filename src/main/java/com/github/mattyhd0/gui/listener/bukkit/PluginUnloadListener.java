package com.github.mattyhd0.gui.listener.bukkit;

import com.github.mattyhd0.ArceusLibrary;
import com.github.mattyhd0.gui.holder.ArceusInventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.Inventory;

public class PluginUnloadListener implements Listener {

    @EventHandler
    public void onPluginUnload(PluginDisableEvent event){

        if(!event.getPlugin().equals(ArceusLibrary.getInstance().getPlugin())){
            return;
        }

        for (Player player: Bukkit.getOnlinePlayers()){

            Inventory inventory = player.getOpenInventory().getTopInventory();

            if(inventory == null){
                continue;
            }

            if(inventory.getHolder() instanceof ArceusInventoryHolder){
                player.closeInventory();
            }


        }

    }

}
