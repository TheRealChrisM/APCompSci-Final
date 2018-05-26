package com.compsciproject.game;

public class Pistol implements Gun 
{
	private String name;
	private int ammo;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 0;
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
