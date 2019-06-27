package com.colin;

public class Region extends CoordinateObject {

    private static Chunk[][] chunks = new Chunk[Map.REGION_SIZE_IN_CHUNKS][Map.REGION_SIZE_IN_CHUNKS];


    public Region(int x, int y) {
        setCoordinate(x, y);
        setPos(x * Map.REGION_SIZE, y * Map.REGION_SIZE);
    }

    public void update() {
        for(Chunk[] i : getChunks()) {
            for(Chunk j : i) {
                j.update();
            }
        }
    }

    public Chunk[][] getChunks() {
        return chunks;
    }

    public Chunk getChunk(int x, int y) {
        return getChunks()[x][y];
    }
}
