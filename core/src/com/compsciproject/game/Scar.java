package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;
public class Scar extends AssaultRifle{
	private final Texture Scar = new Texture("Scar H.png");
	public Scar() {
		super("Scar-H", 30, 25);
		// TODO Auto-generated constructor stub
	}
	public Texture getPicture() {
		return Scar;
	}
	

}