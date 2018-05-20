package com.compsciproject.game;

public class Bullet 
{
	private int damage;
	private int xPos;
	private int yPos;
	private int length;
	private int speed = 10;
	//true for right, false for left
	private boolean direction;
	
	public Bullet(int damage, int x, int y, int length, boolean facingRight)
	{
		this.damage = damage;
		if(facingRight) {
			xPos = x + 50;
			yPos = y;
		}
		else {
			xPos = x;
			yPos = y;
		}
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
	
	public void move() {
		if(direction) {
			xPos = xPos + speed;
		}
		else {
			xPos = xPos - speed;
		}
	}
}
