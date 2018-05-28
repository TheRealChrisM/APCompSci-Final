package com.compsciproject.game;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
	
	GameMain game;
	private static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public static int p1Wins = 0;
	public static int p2Wins = 0;
	SpriteBatch batch;
	SpriteBatch winChar;
	Texture img;
	TextureRegion[] walkFrames;
	TextureRegion[] walkFrames2;
	Texture walkSheetP1;
	Texture walkSheetP2;
	Texture p1Gun;
	Texture p2Gun;
	float stateTime;
	public static Player p1;
	public static Player p2;
	MyInputProcessor inputProcessor = new MyInputProcessor(this);
	TiledMap map;
	OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    Texture bulletImg;
    BitmapFont font;
    private String winString;
    private String healthString;
    private String p1Win;
    private String p2Win;
    int frameSinceWin = 0;
    boolean gameEnd = false;
    public static Gun gun1 = new Magnum();
    public static Gun gun2 = new Magnum();
    Preferences prefs;
    private boolean shootLeft = false;
    
    
    public GameScreen (GameMain gameIn) {
    	game = gameIn;
	}
    
    
    
	public void show() {
		prefs = Gdx.app.getPreferences("zappy_boys_setings");
		p1Wins = 0;
		p2Wins = 0;
		for(int u = 0; u < bullets.size(); u++) {
			bullets.remove(u);
			u--;
		}
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        walkSheetP1 = new Texture("p1.png");
        walkSheetP2 = new Texture("p2.png.");
        TextureRegion[][] tmp2 = TextureRegion.split(walkSheetP2, walkSheetP2.getWidth() / 4, walkSheetP2.getHeight() / 4);
		TextureRegion[][] tmp = TextureRegion.split(walkSheetP1, walkSheetP1.getWidth() / 4, walkSheetP1.getHeight() / 4); 
		batch = new SpriteBatch();
		winChar = new SpriteBatch();
		
		bulletImg = new Texture("bullet.png");
		Gdx.input.setInputProcessor(inputProcessor);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
	    camera.update();
	    map = new TmxMapLoader().load(prefs.getString("map"));
	    p1 = new Player(gun1, (TiledMapTileLayer)map.getLayers().get("Tile Layer 2"), prefs.getString("player1Name"));
		p2 = new Player(gun2, (TiledMapTileLayer)map.getLayers().get("Tile Layer 2"), prefs.getString("player2Name"));
		p1Win = p1.getName() + " WINS!";
		p2Win = p2.getName() + " WINS!";
		p1Gun = gun1.getPicture();
		p2Gun = gun2.getPicture();
		walkFrames = new TextureRegion[17];
		walkFrames[0] = tmp[0][3];
		walkFrames[1] = tmp[1][0];
		walkFrames[2] = tmp[1][0];
		walkFrames[3] = tmp[1][1];
		walkFrames[4] = tmp[1][1];
		walkFrames[5] = tmp[1][2];
		walkFrames[6] = tmp[1][2];
		walkFrames[7] = tmp[1][3];
		walkFrames[8] = tmp[1][3];
		walkFrames[9] = tmp[2][0];
		walkFrames[10] = tmp[2][0];
		walkFrames[11] = tmp[2][1];
		walkFrames[12] = tmp[2][1];
		walkFrames[13] = tmp[2][2];
		walkFrames[14] = tmp[2][2];
		walkFrames[15] = tmp[2][3];
		walkFrames[16] = tmp[2][3];
		
		walkFrames2 = new TextureRegion[17];
		walkFrames2[0] = tmp2[0][3];
		walkFrames2[1] = tmp2[1][0];
		walkFrames2[2] = tmp2[1][0];
		walkFrames2[3] = tmp2[1][1];
		walkFrames2[4] = tmp2[1][1];
		walkFrames2[5] = tmp2[1][2];
		walkFrames2[6] = tmp2[1][2];
		walkFrames2[7] = tmp2[1][3];
		walkFrames2[8] = tmp2[1][3];
		walkFrames2[9] = tmp2[2][0];
		walkFrames2[10] = tmp2[2][0];
		walkFrames2[11] = tmp2[2][1];
		walkFrames2[12] = tmp2[2][1];
		walkFrames2[13] = tmp2[2][2];
		walkFrames2[14] = tmp2[2][2];
		walkFrames2[15] = tmp2[2][3];
		walkFrames2[16] = tmp2[2][3];
//		charAnimation = new Animation<TextureRegion>(0.5f, walkFrames);
		stateTime = 0f;
		tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void render(float delta) {
	
	if(!(gameEnd)) {

		
		healthString = "P1: " + p1.getHealth() + " | P2: " + p2.getHealth() + "";

		winString = prefs.getString("player1Name") + ": " + p1Wins + " | "+ prefs.getString("player2Name") + ": " + p2Wins + "";

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

	
		font.draw(batch,  healthString, 800, 50);

		font.draw(batch,  winString, 1000, 50);

		batch.draw(walkFrames[p1.getFrame()], p1.getX(), p1.getY(), 50, 50);
		batch.draw(walkFrames2[p2.getFrame()], p2.getX(), p2.getY(), 50, 50);
		if(p1.facingLeft() || shootLeft){
			batch.draw(p1Gun, p1.getX()+25, p1.getY(), -1*(p1Gun.getWidth()), p1Gun.getHeight());
		}
		else {
			batch.draw(p1Gun, p1.getX()+25, p1.getY(), (p1Gun.getWidth()), p1Gun.getHeight());
		}
		if(p2.facingLeft() || shootLeft){
			batch.draw(p2Gun, p2.getX()+25, p2.getY(), -1*(p2Gun.getWidth()), p2Gun.getHeight());
		}
		else {
			batch.draw(p2Gun, p2.getX()+25, p2.getY(), (p2Gun.getWidth()), p2Gun.getHeight());
		}
		camera.update();
		
		
		for(int u = 0; u<bullets.size();u++) {
			batch.draw(bulletImg, bullets.get(u).getXPos(), bullets.get(u).getYPos(), 30, 30);
		}
		batch.end();
		checkBullets();
		p1.coolDown();
		p2.coolDown();
	}
	
	
	if(p1Wins >= 25) {
		winChar.begin();
		font.draw(winChar, p1Win, 580,180);
		winChar.draw(walkFrames[0], (640-250), 200, 500, 500);
		gameEnd = true;
		winChar.end();
	}
	else if(p2Wins >= 25) {
		winChar.begin();
		font.draw(winChar,p2Win, 580, 180);
		winChar.draw(walkFrames2[0], (640-250), 200, 500, 500);
		gameEnd = true;
		winChar.end();
	}
	
		if((p2Wins >= 24) || (p1Wins >= 24)) {
			frameSinceWin++;
			gotoMenu();
		}
		
		
	}

	public void exitToMenu() {
		this.dispose();
		game.setScreen(new GameMenu(game));	
	}
	
	public void gotoMenu() {
		
		if(frameSinceWin > 200) {
			this.dispose();
			game.setScreen(new GameMenu(game));
		}
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
		p1.respawn();
		p2.respawn();
		frameSinceWin = 0;
		p1Wins = 0;
		p2Wins = 0;
		batch.dispose();
		winChar.dispose();
		
	}
	
	//fireDirection true = right && false = left
		public static void fireBullet(Player playNo, boolean fireDirection){
			if(playNo.ableToShoot()) {
				bullets.add(playNo.fire(fireDirection));
			}
		}
		
		public static void checkBullets() {
			for(int m = 0; m<bullets.size(); m++) {
				boolean noBulletsRemoved = true;
				bullets.get(m).move();
				if(bullets.get(m).checkCollision()){
					noBulletsRemoved = false;
					bullets.remove(m);
					m--;
				}
				if(noBulletsRemoved && (p1.getX()<bullets.get(m).getXPos()) && ((p1.getX()+50)>bullets.get(m).getXPos()) && (p1.getY()<bullets.get(m).getYPos()) && ((p1.getY()+50)>bullets.get(m).getYPos())){
					p1.setHealth(bullets.get(m).getDamage());
				
					if(p1.getHealth() <= 0) {
						p1.respawn();
						p2Wins++;
					}
					noBulletsRemoved = false;
					bullets.remove(m);
					m--;
				}
				if(noBulletsRemoved && (p2.getX()<bullets.get(m).getXPos()) && ((p2.getX()+50)>bullets.get(m).getXPos()) && (p2.getY()<bullets.get(m).getYPos()) && ((p2.getY()+50)>bullets.get(m).getYPos())){
					p2.setHealth(bullets.get(m).getDamage());
				
					if(p2.getHealth() <= 0) {
						p2.respawn();
						p1Wins++;
					}
					
					noBulletsRemoved = false;
					bullets.remove(m);
					m--;
				}
			}
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
				case(7): fireBullet(p1, false);
					break;
				case(8): fireBullet(p2, false);
					break;
				case(9): fireBullet(p1, true);
					break;
				case(10): fireBullet(p2, true);
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
