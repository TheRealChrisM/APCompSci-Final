package com.compsciproject.game;

public abstract class Gun 
{
	private String name;
	private int fireRate;
	private int ammo;
	
	public Gun(String name, int fireRate, int ammo)
	{
		this.name = name;
		this.fireRate = fireRate;
		this.ammo = ammo;
	}
	
	public void bulletLost()
	{
		ammo--;
	}
	
	public int getFireRate()
	{
		return fireRate;
	}
	
	public String getWeaponName()
	{
		return name;
	}
	
	public int getAmmo()
	{
		return ammo;
	}
	
}
