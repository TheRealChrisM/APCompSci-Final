package com.compsciproject.game;

import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {

	GameScreen game;
	
	public MyInputProcessor(GameScreen gameIn) {
		game = gameIn;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		//D
		case(32): GameScreen.move(1);
			break;
		//A
		case(29): GameScreen.move(2);
			break;
		//W
		case(51): GameScreen.move(3);
			break;
		//L
		case(40): GameScreen.move(4);
			break;
		//J
		case(38): GameScreen.move(5);
			break;
		//I
		case(37): GameScreen.move(6);
			break;
		//Q
		case(45): GameScreen.move(7);
			break;
		//U
		case(49): GameScreen.move(8);
			break;
		//E
		case(33): GameScreen.move(9);
			break;
		//O
		case(43): GameScreen.move(10);
			break;
		case(131): game.exitToMenu();
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		//D
		case(32): GameScreen.move(-1);
			break;
		//A
		case(29): GameScreen.move(-2);
			break;
		//L
		case(40): GameScreen.move(-4);
			break;
		//J
		case(38): GameScreen.move(-5);
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
