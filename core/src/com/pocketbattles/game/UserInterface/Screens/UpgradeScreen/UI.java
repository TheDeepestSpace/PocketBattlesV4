package com.pocketbattles.game.UserInterface.Screens.UpgradeScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Actors.Image;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 28.08.2016.
 * Project: PocketBattlesV4
 */
public class UI {
    private static Table localScreenTable;

    private static float upgradeEntityImageMultiplier;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);

        upgradeEntityImageMultiplier = 1f;
    }

    /** CREATING AND SETTING */

    public static void setUp() {
        localScreenTable.add();
        localScreenTable.add(Label.addInstance("UPGRADE_SCREEN_TITLE", "UPGRADE", "fancyFont32", Color.GREEN));
        localScreenTable.add().row();
        localScreenTable.add().height(50).row();
        localScreenTable.add().height(300);

        final Table upgradesTableImageTable = new Table(UserInterface.skin);
        upgradesTableImageTable.add(Image.addInstance("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE", "image.png"));

        Table entityListTable = new Table(UserInterface.skin);
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY1", "ENTITY1", "toggle", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Image.getImage("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE").setTexture("image.png");
            }
        })).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY2", "ENTITY2", "toggle", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Image.getImage("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE").setTexture("image2.png");
            }
        })).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY3", "ENTITY3", "toggle", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Image.getImage("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE").setTexture("image3.png");
            }
        })).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY4", "ENTITY4", "toggle", 40, new ClickListener())).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY5", "ENTITY5", "toggle", 40, new ClickListener())).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY6", "ENTITY6", "toggle", 40, new ClickListener())).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY7", "ENTITY7", "toggle", 40, new ClickListener())).fill().row();
        entityListTable.add(TextButton.addInstance("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY8", "ENTITY8", "toggle", 40, new ClickListener())).fill().row();

        ButtonGroup entityListButtonGroup = new ButtonGroup(
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY1"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY2"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY3"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY4"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY5"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY6"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY7"),
                TextButton.getButton("UPGRADE_SCREEN_ENTITY_LIST_TABLE_ENTITY8")
        );
        entityListButtonGroup.setMaxCheckCount(1);
        entityListButtonGroup.setMinCheckCount(0);
        entityListButtonGroup.setUncheckLast(true);

        ScrollPane entityListScrollPane = new ScrollPane(entityListTable, UserInterface.skin);

        Table upgradesTable = new Table(UserInterface.skin);
        upgradesTable.add(entityListScrollPane);
        upgradesTable.add(upgradesTableImageTable).width(200).fill();

        localScreenTable.add(upgradesTable).height(300);
        localScreenTable.add(Label.addInstance("UPGRADE_SCREEN_GOLD_AMOUNT", "fancyFont16", Color.GOLD)).left().row();
        localScreenTable.add().height(50).row();
        localScreenTable.add();
        localScreenTable.add(TextButton.addInstance("UPGRADE_SCREEN_BACK_TO_MAIN_SCREEN_BUTTON", "BACK", 40, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PocketBattles.upgradeScreen.game.setMainScreen();
            }
        }));
    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** UPDATING */

    public static void update() {
        Label.getLabel("UPGRADE_SCREEN_GOLD_AMOUNT").update("GOLD:" + Game.GOLD_AMOUNT);
    }

    /** DISPOSING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
