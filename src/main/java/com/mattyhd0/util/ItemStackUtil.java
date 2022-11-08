package com.mattyhd0.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemStackUtil {

    public static ItemStack getItemStack(Material material, String name, String... lore){

        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        itemStack.setItemMeta(meta);

        return itemStack;

    }

}
