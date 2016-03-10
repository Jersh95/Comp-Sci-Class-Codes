/**
 *Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 *Algorithm:
 *Create the constructor for the robot that will read in the maze and set the robot at the start position
 *Create abstract methods: chooseMoveDirection and move that will be overridden by each robot
 *Create a solved method that will return true when the robot has reached the exit space
 *Create getters and setters for currentRow and currentColumn as well as a getter for the robot's name and a setter for the current cell
 *Create a checkCell method that will check if a cell is open and available to move to
 *
 */
package robotMaze;

public abstract class Robot 
{
	/**
	 * these are variables to be used in the Robot class
	 */
	protected char rob = 'r';
	private Maze maze;
	private int exitRow;
	private int exitCol;
	private int currentRow;
	private int currentColumn;

	/**
	 * this is the constructor for the Robot
	 * @param inmaze - this is an instance of the maze class
	 */
	public Robot(Maze inmaze)
	{
		maze = inmaze;
		exitRow = maze.getExitRow();
		exitCol = maze.getExitCol();
		maze.setCell(maze.getStartRow(), maze.getStartCol(), rob);
		currentRow = maze.getStartRow();
		currentColumn = maze.getStartCol();
	}

	
	public void setMaze(Maze inMaze)
	{
		maze = inMaze;
	}
	
	
	/**
	 * this is an abstract method that must be overridden in the RandomRobot and RightHandRobots
	 * @return- this will be overridden to return the direction the robot will move
	 */
	public abstract int chooseMoveDirection();

	/**
	 * this is an abstract method that must be overridden in the RandomRobot and RightHandRobots
	 * @return - this will be overridden to return the move of the robot
	 */
	public abstract boolean move(int direction);

	/**
	 * this will determine if the robot has solved the maze
	 * @return - returns true if the robot has reached the exit space
	 */
	public boolean solved()
	{
		boolean solved = false;
		if(maze.getCell(exitRow, exitCol) == rob)
		{
			solved = true;
		}

		return solved;
	}

	/**
	 * this sets the current row the robot is in
	 * @param row - this is the desired row to be set as the current
	 */
	public void setCurrentRow(int row)
	{
		currentRow = row;
	}

	/**
	 * 
	 * @return - this will return the row the robot is currently in
	 */
	public int getCurrentRow()
	{
		return currentRow;
	}

	/**
	 * this sets the current column the robot is in
	 * @param row - this is the desired column to be set as the current
	 */
	public void setCurrentColumn(int col)
	{
		currentColumn = col;
	}

	/**
	 * 
	 * @return - this will return the column the robot is currently in
	 */
	public int getCurrentColumn()
	{	
		return currentColumn;
	}

	/**
	 * this gets the robots name
	 * @return - this will return the character's name (this is 'r')
	 */
	public char getRobotName()
	{	
		return rob;
	}

	/**
	 * this checks if the cell is open
	 * @param row - this is the desired row to check
	 * @param col - this is the desired column to check
	 * @return - returns true if the cell is open and false if it is not
	 */
	protected boolean checkCell(int row, int col)
	{
		return maze.openCell(row, col);	
	}

	/**
	 * this will set the current cell to the empty
	 * @param row - this is the desired row to set
	 * @param col - this is the desired column to set
	 */
	protected void setEmptyCell(int row, int col)
	{
		maze.setCell(row, col, ' ');
		setCurrentRow(row);
		setCurrentColumn(col);
	}
	
	/**
	 * this will set the current cell to the D representing a dead end
	 * @param row - this is the desired row to set
	 * @param col - this is the desired column to set
	 */
	protected void setDeadEndCell(int row, int col)
	{
		maze.setCell(row, col, 'D');
	}

	/**
	 * this will set the current cell to the robot's name
	 * @param row - this is the desired row to set
	 * @param col - this is the desired column to set
	 */
	protected void setCurrentCell(int row, int col)
	{
		maze.setCell(row, col, this.getRobotName());
		setCurrentRow(row);
		setCurrentColumn(col);
	}
}

