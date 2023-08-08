package com.github.mattyhd0.gui.component.api;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface ClickableComponent extends Component {

    void click(InventoryClickEvent event);

}
