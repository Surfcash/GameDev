package com.colin;

import processing.core.PApplet;

public class MainApp extends PApplet {

    public static void main(String[] args) {
        String[] PApp = {"com.colin.MainApp"};
        PApplet.main(PApp);
    }

    public void setup() {
        surface.setTitle("Colin's Workspace");
        surface.setResizable(false);
        surface.setLocation(-3, -3);
    }

    public void settings() {
        size(displayWidth, displayHeight - 61, P2D);
    }

    public void draw() {
        background(0);
    }
}