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
 *Override the chooseMoveDirection method that will try to make the robot move straight, then try right, then try left, then as a last resort turn around
 *Override the move method that will take in the direction that was decided by the chooseMoveDirection method and move the robot in that direction recursively until it 
 *hits a wall long as that direction is available to move to
 * 
 * 
 *I coordinated with Sujan on how to figure out the logic for implementing the recursion
 */

package robotMaze;

public class LookAheadRobot extends FacingRobot
{
	private int moveCounter = 0;
	private int direction = 0;

	/**
	 *this is the constructor for the LookAheadRobot class
	 * @param inMaze - this is the maze object
	 */
	public LookAheadRobot(Maze inMaze) 
	{	
		super(inMaze);
	}

	public int chooseMoveDirection()
	{
		//This is the order the robot will try to move
		//Straight
		//If can't go straight, turn right
		//If can't go straight or turn right, turn left
		//As a last resort, turn around
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
			//this will check if it can go straight
			if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
			//if it can't go straight, it will go right, West
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');
			}
			//if it cannot move straight or right, it will try to move left, east
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
			//this will check if it can go straight
			if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');
			}
			//if it cannot move straight, it will try to move right
			else if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
			//if it cannot move straight or right, it will try to move left, west
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
			//this will see if it can move straight
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				direction = 2;
				this.setDirectionFacing('W');	
			}
			//if it cannot move straight, it will try to move right
			else if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				direction = 0;
				this.setDirectionFacing('N');
			}
			//if it cannot move straight or right, it will try to move left, south
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
			//this will see if it can move straight
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				direction = 3;
				this.setDirectionFacing('E');
			}
			//if it cannot move straight, it will try to move right
			else if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				direction = 1;
				this.setDirectionFacing('S');
			}
			//if it cannot move straight or right, it will try to move left, north
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
	 *This method will move the robot in the specified direction until it runs into a wall so long as that direction is available to move to
	 */
	public boolean move(int direction)
	{
		boolean moveMade = false;
		//This will move the robot north until it reaches a wall and mark its last space as empty
		if(direction == 0)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			if(checkCell(this.getCurrentRow() - 1, this.getCurrentColumn()) == true)
			{
				this.setCurrentRow(this.getCurrentRow() - 1);
				move(direction);
			}
			else
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn());
				moveMade = true;
				//moveCounter ++;
				//System.out.println("This is move #" + moveCounter + " for the robot.");
			}
		}

		//This will move the robot south until it reaches a wall and mark its last space as empty
		else if(direction == 1)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			if(checkCell(this.getCurrentRow() + 1, this.getCurrentColumn()) == true)
			{
				this.setCurrentRow(this.getCurrentRow() + 1);
				move(direction);
			}	 
			else
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn());
				moveMade = true;
				//moveCounter ++;
				//System.out.println("This is move #" + moveCounter + " for the robot.");
			}
		}

		//This will move the robot west until it reaches a wall and mark its last space as empty
		else if(direction == 2)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() - 1) == true)
			{
				this.setCurrentColumn(this.getCurrentColumn() - 1);
				move(direction);
			}
			else
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn());
				moveMade = true;
				//moveCounter ++;
				//System.out.println("This is move #" + moveCounter + " for the robot.");
			}
		}

		//This will move the robot east until it reaches a wall and mark its last space as empty
		else if(direction == 3)
		{
			this.setEmptyCell(this.getCurrentRow(), this.getCurrentColumn());
			if(checkCell(this.getCurrentRow(), this.getCurrentColumn() + 1) == true)
			{
				this.setCurrentColumn(this.getCurrentColumn() + 1);
				move(direction);
			}
			else
			{
				this.setCurrentCell(this.getCurrentRow(), this.getCurrentColumn());
				moveMade = true;
				//moveCounter ++;
				//System.out.println("This is move #" + moveCounter + " for the robot.");
			}			
		}
		return moveMade;
	}
}
