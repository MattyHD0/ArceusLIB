package com.github.mattyhd0.input;

import com.github.mattyhd0.input.action.InputProcessor;
import org.bukkit.entity.Player;

public abstract class AbstractPlayerInputDialog {

    private InputProcessor processor;

    public AbstractPlayerInputDialog(InputProcessor processor){
        this.processor = processor;
    }

    public InputProcessor getProcessor(){
        return this.processor;
    }

    public abstract void send(Player player);

    public abstract void exit(Player player);

}
