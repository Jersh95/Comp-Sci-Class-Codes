/**
 *Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 *Algorithm:
 *Create the constructor that will read in the maze information
 *Set the direction facing to south as the default
 *Define abstract methods for chooseMoveDirection and move that act as "rules" that must be usesd
 *Create a getter and setter for directionFacing
 * 
 */

package robotMaze;

public abstract class FacingRobot extends Robot
{
	private char directionFacing = 'S';

	/**
	 *this is the constructor for the FacingRobot class
	 * @param inMaze - this is the maze object
	 */
	public FacingRobot(Maze inMaze) 
	{	
		super(inMaze);
	}

	/**
	 *this is an abstract method for choosing the move direction
	 */
	public abstract int chooseMoveDirection();

	/**
	 *this is an abstract method for making the direction
	 */
	public abstract boolean move(int direction);

	/**
	 *this is a getter for the direction the robot is facing
	 * @return - the direction the robot is facing
	 */
	public char getDirectionFacing()
	{
		return directionFacing;
	}

	/**
	 *this is a setter for the direction the robot is facing
	 * @param inDirectionFacing - this is the direction that the robot will now be facing
	 */
	public void setDirectionFacing(char inDirectionFacing)
	{
		directionFacing = inDirectionFacing;
	}
	
	
}
