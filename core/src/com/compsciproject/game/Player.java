package com.compsciproject.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Player 
{
	//private final int MOVE_UP = 5;
	private final int MOVE_LEFT = 5;
	private final int MOVE_RIGHT = 5;
	private final int JUMP_HEIGHT = 80;
	private final int JUMP_SPEED = 6;
	private final int FALL_SPEED = 4;
	private int jumps = 0;
	private int xStart;
	private int yStart;
	private int y;
	private int x;
	private boolean goRight = false;
	private boolean goLeft = false;
	private int maxHeight;
	private boolean jumping = false;
	private Gun playerGun;
	private TiledMapTileLayer collisionLayer;
	//true for Right, false for left.
	private boolean curDirection = true;

	/**
	 * Constructs a player object at loc(x,y).
	 * @param xVal what x value player should be at.
	 * @param yVal what y value player should be at.
	 */
	public Player(int xVal, int yVal, Gun gunIn, TiledMapTileLayer collisionLayerIn)
	{
		x = xVal;
		xStart = xVal;
		y = yVal;
		yStart = yVal;
		playerGun = gunIn;
		collisionLayer = collisionLayerIn;
	}
	
	public void respawn() {
		x = xStart;
		y = yStart;
	}
	
	public Bullet fire() {
		if(ableToShoot()) {
			Bullet bulletOut = new Bullet(playerGun.getDmg(), x+1, y+10, 1, curDirection, collisionLayer);
			playerGun.setCooldown();
			return bulletOut;
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
		int xVarR = (((((getX()+50))+MOVE_RIGHT)) / 16);
		int yVarR = (((getY()+25)) /16 );
		if(goRight && !((collisionLayer.getCell(xVarR, yVarR).getTile().getProperties().containsKey("blocked")))) {
			curDirection = true;
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
		int xVarL = (((((getX()))-MOVE_LEFT)) / 16);
		int yVarL = (((getY())+25) /16 );
		if(goLeft && !(collisionLayer.getCell(xVarL, yVarL).getTile().getProperties().containsKey("blocked"))) {
			curDirection = false;
			x = x - MOVE_LEFT;
		}
	}
	/**
	 * Player jumps up to maxHeight and falls back down to minHeight.
	 */
	public void jump() {
		if((jumps < 2)) {
			maxHeight = y + JUMP_HEIGHT;
			jumps++;
			jumping = true;
		}
	}
	public void rise() {
		int xVarRi = ((getX()+25) / 16);
		int yVarRi = ((getY()+JUMP_SPEED+50) /16);
		
		if(jumping) {
			
			if(y+JUMP_SPEED>669) {
			     jumping = false;
			}
			else if((y<maxHeight)) {
			  
				if(!(collisionLayer.getCell(xVarRi, yVarRi).getTile().getProperties().containsKey("blocked"))) {
					System.out.println("BEFORE xVar: " + xVarRi + " | yVar: " + yVarRi);
					y = y + JUMP_SPEED;
					System.out.println("AFTER xVar: " + xVarRi + " | yVar: " + yVarRi);
				}
				else {
					jumping = false;
					//jumps = 0;
				}
			}
			
			else{
				jumping = false;
				//jumps = 0;
			}
		
		}
		else {
			//jumps = 0;
		}
	}
	public void fall() {
		int xVarF = ((getX()+25) / 16);
		int yVarF = ((getY()-FALL_SPEED) /16);
		if(!jumping)
		{	
			if(!(collisionLayer.getCell(xVarF, yVarF).getTile().getProperties().containsKey("blocked"))){
				System.out.println("BEFORE xVar: " + xVarF + " | yVar: " + yVarF);
				y = y - FALL_SPEED;
				System.out.println("AFTER xVar: " + xVarF + " | yVar: " + yVarF);
				
			}
			if(collisionLayer.getCell(xVarF, yVarF).getTile().getProperties().containsKey("blocked")){
				jumps = 0;
			}	
		}
		
	}
}
