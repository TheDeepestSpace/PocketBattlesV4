package com.pocketbattles.game.UserInterface.Screens.UpgradeScreen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pocketbattles.game.Actors.Entity.Base.ReflectionUtility;
import com.pocketbattles.game.Actors.User;
import com.pocketbattles.game.Game;
import com.pocketbattles.game.PocketBattles;
import com.pocketbattles.game.UserInterface.Actors.Image;
import com.pocketbattles.game.UserInterface.Actors.Label;
import com.pocketbattles.game.UserInterface.Actors.TextButton;
import com.pocketbattles.game.UserInterface.Actors.UpgradeEntityImageButton;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 20.10.2016.
 * Project: PocketBattlesV4
 */
public class UI {
    private static Table localScreenTable;
    private static final float upgradeTableImageScale = 2f;
    private static Table entityListTable;
    private static ButtonGroup entityListButtonGroup;
    private static Stack upgradeTableStack;

    /** INITIALISING */

    public static void initialise() {
        localScreenTable = new Table(UserInterface.skin);
        entityListTable = new Table(UserInterface.skin);
        entityListButtonGroup = new ButtonGroup();
        upgradeTableStack = new Stack();
    }

    /** CREATING AND SETTING UP */

    public static void setUp() {
        localScreenTable.add();
        localScreenTable.add(
                Label.addInstance("UPGRADE_SCREEN_TITLE", "UPGRADE", "fancyFont32", Color.GREEN)
        );
        localScreenTable.add().row();
        localScreenTable.add();
        localScreenTable.add(
                Label.addInstance(
                        "UPGRADE_SCREEN_GOLD_AMOUNT", "fancyFont16", Color.GOLD
                )
        ).row();
        localScreenTable.add().height(50).row();
        localScreenTable.add().height(300);

        final Table upgradesTableImageTable = new Table(UserInterface.skin);
        upgradesTableImageTable.add(
                Image.addInstance("UPGRADE_SCREEN_UPGRADABLE_ENTITY_IMAGE",
                        "Entities/" + Game.entityClassesNames.get(0) + "/initial.png",
                        upgradeTableImageScale)
        ).center();
        upgradesTableImageTable.add(
                Label.addInstance(
                        "UPGRADE_SCREEN_ENTITY_AMOUNT",
                        new Vector2(0, 0),
                        "fancyFont32",
                        Color.GREEN
                )
        ).width(60);

        for (int i = 0; i != Game.entityClassesNames.size(); ++i) {
            addUpgradeTableEntityRow(Game.entityClassesNames.get(i));
        }

        entityListButtonGroup.setMaxCheckCount(1);
        entityListButtonGroup.setMinCheckCount(0);
        entityListButtonGroup.setUncheckLast(true);

        ScrollPane entityListScrollPane = new ScrollPane(entityListTable, UserInterface.skin);

        Table upgradesTable = new Table(UserInterface.skin);
        upgradesTable.add(entityListScrollPane).width(400);
        upgradesTable.add(upgradesTableImageTable).width(400).fill();
        upgradesTable.row();
        upgradesTable.add();

        upgradeTableStack.add(
                TextButton.addInstance(
                        "UPGRADE_SCREEN_BUY_UPGRADE",
                        "BUY UPGRADE",
                        40,
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                for (int i = 0; i < entityListTable.getRows(); i++) {
                                    for (int j = 0; j < entityListTable.getColumns(); j++) {
                                        if (checkClickedEntityForUpgrade(
                                                Game.entityClassesNames.get(i),
                                                j)) {
                                            if (User.buyUpgrade(Game.entityClassesNames.get(i))) {
                                                UpgradeEntityImageButton.getButton(
                                                        "UPGRADE_SCREEN_ENTITY_LIST_TABLE_"
                                                                + Game
                                                                .entityClassesNames.get(i)
                                                                + String.valueOf(j)
                                                ).makeAvailable();
                                                TextButton.getButton(
                                                        "UPGRADE_SCREEN_BUY_UPGRADE"
                                                ).setVisible(false);
                                                showBuyUpgradeUIs();
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                )
        );

        upgradeTableStack.add(
                TextButton.addInstance(
                        "UPGRADE_SCREEN_BUY_ENTITY",
                        "BUY ENTITY",
                        new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                for (int i = 0; i < entityListTable.getRows(); i++) {
                                    for (int j = 0; j < entityListTable.getColumns(); j++) {
                                        if (checkClickedEntityForBuy(
                                                Game.entityClassesNames.get(i),
                                                j)) {
                                            if (User.buyEntity(Game.entityClassesNames.get(i), j)) {
                                                showBuyUpgradeUIs();
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                )
        );

        upgradesTable.add(upgradeTableStack).row();
        upgradesTable.add();
        upgradesTable.add(
                Label.addInstance(
                        "UPGRADE_SCREEN_COST",
                        new Vector2(0, 0),
                        "fancyFont16",
                        Color.GOLD
                )
        );

        localScreenTable.add(upgradesTable).height(400);
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

        showBuyUpgradeUIs();
    }

    private static boolean checkClickedEntityForUpgrade(String className, int level) {
        int checkLevels = ReflectionUtility.invoke(className, "getLevelsAvailable");

        return UpgradeEntityImageButton.getButton(
                "UPGRADE_SCREEN_ENTITY_LIST_TABLE_" + className
                        + String.valueOf(level)).isChecked()
                && level == checkLevels;
    }

    private static boolean checkClickedEntityForBuy(String className, int level) {
        int checkLevels = ReflectionUtility.invoke(className, "getLevelsAvailable");

        return UpgradeEntityImageButton.getButton(
                "UPGRADE_SCREEN_ENTITY_LIST_TABLE_" + className
                        + String.valueOf(level)).isChecked()
                && level < checkLevels;
    }

    public static void addUpgradeTableEntityRow(final String className) {
        int levels = ReflectionUtility.invoke(className, "getLevels");
        int levelsAvailable = ReflectionUtility.invoke(className, "getLevelsAvailable");

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

                                    showBuyUpgradeUIs();
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

    }

    public static void showBuyUpgradeUIs() {
        Label.getLabel("UPGRADE_SCREEN_GOLD_AMOUNT").update("GOLD:" + Game.GOLD_AMOUNT);
        int currentCost, entitiesAvailable;
        for (int i = 0; i < entityListTable.getRows(); i++) {
            for (int j = 0; j < entityListTable.getColumns(); j ++) {
                entitiesAvailable = ReflectionUtility.invoke(Game.entityClassesNames.get(i),
                        "getAvailableEntities", j);
                Label.getLabel(
                        "UPGRADE_SCREEN_ENTITY_AMOUNT"
                ).update("x" + entitiesAvailable);

                if (checkClickedEntityForUpgrade(Game.entityClassesNames.get(i), j)) {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_UPGRADE"
                    ).setVisible(true);
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
                    ).setVisible(true);
                    currentCost = ReflectionUtility.invoke(Game.entityClassesNames.get(i),
                            "getUpgradeCost");
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
                    ).update("COST:" + currentCost);
                    return;
                }else {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_UPGRADE"
                    ).setVisible(false);
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
                    ).setVisible(false);
                }

                if (checkClickedEntityForBuy(Game.entityClassesNames.get(i), j)) {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_ENTITY"
                    ).setVisible(true);
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
                    ).setVisible(true);
                    currentCost = ReflectionUtility.invoke(Game.entityClassesNames.get(i),
                            "getCost", j);
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
                    ).update("COST:" + currentCost);
                    return;
                } else {
                    TextButton.getButton(
                            "UPGRADE_SCREEN_BUY_ENTITY"
                    ).setVisible(false);
                    Label.getLabel(
                            "UPGRADE_SCREEN_COST"
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
