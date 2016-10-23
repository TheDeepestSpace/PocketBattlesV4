package com.pocketbattles.game.UserInterface.Screens.UpgradeScreen;

import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Screens.Screen;

/**
 * Created by Boris on 28.08.2016.
 * Project: PocketBattlesV4
 */
public class UpgradeScreen extends Screen {

    /** INITIALISING */

    public UpgradeScreen(PocketBattles game) {
        super(game);
    }

    @Override
    public void initialise() {
        super.initialise();
        UItest.initialise();
        UItest.setUp();
    }

    /** CREATING AND SETTING UP */

    @Override
    public void show() {
        super.show();
        UItest.set();
    }

    /** UPDATING */

    @Override
    public void update(float delta) {
        super.update(delta);
        UItest.update();
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
        UItest.dispose();
    }
}
