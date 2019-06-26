package com.colin.Sprites;

import processing.core.PImage;


public class Spritesheet {

    private String id;
    private PImage[] sprites;
    private int width;
    private int height;
    private int animationState;

    Spritesheet(String str, int width, int height, PImage spritesheet) {
        setID(str);
        setWidth(width);
        setHeight(height);
        sprites = new PImage[getWidth() * getHeight()];
        int spriteCount = 0;
        int spriteWidth = spritesheet.width / getWidth();
        int spriteHeight = spritesheet.height / getHeight();
        for(int i = 0; i < getWidth(); i++) {
            for(int j = 0; j < getHeight(); j++) {
                sprites[spriteCount] = spritesheet.get(i * spriteWidth, j * spriteHeight, spriteWidth, spriteHeight);
                spriteCount++;
            }
        }
    }

    //Returns sprite from specified animation state
    public PImage getSprite(int num) {
        return sprites[num];
    }

    //Returns sprite from current animation state
    public PImage getSprite() {
        return sprites[animationState];
    }

    public PImage[] getSprites() {
        return sprites;
    }

    public String getID() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int getAnimationState() {
        return animationState;
    }

    private void setID(String str) {
        id = str;
    }

    public void setWidth(int num) {
        width = num;
    }

    public void setHeight(int num) {
        height = num;
    }

    private void setAnimationState(int num) {
        animationState = num;
    }

    public void nextAnimationState() {
        if (getAnimationState() < getSprites().length) {
            setAnimationState(getAnimationState() + 1);
        } else {
            setAnimationState(0);
        }
    }

    public boolean equals(Spritesheet spritesheet) {
        return getID().equals(spritesheet.getID());
    }
}
