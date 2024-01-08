package com.github.mattyhd0;

import com.github.mattyhd0.command.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ArceusLIBPlugin extends JavaPlugin {

    private static ArceusLIBPlugin instance;
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

    public static ArceusLIBPlugin getInstance() {
        return instance;
    }

    public ArceusLibrary getArceusLibrary() {
        return arceusLibrary;
    }
}