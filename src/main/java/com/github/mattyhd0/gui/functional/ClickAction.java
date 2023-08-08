package com.github.mattyhd0.gui.functional;

import com.github.mattyhd0.gui.context.MenuClickContext;

@FunctionalInterface
public interface ClickAction {

    void onClick(MenuClickContext context);

}
