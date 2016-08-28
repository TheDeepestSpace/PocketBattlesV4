package com.pocketbattles.game.UserInterface.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pocketbattles.game.PocketBattles;

/**
 * Created by Boris on 23.08.2016.
 * Project: PocketBattlesV4
 */
public class Screen implements ScreenInterface {

    public PocketBattles game;
    public Screen(PocketBattles game) {
        this.game = game;
        this.initialise();
    }

    @Override
    public void initialise() {

    }

    @Override
    public void show() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        this.update(delta);
        clear();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void dispose() {

    }

    public static void clear() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl20.glEnable(GL20.GL_BLEND);
        Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl20.glEnable(GL20.GL_TEXTURE_2D);
        Gdx.gl20.glBlendEquation(GL20.GL_BLEND);
    }
}
