package com.colin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import static com.colin.MainApp.game;
import static com.colin.MainApp.spriteManager;

public abstract class Renderable extends AppletObject {

    private String spritePrefix;
    private String spriteID;
    private PVector renderPoint;
    private int renderFrom = 3;

    public void render() {
        getApplet().pushStyle();
        getApplet().imageMode(renderFrom());
        getApplet().image(getSprite(), getRenderPoint().x + game.getCamera().getRealPos().x, getRenderPoint().y + game.getCamera().getRealPos().y);
        getApplet().popStyle();
    }

    public abstract void update();

    public PImage getSprite() {
        String sprite = getSpritePrefix() + "_" + getSpriteID();
        return (spriteManager.hasSpriteSheet(sprite)) ? spriteManager.getSpritesheet(sprite).getSprite() : spriteManager.getSprite(sprite);
    }

    public PImage getHighlightedSprite() {
        return spriteManager.getSprite(getSpritePrefix() + getSpriteID() + "_highlighted");
    }

    public String getSpritePrefix() {
        return spritePrefix;
    }

    public String getSpriteID() {
        return spriteID;
    }

    public PVector getRenderPoint() {
        return renderPoint;
    }

    public int renderFrom() {
        return renderFrom;
    }

    public void setSpritePrefix(String str) {
        spritePrefix = str;
    }

    public void setSpriteID(String str) {
        spriteID = str;
    }

    public void setRenderPoint(float x, float y) {
        renderPoint = new PVector(x, y);
    }

    public void setRenderPoint(PVector vec) {
        setRenderPoint(vec.x, vec.y);
    }

    public void setRenderFrom(int num) {
        renderFrom = num;
    }
}
