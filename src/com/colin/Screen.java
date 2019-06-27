package com.colin;

import processing.core.PApplet;
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

    public boolean onScreen(PVector vec, int radX, int radY) {
        boolean topOfScreen = 0 > vec.y + radY;
        boolean bottomOfScreen = getHeight() < vec.y - radY;
        boolean leftOfScreen = 0 > vec.x + radX;
        boolean rightOfScreen = getWidth() < vec.x - radX;

        //PApplet.println("Item is above top of screen: " + topOfScreen + " (" + 0 + ", " + (vec.y + radY) + ")");
        //PApplet.println("Item is below bottom of screen: " + bottomOfScreen + " (" + getHeight() + ", " + (vec.y - radY) + ")");
        //PApplet.println("Item is left of screen: " + leftOfScreen + " (" + 0 + ", " + (vec.x + radX) + ")");
        //PApplet.println("Item is right of screen: " + rightOfScreen + " (" + getWidth() + ", " + (vec.x - radX) + ")");

        if (0 > vec.y + radY || getHeight() < vec.y - radY) {
            return false;
        }
        if (0 > vec.x + radX || getWidth() < vec.x - radX) {
            return false;
        }
        return true;
    }
}
