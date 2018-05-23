package com.compsciproject.game;

import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
		//D
		case(32): GameMain.move(1);
			break;
		//A
		case(29): GameMain.move(2);
			break;
		//W
		case(51): GameMain.move(3);
			break;
		//L
		case(40): GameMain.move(4);
			break;
		//J
		case(38): GameMain.move(5);
			break;
		//I
		case(37): GameMain.move(6);
			break;
		//Q
		case(45): GameMain.move(7);
			break;
		//U
		case(49): GameMain.move(8);
			break;
		//E
		case(33): GameMain.move(9);
			break;
		//O
		case(43): GameMain.move(10);
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		//D
		case(32): GameMain.move(-1);
			break;
		//A
		case(29): GameMain.move(-2);
			break;
		//L
		case(40): GameMain.move(-4);
			break;
		//J
		case(38): GameMain.move(-5);
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
