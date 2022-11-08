package com.mattyhd0.debug;

import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class Debugger {

    private Plugin plugin;
    private boolean enabled;

    public Debugger(Plugin plugin){
        this.plugin = plugin;
        this.enabled = true;
    }

    public void log(String string){
        if(isEnabled()) plugin.getLogger().log(Level.INFO, string);
    }

    public void log(String string, Object... params){
        if(isEnabled()) plugin.getLogger().log(Level.INFO, string, params);
    }

    public void log(Level level, String string){
        if(isEnabled()) plugin.getLogger().log(level, string);
    }

    public void log(Level level, String string, Object... params){
        if(isEnabled()) plugin.getLogger().log(level, string, params);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
