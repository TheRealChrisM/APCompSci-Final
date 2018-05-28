package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class Pistol implements Gun 
{
	private String name;
	private int ammo = 16;
	private int coolDown = 0;
	private int dmg;
	private int COOLDOWN = 0;
	 
	public Pistol(String name, int cool, int dmg, int ammo)
	{
		this.name = name;;
		COOLDOWN = cool;
		this.dmg = dmg;
		this.ammo = ammo;
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
	
	public String toString() {
		return name;
	}

	@Override
	public Texture getPicture() {
		return null;
	}
	
	
}
