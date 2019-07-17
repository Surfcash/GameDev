package com.colin;

import static com.colin.MainApp.game;

abstract class Entity extends CoordinateObject {

    private int width, height;

    public Entity(float x, float y, String id, int width, int height) {
        super(x, y, "entities", id);
        setSpriteID(id);
        setWidth(width);
        setHeight(height);
        setRenderPoint(getPos());
    }

    public void renderHighlight() {
        if (!hasHighlightedSprite()) {
            return;
        }
        getApplet().pushStyle();
        getApplet().imageMode(renderFrom());
        getApplet().image(getHighlightedSprite(), getRenderPoint().x + game.getCamera().getRealPos().x, getRenderPoint().y + game.getCamera().getRealPos().y);
        getApplet().popStyle();
    }

    public void renderSprite() {
        getApplet().pushStyle();
        getApplet().imageMode(renderFrom());
        getApplet().image(getSprite(), getRenderPoint().x + game.getCamera().getRealPos().x, getRenderPoint().y + game.getCamera().getRealPos().y);
        getApplet().popStyle();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int num) {
        width = num;
    }

    public void setHeight(int num) {
        height = num;
    }

    public boolean hasHighlightedSprite() {
       return getHighlightedSprite() != null;
    }

}