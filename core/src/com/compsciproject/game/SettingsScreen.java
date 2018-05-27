package com.compsciproject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class SettingsScreen implements Screen{
	Skin skin;
	GameMain game;
	Label nameLabel;
	Table table;
	Stage stage;
	
	
	public SettingsScreen(GameMain gameIn) {
		game = gameIn;
	}
	
	@Override
	public void show() {
		skin = new Skin(Gdx.files.internal("neon-ui.json"));
		table = new Table();
	    stage = new Stage();
		nameLabel = new Label("Name:", skin);
		table.add(nameLabel);
		TextField nameText = new TextField("bsdhbhj", skin);
		Label addressLabel = new Label("Address:", skin);
		TextField addressText = new TextField("asfddsa", skin);
		ImageButton imgBtn = new ImageButton(skin);    
		   
		
		Object[] blob = new Object[2]; 
		blob[0] = new Pistol(); 
		blob[1] = new Pistol(); 
		final SelectBox<Object> sb = new SelectBox<Object>(skin); 
		sb.setItems(blob); 
		
		
		table.add(nameText).width(100);
		table.row();
		table.add(addressLabel);
		table.add(addressText).width(100);
		table.add(sb);
		table.setFillParent(true);
	    stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		
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
