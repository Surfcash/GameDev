package com.colin;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Collections;

public class Chunk extends CoordinateObject {

    private Tile[][] tiles = new Tile[Map.CHUNK_SIZE_IN_TILES][Map.CHUNK_SIZE_IN_TILES];
    private ArrayList<Tile> tilesOnCamera = new ArrayList<>();

    public Chunk(int x, int y) {
        setCoordinate(x, y);
        setPos((x * Map.CHUNK_SIZE) - ((getX() > 0) ? Map.HALF_CHUNK_SIZE : -Map.HALF_CHUNK_SIZE), (y * Map.CHUNK_SIZE) - ((getY() > 0) ? Map.HALF_CHUNK_SIZE : -Map.HALF_CHUNK_SIZE));
        init();
    }

    public void init() {
        int x, y;
        int startx = (getX() > 0) ? (getX() - 1) * Map.CHUNK_SIZE_IN_TILES + 1 : (getX() + 1) * Map.CHUNK_SIZE_IN_TILES - 1;
        int starty = (getY() > 0) ? (getY() - 1) * Map.CHUNK_SIZE_IN_TILES + 1 : (getY() + 1) * Map.CHUNK_SIZE_IN_TILES - 1;
        for(int i = 0; i < Map.CHUNK_SIZE_IN_TILES; i++) {
            x = (getX() > 0) ? startx + i : startx - i;
            for(int j = 0; j < Map.CHUNK_SIZE_IN_TILES; j++) {
                y = (getY() > 0) ? starty + j : starty - j;
                tiles[i][j] = new Tile(x, y);
            }
        }
    }

    public void updateTilesOnCamera() {
        tilesOnCamera.clear();
        for(Tile[] i : getTiles()) {
            for(Tile j : i) {
                if(MainApp.game.getCamera().coordinateOnCamera(j.getPos(), Map.HALF_TILE_SIZE)) {
                    tilesOnCamera.add(j);
                }
            }
        }
        if(getY() < 0) {
            Collections.reverse(tilesOnCamera);
        }
    }

    public void render() {
        for(Tile i : tilesOnCamera) {
            i.render();
        }
    }

    public void update() {
        updateTilesOnCamera();
        for(Tile i : tilesOnCamera) {
            i.update();
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return getTiles()[x][y];
    }

    public Tile getTile(PVector vec) {
        int x = PApplet.floor((PApplet.abs(vec.x) % Map.CHUNK_SIZE) / Map.TILE_SIZE);
        int y = PApplet.floor((PApplet.abs(vec.y) % Map.CHUNK_SIZE) / Map.TILE_SIZE);
        return getTile(x, y);
    }
}
