package com.pocketbattles.game.Actors;

import com.pocketbattles.game.Actors.Entity.Base.Entity;
import com.pocketbattles.game.Actors.Entity.Base.ReflectionUtility;
import com.pocketbattles.game.Game;

/**
 * Created by Boris on 12.12.2016.
 * Project: PocketBattlesV4
 */
public class User {

    /** INITIALISING */
    public static void initialise() {

    }

    /** CREATING AND SETTING UP */

    public static void setUp() {

    }

    /** GETTERS / SETTERS */

    /** UPDATING */

    /** INTERACTING */

    public static boolean enoughFor(int cost) {
        return cost <= Game.GOLD_AMOUNT;
    }

    public static void pay(int cost) {
        Game.GOLD_AMOUNT -= cost;
    }

    public static boolean buyUpgrade(String entityClass) {
        int upgradeCost = ReflectionUtility.invoke(entityClass, "getUpgradeCost");
        if (enoughFor(upgradeCost)) {
            pay(upgradeCost);
            ReflectionUtility.invoke(entityClass, "addLevelsAvailable");
            return true;
        }else return false;

    }

    public static boolean buyEntity(String entityClass, int level) {
        int buyCost = ReflectionUtility.invoke(entityClass, "getCost", level);

        if (enoughFor(buyCost)) {
            pay(buyCost);
            Entity.addEntity(entityClass, level);
            return true;
        }else return false;
    }

    /** DISPOSING / RESETTING */

    public static void dispose() {

    }
}
