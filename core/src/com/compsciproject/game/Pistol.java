package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;

public class Pistol implements Gun 
{
	private String name;
	private int ammo;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 0;
	private final Texture M1911 = new Texture("Desert eagle 44.png"); 
	public Pistol()
	{
		name = "Desert Eagle 44";
		ammo = 16;
		dmg = 6;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public Texture getPicture() {
		return M1911;
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
		return "Desert Eagle 44";
	}
	
	
}
