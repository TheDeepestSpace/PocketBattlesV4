package com.pocketbattles.game.UserInterface.Screens.SettingsScreen;

import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Screens.Screen;

/**
 * Created by Boris on 28.08.2016.
 * Project: PocketBattlesV4
 */
public class SettingsScreen extends Screen {

    /** INITIALISING */

    public SettingsScreen(PocketBattles game) {
        super(game);
    }

    @Override
    public void initialise() {
        super.initialise();
        UI.initialise();
        UI.setUp();
    }

    /** CREATING AND SETTING UP */

    @Override
    public void show() {
        super.show();
        UI.set();
    }

    /** UPDATING */

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    /** RENDERING */

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    /** INTERACTING */

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    /** DISPOSING */

    @Override
    public void dispose() {
        super.dispose();
        UI.dispose();
    }
}
