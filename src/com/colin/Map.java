package com.colin;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Map extends AppletObject{
    public static int MAP_SIZE_IN_REGIONS = 4;
    public static int REGION_SIZE_IN_CHUNKS = 16;
    public static int CHUNK_SIZE_IN_TILES = 16;
    public static int TILE_SIZE = 64;

    private Region[][] regions = new Region[MAP_SIZE_IN_REGIONS][MAP_SIZE_IN_REGIONS];
    public static ArrayList<Region> regionsOnCamera = new ArrayList<>();

    public static int CHUNK_SIZE = CHUNK_SIZE_IN_TILES * TILE_SIZE;
    public static int REGION_SIZE = CHUNK_SIZE * REGION_SIZE_IN_CHUNKS;
    public static int MAP_SIZE = REGION_SIZE * MAP_SIZE_IN_REGIONS;

    public static int HALF_TILE_SIZE = TILE_SIZE / 2;
    public static int HALF_CHUNK_SIZE = CHUNK_SIZE / 2;
    public static int HALF_REGION_SIZE = REGION_SIZE / 2;
    public static int HALF_MAP_SIZE = MAP_SIZE / 2;

    public static int HALF_MAP_SIZE_IN_REGIONS = MAP_SIZE_IN_REGIONS / 2;
    public static int HALF_REGION_SIZE_IN_CHUNKS = REGION_SIZE_IN_CHUNKS / 2;
    public static int HALF_CHUNK_SIZE_IN_TILES = CHUNK_SIZE_IN_TILES / 2;

    public Map() {
        init();
    }

    public void init() {
        long timePrevious = System.currentTimeMillis();
        int coordinateX, coordinateY;
        for(int i = 0; i < MAP_SIZE_IN_REGIONS; i++) {
            coordinateX = i - HALF_MAP_SIZE_IN_REGIONS;
            if(coordinateX >= 0) {
                coordinateX++;
            }
            for(int j = 0; j < MAP_SIZE_IN_REGIONS; j++) {
                coordinateY = j - HALF_MAP_SIZE_IN_REGIONS;
                if(coordinateY >= 0) {
                    coordinateY++;
                }
                regions[i][j] = new Region(coordinateX, coordinateY);
            }
        }
        PApplet.println("Map Initialization Complete! (" + ((System.currentTimeMillis() - timePrevious) / 1000F) + "s)");
    }

    public void updateRegionsOnCamera() {
        regionsOnCamera.clear();
        for(Region[] i : getRegions()) {
            for(Region j : i) {
                if (j.onCamera()) {
                    regionsOnCamera.add(j);
                }
            }
        }
    }

    public void render() {
        for(Region i : regionsOnCamera) {
            i.render();
        }
    }

    public void update() {
        updateRegionsOnCamera();
        for(Region i : regionsOnCamera) {
            i.update();
        }
    }

    public Region[][] getRegions() {
        return regions;
    }

    public Region getRegion(int x, int y) {
        return getRegions()[x][y];
    }

    public Region getRegion(PVector vec) {
        int x = PApplet.floor(vec.x / REGION_SIZE) + HALF_MAP_SIZE_IN_REGIONS;
        int y = PApplet.floor(vec.y / REGION_SIZE) + HALF_MAP_SIZE_IN_REGIONS;
        return getRegion(x, y);
    }
}
