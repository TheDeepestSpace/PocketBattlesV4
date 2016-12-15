package com.pocketbattles.game.Actors.Entity.Leaf;

import com.pocketbattles.game.Actors.Entity.Base.Entity;

/**
 * Created by Boris on 23.10.2016.
 * Project: PocketBattlesV4
 */
public class SWORDSMAN extends Entity {

    /** INITIALISING */

    public static void initialiseClass() {
        levels = 5;
        levelsAvailable = 1;
        initUpgradeCost = 500;
        upgradeCostMultiplier = 1.2;
        initCost = 50;
        upgradeCostMultiplier = 1.5;
        costMultiplier = 1.2;

        initialiseAvailableByLevel(levels);
    }

    SWORDSMAN() {
        super();
    }

    /** CREATING AND SETTING UP */
    @Override
    protected void setUp(int line, int row, Entity.Team team) {
        super.setUp(line, row, team);

        this.initHP = this.HP = 100;
    }

    /** UPDATING */

    /** GETTERS / SETTERS */

    /** INTERACTING */

    /** RENDERING */

    /** DISPOSING */
}
