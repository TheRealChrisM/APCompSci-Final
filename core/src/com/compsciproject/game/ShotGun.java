package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class ShotGun implements Gun
{
	private String name ;
	private int ammo;
	private int range;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 75;
	private final Texture Remington = new Texture("Remington 870.png");
	
	public ShotGun()
	{
		range = 224;
		name = "Remington 870";
		dmg = 93;
		ammo = 8;
	}
	public int getDmg() {
		return dmg;
	}
	
	public Texture getPicture() {
		return Remington;
	}
	
	public int getRange() {
		return range;
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
	
	/*public void range()
	{
		if (getStart() = getXPos)
	}*/
	
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
		return "Remington 870";
	}
	
}
