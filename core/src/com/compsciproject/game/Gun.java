package com.compsciproject.game;

public abstract class Gun 
{
	private String name;
	private int fireRate;
	private int ammo;
	protected int coolDown = 0;
	private int dmg = 5;
	private final int COOLDOWN = 100;
	
	public Gun(String name, int fireRate, int ammo)
	{
		this.name = name;
		this.fireRate = fireRate;
		this.ammo = ammo;
	}
	
	public int getDmg() {	
		return dmg;
	}
	
	public void bulletLost()
	{
		ammo--;
	}
	
	public int getFireRate()
	{
		return fireRate;
	}
	
	public int getCoolDown() {
		
		return coolDown;
	}
	public void coolDownWep() {
		if(coolDown > 0) {
			coolDown--;
		}
	}
	
	public String getWeaponName()
	{
		return name;
	}
	
	public int getAmmo()
	{
		return ammo;
	}
	
	public void setCooldown(){
		coolDown += COOLDOWN;
	}
	
}
