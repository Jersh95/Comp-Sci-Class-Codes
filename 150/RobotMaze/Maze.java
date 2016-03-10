/**
 *Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 * Algorithm
 * Open the file
 * Read the file and assign the values for the array's constructor for rows and columns based on the first three lines of the file
 *	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
 *	In the second line:  two integers (the row and column locations, respectively, of the Start cell
 *	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
 * Create getters and setters for the num of rows/columns, start row/column, exit row/column, and getCell/setCell
 * Create an openCell method that tests if a given cell is available to move to
 * Create the toString that will display the maze
 */

package robotMaze;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Maze 
{	
	/**
	 * These are the variables used for the Maze class
	 */
	private char[][] maze = null;
	private int rows = 0;
	private int cols = 0;
	private int startRow = 0;
	private int startCol = 0;
	private int exitRow = 0;
	private int exitCol = 0;
	private JFileChooser chooser;


	/**
	 * This method will open the file, assign the number of rows, columns, the start row, and column, and the exit row, and column.
	 * @param filename - This takes in the file from the the driver and assigns the maze from it
	 * @throws FileNotFoundException
	 */
	public Maze(File inFile) 
	{
		try
		{	
			Scanner fileScan = new Scanner(inFile);
			while(fileScan.hasNext())
			{
				rows = fileScan.nextInt();
				cols = fileScan.nextInt();
				startRow = fileScan.nextInt();
				startCol = fileScan.nextInt();
				exitRow = fileScan.nextInt();
				exitCol = fileScan.nextInt();
				fileScan.nextLine();
				maze = new char [rows][cols];
				String rowString = "";

				/**
				 * This section assigns the maze
				 */
				for(int row = 0; row < rows; row++)
				{
					rowString = fileScan.nextLine();
					for(int col = 0; col < cols; col++)
					{
						maze[row][col] = rowString.charAt(col);
					}
				}
			}

			fileScan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);
		}


	}

	/**
	 * 
	 * @return - this method returns the number of rows in the maze
	 */
	public int getRows()
	{
		int numRows = rows;
		return numRows;
	}

	/**
	 * 
	 * @return - this method returns the number of columns in the maze
	 */
	public int getColumns()
	{
		int numCols = cols;
		return numCols;
	}

	/**
	 * 
	 * @return - this method returns the start row
	 */
	public int getStartRow()
	{
		int numStartRow = startRow;
		return numStartRow;
	}

	/**
	 * 
	 * @return - this method returns the start column
	 */
	public int getStartCol()
	{
		int numStartCol = startCol;
		return numStartCol;
	}

	/**
	 * 
	 * @return - this method returns the exit row
	 */
	public int getExitRow()
	{
		int numExitRow = exitRow;
		return numExitRow;
	}

	/**
	 * 
	 * @return - this method returns the exit column
	 */
	public int getExitCol()
	{
		int numExitCol = exitCol;
		return numExitCol;
	}

	/**
	 * 
	 * @param row - this is the row to check the value of
	 * @param col - this is the column to check the value of
	 * @return - returns the value of the index of the maze at the given row and column
	 */
	public char getCell(int row, int col)
	{
		char currentCell = maze[row][col];
		return currentCell;
	}

	/**
	 * 
	 * @param row - this is the desired row to set a value in
	 * @param col - this is the desired column to set a value in
	 * @param newCh - this is the character that will be placed in this index
	 */
	public void setCell(int row, int col, char newCh)
	{
		maze[row][col] = newCh;
	}

	/**
	 * 
	 * @param row - this is the desired row to check a value of
	 * @param col - this is the desired column to check a value of
	 * @return - this will return true if the space is open (the character in the space is a ' ') and false if it is not open (the character in the space is a '*')
	 */
	public boolean openCell(int row, int col)
	{
		boolean isOpen = false;

		if(row < rows && row >= 0 && col < cols && col >= 0)
		{
			if(maze[row][col] != '*' && (maze[row][col] != 'D' && (maze[row][col] != 'S')))
			{
				isOpen = true;
			}
		}
		return isOpen;
	}

	/**
	 * this method will print out the maze array
	 */
	public String toString()
	{
		String results = "";
		for(int row = 0; row < rows; row++)
		{
			for(int col = 0; col < cols; col++)
			{
				results += maze[row][col];
			}
			results += "\n";
		}
		return results;
	}


}
