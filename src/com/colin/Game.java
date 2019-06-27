package com.colin;

public class Game {

    private String STARTING_TIME = "7:00";

    private Clock clock = new Clock(STARTING_TIME);
    private Map map = new Map();
    private Camera camera = new Camera(0, 0);

    public Game() {
    }

    public void frame() {
        update();
        render();
    }

    public void update() {
        getClock().update();
        getCamera().update();
        //getMap().update();
    }

    public void render() {

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
