package com.pocketbattles.game.UserInterface.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.ArrayList;

/**
 * Created by Boris on 29.08.2016.
 * Project: PocketBattlesV4
 */
public class Image extends com.badlogic.gdx.scenes.scene2d.ui.Image {
    public static ArrayList<Image> list;

    private String name;

    /** INITIALISING */

    public static void initialiseClass() {
        list = new ArrayList<Image>();
    }

    /** CREATING AND SETTING UP */

    public static Image addInstance(String name, String path) {
        if (nameAvailable(name)) {
            Texture t = new Texture(Gdx.files.internal(path));
            Image i = new Image(t);
            i.setUp(name);
            list.add(i);
            return i;
        }else return null;
    }

    Image(Texture texture) {
        super(texture);
    }

    private void setUp(String name) {
        this.name = name;
        this.setScale(1f, 1f);
    }

    /** UPDATING */

    /** INTERACTING */

    /** GETTERS / SETTERS */

    public static Image getImage(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).name)) {
                return list.get(i);
            }
        }

        return null;
    }

    private static boolean nameAvailable(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).name)) return false;
        }

        return true;
    }

    public void setTexture(String path) {
        Texture t = new Texture(path);
        this.setWidth(t.getWidth());
        this.setHeight(t.getHeight());
        this.setDrawable(new SpriteDrawable(new Sprite(t)));
    }

    public void setTexture(String path, float scale) {
        Texture t = new Texture(path);
        this.setWidth(t.getWidth());
        this.setHeight(t.getHeight());
        this.setDrawable(new SpriteDrawable(new Sprite(t)));
        this.getDrawable().setMinWidth(t.getWidth() * scale);
        this.getDrawable().setMinHeight(t.getHeight() * scale);
    }

    /** RENDERING */

    /** DISPOSING */

    public static void disposeClass() {
        list.clear();
    }

    public static void disposeInstances() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).dispose();
        }
    }

    public static void disposeInstance(String name) {
        getImage(name).dispose();
    }

    private void dispose() {
        this.clear();
        this.remove();
        this.name = null;
    }
}
