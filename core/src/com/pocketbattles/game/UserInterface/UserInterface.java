package com.pocketbattles.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class UserInterface {
    public static BitmapFont defaultFont;
    private static String defaultFontPath;

    /** INITIALISING */

    public static void initialise() {
        defaultFontPath = "UserInterface/Fonts/defaultFont/defaultFont.fnt";
        defaultFont = new BitmapFont(Gdx.files.internal(defaultFontPath));
    }

    /** CREATING AND SETTING UP */

    public static void create() {

    }

    /** UPDATING */

    public static void update() {

    }

    /** RENDERING */

    public static void render() {

    }

    /** DISPOSING */

    public static void dispose() {
        defaultFont.dispose();
    }
}
