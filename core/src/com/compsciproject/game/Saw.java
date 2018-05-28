package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;
public class Saw extends AssaultRifle{
	private final Texture Saw = new Texture("M249 SAW.png");
	public Saw() {
		super("M249 Saw", 15, 19, 100, 400);
		// TODO Auto-generated constructor stub
	}
	public Texture getPicture() {
		return Saw;
	}
	
}