package com.colin;

import processing.core.PVector;

public class Screen {

    private PVector dimensions;
    private PVector center;

    public Screen(float x, float y) {
        setDimensions(x, y);
        setCenter(x / 2F, y / 2F);
    }

    public PVector getDimensions() {
        return dimensions;
    }

    public float getWidth() {
        return getDimensions().x;
    }

    public float getHeight() {
        return getDimensions().y;
    }

    public PVector getCenter() {
        return center;
    }

    public void setDimensions(float x, float y) {
        dimensions = new PVector(x, y);
    }

    public void setDimensions(PVector vec) {
        setDimensions(vec.x, vec.y);
    }

    public void setCenter(float x, float y) {
        center = new PVector(x, y);
    }

    public void setCenter(PVector vec) {
        setCenter(vec.x, vec.y);
    }

    public boolean offScreen(PVector vec) {
        return( (vec.x > getHeight()) ||
                (vec.x < 0) ||
                (vec.y > getHeight()) ||
                (vec.y < 0));
    }

    public boolean offScreen(PVector vec, int radius) {
        PVector v1 = new PVector(vec.x + radius, vec.y);
        PVector v2 = new PVector(vec.x - radius, vec.y);
        PVector v3 = new PVector(vec.x, vec.y - radius);
        PVector v4 = new PVector(vec.x, vec.y + radius);

        return (!offScreen(v1) || !offScreen(v2) || !offScreen(v3) || !offScreen(v4));
    }
}
