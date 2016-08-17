package com.pocketbattles.game;

import com.badlogic.gdx.Game;

public class PocketBattles extends Game {

	/** INITIALISING */

	private void initialise() {

	}

	/** CREATING AND SETTING UP */
	
	@Override
	public void create () {
		this.initialise();
	}

	/** UPDATING */

	private void update() {

	}

	/** RENDERING */

	@Override
	public void render () {
		this.update();
		super.render();
	}

	/** DISPOSING */

	@Override
	public void dispose() {
		super.dispose();
	}
}
