package com.matthem.ui;

public abstract class UIControl {
    private boolean isEnabled = true;

//    public UIControl(boolean isEnabled) {
//        this.isEnabled = isEnabled;
//    }

    public abstract void render();

    public final void enable() {
        isEnabled = true;
    }

    public final void disable() {
        isEnabled = false;
    }

    public final boolean isEnabled() {
        return isEnabled;
    }
}
