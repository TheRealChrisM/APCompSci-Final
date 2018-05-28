package com.compsciproject.game;
import com.badlogic.gdx.graphics.Texture;
public class Ak extends AssaultRifle{
	private final Texture AK = new Texture("AK-47.png");
	public Ak() {
		super("AK-47", 27, 15, 30);
		// TODO Auto-generated constructor stub
	}
	public Texture getPicture() {
		return AK;
	}
	

}
