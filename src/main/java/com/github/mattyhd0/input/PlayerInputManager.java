package com.github.mattyhd0.input;

import com.github.mattyhd0.input.listener.InputListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class PlayerInputManager {

    private HashMap<UUID, AbstractPlayerInputDialog> playerInputMap;

    public PlayerInputManager(Plugin plugin){
        playerInputMap = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(new InputListener(this), plugin);
    }

    public HashMap<UUID, AbstractPlayerInputDialog> getPlayerInputMap() {
        return new HashMap<>(playerInputMap);
    }

    public boolean has(UUID player){
        return playerInputMap.containsKey(player);
    }

    public AbstractPlayerInputDialog get(UUID player){
        return playerInputMap.get(player);
    }

    public void remove(UUID player){
        playerInputMap.remove(player);
    }

    public void sendInputDialog(Player player, AbstractPlayerInputDialog inputDialog){
        inputDialog.send(player);
        playerInputMap.put(player.getUniqueId(), inputDialog);
    }

}
