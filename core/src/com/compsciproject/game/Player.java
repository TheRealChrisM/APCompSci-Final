package com.compsciproject.game;

public class Player 
{
	private int MOVE_UP = 5;
	private int MOVE_LEFT = 5;
	private int MOVE_RIGHT = 5;
	private int JUMP_HEIGHT = 10;
	private int y;
	private int x;
	
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
	 * Moves player right MOVE_RIGHT places.
	 */
	public void moveRight() {
		x = x + MOVE_RIGHT;
	}
	
	/**
	 * Moves player left MOVE_LEFT places
	 */
	public void moveLeft() {
		x = x - MOVE_LEFT;
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
