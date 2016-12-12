package com.pocketbattles.game.UserInterface.Screens.UpgradeScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.Actors.Entity.Base.Entity;
import com.pocketbattles.game.Actors.Entity.Leaf.SWORDSMAN;
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
    private static Table entityListTable;
    private static ButtonGroup entityListButtonGroup;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);
        entityListTable = new Table(UserInterface.skin);
        entityListButtonGroup = new ButtonGroup();
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

        final Table upgradesTableImageTable = new Table(UserInterface.skin);
        upgradesTableImageTable.add(
                Image.addInstance("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE", "empty.jpg")
        ).center();

        addUpgradeTableEntityRow(SWORDSMAN.getLevels(),
                SWORDSMAN.getLevelsAvailable(),
                SWORDSMAN.class.getSimpleName()
        );

        entityListButtonGroup.setMaxCheckCount(1);
        entityListButtonGroup.setMinCheckCount(0);
        entityListButtonGroup.setUncheckLast(true);

        ScrollPane entityListScrollPane = new ScrollPane(entityListTable, UserInterface.skin);

        Table upgradesTable = new Table(UserInterface.skin);
        upgradesTable.add(entityListScrollPane).width(400);
        upgradesTable.add(upgradesTableImageTable).width(400).fill().row();
        upgradesTable.add();

        upgradesTable.add(
                TextButton.addInstance(
                        "UPGRADE_SCREEN_BUY_UPGRADE",
                        "BUY UPGRADE",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                for (int i = 0; i < entityListTable.getRows(); i++) {
                                    for (int j = 0; j < entityListTable.getColumns(); j ++) {
                                        if (
                                                UpgradeEntityImageButton.getButton(
                                                        "UPGRADE_SCREEN_ENTITY_LIST_TABLE_SWORDSMAN"
                                                                + String.valueOf(j)
                                                ).isChecked()
                                                        && j == SWORDSMAN.getLevelsAvailable()
                                                ) {
                                            SWORDSMAN.addLevelsAvailable();
                                            UpgradeEntityImageButton.getButton(
                                                    "UPGRADE_SCREEN_ENTITY_LIST_TABLE_SWORDSMAN"
                                                            + String.valueOf(j)
                                            ).makeAvailable();
                                            TextButton.getButton(
                                                    "UPGRADE_SCREEN_BUY_UPGRADE"
                                            ).setVisible(false);
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                )
        );

        localScreenTable.add(upgradesTable).height(400);
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

    public static void addUpgradeTableEntityRow(int levels, final int levelsAvailable, final String className) {
        for (int j = 0; j < levels; j++) {
            entityListTable.add(
                    UpgradeEntityImageButton.addInstance(
                            "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                    + className
                                    + String.valueOf(j),
                            "UserInterface/Screens/UpgradeScreen/Upgrades/"
                                    + className
                                    + "/"
                                    + className
                                    + String.valueOf(j),
                            5,
                            new ClickListener() {
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    Image.getImage(
                                            "UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE"
                                    ).setTexture(
                                            "Entities/"
                                                    + className
                                                    + "/initial.png",
                                            upgradeTableImageScale
                                    );
                                }
                            }
                    )
            );
        }
        entityListTable.row();

        for (int j = 0; j < levels; j++) {
            entityListButtonGroup.add(
                    UpgradeEntityImageButton.getButton(
                            "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                    + className
                                    + String.valueOf(j)
                    )
            );

            if (j >= levelsAvailable) {
                UpgradeEntityImageButton.getButton(
                        "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                + className
                                + String.valueOf(j)
                ).makeUnavailable();
            }
        }
    }

    public static void set() {
        UserInterface.screenTable.add(localScreenTable);
    }

    /** UPDATING */

    public static void update() {
        Label.getLabel("UPGRADE_SCREEN_GOLD_AMOUNT").update("GOLD:" + Game.GOLD_AMOUNT);
        showBuyUpgradeButton();
    }

    public static void showBuyUpgradeButton() {
        for (int i = 0; i < entityListTable.getRows(); i++) {
            for (int j = 0; j < entityListTable.getColumns(); j ++) {
                if (
                        UpgradeEntityImageButton.getButton(
                                "UPGRADE_SCREEN_ENTITY_LIST_TABLE_SWORDSMAN"
                                        + String.valueOf(j)
                        ).isChecked()
                                && j == SWORDSMAN.getLevelsAvailable()
                        ) {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_UPGRADE"
                    ).setVisible(true);
                    return;
                }else {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_UPGRADE"
                    ).setVisible(false);
                }
            }
        }
    }

    /** DISPOSING */

    public static void dispose() {
        UserInterface.screenTable.removeActor(localScreenTable);
    }
}
