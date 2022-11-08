package com.mattyhd0;

import com.mattyhd0.command.TestCommand;
import com.mattyhd0.gui.manager.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ArceusLIB extends JavaPlugin {

    private static ArceusLIB instance;
    private GUIManager guiManager;

    @Override
    public void onEnable(){
        this.guiManager = new GUIManager(this);
        getCommand("test").setExecutor(new TestCommand());
        instance = this;
        }

    @Override
    public void onDisable(){

    }

    public static ArceusLIB getInstance() {
        return instance;
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }
}