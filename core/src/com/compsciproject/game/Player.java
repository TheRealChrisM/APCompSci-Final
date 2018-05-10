package com.compsciproject.game;

public class Player 
{
	private final int MOVE_UP = 5;
	private final int MOVE_LEFT = 5;
	private final int MOVE_RIGHT = 5;
	private final int JUMP_HEIGHT = 60;
	private final int JUMP_SPEED = 6;
	private final int FALL_SPEED = 3;
	private int y;
	private int x;
	private boolean goRight = false;
	private boolean goLeft = false;
	private int maxHeight;
	private int minHeight;
	private boolean jumping = false;
	/**
	 * Constructs a player object at loc(x,y).
	 * @param xVal what x value player should be at.
	 * @param yVal what y value player should be at.
	 */
	public Player(int xVal, int yVal)
	{
		x = xVal;
		y = yVal;
		minHeight = y;
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
		maxHeight = y + JUMP_HEIGHT;
		minHeight = y;
		jumping = true;
	}
	public void rise() {
		if(jumping) {
			if(y<maxHeight && y<670) {
				y = y + JUMP_SPEED;
			}
			else{
				jumping = false;
			}
		}
	}
	public void fall() {
		if(y>minHeight) {
			y = y - FALL_SPEED;
		}
	}
}
