package com.colin;

import processing.core.PApplet;

import java.util.ArrayList;

public class Region extends CoordinateObject {

    private Chunk[][] chunks = new Chunk[Map.REGION_SIZE_IN_CHUNKS][Map.REGION_SIZE_IN_CHUNKS];
    private ArrayList<Chunk> chunksOnCamera = new ArrayList<>();


    public Region(int x, int y) {
        setCoordinate(x, y);
        setPos((x * Map.REGION_SIZE) - ((getX() > 0) ? Map.HALF_REGION_SIZE : -Map.HALF_REGION_SIZE), (y * Map.REGION_SIZE) - ((getY() > 0) ? Map.HALF_REGION_SIZE : -Map.HALF_REGION_SIZE));
        init();
    }

    public void init() {
        int coordinateX = getX() * Map.REGION_SIZE_IN_CHUNKS;
        int coordinateY = getY() * Map.REGION_SIZE_IN_CHUNKS;
        for(int i = 0; i < Map.REGION_SIZE_IN_CHUNKS; i++) {
            for(int j = 0; j < Map.REGION_SIZE_IN_CHUNKS; j++) {
                chunks[i][j] = new Chunk(coordinateX, coordinateY);
                coordinateY = (getY() > 0) ? coordinateY - 1 : coordinateY + 1;
            }
            coordinateX = (getX() > 0) ? coordinateX - 1 : coordinateX + 1;
            coordinateY = getY() * Map.REGION_SIZE_IN_CHUNKS;
        }
    }

    public void updateChunksOnCamera() {
        chunksOnCamera.clear();
        for(Chunk[] i : getChunks()) {
            for(Chunk j : i) {
                if(MainApp.game.getCamera().coordinateOnCamera(j.getPos(), Map.HALF_CHUNK_SIZE)) {
                    chunksOnCamera.add(j);
                }
            }
        }
    }

    public void render() {
        for(Chunk i : chunksOnCamera) {
            i.render();
        }
    }

    public void update() {
        updateChunksOnCamera();
        for(Chunk i : chunksOnCamera) {
            i.update();
        }
    }

    public Chunk[][] getChunks() {
        return chunks;
    }

    public Chunk getChunk(int x, int y) {
        return getChunks()[x][y];
    }
}
