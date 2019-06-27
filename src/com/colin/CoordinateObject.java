package com.colin;

import processing.core.PVector;

import java.util.ArrayList;

public abstract class CoordinateObject extends Renderable{
    private PVector pos;
    private int x, y;

    public static ArrayList<CoordinateObject> coordinateObjects = new ArrayList<>();

    public CoordinateObject() {
        setPos(0, 0);
        coordinateObjects.add(this);
    }

    public CoordinateObject(float x, float y) {
        setPos(x, y);
        coordinateObjects.add(this);
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
