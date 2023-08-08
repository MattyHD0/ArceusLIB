package com.github.mattyhd0.gui;

import com.github.mattyhd0.gui.component.api.AnimatedComponent;
import com.github.mattyhd0.gui.component.api.Component;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ArceusAnimatedMenu extends ArceusMenu {

    private ScheduledExecutorService executorService;
    private final int updateInterval;
    private long frame;

    public ArceusAnimatedMenu(Builder builder){
        super(builder);
        this.updateInterval = builder.updateInterval;
        executorService = Executors.newScheduledThreadPool(1);
        ArceusAnimatedMenu menu = this;
        registerEventListener(InventoryOpenEvent.class, event -> executorService.scheduleAtFixedRate(
                () -> {

                    for(Map.Entry<Integer, Component> entry: menu.components.entrySet()){

                        int slot = entry.getKey();
                        Component component = entry.getValue();

                        if(!(component instanceof AnimatedComponent)){
                            return;
                        }

                        ((AnimatedComponent) component)
                                .frame(this, slot, frame);

                    }

                    frame++;
                },
                0L,
                (long) (1000 / 20) *builder.updateInterval,
                TimeUnit.MILLISECONDS
        ));

        registerEventListener(InventoryCloseEvent.class, event -> {
            executorService.shutdown();
        });

    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public static class Builder<T extends Builder<T>> extends ArceusMenu.Builder {

        private int updateInterval;

        protected Builder(){
            this.updateInterval = 1;
        }

        public T updateInterval(int updateInterval){
            this.updateInterval = updateInterval;
            return (T) this;
        }


        public ArceusAnimatedMenu build(){
            return new ArceusAnimatedMenu(this);
        }

    }

}
