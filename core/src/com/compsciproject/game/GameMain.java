package com.compsciproject.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameMain extends ApplicationAdapter {
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	SpriteBatch batch;
	Texture img;
	//Animation<TextureRegion> charAnimation;
	TextureRegion[] walkFrames;
	Texture walkSheet;
	SpriteBatch spriteBatch;
	float stateTime;
	public static Player p1;
	public static Player p2;
	MyInputProcessor inputProcessor = new MyInputProcessor();
	TiledMap map;
	OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    TiledMapTileLayer collisionLayer;
    
	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		walkSheet = new Texture("default_char.png");
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 4, walkSheet.getHeight() / 4); 
		batch = new SpriteBatch();
		Gun gun1 = new Pistol();
		Gun gun2 = new Pistol();
		p1 = new Player(50,165, gun1);
		p2 = new Player(1175,165, gun2);
		Gdx.input.setInputProcessor(inputProcessor);
		camera = new OrthographicCamera();
	    camera.setToOrtho(false,w,h);
	    camera.update();
	    map = new TmxMapLoader().load("Factory.tmx"); 
	    collisionLayer = (TiledMapTileLayer)map.getLayers().get(1);
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
		tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
        
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
		tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
		batch.begin();
		batch.draw(walkFrames[0], p1.getX(), p1.getY(), 50, 50);
		batch.draw(walkFrames[0], p2.getX(), p2.getY(), 50, 50);
		camera.update();
		batch.end();
		p1.coolDown();
		p2.coolDown();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	public static void fireBullet(Player playNo){
		if(playNo.ableToShoot()) {
			bullets.add(playNo.fire());
		}
	}
	
	public static void checkBullets() {
		
	}
	
	public void move(int x) {
		boolean collision;
		switch(x) {
			case(1): collision = collisionLayer.getCell((int)((p1.getX()+5)/ 16 ), (int)((((p1.getY()+50)/2)/16))).getTile().getProperties().containsKey("blocked");
				p1.moveRight(!collision);
				break;
			case(2): collision = collisionLayer.getCell((int)((p1.getX()-5)/ 16 ), (int)((((p1.getY()+50)/2)/16))).getTile().getProperties().containsKey("blocked");
				p1.moveLeft(!collision);
				break;
			case(3): 
				p1.jump();
				break;
			case(4): collision = collisionLayer.getCell((int)((p2.getX()+5)/ 16 ), (int)((((p2.getY()+50)/2)/16))).getTile().getProperties().containsKey("blocked");
				p2.moveRight(!collision);
				break;
			case(5): collision = collisionLayer.getCell((int)((p2.getX()-5)/ 16 ), (int)((((p2.getY()+50)/2)/16))).getTile().getProperties().containsKey("blocked");
				p2.moveLeft(!collision);
				break;
			case(6):
				p2.jump();
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
