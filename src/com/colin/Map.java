package com.colin;

public class Map {
    public static int MAP_SIZE_IN_REGIONS = 4;
    public static int REGION_SIZE_IN_CHUNKS = 16;
    public static int CHUNK_SIZE_IN_TILES = 16;
    public static int TILE_SIZE = 64;

    private Region[][] regions = new Region[MAP_SIZE_IN_REGIONS][MAP_SIZE_IN_REGIONS];

    public static int CHUNK_SIZE = CHUNK_SIZE_IN_TILES * TILE_SIZE;
    public static int REGION_SIZE = CHUNK_SIZE * REGION_SIZE_IN_CHUNKS;
    public static int MAP_SIZE = REGION_SIZE * MAP_SIZE_IN_REGIONS;

    public Map() {

    }

    public void update() {
        for(Region[] i : getRegions()) {
            for(Region j : i) {
                j.update();
            }
        }
    }

    public Region[][] getRegions() {
        return regions;
    }

    public Region getRegion(int x, int y) {
        return getRegions()[x][y];
    }
}
