package com.github.mattyhd0.input.context;

import org.bukkit.entity.Player;

public class InputContext {

    private Player player;
    private String input;

    public InputContext(Player player, String input){
        this.player = player;
        this.input = input;
    }

    public Player getPlayer() {
        return player;
    }

    public String getInput() {
        return input;
    }

    public String[] getInputs() {
        return input.split(" ");
    }

    public int getIntInput() throws NumberFormatException{
        return Integer.parseInt(input);
    }

    public long getLongInput() throws NumberFormatException{
        return Long.parseLong(input);
    }

    public double getDoubleInput() throws NumberFormatException{
        return Double.parseDouble(input);
    }

    public float getFloatInput() throws NumberFormatException{
        return Float.parseFloat(input);
    }

    public boolean getBoolInput() {
        return Boolean.parseBoolean(input);
    }

}
