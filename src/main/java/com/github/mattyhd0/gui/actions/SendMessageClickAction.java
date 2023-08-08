package com.github.mattyhd0.gui.actions;

import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.ChatColor;

public class SendMessageClickAction implements ClickAction {

    private String message;

    public SendMessageClickAction(String message){
        this.message = message;
    }

    @Override
    public void onClick(MenuClickContext context) {
        context.getClicker().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
