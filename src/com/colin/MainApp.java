package com.colin;

import com.colin.Sprites.SpriteManager;
import processing.core.PApplet;
import processing.opengl.PJOGL;

public class MainApp extends PApplet {

    public static PApplet applet;
    public static SpriteManager spriteManager;
    public static DeltaTime deltaTime;
    public static Screen screen;

    public static void main(String[] args) {
        String[] PApp = {"com.colin.MainApp"};
        PApplet.main(PApp);
    }

    public void setup() {
        applet = this;
        deltaTime = new DeltaTime();
        spriteManager = new SpriteManager();
        screen = new Screen(width, height);

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