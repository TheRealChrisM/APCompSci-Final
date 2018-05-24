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
	
	private String name = "";  
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
	/**
	 * Constructs a player object at loc(x,y).
	 * @param xVal what x value player should be at.
	 * @param yVal what y value player should be at.
	 */
	public Player(int xVal, int yVal, Gun gunIn, TiledMapTileLayer collisionLayerIn, String nameIn)
	{
		name = nameIn;
		x = xVal;
		xStart = xVal;
		y = yVal;
		yStart = yVal;
		playerGun = gunIn;
		collisionLayer = collisionLayerIn;
	}
	
	public String getName() {
		return name;
	}
	
	public void respawn() {
		x = xStart;
		y = yStart;
	}
	
	public Bullet fire(boolean fireDirection) {
		if(ableToShoot()) {
			Bullet bulletOut = new Bullet(playerGun.getDmg(), x+1, y+10, 1, fireDirection, collisionLayer);
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
		int xVarRi = ((getX()) / 16);
		int xVarRi1 = ((getX()+40) / 16);
		int xVarRi2 = ((getX()+10) / 16);
		int yVarRi = ((getY()+JUMP_SPEED+50) /16);
		
		if(jumping) {
			
			if(y+JUMP_SPEED>669) {
			     jumping = false;
			}
			else if((y<maxHeight)) {
				if(!(collisionLayer.getCell(xVarRi, yVarRi).getTile().getProperties().containsKey("blocked")) && !(collisionLayer.getCell(xVarRi1, yVarRi).getTile().getProperties().containsKey("blocked")) && !(collisionLayer.getCell(xVarRi2, yVarRi).getTile().getProperties().containsKey("blocked"))) {
						jumping = true;
				}
				else {
					jumping = false;
				}
			}
			else{
				jumping = false;
			}
		}
			if(jumping) {
				y = y + JUMP_SPEED;
			}
		}
	
	public void fall() {
		int xVarF = ((getX()) / 16);
		int yVarF = ((getY()-FALL_SPEED) /16);
		int xVarF1 = ((getX()+40) / 16);
		int xVarF2 = ((getX()+10) / 16);
		xVarF2 = xVarF;
		boolean shouldFall = true;
		if(!jumping)
		{	
			if((collisionLayer.getCell(xVarF, yVarF).getTile().getProperties().containsKey("blocked"))){
				shouldFall = false;
				
			}
			else if((collisionLayer.getCell(xVarF2, yVarF).getTile().getProperties().containsKey("blocked"))){
				shouldFall = false;
			}
			else if((collisionLayer.getCell(xVarF1, yVarF).getTile().getProperties().containsKey("blocked"))){
				shouldFall = false;
				shouldFall = false;
				
			}
			else if((collisionLayer.getCell(xVarF2, yVarF).getTile().getProperties().containsKey("blocked"))){
				shouldFall = false;
			}
			else if((collisionLayer.getCell(xVarF1, yVarF).getTile().getProperties().containsKey("blocked"))){
				shouldFall = false;
			}
			
			if(shouldFall) {
				y = y - FALL_SPEED;
			}
			
			
			if(collisionLayer.getCell(xVarF, yVarF).getTile().getProperties().containsKey("blocked")){
				jumps = 0;
			}	
		}
		
	}
}
