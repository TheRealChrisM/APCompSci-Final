package com.compsciproject.game;

public class Pistol implements Gun 
{
<<<<<<< HEAD
	private String name;
	private int ammo;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 25;
=======
	private static String name = "M1911";
	private final int COOLDOWN = 10; 
>>>>>>> 752031d7b9ad3a0af091f8eb2adad9ca9161d595
	
	public Pistol()
	{
		name = "M1911";
		ammo = 16;
		dmg = 6;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public void bulletLost() {
		ammo--;
	}
	
	public int getCoolDown() {
		return coolDown;
	}
	
	public void addCool() {
		coolDown++;
	}
	
	public void coolDownWep() {
		if(coolDown > 0) {
			coolDown--;
		}
	}
	
	public String getWeaponName() {
		return name;
	}
	
	public int getAmmo() {
		return ammo;
	}
	public void setCooldown() {
		coolDown += COOLDOWN;
	}
	
	
	
}
