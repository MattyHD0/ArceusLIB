package com.github.mattyhd0.gui.component.arceus;

import com.github.mattyhd0.builder.component.AbstractButtonBuilderLayout;
import com.github.mattyhd0.gui.component.api.ClickableComponent;
import com.github.mattyhd0.gui.context.MenuClickContext;
import com.github.mattyhd0.gui.functional.ClickAction;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Button extends DisplayItem implements ClickableComponent {

    private final HashMap<ClickType, ClickAction> actions;

    protected Button(Builder builder){
        super(builder.itemStack);
        this.actions = builder.actions;
    }

    public void setAction(ClickType clickType, ClickAction action){
        actions.put(clickType, action);
    }

    public HashMap<ClickType, ClickAction> getClickActions() {
        return actions;
    }

    @Override
    public void click(InventoryClickEvent event) {

        ClickType clickType = event.getClick();

        if(!actions.containsKey(clickType)){
            return;
        }

        actions.get(clickType)
                .onClick(
                        new MenuClickContext(event)
                );

    }

    public static class Builder extends AbstractButtonBuilderLayout<Button, Builder> {

        private ItemStack itemStack;
        private final HashMap<ClickType, ClickAction> actions;

        public Builder(){
            super();
            actions = new HashMap<>();
        }

        @Override
        public Builder action(ClickType clickType, ClickAction action) {
            this.actions.put(clickType, action);
            return self();
        }

        @Override
        public Builder anyAction(ClickAction action) {
            for(ClickType type: ClickType.values()){
                this.actions.put(type, action);
            }
            return self();
        }

        @Override
        public Builder leftClickAction(ClickAction action) {
            this.actions.put(ClickType.LEFT, action);
            return self();
        }

        @Override
        public Builder shiftLeftClickAction(ClickAction action) {
            this.actions.put(ClickType.SHIFT_LEFT, action);
            return self();
        }

        @Override
        public Builder rightClickAction(ClickAction action) {
            this.actions.put(ClickType.RIGHT, action);
            return self();
        }

        @Override
        public Builder shiftRightClickAction(ClickAction action) {
            this.actions.put(ClickType.SHIFT_RIGHT, action);
            return self();
        }

        @Override
        public Builder middleClickAction(ClickAction action) {
            this.actions.put(ClickType.MIDDLE, action);
            return self();
        }

        @Override
        public Builder doubleClickAction(ClickAction action) {
            this.actions.put(ClickType.DOUBLE_CLICK, action);
            return self();
        }

        @Override
        public Builder controlDrop(ClickAction action) {
            this.actions.put(ClickType.CONTROL_DROP, action);
            return self();
        }

        @Override
        public Builder dropAction(ClickAction action) {
            this.actions.put(ClickType.DROP, action);
            return self();
        }

        @Override
        public Builder numberKeyAction(ClickAction action) {
            this.actions.put(ClickType.NUMBER_KEY, action);
            return self();
        }

        @Override
        public Builder unknownAction(ClickAction action) {
            this.actions.put(ClickType.UNKNOWN, action);
            return self();
        }

        @Override
        public Builder item(ItemStack itemStack) {
            this.itemStack = itemStack;
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Button build(){
            return new Button(self());
        }

    }
}
