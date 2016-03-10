/**
 *Program: Drawing circles
 *Program Purpose: This program will draw a group of randomly colored circles when clicked
 *Author: Josh Jacobsen
 *Date: 4-6-2015
 *
 *Algorithm:
 *Create the constructor
 *Create getters and setters for the variables
 */
package lab8;

public class ExerciseGame 
{
	private int circleX = 200; 
	private int circleY = 100; 
	private int circleWidth = 50; 
	private int circleHeight= 100;
	
	public ExerciseGame(int x, int y, int wid, int hei)
	{
		this.circleX = x; this.circleY = y; this.circleWidth = wid; this.circleHeight = hei;
	}

	public void processMove( int x, int y)
	{
		this.circleX = x;
		this.circleY = y;
	}


	public int getCircleX() {
		return circleX;
	}

	public void setCircleX(int circleX) {
		this.circleX = circleX;
	}
	public int getCircleY() {
		return circleY;
	}

	public void setCircleY(int circleY) {
		this.circleY = circleY;
	}

	public int getCircleWidth() {
		return circleWidth;
	}

	public void setCircleWidth(int circleWidth) {
		this.circleWidth = circleWidth;
	}

	public int getCircleHeight() {
		return circleHeight;
	}

	public void setCircleHeight(int circleHeight) {
		this.circleHeight = circleHeight;
	}

}
