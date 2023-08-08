package com.github.mattyhd0.builder.component;

import com.github.mattyhd0.builder.IBuilder;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.event.inventory.ClickType;

public abstract class AbstractButtonBuilderLayout<C, B extends IBuilder<C>> extends AbstractDisplayItemBuilderLayout<C, B> {

    public abstract B action(ClickType clickType, ClickAction action);

    public abstract B anyAction(ClickAction action);

    public abstract B leftClickAction(ClickAction action);

    public abstract B shiftLeftClickAction(ClickAction action);

    public abstract B rightClickAction(ClickAction action);

    public abstract B shiftRightClickAction(ClickAction action);

    public abstract B middleClickAction(ClickAction action);

    public abstract B doubleClickAction(ClickAction action);

    public abstract B controlDrop(ClickAction action);

    public abstract B dropAction(ClickAction action);

    public abstract B numberKeyAction(ClickAction action);

    public abstract B unknownAction(ClickAction action);

}
