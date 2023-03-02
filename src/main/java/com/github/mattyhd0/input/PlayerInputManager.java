package com.github.mattyhd0.input;

import com.github.mattyhd0.input.listener.ChatInputListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.UUID;

public class PlayerInputManager {

    private HashMap<UUID, PlayerChatInputDialog> playerInputMap;

    public PlayerInputManager(Plugin plugin){
        playerInputMap = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(new ChatInputListener(this), plugin);
        new PlayerTitleTask(this)
                .runTaskTimer(plugin, 0L, 10L);
    }

    public HashMap<UUID, PlayerChatInputDialog> getPlayerInputMap() {
        return new HashMap<>(playerInputMap);
    }

    public boolean has(UUID player){
        return playerInputMap.containsKey(player);
    }

    public PlayerChatInputDialog get(UUID player){
        return playerInputMap.get(player);
    }

    public void remove(UUID player){
        playerInputMap.remove(player);
    }

    public void sendInputDialog(Player player, PlayerChatInputDialog playerChatInputDialog){
        playerInputMap.put(player.getUniqueId(), playerChatInputDialog);
    }

}
