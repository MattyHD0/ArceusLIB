package com.github.mattyhd0.gui.actions;

import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.Sound;

public class PlaySoundClickAction implements ClickAction {

    private Sound sound;
    private float pitch;
    private float yaw;

    public PlaySoundClickAction(Sound sound, float pitch, float yaw){
        this.sound = sound;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    @Override
    public void onClick(MenuClickContext context) {
        context.getClicker().playSound(
                context.getClicker().getLocation(),
                sound,
                pitch,
                yaw
        );
    }
}
