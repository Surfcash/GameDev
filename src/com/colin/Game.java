package com.colin;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Game extends AppletObject{

    private String STARTING_TIME = "7:00";

    private Clock clock;
    private Map map;
    private Camera camera;
    private PGraphics scene = getApplet().createGraphics(PApplet.floor(MainApp.screen.getWidth()), PApplet.floor(MainApp.screen.getHeight()));

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
        long timePrevious = System.currentTimeMillis();
        getCamera().addPos(0.3F * MainApp.deltaTime.get(), 0);

        getClock().update();
        getCamera().update();
        getMap().update();

        float timePassed = (System.currentTimeMillis() - timePrevious) / 1000F;
        if(timePassed > 0.01) {
            PApplet.println("Update Lag: (" + timePassed + "s)");
        }
    }

    public void render() {
        long timePrevious = System.currentTimeMillis();
        getMap().render();

        float timePassed = (System.currentTimeMillis() - timePrevious) / 1000F;
        int regionsOnCamera;
        int chunksOnCamera = 0;
        int tilesOnCamera = 0;
        if(timePassed > 0.1) {
            PApplet.println("Render Lag: (" + timePassed + "s)");
            regionsOnCamera = Map.regionsOnCamera.size();
            for(Region i : Map.regionsOnCamera) {
                chunksOnCamera += i.chunksOnCamera.size();
                for(Chunk j : i.chunksOnCamera) {
                    tilesOnCamera += j.tilesOnCamera.size();
                }
            }
            PApplet.println("Regions: " + regionsOnCamera);
            PApplet.println("Chunks: " + chunksOnCamera);
            PApplet.println("Tiles: " + tilesOnCamera);
        }

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
        getApplet().text("Render Time: (" + ((System.currentTimeMillis() - timePrevious) / 1000F) + "s)", 50, 170);
        getApplet().text("Camera Pos: (" + getCamera().getPos().toString(), 50, 190);
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

    public PGraphics getScene() {
        return scene;
    }

    public void renderScene() {
        getApplet().image(getScene(), 0, 0);
    }
}
