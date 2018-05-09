package com.compsciproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture[] bg = new Texture[2];
	Animation<TextureRegion> charAnimation;
	Texture walkSheet;
	SpriteBatch spriteBatch;
	float stateTime;
	
	@Override
	public void create () {
		walkSheet = new Texture("default_char.png");
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 4, walkSheet.getHeight() / 4); 
		batch = new SpriteBatch();
		bg[0] = new Texture("desert_bg.jpg");
		bg[1] = new Texture("volcano_bg.jpg");
		
		TextureRegion[] walkFrames = new TextureRegion[9];
		walkFrames[0] = tmp[0][3];
		walkFrames[1] = tmp[1][0];
		walkFrames[2] = tmp[1][1];
		walkFrames[3] = tmp[1][2];
		walkFrames[4] = tmp[1][3];
		walkFrames[5] = tmp[2][0];
		walkFrames[6] = tmp[2][1];
		walkFrames[7] = tmp[2][2];
		walkFrames[8] = tmp[2][3];
		
		charAnimation = new Animation<TextureRegion>(0.025f, walkFrames);
		stateTime = 0f;
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		TextureRegion currentFrame = charAnimation.getKeyFrame(stateTime, true);
		batch.begin();
		batch.draw(bg[0], 0, 0);
		batch.draw(currentFrame, 50, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
