package com.colin;

public class Tile extends CoordinateObject {

    public Tile(int x, int y) {
        setSpriteID("default");
        setSpritePrefix("tiles");
        setCoordinate(x, y);
        setPos((x * Map.TILE_SIZE) - ((getX() > 0) ? Map.HALF_TILE_SIZE : -Map.HALF_TILE_SIZE), (y * Map.TILE_SIZE) - ((getY() > 0) ? Map.HALF_TILE_SIZE : -Map.HALF_TILE_SIZE));
        setRenderPoint(getPos());
    }

    public void update() {

    }
}
