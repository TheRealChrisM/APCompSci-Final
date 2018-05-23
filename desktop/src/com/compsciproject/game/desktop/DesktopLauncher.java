package com.compsciproject.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.compsciproject.game.GameMain;
import com.compsciproject.game.MyTextInputListener;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Zappy Dudes";
		config.width = 1280;
		config.height = 720;
		
		MyTextInputListener listener = new MyTextInputListener();
		Gdx.input.getTextInput(listener, "Select a Gun for P1", "", "pistol, shotgun, ak");
		
		new LwjglApplication(new GameMain(), config);
	}
}
