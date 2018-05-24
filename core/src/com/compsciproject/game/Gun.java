package com.compsciproject.game;

public interface Gun 
{
<<<<<<< HEAD
	
	
	
	
	public int getDmg();
	
	public void bulletLost();
	
	
	public int getCoolDown();
	
	public void addCool();
	public void coolDownWep();
	
	
	public String getWeaponName();
	
	public int getAmmo();
	
	public void setCooldown();
=======
	private String name;
	private int fireRate;
	private int ammo;
	protected int coolDown = 0;
	private int dmg = 5;
	private final int COOLDOWN = 5;
	
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
	
	public void addCool() {
		coolDown++;
	}
	public void coolDownWep(){
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
>>>>>>> 752031d7b9ad3a0af091f8eb2adad9ca9161d595
	
}
