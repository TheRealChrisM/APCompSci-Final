package com.compsciproject.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class SettingsScreen implements Screen{
	Skin skin = new Skin();
	GameMain game;
	
	
	public SettingsScreen(GameMain gameIn) {
		game = gameIn;
	}
	
	@Override
	public void show() {
		 
		Label nameLabel = new Label("Name:", skin);
		 TextField nameText = new TextField("", skin);
		 Label addressLabel = new Label("Address:", skin);
		 TextField addressText = new TextField("", skin);
		    
		    Table table = new Table();
		    table.add(nameLabel);
		    table.add(nameText).width(100);
		    table.row();
		    table.add(addressLabel);
		    table.add(addressText).width(100);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
