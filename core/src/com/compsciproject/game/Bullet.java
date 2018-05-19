package com.compsciproject.game;

public abstract class Bullet 
{
	private int damage;
	private int speed;
	private int xPos;
	private int yPos;
	private int weight;
	private int length;
	
	public Bullet(int damage, int speed, int x, int y, int weight, int length)
	{
		this.damage = damage;
		this.speed = speed;
		xPos = x;
		yPos = y;
		this.weight = weight;
		this.length = length;
	}
	
	public int getWeight()
	{
		return weight;
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
