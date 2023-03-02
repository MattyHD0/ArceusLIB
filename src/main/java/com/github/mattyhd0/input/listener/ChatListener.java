package com.github.mattyhd0.input.listener;

import com.github.mattyhd0.input.PlayerInputManager;
import com.github.mattyhd0.input.event.PlayerChatInputEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatListener implements Listener {

    private PlayerInputManager playerInputManager;

    public ChatListener(PlayerInputManager playerInputManager){
        this.playerInputManager = playerInputManager;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        UUID playerUuid = player.getUniqueId();

        if(!playerInputManager.has(playerUuid)){
            return;
        }


        PlayerChatInputEvent inputEvent = new PlayerChatInputEvent(
                event.getPlayer(),
                playerInputManager.get(playerUuid).getId(),
                event.getMessage()
        );

        Bukkit.getPluginManager().callEvent(inputEvent);

        if(inputEvent.isAccepted()){
            playerInputManager.remove(player.getUniqueId());
        } else {
            event.setCancelled(true);
        }

    }

}
