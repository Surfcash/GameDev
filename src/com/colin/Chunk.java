package com.colin;

import processing.core.PApplet;

import java.util.ArrayList;

public class Chunk extends CoordinateObject {

    private Tile[][] tiles = new Tile[Map.CHUNK_SIZE_IN_TILES][Map.CHUNK_SIZE_IN_TILES];
    private ArrayList<Tile> tilesOnCamera = new ArrayList<>();

    public Chunk(int x, int y) {
        setCoordinate(x, y);
        setPos((x * Map.CHUNK_SIZE) - ((getX() > 0) ? Map.HALF_CHUNK_SIZE : -Map.HALF_CHUNK_SIZE), (y * Map.CHUNK_SIZE) - ((getY() > 0) ? Map.HALF_CHUNK_SIZE : -Map.HALF_CHUNK_SIZE));
        init();
    }

    public void init() {
        int coordinateX = getX() * Map.CHUNK_SIZE_IN_TILES;
        int coordinateY = getY() * Map.CHUNK_SIZE_IN_TILES;
        for(int i = 0; i < Map.CHUNK_SIZE_IN_TILES; i++) {
            for(int j = 0; j < Map.CHUNK_SIZE_IN_TILES; j++) {
                tiles[i][j] = new Tile(coordinateX, coordinateY);
                coordinateY++;
            }
            coordinateX++;
            coordinateY = getY() * Map.CHUNK_SIZE_IN_TILES;
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
}
