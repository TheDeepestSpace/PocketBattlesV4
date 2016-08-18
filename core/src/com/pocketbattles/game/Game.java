package com.pocketbattles.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pocketbattles.game.Utilities.Utilities;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class Game {
    public static Stage stage;

    /** INITIALISING */

    public static void initialise() {
        Utilities.initialise();
        stage = new Stage();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        Utilities.create();
        Gdx.input.setInputProcessor(stage);
    }

    /** UPDATING */

    public static void update() {
        Utilities.update();
        stage.act();
    }

    /** RENDERING */

    public static void render() {
        stage.draw();
    }

    /** DISPOSING */

    public static void dispose() {
        Utilities.dispose();
        stage.dispose();
    }
}
