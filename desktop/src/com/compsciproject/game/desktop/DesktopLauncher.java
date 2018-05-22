package com.compsciproject.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.compsciproject.game.GameMain;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="game thing";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new GameMain(), config);
	}
}
