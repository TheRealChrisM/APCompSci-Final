package com.compsciproject.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends Game {
	

	public SpriteBatch spriteBatch;
	
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		this.setScreen(new GameMenu(this));
	}
	
	@Override
	public void render () {
		super.render();
		
	}
	
	public static void endGame() {
		//setScreen(new GameMenu());
	}
	
	@Override
	public void dispose () {
		
	}
}
