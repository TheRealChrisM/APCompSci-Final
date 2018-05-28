package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public interface Gun 
{
	
	public int getDmg();
	
	public void bulletLost();
	
	public int getCoolDown();
	
	public void addCool();
	
	public void coolDownWep();
	
	public String getWeaponName();
	
	public int getAmmo();
	
	public void setCooldown();

	public Texture getPicture();
	
	
	
}
