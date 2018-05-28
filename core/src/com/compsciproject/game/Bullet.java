package com.compsciproject.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Bullet 
{
	private int damage;
	private int start;
	private int xPos;
	private int yPos;
	private int length;
	private int speed = 10;
	//true for right, false for left
	private boolean direction;
	private TiledMapTileLayer collisionLayer;
	
	public Bullet(int damage, int x, int y, int length, boolean facingRight, TiledMapTileLayer collisionLayerIn)
	{
		collisionLayer = collisionLayerIn;
		this.damage = damage;
		if(facingRight) {
			xPos = x + 50;
			yPos = y;
		}
		else {
			xPos = x;
			yPos = y;
		}
		start = xPos;
		this.length = length;
		direction = facingRight;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public int getStart()
	{
		return start;
	}
	
	public void move() {
		if(direction) {
			xPos = xPos + speed;
		}
		else {
			xPos = xPos - speed;
		}
	
	}
	
	public boolean checkCollision() {
		int xVarB = ( (xPos + 15)  / 16);
		int yVarB = ( (yPos + 15) / 16 );
		if(collisionLayer.getCell(xVarB, yVarB).getTile().getProperties().containsKey("blocked")) {
			return true;
		}
		
		return false;
	}
}
