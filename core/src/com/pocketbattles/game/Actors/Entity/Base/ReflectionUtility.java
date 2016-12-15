package com.pocketbattles.game.Actors.Entity.Base;

import com.pocketbattles.game.Game;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Boris on 14.12.2016.
 * Project: PocketBattlesV4
 */
public class ReflectionUtility {
    private static ArrayList<Class<?>> entityClasses;
    private static ArrayList<String> methodNames;
    private static ArrayList<ArrayList<Method>> methods;

    public static void initilaise() {
        entityClasses = new ArrayList<Class<?>>();
        methodNames = new ArrayList<String>();
        methodNames.add("getLevelsAvailable");
        methodNames.add("getLevels");
        methodNames.add("getUpgradeCost");
        methodNames.add("getCost");
        methodNames.add("addLevelsAvailable");
        methodNames.add("addEntity");
        methodNames.add("getAvailableEntities");
        methods = new ArrayList<ArrayList<Method>>();

        for (int i = 0; i != Game.entityClassesNames.size(); ++i) {
            try {
                entityClasses.add(Class.forName("com.pocketbattles.game.Actors.Entity.Leaf."
                        + Game.entityClassesNames.get(i)));
                methods.add(new ArrayList<Method>());
                for (int j = 0; j != methodNames.size(); ++j) {
                    if (j == 3 || j == 5 || j == 6) {
                        try {
                            methods.get(i).add(entityClasses.get(i).getMethod(methodNames.get(j), int.class));
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }else {
                        try {
                            methods.get(i).add(entityClasses.get(i).getMethod(methodNames.get(j)));
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static int invoke(String className, String methodName, int param) {
        if (methodName.equals("getCost") || methodName.equals("addEntity")
                || methodName.equals("getAvailableEntities")) {
            try {
                return (Integer) methods.get(getClassIdx(className)).get(getMethodIdx(methodName)).invoke(null, param);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static int invoke(String className, String methodName) {
        try {
            return (Integer) methods.get(getClassIdx(className)).get(getMethodIdx(methodName)).invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /** GETTERS / SETTERS */

    private static int getClassIdx(String className) {
        for (int i = 0; i != Game.entityClassesNames.size(); ++i) {
            if (Game.entityClassesNames.get(i).equals(className))
                return i;
        }
        return -1;
    }

    private static int getMethodIdx(String methodName) {
        for (int i = 0; i != methodNames.size(); ++i) {
            if (methodNames.get(i).equals(methodName))
                return i;
        }
        return -1;
    }
}
