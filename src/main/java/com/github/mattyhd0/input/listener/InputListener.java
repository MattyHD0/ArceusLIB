package com.github.mattyhd0.input.listener;

import com.github.mattyhd0.input.AbstractPlayerInputDialog;
import com.github.mattyhd0.input.PlayerChatInputDialog;
import com.github.mattyhd0.input.PlayerInputManager;
import com.github.mattyhd0.input.PlayerSignInputDialog;
import com.github.mattyhd0.input.context.InputContext;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class InputListener implements Listener {

    private PlayerInputManager playerInputManager;

    public InputListener(PlayerInputManager playerInputManager){
        this.playerInputManager = playerInputManager;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if(!playerInputManager.has(uuid)){
            return;
        }

        AbstractPlayerInputDialog inputDialog = playerInputManager.get(uuid);

        if(!(inputDialog instanceof PlayerChatInputDialog)){
            return;
        }

        event.setCancelled(true);
        player.performCommand("/"+event.getMessage());

    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if(!playerInputManager.has(uuid)){
            return;
        }

        AbstractPlayerInputDialog inputDialog = playerInputManager.get(uuid);

        if(!(inputDialog instanceof PlayerChatInputDialog)){
            return;
        }

        String input = event.getMessage().substring(1);

        InputContext inputContext = new InputContext(player, input);
        boolean accepted = inputDialog.getProcessor()
                .process(inputContext);

        event.setCancelled(true);

        if(!accepted){
            return;
        }

        playerInputManager.remove(uuid);

    }

    @EventHandler
    public void onSignEdit(SignChangeEvent event){


        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if(!playerInputManager.has(uuid)){
            return;
        }

        AbstractPlayerInputDialog inputDialog = playerInputManager.get(uuid);

        if(!(inputDialog instanceof PlayerSignInputDialog)){
            return;
        }

        PlayerSignInputDialog signInputDialog = (PlayerSignInputDialog) inputDialog;

        String[] inputLines = {"", "", "", ""};

        for (int i = 0; i < signInputDialog.getInputLines().length; i++){
            int line = signInputDialog.getInputLines()[i];
            inputLines[line] = event.getLine(line);
        }


        StringBuilder input = new StringBuilder(inputLines[0]);

        InputContext inputContext = new InputContext(player, input.toString());
        boolean accepted = inputDialog.getProcessor()
                .process(inputContext);

        event.setCancelled(true);

        if(!accepted){
            return;
        }

        playerInputManager.remove(uuid);

    }

}
