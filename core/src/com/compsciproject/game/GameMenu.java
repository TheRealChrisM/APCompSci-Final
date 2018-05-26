package com.compsciproject.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMenu implements Screen{

	private SpriteBatch batch;
	Texture background;
	
	@Override
	public void show() {
		background = new Texture("sky.png");
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(background, 100, 100, 50, 50);
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
