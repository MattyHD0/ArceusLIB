package com.github.mattyhd0.input.event;

import org.bukkit.entity.Player;

public interface PlayerInputListener {

    boolean onEvent(Player player, String input);

}
