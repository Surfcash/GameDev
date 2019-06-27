package com.colin;

public class Tile extends CoordinateObject {

    public Tile(int x, int y) {
        setCoordinate(x, y);
        setPos(x * Map.CHUNK_SIZE, y * Map.CHUNK_SIZE);
    }

    public void update() {

    }
}
