package com.github.mattyhd0.input;

import com.github.mattyhd0.input.action.InputProcessor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlayerChatInputDialog extends AbstractPlayerInputDialog {

    private String title;
    private String subtitle;
    private ScheduledExecutorService executorService;

    public PlayerChatInputDialog(InputProcessor processor, String title, String subtitle) {
        super(processor);
        this.title = title;
        this.subtitle = subtitle;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public void send(Player player) {

        executorService.schedule(() -> {

            if(!player.isOnline() || player.isDead()) return;

            try {
                player.sendTitle(
                        ChatColor.translateAlternateColorCodes('&', getTitle()),
                        ChatColor.translateAlternateColorCodes('&', getSubtitle()),
                        0, 20, 0
                );
            } catch (NoSuchMethodError e){
                player.sendTitle(
                        ChatColor.translateAlternateColorCodes('&', getTitle()),
                        ChatColor.translateAlternateColorCodes('&', getSubtitle())
                );
            }

        }, 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void exit(Player player) {
        try {
            player.resetTitle();
        } catch (NoSuchMethodError ignored){}

        executorService.shutdown();
    }

}
