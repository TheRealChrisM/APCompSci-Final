package com.compsciproject.game;

public class Pistol extends Gun 
{
	private static String name = "M1911";
	private final int COOLDOWN = 1000; 
	
	public Pistol()
	{
		super(name, 1, 8);
	}
	
	public void setCoolDown() {
		coolDown += COOLDOWN;
	}
}
