package com.compsciproject.game;

public class Gun 
{
	protected String name;
	/*protected boolean automatic;
	protected boolean semiAutomatic;
	protected boolean boltAction;*/
	protected int ammo;
	protected int accuracy;
	
	public Gun(String name, boolean automatic, int ammo, int accuracy /*boolean semiAutomatic, boolean boltAction,*/)
	{
		this.name = name;
		/*this.automatic = automatic;
		this.semiAutomatic = semiAutomatic;
		this.boltAction = boltAction;*/
		this.ammo = ammo;
		this.accuracy = accuracy;
	}
	
	/*protected int fireRate()
	{
		int fireRate = 0;
		if (automatic)
		{
			fireRate = 1;
		}
		else if (semiAutomatic)
		{
			fireRate = 1;
		}
		else if (boltAction)
		{
			fireRate = 100;
		}
		return fireRate;
	}*/
	
	protected void bulletLost()
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
