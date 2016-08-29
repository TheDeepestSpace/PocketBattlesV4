package com.pocketbattles.game.UserInterface.Screens.GameScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 29.08.2016.
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

    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** DISPOSING / RESETTING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
