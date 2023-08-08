package com.github.mattyhd0.builder.component;

import com.github.mattyhd0.builder.AbstractLayoutBuilder;
import com.github.mattyhd0.builder.IBuilder;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractDisplayItemBuilderLayout<C, B extends IBuilder<C>> extends AbstractLayoutBuilder<C, B> {

    public abstract B item(ItemStack itemStack);

}
