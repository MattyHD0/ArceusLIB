package com.github.mattyhd0.gui;

import com.github.mattyhd0.builder.gui.AbstractPaginatedMenuBuilderLayout;
import com.github.mattyhd0.gui.component.api.ClickableComponent;
import com.github.mattyhd0.gui.component.api.Component;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ArceusPaginatedMenu extends ArceusMenu {

    private int[] pageSlots;
    private final List<Component> paginatedComponents;
    private int page;

    public ArceusPaginatedMenu(
            String title,
            int rows,
            InventoryType inventoryType,
            HashMap<Integer, Component> components,
            HashMap<Class<? extends InventoryEvent>, List<Consumer<InventoryEvent>>> listeners,
            int[] pageSlots,
            List<Component> paginatedComponents,
            int page
    ) {
        super(title, rows, inventoryType, components, listeners);
        this.pageSlots = pageSlots;
        this.paginatedComponents = paginatedComponents;
        this.page = page;

        registerEventListener(InventoryClickEvent.class, event -> {


            if (event.getClickedInventory() instanceof PlayerInventory) {
                return;
            }

            int slot = event.getSlot();

            if(slot < 0){
                return;
            }

            ArceusPaginatedMenu paginatedMenu = (ArceusPaginatedMenu) event.getClickedInventory().getHolder();

            if (Arrays.stream(paginatedMenu.pageSlots).noneMatch(num -> num == slot)) {
                return;
            }

            if (paginatedComponents.size() <= calculateIndexOfPaginatedComponent(paginatedMenu.page, slot)) {
                return;
            }

            Component component = paginatedComponents.get(calculateIndexOfPaginatedComponent(paginatedMenu.page, slot));

            if (!(component instanceof ClickableComponent)) {
                return;
            }

            ((ClickableComponent) component).click(event);
        });
    }

    protected ArceusPaginatedMenu(Builder builder) {
        this(
                builder.title,
                builder.rows,
                builder.inventoryType,
                builder.components,
                builder.listeners,
                builder.pageSlots,
                builder.paginatedComponents,
                0
        );
    }

    protected int calculateSlotOfPaginatedComponent(int page, int slot) {
        return (slot + (page * pageSlots.length));
    }

    protected int calculateIndexOfPaginatedComponent(int page, int slot) {
        return (findIndex(slot) + (page * pageSlots.length));
    }

    private int findIndex(int integer){
        for(int i = 0; i < pageSlots.length; i++){
            if(pageSlots[i] == integer) return i;
        }
        return -1;
    }

    public void addPaginatedComponents(Component... components) {
        paginatedComponents.addAll(Arrays.asList(components));
    }

    public void setPageSlotsSpecific(int... slots) {
        this.pageSlots = slots;
    }

    public void setPageSlotsRange(int start, int end) {
        int[] slots = new int[end - start];
        for (int i = 0; i < end; i++) {
            slots[i] = i + start;
        }
        this.pageSlots = slots;
    }

    public int getElementsPerPage() {
        return pageSlots.length;
    }

    public int getPages() {
        return (paginatedComponents.size() / getElementsPerPage());
    }

    public boolean hasPage(int page) {
        return page >= 0 && page <= getPages();
    }

    public void setCurrentPage(int page) {
        this.page = page;
        draw();
    }

    public int getCurrentPage() {
        return this.page;
    }

    @Override
    public void draw() {
        super.draw();
        for (
                int i = 0;
                i < pageSlots.length &&
                        calculateSlotOfPaginatedComponent(page, i) < paginatedComponents.size() &&
                        i < this.inventory.getSize();
                i++
        ) {
            Component component = paginatedComponents.get(calculateSlotOfPaginatedComponent(page, i));
            component.drawItem(this.inventory, pageSlots[i]);
        }
    }

    public static class Builder extends AbstractPaginatedMenuBuilderLayout<ArceusPaginatedMenu, Builder> {

        private String title;
        private int rows;
        private InventoryType inventoryType;
        private final HashMap<Integer, Component> components;
        private final HashMap<
                Class<? extends InventoryEvent>,
                List<Consumer<InventoryEvent>>
                > listeners;
        private int[] pageSlots;
        private final List<Component> paginatedComponents;

        public Builder() {
            components = new HashMap<>();
            listeners = new HashMap<>();
            pageSlots = new int[]{};
            paginatedComponents = new ArrayList<>();
        }

        @Override
        public Builder title(String title) {
            this.title = title;
            return self();
        }

        @Override
        public Builder rows(int rows) {
            this.rows = rows;
            return self();
        }

        @Override
        public Builder inventoryType(InventoryType inventoryType) {
            this.inventoryType = inventoryType;
            return self();
        }

        @Override
        public Builder component(int slot, Component component) {
            this.components.put(slot, component);
            return self();
        }

        @Override
        public Builder listener(Class<? extends InventoryEvent> clazz, Consumer<InventoryEvent> consumer) {
            if (!this.listeners.containsKey(clazz)) {
                this.listeners.put(clazz, new ArrayList<>());
            }
            this.listeners.get(clazz).add(consumer);
            return self();
        }

        @Override
        public Builder pageSlots(int start, int end) {
            int[] slots = new int[end - start];
            for (int i = 0; i < end; i++) {
                slots[i] = i + start;
            }
            this.pageSlots = slots;
            return this;
        }

        @Override
        public Builder pageSlots(int... slots) {
            this.pageSlots = slots;
            return this;
        }

        @Override
        public Builder paginatedComponent(Component component) {
            this.paginatedComponents.add(component);
            return this;
        }

        /*@Override
        public Builder paginatedComponent(int page, int slot, Component component) {
            return null;
        }*/

        @Override
        public ArceusPaginatedMenu build() {
            return new ArceusPaginatedMenu(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}
