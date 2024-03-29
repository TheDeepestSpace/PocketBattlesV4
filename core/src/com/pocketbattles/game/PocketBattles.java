package com.pocketbattles.game;

import com.pocketbattles.game.UserInterface.Screens.GameScreen.GameScreen;
import com.pocketbattles.game.UserInterface.Screens.MainScreen.MainScreen;
import com.pocketbattles.game.UserInterface.Screens.SettingsScreen.SettingsScreen;
import com.pocketbattles.game.UserInterface.Screens.UpgradeScreen.UpgradeScreen;

public class PocketBattles extends com.badlogic.gdx.Game {

	/* SCREENS */

	public static MainScreen mainScreen;
	public static SettingsScreen settingsScreen;
	public static UpgradeScreen upgradeScreen;
	public static GameScreen gameScreen;

	/** INITIALISING */

	private void initialise() {
		Game.initialise();
		this.initialiseScreens();
	}

	private void initialiseScreens() {
		mainScreen = new MainScreen(this);
		settingsScreen = new SettingsScreen(this);
		upgradeScreen = new UpgradeScreen(this);
		gameScreen = new GameScreen(this);
	}

	public void setMainScreen() {
		setScreen(mainScreen);
		System.gc();
	}

	public void setSettingsScreen() {
		setScreen(settingsScreen);
		System.gc();
	}

	public void setUpgradeScreen() {
		setScreen(upgradeScreen);
		System.gc();
	}

	public void setGameScreen() {
		setScreen(gameScreen);
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
