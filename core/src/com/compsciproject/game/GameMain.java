package com.compsciproject.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture[] bg = new Texture[2];
	//Animation<TextureRegion> charAnimation;
	TextureRegion[] walkFrames;
	Texture walkSheet;
	SpriteBatch spriteBatch;
	float stateTime;
	public static Player p1;
	public static Player p2;
	MyInputProcessor inputProcessor = new MyInputProcessor();
	//TiledMap map;
	//OrthographicCamera camera;
    //TiledMapRenderer tiledMapRenderer;
    
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		walkSheet = new Texture("default_char.png");
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 4, walkSheet.getHeight() / 4); 
		batch = new SpriteBatch();
		bg[0] = new Texture("desert_bg.jpg");
		bg[1] = new Texture("volcano_bg.jpg");
		p1 = new Player(50,50);
		p2 = new Player(300,50);
		Gdx.input.setInputProcessor(inputProcessor);
		//camera = new OrthographicCamera();
	    //camera.setToOrtho(false,w,h);
	    //camera.update();
	    //map = new TmxMapLoader().load("New Map.tmx");
		walkFrames = new TextureRegion[9];
		walkFrames[0] = tmp[0][3];
		walkFrames[1] = tmp[1][0];
		walkFrames[2] = tmp[1][1];
		walkFrames[3] = tmp[1][2];
		walkFrames[4] = tmp[1][3];
		walkFrames[5] = tmp[2][0];
		walkFrames[6] = tmp[2][1];
		walkFrames[7] = tmp[2][2];
		walkFrames[8] = tmp[2][3];
		
//		charAnimation = new Animation<TextureRegion>(0.5f, walkFrames);
		stateTime = 0f;
		//tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
        //Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		//TextureRegion currentFrame = charAnimation.getKeyFrame(stateTime, true);
		p1.goLeft();
		p1.goRight();
		p2.goLeft();
		p2.goRight();
		p1.rise();
		p2.rise();
		p1.fall();
		p2.fall();
		
		batch.begin();
		//camera.update();
        //tiledMapRenderer.setView(camera);
        //tiledMapRenderer.render();
		//batch.draw(bg[0], 0, 0);
		batch.draw(walkFrames[0], p1.getX(), p1.getY(), 50, 50);
		batch.draw(walkFrames[0], p2.getX(), p2.getY(), 50, 50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	public static void move(int x) {
		switch(x) {
			case(1): p1.moveRight(true);
				break;
			case(2): p1.moveLeft(true);
				break;
			case(3): p1.jump();
				break;
			case(4): p2.moveRight(true);
				break;
			case(5): p2.moveLeft(true);
				break;
			case(6): p2.jump();
				break;
			case(-1): p1.moveRight(false);
				break;
			case(-2): p1.moveLeft(false);
				break;
			case(-4): p2.moveRight(false);
				break;
			case(-5): p2.moveLeft(false);
				break;
			default: break;
		}
	}
}
