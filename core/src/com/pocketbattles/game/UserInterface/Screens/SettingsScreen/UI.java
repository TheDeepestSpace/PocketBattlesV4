package com.pocketbattles.game.UserInterface.Screens.SettingsScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 28.08.2016.
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
        localScreenTable.add(Label.addInstance("SETTINGS_SCREEN_TITLE", "SETTINGS", "fancyFont32", Color.GREEN)).row();
        localScreenTable.add().height(300).row();
        localScreenTable.add(TextButton.addInstance("SETTINGS_SCREEN_BACK_TO_MAIN_SCREEN_BUTTON", "BACK", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PocketBattles.settingsScreen.game.setMainScreen();
            }
        }));
    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** DISPOSING / RESETTING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
