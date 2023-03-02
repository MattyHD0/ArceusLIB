package com.github.mattyhd0;

import com.github.mattyhd0.command.TestCommand;
import com.github.mattyhd0.gui.manager.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ArceusLIB extends JavaPlugin {

    private static ArceusLIB instance;
    private ArceusLibrary arceusLibrary;

    @Override
    public void onEnable(){
        getCommand("acltest").setExecutor(new TestCommand());
        arceusLibrary = new ArceusLibrary(this);
        instance = this;
        }

    @Override
    public void onDisable(){

    }

    public static ArceusLIB getInstance() {
        return instance;
    }

    public ArceusLibrary getArceusLibrary() {
        return arceusLibrary;
    }
}