package com.compsciproject.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends Game {
	

	public SpriteBatch spriteBatch;
	
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		this.setScreen(new GameScreen());
	}
	
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		
	}
}
