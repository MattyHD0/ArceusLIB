package com.github.mattyhd0.gui.actions;

import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;

public class CloseGuiClickAction implements ClickAction {

    @Override
    public void onClick(MenuClickContext context) {
        context.getClicker().closeInventory();
    }
}
