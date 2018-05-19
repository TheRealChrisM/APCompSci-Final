package com.compsciproject.game;

public abstract class Gun 
{
	private String name;
	/*protected boolean automatic;
	protected boolean semiAutomatic;
	protected boolean boltAction;*/
	private int ammo;
	private int accuracy;
	
	public Gun(String name, boolean automatic, int ammo, int accuracy /*boolean semiAutomatic, boolean boltAction,*/)
	{
		this.name = name;
		/*this.automatic = automatic;
		this.semiAutomatic = semiAutomatic;
		this.boltAction = boltAction;*/
		this.ammo = ammo;
		this.accuracy = accuracy;
	}
	
	
	public void bulletLost()
	{
		ammo--;
	}
	
	public int getAccuracy()
	{
		return accuracy;
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
