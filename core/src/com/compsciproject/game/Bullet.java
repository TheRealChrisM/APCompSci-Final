package com.compsciproject.game;

public abstract class Bullet 
{
	private int damage;
	private int speed;
	/*protected boolean heavy;
	protected boolean medium;
	protected boolean light;*/
	
	public Bullet(int damage, int speed /*boolean heavy, boolean medium, boolean light*/)
	{
		this.damage = damage;
		this.speed = speed;
		/*this.heavy = heavy;
		this.light = light;
		this.medium = medium;*/
	}
	
	
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getDamage()
	{
		return damage;
	}
}
