package com.github.mattyhd0.builder;

public abstract class AbstractLayoutBuilder<C, B extends IBuilder<C>> implements IBuilder<C> {

    protected abstract B self();

}
