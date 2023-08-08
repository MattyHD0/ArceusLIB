package com.github.mattyhd0.gui.component.arceus;

import com.github.mattyhd0.builder.AbstractLayoutBuilder;
import com.github.mattyhd0.builder.IBuilder;
import com.github.mattyhd0.gui.component.api.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.AbstractCollection;

public class DisplayItem implements Component {

    private final ItemStack itemStack;

    protected DisplayItem(Builder builder){
        this.itemStack = builder.itemStack;
    }

    public DisplayItem(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public void drawItem(Inventory inventory, int slot) {
        inventory.setItem(slot, itemStack);
    }

    public static class Builder extends AbstractLayoutBuilder<DisplayItem, Builder> implements IBuilder<DisplayItem> {

        private ItemStack itemStack;

        public Builder(){
            this.itemStack = new ItemStack(Material.STONE);
        }

        public Builder item(ItemStack itemStack){
            this.itemStack = itemStack;
            return self();
        }

        @Override
        protected Builder self() {
            return null;
        }

        @Override
        public DisplayItem build() {
            return new DisplayItem(this);
        }
    }

}
