package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class DesertEagle extends Pistol{
	private final Texture DE = new Texture("Desert eagle 44.png");
	public DesertEagle() {
		super("Desert Eagle 44", 50, 36, 8, 50);
		// TODO Auto-generated constructor stub
	}
	public Texture getPicture() {
		return DE;
	}

}
