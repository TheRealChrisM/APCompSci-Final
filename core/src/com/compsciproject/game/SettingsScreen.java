package com.compsciproject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
		Preferences prefs = Gdx.app.getPreferences("zappy_boys_setings");
		skin = new Skin(Gdx.files.internal("neon-ui.json"));
		table = new Table();
	    stage = new Stage();
	    
	    Label settingsLabel = new Label("SETTINGS:", skin);
		Label playerOneLabel = new Label("Player 1:", skin);
		TextField playerOneText = new TextField(prefs.getString("player1Name"), skin);
		Label playerTwoLabel = new Label("Player 2:", skin);
		TextField playerTwoText = new TextField(prefs.getString("player2Name"), skin);    
		Label mapLabel = new Label("Map: ", skin);
		
		
		Object[] blob = new Object[6]; 
		blob[0] = new Pistol(); 
		blob[1] = new Saw(); 
		blob[2] = new Scar();
		blob[3] = new DMR();
		blob[4] = new Ak();
		blob[5] = new ShotGun();
		
		Object[] maps = new Object[2];
		maps[0] = new String("Factory.tmx");
		maps[1] = new String("Cave.tmx");
		
		final SelectBox<Object> mapOpt = new SelectBox<Object>(skin); 
		final SelectBox<Object> p1Wep = new SelectBox<Object>(skin); 
		final SelectBox<Object> p2Wep = new SelectBox<Object>(skin); 
		p1Wep.setItems(blob); 
		p2Wep.setItems(blob);
		mapOpt.setItems(maps);
		
		table.add(settingsLabel);
		table.row();
		table.add(playerOneLabel);
		table.add(playerOneText).width(100);
		table.add(p1Wep);
		table.row();
		table.add(playerTwoLabel);
		table.add(playerTwoText).width(100);
		table.add(p2Wep);
		table.row();
		table.add(mapLabel);
		table.add(mapOpt);
		table.setFillParent(true);
	    stage.addActor(table);
	    Gdx.input.setInputProcessor(stage);
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
