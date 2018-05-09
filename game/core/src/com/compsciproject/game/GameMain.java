package com.compsciproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture[] bg = new Texture[2];
		//{new Texture("volcano_bg.jpg"), new Texture("badlogic.jpg")};
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		bg[0] = new Texture("volcano_bg.jpg");
		bg[1] = new Texture("badlogic.jpg");
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(bg[0], 0, 0);
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
