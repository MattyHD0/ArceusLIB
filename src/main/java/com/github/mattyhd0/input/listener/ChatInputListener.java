package com.github.mattyhd0.input.listener;

import com.github.mattyhd0.input.PlayerChatInputDialog;
import com.github.mattyhd0.input.PlayerInputManager;
import com.github.mattyhd0.input.event.PlayerChatInputEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class ChatInputListener implements Listener {

    private PlayerInputManager playerInputManager;

    public ChatInputListener(PlayerInputManager playerInputManager){
        this.playerInputManager = playerInputManager;
    }

    @EventHandler
    public void onPlayerCommand(PlayerChatEvent event){

        Player player = event.getPlayer();
        UUID playerUuid = player.getUniqueId();
        String input = event.getMessage().replace("/", "");

        if(!playerInputManager.has(playerUuid)){
            return;
        }

        event.setCancelled(true);

        PlayerChatInputDialog playerChatInputDialog = playerInputManager.get(playerUuid);

        boolean accepted = false;

        if(playerChatInputDialog.getListener() == null){

            PlayerChatInputEvent inputEvent = new PlayerChatInputEvent(
                    player,
                    playerInputManager.get(playerUuid).getId(),
                    input
            );

            Bukkit.getPluginManager().callEvent(inputEvent);

            accepted = inputEvent.isAccepted();

        } else {
            accepted = playerChatInputDialog.getListener().onEvent(player, input);
        }

        if(!accepted){
            return;
        }

        playerInputManager.remove(player.getUniqueId());
        player.sendTitle("", "");

    }

}
