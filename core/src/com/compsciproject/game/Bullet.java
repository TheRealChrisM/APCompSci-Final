package com.compsciproject.game;

public class Bullet 
{
	private int damage;
	private int xPos;
	private int yPos;
	private int length;
	private int speed = 5;
	
	public Bullet(int damage, int x, int y, int length)
	{
		this.damage = damage;
		xPos = x;
		yPos = y;
		this.length = length;
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
		xPos = xPos + speed;
	}
}
