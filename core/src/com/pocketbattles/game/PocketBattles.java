package com.pocketbattles.game;

public class PocketBattles extends com.badlogic.gdx.Game {

	/** INITIALISING */

	private void initialise() {
		Game.initialise();
	}

	/** CREATING AND SETTING UP */
	
	@Override
	public void create () {
		this.initialise();
		Game.create();
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
