package com.github.mattyhd0.gui.actions;

import com.github.mattyhd0.gui.ArceusPaginatedMenu;
import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.inventory.InventoryHolder;

public class OpenPageAction implements ClickAction {

    private final int target;
    private final Type type;

    public OpenPageAction(Type type){
        this.type = type;
        this.target = 0;
    }

    public OpenPageAction(int target){
        this.type = Type.CUSTOM;
        this.target = target;
    }

    public OpenPageAction(Type type, int target){
        this.type = type;
        this.target = target;
    }

    @Override
    public void onClick(MenuClickContext context) {

        InventoryHolder holder = context.getInventory().getHolder();

        if(!(holder instanceof ArceusPaginatedMenu)){
            return;
        }

        ArceusPaginatedMenu paginatedMenu = (ArceusPaginatedMenu) holder;

        int targetPage;

        switch (type){
            case CUSTOM:
                targetPage = target;
                break;
            case NEXT:
                targetPage = paginatedMenu.getCurrentPage() + 1;
                break;
            case PREVIOUS:
                targetPage = paginatedMenu.getCurrentPage() - 1;
                break;
            case INCREMENT_TO_CURRENT:
                targetPage = paginatedMenu.getCurrentPage() + target;
                break;
            case DECREMENT_TO_CURRENT:
                targetPage = paginatedMenu.getCurrentPage() - target;
                break;
            default:
                targetPage = 0;
        }

        if(!paginatedMenu.hasPage(targetPage)){
            return;
        }

        paginatedMenu.setCurrentPage(targetPage);

    }

    public enum Type {
        CUSTOM,
        NEXT,
        PREVIOUS,
        INCREMENT_TO_CURRENT,
        DECREMENT_TO_CURRENT;
    }

}
