package com.colin;

import processing.core.PImage;

public class Sprite {
    private PImage image;
    private String id;

    public Sprite(PImage img, String str) {
        setImage(img);
        setID(str);
    }

    public PImage getImage() {
        return image;
    }

    public String getID() {
        return id;
    }

    public void setImage(PImage img) {
        image = img;
    }

    public void setID(String str) {
        id = str;
    }

    public boolean equals(Sprite sprite) {
        return getID().equals(sprite.getID());
    }
}
