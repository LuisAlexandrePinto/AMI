package com.nightgames;

import com.badlogic.gdx.Game;

public class FingerinMain extends Game {

	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose () {
		super.dispose();
		AssetLoader.dispose();
	}
}
