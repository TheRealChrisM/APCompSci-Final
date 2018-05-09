package com.compsciproject.game;

public class Player 
{
	private int MOVE_UP = 5;
	private int MOVE_LEFT = 5;
	private int MOVE_RIGHT = 5;
	private int JUMP_HEIGHT = 10;
	private int y;
	private int x;
	private boolean goRight = false;
	private boolean goLeft = false;
	
	/**
	 * Constructs a player object at loc(x,y).
	 * @param xVal what x value player should be at.
	 * @param yVal what y value player should be at.
	 */
	public Player(int xVal, int yVal)
	{
		x = xVal;
		y = yVal;
	}
	
	/**
	 * 
	 * @return x value of player.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return return y value of player.
	 */
	public int getY() {
		return y;
	}
	
	public void moveRight(boolean goR) {
		goRight = goR;
		goRight();
	}
	/**
	 * Moves player right MOVE_RIGHT places.
	 */
	public void goRight() {
		if(goRight) {
			x = x + MOVE_RIGHT;
		}
	}
	public void moveLeft(boolean goL) {
		goLeft = goL;
		goLeft();
	}
	/**
	 * Moves player left MOVE_LEFT places
	 */
	public void goLeft() {
		if(goLeft) {
			x = x - MOVE_LEFT;
		}
	}
	
	/**
	 * Player jumps up to maxHeight and falls back down to minHeight.
	 */
	public void jump() {
		int maxHeight = y + JUMP_HEIGHT;
		int minHeight = y;
		while(y<maxHeight) {
			y =+ MOVE_UP;
		}
		while(y>minHeight) {
			y =- MOVE_UP;
		}
	}
}
