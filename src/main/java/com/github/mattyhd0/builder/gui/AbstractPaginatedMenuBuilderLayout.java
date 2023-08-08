package com.github.mattyhd0.builder.gui;

import com.github.mattyhd0.builder.IBuilder;
import com.github.mattyhd0.gui.component.api.Component;

public abstract class AbstractPaginatedMenuBuilderLayout<C, B extends IBuilder<C>> extends AbstractMenuBuilderLayout<C, B> {

    public abstract B pageSlots(int start, int end);

    public abstract B pageSlots(int... slots);

    public abstract B paginatedComponent(Component component);

    //public abstract B paginatedComponent(int page, int slot, Component component);

}
