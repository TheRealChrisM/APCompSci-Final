package com.compsciproject.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingsScreen implements Screen{
	Skin skin;
	GameMain game;
	Label nameLabel;
	Table table;
	Stage stage;
	TextField playerOneText;
	TextField playerTwoText;
	Preferences prefs;
	
	public SettingsScreen(GameMain gameIn) {
		game = gameIn;
	}
	
	@Override
	public void show() {
		prefs = Gdx.app.getPreferences("zappy_boys_setings");
		skin = new Skin(Gdx.files.internal("neon-ui.json"));
		table = new Table();
	    stage = new Stage();
	    
	    Label settingsLabel = new Label("SETTINGS:", skin);
		Label playerOneLabel = new Label("Player 1:", skin);
		playerOneText = new TextField(prefs.getString("player1Name"), skin);
		Label playerTwoLabel = new Label("Player 2:", skin);
		playerTwoText = new TextField(prefs.getString("player2Name"), skin);    
		Label mapLabel = new Label("Map: ", skin);
		TextButton saveButton = new TextButton("SAVE", skin);
		
		Object[] blob = new Object[9]; 
		blob[0] = new Magnum(); 
		blob[1] = new Saw(); 
		blob[2] = new Scar();
		blob[3] = new DMR();
		blob[4] = new Ak();
		blob[5] = new ShotGun();
		blob[6] = new DesertEagle();
		blob[7] = new M1911();
		blob[8] = new Sniper();
		
		Object[] maps = new Object[2];
		maps[0] = new String("Factory.tmx");
		maps[1] = new String("Cave.tmx");
		
		final SelectBox<Object> mapOpt = new SelectBox<Object>(skin); 
		final SelectBox<Object> p1Wep = new SelectBox<Object>(skin); 
		final SelectBox<Object> p2Wep = new SelectBox<Object>(skin); 
		p1Wep.setItems(blob); 
		p2Wep.setItems(blob);
		mapOpt.setItems(maps);
		
		saveButton.addListener(new ClickListener() {
		    public void clicked(InputEvent event, float x, float y) {
		        prefs.putString("player1Name", playerOneText.getText());
		        prefs.putString("player2Name", playerTwoText.getText());
		        prefs.putString("map", (String) mapOpt.getSelected());
		        prefs.flush();
		        
		        GameScreen.gun1 = (Gun) p1Wep.getSelected();
		        GameScreen.gun2 = (Gun) p2Wep.getSelected();
		        game.setScreen(new GameMenu(game));
		    }
		});
		
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
		table.row();
		table.add(saveButton);
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
