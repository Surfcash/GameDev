package com.colin;

import processing.core.PApplet;
import processing.core.PVector;

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

        PVector mouseLocation = new PVector(getApplet().mouseX - PApplet.floor(getCamera().getRealPos().x), PApplet.floor(getApplet().mouseY - getCamera().getRealPos().y));
        Region hoveredRegion = map.getRegion(mouseLocation);
        Chunk hoveredChunk = hoveredRegion.getChunk(mouseLocation);
        Tile hoveredTile = hoveredChunk.getTile(mouseLocation);

        getApplet().fill(255);
        getApplet().text(getApplet().frameRate, 50, 50);
        getApplet().text(hoveredRegion.getX() + ", " + hoveredRegion.getY(), 50, 70);
        getApplet().text(hoveredChunk.getX() + ", " + hoveredChunk.getY(), 50, 90);
        getApplet().text(hoveredTile.getX() + ", " + hoveredTile.getY(), 50, 110);
        getApplet().text(getApplet().mouseX - PApplet.floor(getCamera().getRealPos().x) + ", " + PApplet.floor(getApplet().mouseY - getCamera().getRealPos().y), 50, 130);
        getApplet().text(MainApp.deltaTime.get(), 50, 150);
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
