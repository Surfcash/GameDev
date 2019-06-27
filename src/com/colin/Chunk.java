package com.colin;

public class Chunk extends CoordinateObject {

    private static Tile[][] tiles = new Tile[Map.CHUNK_SIZE_IN_TILES][Map.CHUNK_SIZE_IN_TILES];

    public Chunk(int x, int y) {
        setCoordinate(x, y);
        setPos(x * Map.CHUNK_SIZE, y * Map.CHUNK_SIZE);
    }

    public void update() {
        for(Tile[] i : tiles) {
            for(Tile j : i) {
                j.update();
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return getTiles()[x][y];
    }
}
