package com.github.mattyhd0.gui.actions;

import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SendTitleClickAction implements ClickAction {

    private String title;
    private String subtitle;

    public SendTitleClickAction(String title, String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public void onClick(MenuClickContext context) {
        Player player = (Player) context.getClicker();
        player.sendTitle(
                ChatColor.translateAlternateColorCodes('&', title),
                ChatColor.translateAlternateColorCodes('&', subtitle)
        );
    }
}
