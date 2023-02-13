package com.github.mattyhd0.gui.actions;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class PlaySoundClickAction implements Consumer<InventoryClickEvent> {

    private Sound sound;
    private float pitch;
    private float yaw;

    public PlaySoundClickAction(Sound sound, float pitch, float yaw){
        this.sound = sound;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    @Override
    public void accept(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        player.playSound(
                player.getLocation(),
                sound,
                pitch,
                yaw
        );
    }

}
