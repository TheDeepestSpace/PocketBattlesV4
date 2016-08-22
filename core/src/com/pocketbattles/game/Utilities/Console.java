package com.pocketbattles.game.Utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Boris on 23.08.2016.
 * Project: PocketBattlesV4
 */
public class Console {
    public static ArrayList<Console> list;

    static SimpleDateFormat simpleDateFormat;
    static Calendar calendar;

    private ArrayList<String> strings;
    private ArrayList<Color> stringsColors;
    private ArrayList<Vector2> stringsPositions;
    private Timer lineTimer;

    Name name;

    private Vector2 startingPosition;
    int direction;
    int lineSeenTime; // in milliseconds

    boolean rendering;

    public enum LineType {
        WARNING,
        ERROR,
        REGULAR,
        SUCCESS
    }

    public enum Name {
        NONE,
        MAIN,
        GAME
    }

    /** INITIALISING */

    public static void initialiseClass() {
        list = new ArrayList<Console>();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
    }

    Console() {
        this.initialise();
    }

    private void initialise() {
        this.strings = new ArrayList<String>();
        this.stringsColors = new ArrayList<Color>();
        this.stringsPositions = new ArrayList<Vector2>();

        this.lineTimer = new Timer();

        this.name = Name.NONE;

        this.startingPosition = new Vector2();
        this.direction = 0;
        this.lineSeenTime = 0;

        this.rendering = true;
    }

    /** CREATING AND SETTING UP */

    private void setUp(Name name, Vector2 startingPosition, int direction, int lineSeenTime) {
        this.name = name;
        this.startingPosition = startingPosition.cpy();
        this.direction = direction;
        this.lineSeenTime = lineSeenTime;
    }

    /** UPDATING */

    private void moveLines() {
        for (int i = 0, len = this.strings.size(); i < len; i++) {
            if (this.direction == 0) {
                this.stringsPositions.get(i).y += 25;
            }
            if (this.direction == 1) {
                this.stringsPositions.get(i).y -= 25;
            }
        }
    }

    private void removeLine(int index) {
        this.strings.remove(index);
        this.stringsColors.remove(index);
        this.stringsPositions.remove(index);
    }

    /** INTERACTING */

    public static void addLine(Name name, String text, LineType lineType) {
        getConsole(name).addLine(text, getColor(lineType));
    }

    private void addLine(String text, Color textColor) {
        text = printCurrentTime() + text;
        this.strings.add(text);
        this.stringsColors.add(textColor);
        this.stringsPositions.add(this.startingPosition.cpy());
        this.lineTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                removeLine(0);
                this.cancel();
            }
        }, this.lineSeenTime);
        this.lineTimer.purge();
        this.moveLines();
        System.out.print(text + "\n");
    }

    private String printCurrentTime() {
        calendar = Calendar.getInstance();
        return "[" + simpleDateFormat.format(calendar.getTime()) + "] ";
    }

    /** GETTERS / SETTERS */

    public void setRendering(boolean rendering) {
        this.rendering = rendering;
    }

    public static Console getConsole (Name name) {
        for (int i = 0, len = list.size(); i < len; i++) {
            if (list.get(i).name.equals(name)) {
                return list.get(i);
            }
        }

        return null;
    }

    private static Color getColor(LineType lineType) {
        if (lineType == LineType.WARNING) return Color.YELLOW;
        else if (lineType == LineType.ERROR) return Color.RED;
        else if (lineType == LineType.REGULAR) return Color.WHITE;
        else if (lineType == LineType.SUCCESS) return Color.GREEN;
        else return Color.BLACK;
    }

    /** RENDERING */

    public static void renderInstances() {
        for (int i = 0, len = list.size(); i < len; i++) {
            list.get(i).render();
        }
    }

    private void render() {
        if (this.rendering) {
            for (int i = 0; i < this.strings.size(); i++) {
                Renderer.renderTextLine(this.strings.get(i), this.stringsPositions.get(i), this.stringsColors.get(i));
            }
        }
    }

    /** DISPOSING / RESETTING */

    public static void disposeInstances() {
        for (int i = 0, len = list.size(); i < len; i++) {
            list.get(i).dispose();
        }
    }

    public static void disposeClass() {
        list.clear();
    }

    public void dispose() {
        this.strings.clear();
        this.stringsColors.clear();
        this.stringsPositions.clear();

        this.name = null;

        this.startingPosition = null;
    }
}
