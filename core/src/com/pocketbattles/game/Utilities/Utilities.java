package com.pocketbattles.game.Utilities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class Utilities {
    public static SpriteBatch spriteBatch;
    public static Random random;

    /** INITIALISING */

    public static void initialise() {
        spriteBatch = new SpriteBatch();
        random = new Random(System.nanoTime());
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
