package com.pocketbattles.game.UserInterface.Actors;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.UserInterface.UserInterface;

import java.util.ArrayList;

/**
 * Created by Boris on 25.08.2016.
 * Project: PocketBattlesV4
 */
public class TextButton extends com.badlogic.gdx.scenes.scene2d.ui.TextButton {
    public static ArrayList<TextButton> list;

    private String name;

    /** INITIALISING */

    public static void initialiseClass() {
        list = new ArrayList<TextButton>();
    }

    /** CREATING AND SETTING UP */

    public static TextButton addInstance(String name, String text, ClickListener clickListener) {
        TextButton button = new TextButton(text, UserInterface.skin);
        button.setUp(name);
        button.addListener(clickListener);

        list.add(button);

        return button;
    }

    public static TextButton addInstance(String name, String text, String style, ClickListener clickListener) {
        TextButton button = new TextButton(text, UserInterface.skin, style);
        button.setUp(name);
        button.addListener(clickListener);

        list.add(button);

        return button;
    }

    public static TextButton addInstance(String name, String text, int pad, ClickListener clickListener) {
        TextButton button = new TextButton(text, UserInterface.skin);
        button.setUp(name);
        button.addListener(clickListener);
        button.pad(pad);

        list.add(button);

        return button;
    }

    public static TextButton addInstance(String name, String text, String style, int pad, ClickListener clickListener) {
        TextButton button = new TextButton(text, UserInterface.skin, style);
        button.setUp(name);
        button.addListener(clickListener);
        button.pad(pad);

        list.add(button);

        return button;
    }

    public TextButton(String text, Skin skin, String styleName) {
        super(text, skin, styleName);
    }

    public TextButton(String text, Skin skin) {
        super(text, skin);
    }

    private void setUp(String name) {
        this.name = name;
        Game.stage.addActor(this);
    }

    /** UPDATING */

    /** GETTERS / SETTERS */

    public static TextButton getButton(String name) {
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

    /** INTERACTING */

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

    private void dispose() {
        this.clear();
        this.remove();
        this.name = null;
    }
}
