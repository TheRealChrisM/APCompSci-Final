package com.compsciproject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMenu implements Screen{

	private SpriteBatch batch;
	Texture background;
	GameMain game;
	Texture settingsInactive;
	Texture settingsActive;
	Texture playInactive;
	Texture playActive;
	Texture exitInactive;
	Texture exitActive;
	Texture helpInactive;
	Texture helpActive;
	public final int SETTINGS_WIDTH = 200;
	public final int SETTINGS_HEIGHT = 80;
	public final int PLAY_WIDTH = 170;
	public final int PLAY_HEIGHT = 90;
	public final int EXIT_WIDTH = 170;
	public final int EXIT_HEIGHT = 100;
	public final int HELP_WIDTH = 200;
	public final int HELP_HEIGHT = 100;
	public Gun gun1;
	public Gun gun2;
	
	
	public GameMenu(GameMain gameIn) {
		game = gameIn;
		Gun gun1;
		Gun gun2;
	}
	
	
	@Override
	public void show() {
		background = new Texture("menu.png");
		batch = new SpriteBatch();
		settingsInactive = new Texture("settingsInactive.png");
		settingsActive = new Texture("settingsActive.png");
		playInactive = new Texture("playInactive.png");
		playActive = new Texture("playActive.png");
		exitInactive = new Texture("exitInactive.png");
		exitActive = new Texture("exitActive.png");
		helpInactive = new Texture("helpInactive.png");
		helpActive = new Texture("helpActive.png");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.draw(background, 0, 0, 1280, 720);
		
		if((Gdx.input.getX() > 960) && (Gdx.input.getX() < (960+SETTINGS_WIDTH)) && (Gdx.input.getY() < (720-160)) && (Gdx.input.getY() > (720-(160+SETTINGS_HEIGHT))) ){
			batch.draw(settingsActive, 960, 160, SETTINGS_WIDTH, SETTINGS_HEIGHT);
			if(Gdx.input.isTouched()) {
				game.setScreen(new SettingsScreen(game));
			}
		}
		else {
			batch.draw(settingsInactive, 960, 160, SETTINGS_WIDTH, SETTINGS_HEIGHT);
		}
		
		if((Gdx.input.getX() > 650) && (Gdx.input.getX() < (650+PLAY_WIDTH)) && (Gdx.input.getY() < (720-400)) && (Gdx.input.getY() > (720-(400+PLAY_HEIGHT))) ) {
			batch.draw(playActive, 650, 400, PLAY_WIDTH, PLAY_HEIGHT);
			if(Gdx.input.isTouched()) {
				game.setScreen(new GameScreen(game));
			}
		}
		else{
			batch.draw(playInactive, 650, 400, PLAY_WIDTH, PLAY_HEIGHT);
		}
		
		if((Gdx.input.getX() > 650) && (Gdx.input.getX() < (650+PLAY_WIDTH)) && (Gdx.input.getY() < (720-150)) && (Gdx.input.getY() > (720-(150+PLAY_HEIGHT)))) {
			batch.draw(exitActive, 650, 150, EXIT_WIDTH, EXIT_HEIGHT);
			if(Gdx.input.isTouched()) {
				Gdx.app.exit();	
			}
		}
		else {
			batch.draw(exitInactive, 650, 150, EXIT_WIDTH, EXIT_HEIGHT);
		}
		if((Gdx.input.getX() > 970) && (Gdx.input.getX() < (970+PLAY_WIDTH)) && (Gdx.input.getY() < (720-400)) && (Gdx.input.getY() > (720-(400+PLAY_HEIGHT)))) {
			batch.draw(helpActive, 970, 400, HELP_WIDTH, HELP_HEIGHT);
			if(Gdx.input.justTouched()) {
				game.setScreen(new HelpScreen(game));
			}
		}
		else {
			batch.draw(helpInactive, 970, 400, HELP_WIDTH, HELP_HEIGHT);
		}
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		
	}

}
