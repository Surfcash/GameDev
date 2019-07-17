package com.colin;

import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;

import static com.colin.MainApp.game;
import static com.colin.MainApp.spriteManager;

public class Renderable extends AppletObject {

    private String spritePrefix;
    private String spriteID;
    private int spriteIndex;
    private boolean hasSpritesheet;
    private PVector renderPoint;
    private int renderFrom = 3;

    public Renderable(String prefix, String id) {
        setSpritePrefix(prefix);
        setSpriteID(id);
        String sprite = getSpritePrefix() + "_" + getSpriteID();
        hasSpritesheet = spriteManager.hasSpriteSheet(sprite);
        setSpriteIndex(spriteManager.getSpriteIndex(sprite));
    }

    public void render() {
        if(getSpriteID() == null || getSpritePrefix() == null) {
            return;
        }
        getApplet().pushStyle();
        getApplet().imageMode(renderFrom());
        getApplet().image(getSprite(), getRenderPoint().x + game.getCamera().getRealPos().x, getRenderPoint().y + game.getCamera().getRealPos().y);
        getApplet().popStyle();
    }

    public PImage getSprite() {
        String sprite = getSpritePrefix() + "_" + getSpriteID();
        if(getSpriteIndex() == 0) {
            setSpriteIndex(spriteManager.getSpriteIndex(sprite));
        }
        return (hasSpritesheet()) ? spriteManager.getSpritesheet(sprite).getSprite() : spriteManager.getSprite(getSpriteIndex());
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

    public boolean hasSpritesheet() {
        return hasSpritesheet;
    }

    public int getSpriteIndex() {
        return spriteIndex;
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

    public void setSpriteIndex(int num) {
        spriteIndex = num;
    }
}
