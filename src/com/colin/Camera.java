package com.colin;

import processing.core.PApplet;
import processing.core.PVector;

public class Camera extends PhysicsObject{

    private static PVector CAMERA_FRICTION = new PVector(2.5F, 2.5F);

    private PVector camBorder;
    private PVector realPosition;

    public Camera(float x, float y) {
        super(x, y);
        setRealPos(MainApp.screen.getCenter().x, MainApp.screen.getCenter().y);
        setCamBorder(Map.MAP_SIZE - MainApp.screen.getCenter().x, Map.MAP_SIZE - MainApp.screen.getCenter().y);
    }

    @Override
    public void render() {
    }

    public void update() {
        float fixedX = PApplet.constrain(getPos().x, -getCamBorder().x, getCamBorder().x) - getPos().x;
        float fixedY = PApplet.constrain(getPos().y, -getCamBorder().y, getCamBorder().y) - getPos().y;
        addPos(fixedX, fixedY);
    }

    public PVector getCamBorder() {
        return camBorder;
    }

    public PVector getRealPos() {
        return realPosition;
    }

    public void setCamBorder(float x, float y) {
        camBorder = new PVector(x, y);
    }

    public void setRealPos(float x, float y) {
        realPosition = new PVector(x, y);
    }

    @Override
    public void addPos(float x, float y) {
      super.addPos(x, y);
      setRealPos(getRealPos().x + x, getRealPos().y + y);
    }

    @Override
    public void subPos(float x, float y) {
        super.subPos(x, y);
        setRealPos(getRealPos().x - x, getRealPos().y - y);
    }

    public boolean coordinateOffCamera(CoordinateObject obj, int radius) {
        PVector trueLoc = new PVector(obj.getPos().x + getRealPos().x, obj.getPos().y + getRealPos().y);
        return MainApp.screen.offScreen(trueLoc, radius);
    }

    @Override
    public String toString() {
        return "Camera: ( " +  PApplet.floor(getPos().x) + ", " + PApplet.floor(getPos().y) + " )" + " ( " + PApplet.floor(getCamBorder().x) + ", " + PApplet.floor(getCamBorder().y) + " )";
    }
}
