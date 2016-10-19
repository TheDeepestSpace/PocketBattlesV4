package com.pocketbattles.game.Utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.pocketbattles.game.UserInterface.UserInterface;

/**
 * Created by Boris on 20.08.2016.
 * Project: PocketBattlesV4
 */
public class Renderer {

    /** FONT RENDERING */

    public static void renderTextLine(String text, Vector2 screenPosition, Color textColor) {
        Utilities.spriteBatch.begin();
        UserInterface.defaultFont.setColor(textColor);
        UserInterface.defaultFont.draw(
                Utilities.spriteBatch,
                text,
                screenPosition.x,
                screenPosition.y
        );
        Utilities.spriteBatch.end();
    }
}
