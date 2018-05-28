package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class Magnum extends Pistol{
	private final Texture MG = new Texture("500 Magnum.png");
	public Magnum() {
		super("500 Magnum", 60, 25, 6);
		
	}
	public Texture getPicture() {
		return MG;
	}

}
