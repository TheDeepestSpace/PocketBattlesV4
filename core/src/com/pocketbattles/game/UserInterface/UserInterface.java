package com.pocketbattles.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.UserInterface.Actors.Label;

/**
 * Created by Boris on 16.08.2016.
 * Project: PocketBattlesV4
 */
public class UserInterface {
    public static BitmapFont defaultFont;
    public static TextureAtlas atlas;
    public static Skin skin;

    public static Table screenTable, globalTable;

    /** INITIALISING */

    public static void initialise() {
        String defaultFontPath = "UserInterface/Fonts/defaultFont/font16.fnt";
        defaultFont = new BitmapFont(Gdx.files.internal(defaultFontPath));
        String atlasPath = "UserInterface/Atlas/atlas.pack";
        atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
        String skinPath = "UserInterface/Skin/skin.json";
        skin = new Skin(Gdx.files.internal(skinPath), atlas);

        initialiseUIActors();

        screenTable = new Table(skin);
        globalTable = new Table(skin);
    }

    private static void initialiseUIActors() {
        Label.initialiseClass();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        screenTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Game.stage.addActor(screenTable);

        globalTable.setBounds(0, Gdx.graphics.getHeight() - 300, Gdx.graphics.getWidth(), 300);
        Game.stage.addActor(globalTable);
        globalTable.add(Label.addInstance("GLOBAL_JAVA_HEAP", "defaultFont64", Color.GREEN)).row();
        globalTable.add(Label.addInstance("GLOBAL_FPS", "defaultFont64", Color.GREEN));
    }

    /** UPDATING */

    public static void update() {
        Label.getLable("GLOBAL_JAVA_HEAP").update("Java Heap: " + Gdx.app.getJavaHeap());
        Label.getLable("GLOBAL_FPS").update("FPS: " + Gdx.graphics.getFramesPerSecond());
    }

    /** RENDERING */

    public static void render() {

    }

    /** DISPOSING */

    public static void dispose() {
        defaultFont.dispose();
        atlas.dispose();
        skin.dispose();

        disposeUIActors();

        screenTable.remove();
        globalTable.remove();
    }

    private static void disposeUIActors() {
        Label.disposeClass();
        Label.disposeInstances();
    }
}
