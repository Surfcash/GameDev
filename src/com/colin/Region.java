package com.colin;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.Collections;

public class Region extends CoordinateObject {

    private Chunk[][] chunks = new Chunk[Map.REGION_SIZE_IN_CHUNKS][Map.REGION_SIZE_IN_CHUNKS];
    private ArrayList<Chunk> chunksOnCamera = new ArrayList<>();


    public Region(int x, int y) {
        setCoordinate(x, y);
        setPos((x * Map.REGION_SIZE) - ((getX() > 0) ? Map.HALF_REGION_SIZE : -Map.HALF_REGION_SIZE), (y * Map.REGION_SIZE) - ((getY() > 0) ? Map.HALF_REGION_SIZE : -Map.HALF_REGION_SIZE));
        init();
    }

    public void init() {
        int x, y;
        int startx = (getX() > 0) ? (getX() - 1) * Map.REGION_SIZE_IN_CHUNKS + 1 : (getX() + 1) * Map.REGION_SIZE_IN_CHUNKS - 1;
        int starty = (getY() > 0) ? (getY() - 1) * Map.REGION_SIZE_IN_CHUNKS + 1 : (getY() + 1) * Map.REGION_SIZE_IN_CHUNKS - 1;
        for(int i = 0; i < Map.REGION_SIZE_IN_CHUNKS; i++) {
            x = (getX() > 0) ? startx + i : startx - i;
            for(int j = 0; j < Map.REGION_SIZE_IN_CHUNKS; j++) {
                y = (getY() > 0) ? starty + j : starty - j;
                chunks[i][j] = new Chunk(x, y);
            }
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
        if(getY() < 0) {
            Collections.reverse(chunksOnCamera);
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

    public Chunk getChunk(PVector vec) {
        int x = PApplet.floor((PApplet.abs(vec.x) % Map.REGION_SIZE) / Map.CHUNK_SIZE);
        int y = PApplet.floor((PApplet.abs(vec.y) % Map.REGION_SIZE) / Map.CHUNK_SIZE);
        return getChunk(x, y);
    }
}
