package com.pocketbattles.game.Utilities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class Utilities {
    public static SpriteBatch spriteBatch;

    /** INITIALISING */

    public static void initialise() {
        spriteBatch = new SpriteBatch();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        spriteBatch.enableBlending();
    }

    /** UPDATING */

    public static void update() {

    }

    /** DISPOSING */

    public static void dispose() {
        spriteBatch.dispose();
    }
}
