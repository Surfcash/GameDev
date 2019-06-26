package com.colin;

import processing.core.PApplet;
import processing.opengl.PJOGL;

public class MainApp extends PApplet {

    public static PApplet applet;
    public static SpriteManager spriteManager;
    public static DeltaTime deltaTime;

    public static void main(String[] args) {
        String[] PApp = {"com.colin.MainApp"};
        PApplet.main(PApp);
    }

    public void setup() {
        applet = this;
        deltaTime = new DeltaTime();
        spriteManager = new SpriteManager();

        surface.setTitle("Colin's Workspace");
        surface.setResizable(false);
        surface.setLocation(-3, -3);
    }

    public void settings() {
        size(displayWidth, displayHeight - 61, P2D);
        PJOGL.setIcon(sketchPath("assets/icon.png"));
    }

    public void draw() {
        deltaTime.update();
        background(0);
    }
}