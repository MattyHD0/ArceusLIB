package com.github.mattyhd0.input;

import com.github.mattyhd0.input.action.InputProcessor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

public class PlayerSignInputDialog extends AbstractPlayerInputDialog {

    private String[] lines;
    private int[] inputLines;

    public PlayerSignInputDialog(InputProcessor processor, String[] lines, int[] inputLines) {
        super(processor);
        this.lines = lines;
        this.inputLines = inputLines;
    }

    public String[] getLines(){
        return this.lines;
    }

    public int[] getInputLines() {
        return inputLines;
    }

    @Override
    public void send(Player player) {


        Location location = player.getLocation();


        Block block = location.getBlock();
        BlockData blockData = block.getBlockData().clone();

        Sign sign = (Sign) Bukkit.createBlockData(Material.OAK_SIGN);

        block.setBlockData(sign.getBlockData(), false);

        for (int i = 0; i < 4 || i < lines.length; i++){
            sign.setLine(i, lines[i]);
        }

        //int maxHeight = location.getWorld().getMaxHeight();
        /*for (int i = -64; i < maxHeight; i++){

        }*/

        player.openSign(sign);
        block.setBlockData(blockData, false);

    }

    @Override
    public void exit(Player player) {

    }

}
