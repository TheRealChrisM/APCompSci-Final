package com.compsciproject.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends Game {
	

	public SpriteBatch spriteBatch;
	
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		this.setScreen(new GameMenu(this));
		
		//instantiates and checks for preferences
		Preferences prefs = Gdx.app.getPreferences("zappy_boys_setings");
		if(!(prefs.getBoolean("firstTime"))) {
			prefs.putString("player1Name", "Player 1aa");
			prefs.putString("player2Name", "Player 2a");
			prefs.putString("map", "Factory.tmx");
			prefs.putBoolean("firstTime", true);
			prefs.flush();
			
		}
		
		
		
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
