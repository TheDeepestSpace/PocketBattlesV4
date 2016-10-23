package com.pocketbattles.game.UserInterface.Screens.UpgradeScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Actors.UpgradeEntityImageButton;
import com.pocketbattles.game.UserInterface.Actors.Image;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 20.10.2016.
 * Project: PocketBattlesV4
 */
public class UItest {
    private static Table localScreenTable;
    private static final float upgradeTableImageScale = 2f;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);
    }

    /** CREATING AND SETTING UP */

    public static void setUp() {
        localScreenTable.add();
        localScreenTable.add(
                Label.addInstance("UPGRADE_SCREEN_TITLE", "UPGRADE", "fancyFont32", Color.GREEN)
        );
        localScreenTable.add().row();
        localScreenTable.add().height(50).row();
        localScreenTable.add().height(300);

        /*final Table upgradesTableImageTable = new Table(UserInterface.skin);
        upgradesTableImageTable.add(
                Image.addInstance("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE", "empty.jpg")
        ).center();

        Table entityListTable = new Table(UserInterface.skin);
        for (int i = 0; i < Game.entityClassesNames.size(); i++) {
            final int finalI = i;
            for (int j = 0; j < Game.entityUpgradeLevelsAvailable[i]; j++) {
                entityListTable.add(
                        UpgradeEntityImageButton.addInstance(
                                "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                        + Game.entityClassesNames.get(i)
                                        + String.valueOf(j),
                                "UserInterface/Screens/UpgradeScreen/Upgrades/"
                                        + Game.entityClassesNames.get(i)
                                        + "/"
                                        + Game.entityClassesNames.get(i)
                                        + String.valueOf(j),
                                5,
                                new ClickListener() {
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        Image.getImage(
                                                "UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE"
                                        ).setTexture(
                                                "Entities/"
                                                        + Game.entityClassesNames.get(finalI)
                                                        + "/initial.png",
                                                upgradeTableImageScale
                                        );
                                    }
                                }
                        )
                );
            }
            entityListTable.row();
        }

        ButtonGroup entityListButtonGroup = new ButtonGroup();
        for (int i = 0; i < Game.entityClassesNames.size(); i++) {
            for (int j = 0; j < Game.entityUpgradeLevelsAvailable[i]; j++) {
                entityListButtonGroup.add(
                        UpgradeEntityImageButton.getButton(
                                "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                        + Game.entityClassesNames.get(i)
                                        + String.valueOf(j)
                        )
                );
            }
        }
        entityListButtonGroup.setMaxCheckCount(1);
        entityListButtonGroup.setMinCheckCount(0);
        entityListButtonGroup.setUncheckLast(true);

        ScrollPane entityListScrollPane = new ScrollPane(entityListTable, UserInterface.skin);

        Table upgradesTable = new Table(UserInterface.skin);
        upgradesTable.add(entityListScrollPane).width(400);
        upgradesTable.add(upgradesTableImageTable).width(400).fill();

        localScreenTable.add(upgradesTable).height(400);*/
        localScreenTable.add(
                Label.addInstance(
                        "UPGRADE_SCREEN_GOLD_AMOUNT", "fancyFont16", Color.GOLD
                )
        ).left().row();
        localScreenTable.add().height(50).row();
        localScreenTable.add();
        localScreenTable.add(
                TextButton.addInstance(
                        "UPGRADE_SCREEN_BACK_TO_MAIN_SCREEN_BUTTON",
                        "BACK",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                PocketBattles.upgradeScreen.game.setMainScreen();
                            }
                        }
                )
        );
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
