package com.github.mattyhd0.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ItemStackBuilder {

    private Material material;
    private short data;
    private String name;
    private List<String> lore;

    private ItemStackBuilder(){
    }

    public static ItemStackBuilder create(Material material){
        ItemStackBuilder builder = new ItemStackBuilder();
        builder.material = material;
        return builder;
    }

    public static ItemStackBuilder create(Material material, int data){
        ItemStackBuilder builder = new ItemStackBuilder();
        builder.material = material;
        builder.data = (short) data;
        return builder;
    }

    public static ItemStackBuilder create(ItemStack itemStack){
        ItemStackBuilder builder = new ItemStackBuilder();
        builder.material = itemStack.getType();
        builder.data = itemStack.getDurability();
        return builder;
    }

    public void name(String name){
        this.name = name;
    }

    public void lore(String... lines){
        this.lore = Arrays.asList(lines);
    }

    public ItemStack build(){
        return null;
    }

}
