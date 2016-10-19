package com.pocketbattles.game.UserInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.UserInterface.Actors.Image;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.Utilities.Console;

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

        Console.initialiseClass();
        initialiseUIActors();

        screenTable = new Table(skin);
        globalTable = new Table(skin);
    }

    private static void initialiseUIActors() {
        Label.initialiseClass();
        TextButton.initialiseClass();
        Image.initialiseClass();
    }

    /** CREATING AND SETTING UP */

    public static void create() {
        screenTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Game.stage.addActor(screenTable);

        globalTable.setBounds(0, Gdx.graphics.getHeight() - 300, Gdx.graphics.getWidth(), 300);
        Game.stage.addActor(globalTable);
        globalTable.add(
                Label.addInstance(
                        "GLOBAL_JAVA_HEAP",
                        "defaultFont64",
                        Color.GREEN
                )
        ).left().growX().row();
        globalTable.add(
                Label.addInstance(
                        "GLOBAL_FPS",
                        "defaultFont64",
                        Color.GREEN
                )
        ).left().row();
        globalTable.add().growY();
    }

    /** UPDATING */

    public static void update() {
        Label.getLabel("GLOBAL_JAVA_HEAP").update("Java Heap: " + Gdx.app.getJavaHeap());
        Label.getLabel("GLOBAL_FPS").update("FPS: " + Gdx.graphics.getFramesPerSecond());
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
        Label.disposeInstances();
        Label.disposeClass();
        TextButton.disposeInstances();
        TextButton.disposeClass();
        Image.disposeInstances();
        Image.disposeClass();
    }
}
