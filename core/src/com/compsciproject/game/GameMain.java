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
		if(!(prefs.getBoolean("notFirstTime"))) {
			prefs.putString("player1Name", "Player 1");
			prefs.putString("player2Name", "Player 2");
			prefs.putString("map", "Factory.tmx");
			prefs.putBoolean("notFirstTime", true);
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
