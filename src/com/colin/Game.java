package com.colin;

public class Game extends AppletObject{

    private String STARTING_TIME = "7:00";

    private Clock clock;
    private Map map;
    private Camera camera;

    public Game() {
        clock = new Clock(STARTING_TIME);
        camera = new Camera(0, 0);
        map = new Map();
    }

    public void frame() {
        update();
        render();
    }

    public void update() {
        getClock().update();
        getCamera().update();
        getMap().update();
    }

    public void render() {
        getMap().render();

        getApplet().fill(128, 255, 128);
        getApplet().text(getApplet().frameRate, 50, 50);
    }

    public Clock getClock() {
        return clock;
    }

    public Map getMap() {
        return map;
    }

    public Camera getCamera() {
        return camera;
    }
}
