package com.github.mattyhd0.input;

import com.github.mattyhd0.input.event.PlayerInputListener;

public class PlayerChatInputDialog {

    private String id;
    private PlayerInputListener listener;
    private String title;
    private String subtitle;

    public PlayerChatInputDialog(String id, String title, String subtitle){
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }

    public PlayerChatInputDialog(PlayerInputListener listener, String title, String subtitle){
        this.listener = listener;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public PlayerInputListener getListener() {
        return listener;
    }
}
