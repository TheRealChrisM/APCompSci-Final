package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;

public class DMR implements Gun
{
	private String name ;
	private int range;
	private int ammo;
	private int coolDown = 0;
	private int dmg;
	private final int COOLDOWN = 88;
	private final Texture DMR = new Texture("SR-25.png");
	
	public DMR()
	{
		range = 750;
		dmg = 47;
		name = "SR-25";
		ammo = 10;
	}
	
	public Texture getPicture() {
		return DMR;
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
	
	public int getRange() {
		return range;
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
		return "SR-25 Semi-auto";
	}
	
}
