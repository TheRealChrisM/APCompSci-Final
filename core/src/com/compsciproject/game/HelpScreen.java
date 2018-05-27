package com.compsciproject.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelpScreen implements Screen{
	private SpriteBatch background;
	Texture bg;
	GameMain game;
	
	public HelpScreen(GameMain gameIn) {
		game = gameIn;
	}
	
	@Override
	public void show() {
		background = new SpriteBatch();
		bg = new Texture("menu.png");
	}

	@Override
	public void render(float delta) {
		background.begin();
		background.draw(bg, 0, 0, 1280, 720);
		background.end();
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
		// TODO Auto-generated method stub
		
	}

}
