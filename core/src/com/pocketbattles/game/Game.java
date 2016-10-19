package com.pocketbattles.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pocketbattles.game.UserInterface.UserInterface;
import com.pocketbattles.game.Utilities.Utilities;

import java.util.ArrayList;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class Game {
    private static Preferences gamePreferences;
    public static Stage stage;
    public static int GOLD_AMOUNT;
    public static ArrayList<String> entityClassesNames;

    /** INITIALISING */

    public static void initialise() {
        gamePreferences = Gdx.app.getPreferences("GAME_PREFERENCES");
        stage = new Stage();
        Utilities.initialise();
        UserInterface.initialise();

        GOLD_AMOUNT = gamePreferences.getInteger("GOLD_AMOUNT", 10000);
        entityClassesNames = new ArrayList<String>();
        setEntityClassesNames();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        Utilities.create();
        Gdx.input.setInputProcessor(stage);
        UserInterface.create();
    }

    private static void setEntityClassesNames(){
        entityClassesNames.add("SWORDSMAN");
        entityClassesNames.add("ARCHER");
        entityClassesNames.add("WATCHTOWER");
        entityClassesNames.add("WALL");
        entityClassesNames.add("TREE");
    }

    /** UPDATING */

    public static void update() {
        Utilities.update();
        stage.act();
        UserInterface.update();
    }

    /** RENDERING */

    public static void render() {
        stage.draw();
        UserInterface.render();
    }

    /** DISPOSING */

    public static void dispose() {
        gamePreferences.putInteger("GOLD_AMOUNT", GOLD_AMOUNT);
        gamePreferences.flush();
        Utilities.dispose();
        UserInterface.dispose();
        stage.dispose();
    }
}
