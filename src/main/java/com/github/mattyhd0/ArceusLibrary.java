package com.github.mattyhd0;

import com.github.mattyhd0.gui.listener.bukkit.PlayerInventoryListener;
import com.github.mattyhd0.gui.listener.bukkit.PluginUnloadListener;
import com.github.mattyhd0.input.PlayerInputManager;
import org.bukkit.plugin.Plugin;

public class ArceusLibrary {

    private static ArceusLibrary instance;
    private Plugin plugin;
    private PlayerInputManager playerInputManager;

    public ArceusLibrary(Plugin plugin){
        instance = this;
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new PlayerInventoryListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PluginUnloadListener(), plugin);
        playerInputManager = new PlayerInputManager(plugin);
    }

    public PlayerInputManager getPlayerInputManager() {
        return playerInputManager;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public static ArceusLibrary getInstance() {
        return instance;
    }
}
