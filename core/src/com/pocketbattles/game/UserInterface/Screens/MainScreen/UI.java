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
    private static Table mainMenuButtonsTable;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);
        mainMenuButtonsTable = new Table(UserInterface.skin);
    }

    /** CREATING AND SETTING UP */

    public static void setUp() {
        addTitle();
        localScreenTable.add().height(40).row();
        addStartButton();
        mainMenuButtonsTable.add().width(40);
        addUpgradeButton();
        mainMenuButtonsTable.add().height(40).row();
        addSettingsButton();
        mainMenuButtonsTable.add();
        addExitButton();

        localScreenTable.add(mainMenuButtonsTable);
    }

    private static void addTitle() {
        localScreenTable.add(
                Label.addInstance(
                        "MAIN_SCREEN_TITLE",
                        "POCKET BATTLES V4",
                        "fancyFont64",
                        Color.GREEN
                )
        ).row();
    }

    private static void addStartButton() {
        mainMenuButtonsTable.add(
                TextButton.addInstance(
                        "MAIN_SCREEN_START_BUTTON",
                        "START",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                PocketBattles.mainScreen.game.setGameScreen();
                            }
                        }
                )
        ).fill();
    }

    private static void addUpgradeButton() {
        mainMenuButtonsTable.add(
                TextButton.addInstance(
                        "MAIN_SCREEN_UPGRADE_BUTTON",
                        "UPGRADE",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                PocketBattles.mainScreen.game.setUpgradeScreen();
                            }
                        }
                )
        ).fill().row();
    }

    private static void addSettingsButton() {
        mainMenuButtonsTable.add(
                TextButton.addInstance(
                        "MAIN_SCREEN_SETTINGS_BUTTON",
                        "SETTINGS",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                PocketBattles.mainScreen.game.setSettingsScreen();
                            }
                        }
                )
        ).fill();
    }

    private static void addExitButton() {
        mainMenuButtonsTable.add(
                TextButton.addInstance(
                        "MAIN_SCREEN_EXIT_BUTTON",
                        "EXIT",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                Gdx.app.exit();
                            }
                        }
                )
        ).fill();
    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** DISPOSING / RESETTING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
