package com.pocketbattles.game;

import com.pocketbattles.game.UserInterface.Screens.MainScreen.MainScreen;

public class PocketBattles extends com.badlogic.gdx.Game {

	/* SCREENS */

	public static MainScreen mainScreen;

	/** INITIALISING */

	private void initialise() {
		Game.initialise();
		this.initialiseScreens();
	}

	private void initialiseScreens() {
		mainScreen = new MainScreen(this);
	}

	public void setMainScreen() {
		setScreen(mainScreen);
		System.gc();
	}

	/** CREATING AND SETTING UP */


	
	@Override
	public void create () {
		this.initialise();
		Game.create();
		this.setMainScreen();
	}

	/** UPDATING */

	private void update() {
		Game.update();
	}

	/** RENDERING */

	@Override
	public void render () {
		this.update();
		super.render();
		Game.render();
	}

	/** DISPOSING */

	@Override
	public void dispose() {
		super.dispose();
		Game.dispose();
	}
}
