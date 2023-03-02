package com.github.mattyhd0.input;

public class PlayerChatInputDialog {

    private String id;
    private String title;
    private String subtitle;

    public PlayerChatInputDialog(String id, String title, String subtitle){
        this.id = id;
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

}
