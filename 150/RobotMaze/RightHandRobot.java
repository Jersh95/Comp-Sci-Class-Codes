/**
 *Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 *Algorithm:
 *Create the constructor
 *Override the chooseMoveDirection method that will try to make the robot move right, then try straight, then try left, then as a last resort turn around
 *Override the move method that will take in the direction that was decided by the chooseMoveDirection method and will assign the robot's new position in the maze as
 *long as the cell is available to move to
 */
package robotMaze;

public class RightHandRobot extends FacingRobot
{	
	private int direction = 0;
	private int moveCounter = 0;

	/** 
	 * this is the constructor for the RightHandRobot
	 * @param - this is an instance of the Maze class
	 */
	public RightHandRobot(Maze inMaze) 
	{	
		super(inMaze);
	}

	/**
	 * this method will choose which direction the robot will move based on which direction it is facing, it will always try to turn right first,
	 * if it cannot turn right, it will try to go straight, if it can not do either then it will move left, as a last resort it will turn around and move straight
	 * the robot will only move one space at a time
	 */
	public int chooseMoveDirection() 
	{
		//The directions are as follows:
		//0 = north
		//1 = south
		//2 = west
		//3 = east

		/**
		 * this block of code determines which direction the robot will move based on it facing south
		 */
		if(this.getDirectionFacing() == 'S')
		{
			//checks right, west, first if it can move there
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');
			}
			//if it cannot move right, it will try to move straight
			else if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
			//if it cannot move right or straight, it will try to move left, east
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
			//as a last resort, it will back up
			else if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');
			}
		}

		/**
		 * this block of code determines which direction the robot will move based on it facing north
		 */
		else if(this.getDirectionFacing() == 'N')
		{
			//checks right, east, first if it can move there
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
			//if it cannot move right, it will try to move straight
			else if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');
			}
			//if it cannot move right or straight, it will try to move left, west
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');
			}
			//as a last resort, it will back up
			else if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
		}

		/**
		 * this block of code determines which direction the robot will move based on it facing west
		 */
		else if(this.getDirectionFacing() == 'W')
		{
			//checks right, north, first if it can move there
			if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');	
			}
			//if it cannot move right, it will try to move straight
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');
			}
			//if it cannot move right or straight, it will try to move left, south
			else if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
			//as a last resort, it will back up
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
		}

		/**
		 * this block of code determines which direction the robot will move based on it facing east
		 */
		else if(this.getDirectionFacing() == 'E')
		{
			//checks right, south, first if it can move there
			if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
			//if it cannot move right, it will try to move straight
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
			//if it cannot move right or straight, it will try to move left, north
			else if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');
			}
			//as a last resort, it will back up
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');
			}
		}

		return direction;
	}

	/**
	 *This method will move the robot one space in the specified direction so long as that space is open to move to
	 */
	public boolean move(int direction)
	{
		boolean moveMade = false;
		//This will move the robot north one space and mark its last space as empty
		if(direction == 0)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow() - 1, this.getCurrentColumn());
			moveMade = true;
			//moveCounter ++;
			//System.out.println("This is move #" + moveCounter + " for the robot.");
		}

		//This will move the robot south one space and mark its last space as empty
		else if(direction == 1)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow() + 1, this.getCurrentColumn());
			moveMade = true;
			//moveCounter ++;
			//System.out.println("This is move #" + moveCounter + " for the robot.");
		}

		//This will move the robot west one space and mark its last space as empty
		else if(direction == 2)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() - 1);
			moveMade = true;
			//moveCounter ++;
			//System.out.println("This is move #" + moveCounter + " for the robot.");
		}

		//This will move the robot east one space and mark its last space as empty
		else if(direction == 3)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() + 1);
			moveMade = true;
			//moveCounter++;
			//System.out.println("This is move #" + moveCounter + " for the robot.");
		}
		return moveMade;
	}
}
