package com.colin.Sprites;

import com.colin.AppletObject;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.util.ArrayList;

public final class SpriteManager extends AppletObject {

    private ArrayList<Sprite> sprites = new ArrayList<>();
    private ArrayList<Spritesheet> spritesheets = new ArrayList<>();

    public SpriteManager() {
        loadAssets();
    }

    public static PImage loadSprite(String filePath, String name, PApplet applet) {
        File folder = new File(applet.sketchPath(filePath));
        File[] files = folder.listFiles();
        PApplet.println("Loading '" + filePath + "/" + name + "...'");
        if (files != null) {
            for (File i : files) {
                String fileName = i.getName();
                int pos = fileName.lastIndexOf(".");
                fileName = pos > 0 ? fileName.substring(0, pos) : fileName;
                if (i.isFile()) {
                    if(fileName.equals(name)) {
                        System.out.println(fileName);
                        return applet.loadImage(i.getPath());
                    }
                    else {
                        System.out.println("File does not exist!");
                    }
                }
            }
        }
        return null;
    }

    private void loadSpritesFromFolder(String filePath, String prefix) {
        File folder = new File(getApplet().sketchPath(filePath));
        File[] files = folder.listFiles();
        PApplet.println("Loading Folder '" + filePath + "/...'" + " (Prefix " + prefix + ")");
        if (files != null) {
            for (File i : files) {
                String fileName = i.getName();
                String[] fileNameSections = PApplet.split(fileName, ".");
                String name = fileNameSections[0];
                String fileType = fileNameSections[fileNameSections.length - 1];
                //Proper image
                if(fileType.equals("png")) {
                    PImage img = getApplet().loadImage(i.getPath());
                    PApplet.print("Loading ");
                    //Sprite format
                    if(fileNameSections.length == 2) {
                        PApplet.println("Sprite: " + name);
                        sprites.add(new Sprite(img, prefix + "_" + name));
                    }
                    //Spritesheet format
                    else if(fileNameSections.length == 4) {
                        PApplet.println("Spritesheet: " + name);
                        spritesheets.add(new Spritesheet(prefix + "_" + name, Integer.parseInt(fileNameSections[1]), Integer.parseInt(fileNameSections[2]), img));
                    } else {
                        PApplet.println("Invalid Name");
                    }
                }
            }
        }
    }

    public void reload() {
        loadAssets();
    }

    private void loadAssets() {
        PApplet.println("-= Loading Sprite Assets =-");
        sprites.clear();
        long timePrevious = System.currentTimeMillis();
        loadSpritesFromFolder("assets", "assets");
        File folder = new File(getApplet().sketchPath("assets/sprites"));
        File[] files = folder.listFiles();
        if(files != null) {
            for(File i : files) {
                String fileName = i.getName();
                loadSpritesFromFolder(i.getPath(), fileName);
            }
        }
        PApplet.println("Asset Sprite Loading Complete! (" + ((System.currentTimeMillis() - timePrevious) / 1000F) + "s)");
    }

    public int getSpriteIndex(String str) {
        int num = 0;
        for(Sprite i : sprites) {
            if(i.getID().equals(str)) {
                return num;
            }
            num++;
        }
        return 0;
    }

    public PImage getSprite(String str) {
        for(Sprite i : sprites) {
            if(i.getID().equals(str)) {
                return i.getImage();
            }
        }
        return null;
    }

    public PImage getSprite(int num) {
        return sprites.get(num).getImage();
    }

    public Spritesheet getSpritesheet(String str) {
        for(Spritesheet i : spritesheets) {
            if(i.getID().equals(str + "_spritesheet")) {
                return i;
            }
        }
        return null;
    }

    public boolean hasSpriteSheet(String str) {
        for(Spritesheet i : spritesheets) {
            if(i.getID().equals(str + "_spritesheet")) {
                return true;
            }
        }
        return false;
    }
}