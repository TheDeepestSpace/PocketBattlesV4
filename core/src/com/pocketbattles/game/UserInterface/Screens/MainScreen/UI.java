package com.pocketbattles.game.UserInterface.Screens.MainScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 23.08.2016.
 * Project: PocketBattlesV4
 */
public class UI {
    private static Table localScreenTable;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);
    }

    /** CREATING AND SETTING UP */

    public static void setUp() {
        localScreenTable.add(Label.addInstance("MAIN_SCREEN_TITLE", "POCKET BATTLES V4", "fancyFont64", Color.GREEN)).row();
        localScreenTable.add().height(40).row();
        Table mainMenuButtonsTable = new Table(UserInterface.skin);
        mainMenuButtonsTable.add(TextButton.addInstance("MAIN_SCREEN_START_BUTTON", "START", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PocketBattles.mainScreen.game.setGameScreen();
            }
        })).fill();
        mainMenuButtonsTable.add().width(40);
        mainMenuButtonsTable.add(TextButton.addInstance("MAIN_SCREEN_UPGRADE_BUTTON", "UPGRADE", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PocketBattles.mainScreen.game.setUpgradeScreen();
            }
        })).fill().row();
        mainMenuButtonsTable.add().height(40).row();
        mainMenuButtonsTable.add(TextButton.addInstance("MAIN_SCREEN_SETTINGS_BUTTON", "SETTINGS", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PocketBattles.mainScreen.game.setSettingsScreen();
            }
        })).fill();
        mainMenuButtonsTable.add();
        mainMenuButtonsTable.add(TextButton.addInstance("MAIN_SCREEN_EXIT_BUTTON", "EXIT", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        })).fill();
        localScreenTable.add(mainMenuButtonsTable);
    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** DISPOSING / RESETTING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
