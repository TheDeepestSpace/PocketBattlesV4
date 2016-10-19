package com.pocketbattles.game.UserInterface.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.UserInterface.UserInterface;

import java.util.ArrayList;

/**
 * Created by Boris on 22.08.2016.
 * Project: PocketBattlesV4
 */
public class Label extends com.badlogic.gdx.scenes.scene2d.ui.Label {
    public static ArrayList<Label> list;

    private String name;

    /** INITIALISING */

    public static void initialiseClass() {
        list = new ArrayList<Label>();
    }

    /** CREATING AND SETTING UP */

    public static Label addInstance(
            String name, Vector2 position, String fontName, Color textColor
    ) {
        if (nameAvailable(name)) {
            Label l = new Label("n/a", UserInterface.skin, fontName, textColor);
            l.setPosition(position.x, position.y);
            l.setUp(name);
            list.add(l);
            return l;
        }else return null;
    }

    public static Label addInstance(
            String name, String text, Vector2 position, String fontName, Color textColor
    ) {
        if (nameAvailable(name)) {
            Label l = new Label(text, UserInterface.skin, fontName, textColor);
            l.setPosition(position.x, position.y);
            l.setUp(name);
            list.add(l);
            return l;
        }else return null;
    }

    public static Label addInstance(String name, String fontName, Color textColor) {
        if (nameAvailable(name)) {
            Label l = new Label("n/a", UserInterface.skin, fontName, textColor);
            l.setUp(name);
            list.add(l);
            return l;
        }else return null;
    }

    public static Label addInstance(String name, String text, String fontName, Color textColor) {
        if (nameAvailable(name)) {
            Label l = new Label(text, UserInterface.skin, fontName, textColor);
            l.setUp(name);
            list.add(l);
            return l;
        }else return null;
    }

    private Label(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    private void setUp(String name) {
        this.name = name;
        Game.stage.addActor(this);
    }

    /** UPDATING */

    public void update(String text) {
        setText(text);
    }

    /** INTERACTING */

    /** GETTERS / SETTERS */

    public static Label getLabel(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(name)) {
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

    /** RENDERING */

    /** DISPOSING / RESETTING */

    public static void disposeClass() {
        list.clear();
    }

    public static void disposeInstances() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).dispose();
        }
    }

    public static void disposeInstance(String name) {
        getLabel(name).dispose();
    }

    private void dispose() {
        this.clear();
        this.remove();
        list.remove(this);
        this.name = null;
    }
}
