package com.compsciproject.game;

import com.badlogic.gdx.graphics.Texture;

public class M1911 extends Pistol{
	private final Texture M1911 = new Texture("M1911.png");
	public M1911() {
		super("M1911", 15, 8);
		
	}
	public Texture getPicture() {
		return M1911;
	}

}
