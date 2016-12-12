package com.pocketbattles.game.Actors;

import com.pocketbattles.game.Actors.Entity.Base.Entity;
import com.pocketbattles.game.Actors.Entity.Leaf.SWORDSMAN;

/**
 * Created by Boris on 23.10.2016.
 * Project: PocketBattlesV4
 */
public class Actors {

    /** INITIALISING */

    public static void initialise() {
        Entity.initialiseClass();
        SWORDSMAN.initialiseClass();
    }

    /** CREATING AND SETTING UP */

    public static void create() {

    }

    /** UPDATING */

    public static void update() {
        Entity.updateInstances();
    }

    /** RENDERING */

    public static void render() {
        Entity.renderInstances();
    }

    /** DISPOSING */

    public static void dispose() {
        Entity.disposeInstances();
        Entity.disposeClass();
    }
}
