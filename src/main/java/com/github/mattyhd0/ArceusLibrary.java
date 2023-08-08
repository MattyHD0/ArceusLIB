package com.github.mattyhd0;

import com.github.mattyhd0.gui.listener.bukkit.PlayerInventoryListener;
import com.github.mattyhd0.input.PlayerInputManager;
import org.bukkit.plugin.Plugin;

public class ArceusLibrary {

    private PlayerInputManager playerInputManager;

    public ArceusLibrary(Plugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new PlayerInventoryListener(), plugin);
        playerInputManager = new PlayerInputManager(plugin);
    }

    public PlayerInputManager getPlayerInputManager() {
        return playerInputManager;
    }
}
