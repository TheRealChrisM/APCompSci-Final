package com.compsciproject.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Player 
{
	//private final int MOVE_UP = 5;
	private final int MOVE_LEFT = 5;
	private final int MOVE_RIGHT = 5;
	private final int JUMP_HEIGHT = 80;
	private final int JUMP_SPEED = 8;
	private final int FALL_SPEED = 4;
	private int y;
	private int x;
	private boolean goRight = false;
	private boolean goLeft = false;
	private int maxHeight;
	private int minHeight;
	private boolean jumping = false;
	private Gun playerGun;
	private TiledMapTileLayer collisionLayer;
	/**
	 * Constructs a player object at loc(x,y).
	 * @param xVal what x value player should be at.
	 * @param yVal what y value player should be at.
	 */
	public Player(int xVal, int yVal, Gun gunIn, TiledMapTileLayer collisionLayerIn)
	{
		x = xVal;
		y = yVal;
		minHeight = y;
		playerGun = gunIn;
		collisionLayer = collisionLayerIn;
	}
	
	public Bullet fire() {
		if(playerGun.getCoolDown() == 0) {
			Bullet bullet = new Bullet(playerGun.getDmg(), x+1, y+1, 1);
			return bullet;
		}
		return null;
	}
	
	public boolean ableToShoot() {
		if(playerGun.getCoolDown()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void coolDown() {
		playerGun.coolDownWep();
		
	}
	/**
	 * 
	 * @return x value of player.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return return y value of player.
	 */
	public int getY() {
		return y;
	}
	
	public void moveRight(boolean goR) {
		goRight = goR;
		goRight();
	}
	/**
	 * Moves player right MOVE_RIGHT places.
	 */
	public void goRight() {
		int xVarR = 80-(((((getX()+25))+MOVE_RIGHT)) / 16);
		int yVarR = 45-(((getY()+25)) /16 );
		System.out.println(xVarR + "" + yVarR);
		if(goRight && (collisionLayer.getCell(xVarR, yVarR).getTile().getProperties().containsKey("blocked"))) {
			x = x + MOVE_RIGHT;
		}
	}
	public void moveLeft(boolean goL) {
		goLeft = goL;
		goLeft();
	}
	/**
	 * Moves player left MOVE_LEFT places
	 */
	public void goLeft() {
		int xVarL = 80-(((((getX()+25))-MOVE_LEFT)) / 16);
		int yVarL = 45-(((getY())+25) /16 );
		System.out.println(xVarL + "" + yVarL);
		if(goLeft && collisionLayer.getCell(xVarL, yVarL).getTile().getProperties().containsKey("blocked")) {
			x = x - MOVE_LEFT;
		}
	}
	/**
	 * Player jumps up to maxHeight and falls back down to minHeight.
	 */
	public void jump() {
		if(jumping == false && !(y>minHeight)) {
			maxHeight = y + JUMP_HEIGHT;
			minHeight = y;
			jumping = true;
		}
	}
	public void rise() {
		if(jumping) {
			if(y<maxHeight && y<670) {
				y = y + JUMP_SPEED;
			}
			else{
				jumping = false;
			}
		}
	}
	public void fall() {
		if(y>minHeight) {
			y = y - FALL_SPEED;
		}
	}
}
