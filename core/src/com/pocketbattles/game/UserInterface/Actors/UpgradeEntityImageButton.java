package com.pocketbattles.game.UserInterface.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.UserInterface.UserInterface;

import java.util.ArrayList;

/**
 * Created by Boris on 20.10.2016.
 * Project: PocketBattlesV4
 */
public class UpgradeEntityImageButton extends com.badlogic.gdx.scenes.scene2d.ui.ImageButton {
    public static ArrayList<UpgradeEntityImageButton> list;

    private String name;
    private static NinePatchDrawable buttonStateUpPatch, buttonStateDownPatch;

    private SpriteDrawable imageUnavailable;
    private SpriteDrawable imageUp, imageDown, imageChecked;

    /** INITIALISING */

    public static void initialiseClass() {
        list = new ArrayList<UpgradeEntityImageButton>();

        buttonStateUpPatch = new NinePatchDrawable(
                UserInterface.atlas.createPatch("buttonStateUp")
        );
        buttonStateDownPatch = new NinePatchDrawable(
                UserInterface.atlas.createPatch("buttonStateDown")
        );
    }

    /** CREATING AND SETTING UP */

    public static UpgradeEntityImageButton addInstance(
            String name, String texturePath, ClickListener clickListener
    ) {
        if (nameAvailable(name)) {
            UpgradeEntityImageButton button = new UpgradeEntityImageButton(new ImageButtonStyle());
            button.setUp(name, texturePath);
            button.addListener(clickListener);
            list.add(button);
            return button;
        }else return null;
    }

    public static UpgradeEntityImageButton addInstance(
            String name, String texturePath, int pad, ClickListener clickListener
    ) {
        if (nameAvailable(name)) {
            UpgradeEntityImageButton button = new UpgradeEntityImageButton(new ImageButtonStyle());
            button.setUp(name, texturePath);
            button.addListener(clickListener);
            button.pad(pad);
            button.makeUnavailable();
            list.add(button);
            return button;
        } else return null;
    }

    public UpgradeEntityImageButton(ImageButtonStyle ibs) {
        super(ibs);
    }

    private void setUp(String name, String path) {
        this.name = name;
        this.setUpStyle(path);
        this.setUpDrawable(path);
        Game.stage.addActor(this);
    }

    private void setUpStyle(String path) {
        Texture tUp = new Texture(Gdx.files.internal(path + ".up.png"));
        Texture tDown = new Texture(Gdx.files.internal(path + ".down.png"));
        Texture tChecked = new Texture(Gdx.files.internal(path + ".checked.png"));

        this.imageUp = new SpriteDrawable(new Sprite(tUp));
        this.imageDown = new SpriteDrawable(new Sprite(tDown));
        this.imageChecked = new SpriteDrawable(new Sprite(tChecked));

        this.getStyle().up = buttonStateUpPatch;
        this.getStyle().down = buttonStateDownPatch;
        this.getStyle().checked = buttonStateDownPatch;

        this.getStyle().imageUp = this.imageUp;
        this.getStyle().imageDown = this.imageDown;
        this.getStyle().imageChecked = this.imageChecked;
    }

    private void setUpDrawable(String path){
        Texture tUnavailable = new Texture(Gdx.files.internal(path + ".unavailable.png"));
        imageUnavailable = new SpriteDrawable(new Sprite(tUnavailable));
    }


    /** UPDATING */

    /** GETTERS / SETTERS */

    public static UpgradeEntityImageButton getButton(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).name)) {
                return list.get(i);
            }
        }

        return null;
    }

    private static boolean nameAvailable(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).name)) return false;
        }

        return true;
    }

    /** INTERACTING */

    public void makeUnavailable() {
        this.getStyle().imageUp = this.imageUnavailable;
        this.getStyle().imageDown = this.imageUnavailable;
        this.getStyle().imageChecked = this.imageUnavailable;
    }

    public void makeAvailable() {
        this.getStyle().imageUp = this.imageUp;
        this.getStyle().imageDown = this.imageDown;
        this.getStyle().imageChecked = this.imageChecked;
    }

    /** RENDERING */

    /** DISPOSING */

    public static void disposeClass() {
        list.clear();
    }

    public static void disposeInstances() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).dispose();
        }
    }

    public static void disposeInstance(String name) {
        getButton(name).dispose();
    }

    private void dispose() {
        this.clear();
        this.remove();
        this.name = null;
    }
}
