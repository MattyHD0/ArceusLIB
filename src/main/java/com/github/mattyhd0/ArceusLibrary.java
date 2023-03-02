package com.github.mattyhd0;

import com.github.mattyhd0.gui.manager.GUIManager;
import com.github.mattyhd0.input.PlayerInputManager;
import org.bukkit.plugin.Plugin;

public class ArceusLibrary {

    private GUIManager guiManager;
    private PlayerInputManager playerInputManager;

    public ArceusLibrary(Plugin plugin){
        guiManager = new GUIManager(plugin);
        playerInputManager = new PlayerInputManager(plugin);
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }

    public PlayerInputManager getPlayerInputManager() {
        return playerInputManager;
    }
}
