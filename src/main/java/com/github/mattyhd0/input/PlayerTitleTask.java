package com.github.mattyhd0.input;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

public class PlayerTitleTask extends BukkitRunnable {

    private PlayerInputManager playerInputManager;

    public PlayerTitleTask(PlayerInputManager playerInputManager){
        this.playerInputManager = playerInputManager;
    }

    @Override
    public void run() {

        for (Map.Entry<UUID, PlayerChatInputDialog> entry: playerInputManager.getPlayerInputMap().entrySet()){

            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(entry.getKey());

            if(!offlinePlayer.isOnline()){
                continue;
            }

            Player player = (Player) offlinePlayer;
            PlayerChatInputDialog playerChatInputDialog = entry.getValue();

            player.sendTitle(
                    ChatColor.translateAlternateColorCodes('&', playerChatInputDialog.getTitle()),
                    ChatColor.translateAlternateColorCodes('&', playerChatInputDialog.getSubtitle())
                    );

        }

    }
}
