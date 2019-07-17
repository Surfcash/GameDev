package com.colin;

import processing.core.PVector;

public abstract class CoordinateObject extends Renderable{
    private PVector pos;
    private int x, y;

    public CoordinateObject() {
        this(0, 0);
    }

    public CoordinateObject(float x, float y) {
        this(0, 0, null, null);
    }

    public CoordinateObject(float x, float y, String prefix, String id) {
        super(prefix, id);
        setPos(x, y);
    }

    public PVector getPos() {
        return new PVector(pos.x,pos.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPos(float x, float y) {
        this.pos = new PVector(x, y);
    }

    public void setPos(PVector vector) {
        setPos(vector.x, vector.y);
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addPos(float x, float y) {
        setPos(pos.x + x, pos.y + y);
    }

    public void addPos(PVector vector) {
        addPos(vector.x, vector.y);
    }

    public void subPos(float x, float y) {
        setPos(pos.x - x, pos.y - y);
    }

    public void subPos(PVector vector) {
        subPos(vector.x, vector.y);
    }

    public void addCoordinate(float x, float y) {
        this.x += x;
        this.y += y;
    }
}
