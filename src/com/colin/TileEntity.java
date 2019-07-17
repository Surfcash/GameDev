package com.colin;

import processing.core.PVector;

import static com.colin.MainApp.game;

public class TileEntity extends Entity {

    enum TileEntities {
        TREE("tree", 76, 128),
        ;

        String name;
        int width, height;

        TileEntities(String name, int width, int height) {
            this.name = name;
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private TileEntities type;

    public TileEntity(float x, float y, String id, int width, int height) {
        super(x, y, id, width, height);
        setRenderPoint(getPos().x, getPos().y - height / 2F);
    }

    public TileEntity(float x, float y, TileEntities type) {
        this(x, y, type.name, type.width, type.height);
        setType(type);
    }

    public TileEntity(float x, float y) {
        this(x, y, "rock", 76, 128);
    }

    public TileEntities getType() {
        return type;
    }

    public void setType(TileEntities val) {
        type = val;
    }

    public static TileEntities getEntityType(String str) {
        for(TileEntities i : TileEntities.values()) {
            if(str.equals(i.name)) {
                return i;
            }
        }
        return null;
    }

    public boolean onCamera() {
        return MainApp.game.getCamera().coordinateOnCamera(getPos(), getWidth(), getHeight());
    }
}
