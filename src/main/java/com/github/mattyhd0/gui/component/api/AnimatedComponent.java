package com.github.mattyhd0.gui.component.api;

import com.github.mattyhd0.gui.holder.ArceusInventoryHolder;

public interface AnimatedComponent extends Component {

    void frame(ArceusInventoryHolder holder, int slot, long frame);

    int updateInterval();

}
