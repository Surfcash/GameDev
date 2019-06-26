package com.colin;

import processing.core.PApplet;

public abstract class AppletObject {
    private static final PApplet applet = MainApp.applet;

    public static PApplet getApplet() {
        return applet;
    }
}
