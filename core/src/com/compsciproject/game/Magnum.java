package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class Magnum extends Pistol{
	private final Texture MG = new Texture("500 Magnum.png");
	public Magnum() {
		super("500 Magnum", 60, 20);
		
	}
	public Texture getPicture() {
		return MG;
	}

}
