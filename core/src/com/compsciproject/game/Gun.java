package com.compsciproject.game;

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
	
}
