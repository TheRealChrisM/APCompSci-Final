package com.compsciproject.game;

public class Bullet 
{
	protected int damage;
	protected int speed;
	/*protected boolean heavy;
	protected boolean medium;
	protected boolean light;*/
	private int xPos;
	private int yPos;
	
	public Bullet(int damage, int speed, int x, int y /*boolean heavy, boolean medium, boolean light*/)
	{
		this.damage = damage;
		this.speed = speed;
		xPos = x;
		yPos = y;
		/*this.heavy = heavy;
		this.light = light;
		this.medium = medium;*/
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void move() {
		xPos = xPos + speed;
	}
}
