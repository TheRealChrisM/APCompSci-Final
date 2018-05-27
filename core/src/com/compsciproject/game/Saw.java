package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;
public class Saw extends AssaultRifle{
	private final Texture Saw = new Texture("M249 SAW.png");
	public Saw() {
		super("Saw", 10, 5);
		// TODO Auto-generated constructor stub
	}
	public Texture getPicture() {
		return Saw;
	}
	

}