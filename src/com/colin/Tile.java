package com.colin;

import processing.core.PApplet;

public class Tile extends CoordinateObject {

    private TileEntity entity;

    public Tile(int x, int y) {
        super(x, y, "tiles", "grass");
        setCoordinate(x, y);
        setPos((x * Map.TILE_SIZE) - ((getX() > 0) ? Map.HALF_TILE_SIZE : -Map.HALF_TILE_SIZE), (y * Map.TILE_SIZE) - ((getY() > 0) ? Map.HALF_TILE_SIZE : -Map.HALF_TILE_SIZE));
        setRenderPoint(getPos());
        setEntity(new TileEntity(getPos().x, getPos().y));
    }

    public void render() {
        super.render();
        if(hasEntity()) {
            getEntity().render();
        }
    }

    public TileEntity getEntity() {
        return entity;
    }

    public void setEntity(TileEntity obj) {
        entity = obj;
    }

    public boolean hasEntity() {
        return getEntity() != null;
    }

    public boolean onCamera() {
        boolean tileOnCamera = MainApp.game.getCamera().coordinateOnCamera(getPos(), Map.HALF_TILE_SIZE);
        return (hasEntity()) ? (hasEntity() && getEntity().onCamera()) || tileOnCamera : tileOnCamera;
    }
}
