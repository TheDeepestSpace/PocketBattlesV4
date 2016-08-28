package com.pocketbattles.game.UserInterface.Screens.MainScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 23.08.2016.
 * Project: PocketBattlesV4
 */
public class UI {

    /** CREATING AND SETTING UP */

    public static void setUp() {
        UserInterface.screenTable.reset();
        UserInterface.screenTable.add(Label.addInstance("MAIN_SCREEN_TITLE", "POCKET BATTLES V4", "fancyFont64", Color.GREEN)).row();
        UserInterface.screenTable.add(TextButton.addInstance("MAIN_SCREEN_TEST_BUTTON", "TEST", 40, new ClickListener()));
    }
}
