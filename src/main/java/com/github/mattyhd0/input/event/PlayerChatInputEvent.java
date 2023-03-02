package com.github.mattyhd0.input.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerChatInputEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private String id;
    private boolean accepted;
    private String input;

    public PlayerChatInputEvent(Player player, String id, String input){
        this.player = player;
        this.id = id;
        this.input = input;
        this.accepted = false;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return player;
    }

    public String getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public void accept(){
        accepted = true;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
