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
 *Override the chooseMoveDirection method that will randomly generate a number between 0-4(not including 4) that determines the direction the robot will move
 *Override the move method that will take in the direction that was generated by the chooseMoveDirection method and will check if there is only one space available
 *for the robot to move to. If it only has one space, it will mark the current space as dead end and move to the empty space.
 *Otherwise, it will assign the robot's new position in the maze as the direction it rolled as long as the cell is available to move to
 */
package robotMaze;
import java.util.*;



public class MemoryRobot extends FacingRobot
{
	private int moveCounter = 0;
	ArrayList<Location> cellMemory = new ArrayList<Location>();

	/**
	 * this is the constructor for the RandomRobot class
	 * @param - this is an instance of the Maze class
	 */
	public MemoryRobot(Maze inMaze) 
	{	
		super(inMaze);
	}

	/**
	 * this method randomly generates a number between 0 and 4 (not including 4) that determines which direction the robot will move to
	 * the robot will only move one space at a time
	 * @return - this returns the number for the robot's direction
	 */
	public int chooseMoveDirection() 
	{
		Random randomInt = new Random();
		int direction = randomInt.nextInt(4);
		return direction;
	}

	/**
	 * This method will check every direction around the robot's current location and determine how many open cells are around the robot
	 * @return - the number of open cells
	 */
	public int openNeighborCells()
	{
		int openCount = 0;
		if(this.checkCell(this.getCurrentRow() -1, this.getCurrentColumn()) == true)
		{
			openCount++;
		}
		if(this.checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
		{
			openCount++;
		}
		if(this.checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
		{
			openCount++;
		}
		if(this.checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
		{
			openCount++;
		}
		return openCount;
	}

	/**
	 * this method actually moves the robot
	 * @param - this is the direction that has been randomly rolled for the robot to move to
	 * @return - this will return true if the move has been made or false if the move has not been made
	 */
	public boolean move(int direction) 
	{		
		boolean moveMade = false;
		
		/**
		 * This block will check if there is only one open cell around the robot, if so, it will 
		 * 	set the current cell as a dead end and move the robot to the open cell
		 * If there is more than one space open, it will move based on the direction it rolled
		 */
		if (openNeighborCells() == 1)
		{
			Location l = new Location(this.getCurrentRow(),this.getCurrentColumn());
			cellMemory.add(l);
			this.setDeadEndCell(this.getCurrentRow(), this.getCurrentColumn());

			//This will move the robot north
			if(this.checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				this.setCurrentCell(this.getCurrentRow() - 1, this.getCurrentColumn());
				moveMade = true;
			}
			
			//This will move the robot south
			else if(this.checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				this.setCurrentCell(this.getCurrentRow() + 1, this.getCurrentColumn());
				moveMade = true;
			}
			
			//This will move the robot west
			else if(this.checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() - 1);
				moveMade = true;
			}
			
			//This will move the robot east
			else if(this.checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() + 1);
				moveMade = true;
			}
		}
		/**
		 * this section of code is for the robot moving north
		 */

		else if(direction == 0 && this.checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
		{
			//The robot will move north
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow() - 1, this.getCurrentColumn());
			moveMade = true;
		}

		/*else if(direction == 0)
		{
			//if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			//{
			if(openNeighborCells() == 1 && this.checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				Location l = new Location(this.getCurrentRow(),this.getCurrentColumn());
				cellMemory.add(l);
				this.setDeadEndCell(this.getCurrentRow(), this.getCurrentColumn());
				for(int i = 0; i< cellMemory.size(); i++)
				{
					if(cellMemory.get(i).getRow() !=this.getCurrentRow() && cellMemory.get(i).getCol() !=this.getCurrentColumn())
					{

						this.setCurrentCell(this.getCurrentRow() + 1, this.getCurrentColumn());
					}
				}
			}
		}*/

		/**
		 * this section of code is for the robot moving south
		 */
		else if(direction == 1 && this.checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
		{
			//The robot will move south
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow() + 1, this.getCurrentColumn());
			moveMade = true;
		}

		/**
		 * this section of code is for the robot moving west
		 */
		else if(direction == 2 && this.checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
		{
			//The robot will move west
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() - 1);
			moveMade = true;
		}

		/**
		 * this section of code is for the robot moving east
		 */
		else if(direction == 3 && this.checkCell(this.getCurrentRow(), this.getCurrentColumn() +1) == true)
		{
			//The robot will move east	
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn() + 1);
			moveMade = true;
		}

		

		return moveMade;
	}
}
