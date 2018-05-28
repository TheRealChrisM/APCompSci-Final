package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class Sniper implements Gun
{
	private String name ;
	private int range;
	private int ammo;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 150;
	private final Texture Sn = new Texture("L115A3.png");
	
	public Sniper()
	{
		range = 1280;
		name = "L115A3";
		dmg = 88;
		ammo = 5;
	}
	public int getDmg() {
		return dmg;
	}
	
	public int getRange() {
		return range;
	}
	public Texture getPicture() {
		return Sn;
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
		return "L115A3 Sniper";
	}
	
}
