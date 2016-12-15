package com.pocketbattles.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pocketbattles.game.Actors.Actors;
import com.pocketbattles.game.Actors.Entity.Base.ReflectionUtility;
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
        stage.setDebugAll(false);
        Utilities.initialise();
        Actors.initialise();
        UserInterface.initialise();

        GOLD_AMOUNT = gamePreferences.getInteger("GOLD_AMOUNT", 10000);
        entityClassesNames = new ArrayList<String>();
        setEntityClassesNames();
        ReflectionUtility.initilaise();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        Utilities.create();
        Gdx.input.setInputProcessor(stage);
        Actors.create();
        UserInterface.create();
    }

    private static void setEntityClassesNames(){
        entityClassesNames.add("SWORDSMAN");
    }

    /** UPDATING */

    public static void update() {
        Utilities.update();
        stage.act();
        Actors.update();
        UserInterface.update();
    }

    /** RENDERING */

    public static void render() {
        stage.draw();
        Actors.render();
        UserInterface.render();
    }

    /** DISPOSING */

    public static void dispose() {
        gamePreferences.putInteger("GOLD_AMOUNT", GOLD_AMOUNT);
        gamePreferences.flush();
        Utilities.dispose();
        Actors.dispose();
        UserInterface.dispose();
        stage.dispose();
    }
}
