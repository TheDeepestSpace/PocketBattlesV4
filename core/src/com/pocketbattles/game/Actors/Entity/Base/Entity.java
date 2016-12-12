package com.pocketbattles.game.Actors.Entity.Base;

import java.util.ArrayList;

/**
 * Created by Boris on 23.10.2016.
 * Project: PocketBattlesV4
 */
public class Entity {
    private static ArrayList<String> leafClassNames;
    private static ArrayList<Entity> list;
    private static int currentListIndex;

    /* UPDATING */

    private static int btreeUpdateDelay; // in frames
    private static int currentBtreeUpdateDelay;

    /* INIT PROPERTIES */

    protected String name;
    protected Team team;

    protected enum Team {
        NONE,
        USER,
        ARTIFICIAL
    }

    /* SETTABLE PROPERTIES */

    protected static int levels, levelsAvailable;

    protected int line, row;
    protected int initHP, HP;

    /* FLAGS */

    protected boolean selected;
    protected boolean dead;

    /* VISUAL */

    /** INITIALISING */

    public static void initialiseClass() {
        leafClassNames = new ArrayList<String>();
        list = new ArrayList<Entity>();
        currentListIndex = 0;

        btreeUpdateDelay = 60;
        currentBtreeUpdateDelay = 0;
    }

    protected Entity() {
        this.initialise();
    }

    protected void initialise() {
        this.name = "n/a";
        this.team = Team.NONE;

        this.line = this.row = -1;
        this.initHP = this.HP = 0;
    }

    /** CREATING AND SETTING UP */

    protected void setUp(int line, int row, Team team) {
        this.setLine(line);
        this.setRow(row);
        this.setTeam(team);
        this.setName(this.getClass().getSimpleName() + ":" + getCurrentListIndex());

        getList().add(this);
        updateCurrentListIndex();
    }

    /** UPDATING */

    public static void updateInstances() {
        if (getCurrentBtreeUpdateDelay() >= getBtreeUpdateDelay()) {
            setCurrentBtreeUpdateDelay(0);
            for (int i = 0; i < list.size(); i++) list.get(i).updateBtree();
        }else updateCurrentBtreeUpdateDelay();

        for (int i = 0; i < list.size(); i++) list.get(i).update();
    }

    protected void updateBtree() {

    }

    protected void update() {

    }

    /** GETTERS / SETTERS */

    public static ArrayList<String> getLeafClassNames() {
        return leafClassNames;

    }

    public static ArrayList<Entity> getList() {
        return list;
    }

    public static int getCurrentListIndex() {
        return currentListIndex;
    }

    public static int getBtreeUpdateDelay() {
        return btreeUpdateDelay;
    }

    public static int getCurrentBtreeUpdateDelay() {
        return currentBtreeUpdateDelay;
    }

    public static void setCurrentBtreeUpdateDelay(int currentBtreeUpdateDelay) {
        Entity.currentBtreeUpdateDelay = currentBtreeUpdateDelay;
    }

    public static int updateCurrentBtreeUpdateDelay() {
        currentBtreeUpdateDelay += 1;
        return currentBtreeUpdateDelay;
    }

    private static int updateCurrentListIndex() {
        currentListIndex += 1;
        return currentListIndex;
    }

    public static int getLevels() {
        return levels;
    }

    public static int getLevelsAvailable() {
        return levelsAvailable;
    }

    public static void setLevelsAvailable(int levelsAvailable) {
        Entity.levelsAvailable = levelsAvailable;
    }

    public static int addLevelsAvailable() {
        levelsAvailable += 1;
        return levelsAvailable;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getLine() {
        return this.line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int changeLine(int add) {
        this.line += add;
        return this.line;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int changeRow(int add) {
        this.row += add;
        return this.row;
    }

    public int getInitHP() {
        return this.initHP;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int changeHP(int add) {
        this.HP += add;
        return this.HP;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDead() {
        return this.dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    private static boolean canCreateEntity(int line, int row) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLine() == line && list.get(i).getRow() == row)
                return false;
        }

        return true;
    }

    /** INTERACTING */

    /** RENDERING */

    public static void renderInstances() {
        for (int i = 0; i < list.size(); i++) list.get(i).render();
    }

    protected void render() {

    }

    /** DISPOSING */

    public static void disposeInstances() {
        for (int i = 0; i < list.size(); i++) list.get(i).dispose();
    }

    public static void disposeClass() {
        leafClassNames.clear();
        list.clear();
        currentListIndex = -1;
        levels = -1;
        levelsAvailable = -1;
    }

    protected void dispose() {
        this.name = null;
        this.team = null;
    }

}
