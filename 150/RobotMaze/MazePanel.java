/**
 * Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 * Algorithm:
 * Override the paintComponent method to read through the maze and set the * to blue walls and the empty spaces to white and draw a red dot to display where the robot
 * 	as well as a yellow square where the dead ends are once the robot reaches them
 * currently is in the maze
 * Add getters and setters
 * 
 */
package robotMaze;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class MazePanel extends JPanel
{
	private Maze maze;
	private Robot robot;

	private int recWidth = 20;
	private int recHeight = 20;

	private int height = 400;
	private int width = 400;

	private int robSize = 12;

	/**
	 *This is a default constructor for the class;
	 */
	MazePanel()
	{
		robot = null;
		maze = null;
	}

	/**
	 *This is a getter for the height of the panel
	 */
	public int getHeight() 
	{
		return height;
	}

	/**
	 *This is a setter for the height of the panel
	 * @param height - this is the height
	 */
	public void setHeight(int height) 
	{
		this.height = height;
	}

	/**
	 * This is a getter for the width
	 * @return - thewidth
	 */
	public int getWidth() 
	{
		return width;
	}

	/**
	 * This is a setter for the width
	 * @param width - the width
	 */
	public void setWidth(int width) 
	{
		this.width = width;
	}

	/**
	 * Getter for the rectangle width
	 * @return - the recWidth
	 */
	public int getRecWidth() {
		return recWidth;
	}

	/**
	 * Setter for the rectangle width
	 * @param - the recWidth
	 */
	public void setRecWidth(int recWidth) {
		this.recWidth = recWidth;
	}

	/**
	 * Getter for the rectangle height
	 * @return - the recHeight
	 */
	public int getRecHeight() {
		return recHeight;
	}

	/**
	 * Getter for the rectangle height
	 * @param - the recHeight
	 */
	public void setRecHeight(int recHeight) 
	{
		this.recHeight = recHeight;
	}

	/**
	 * This is a setter for the maze
	 * @param inMaze - the maze to be used
	 */
	public void setMaze(Maze inMaze)
	{
		maze = inMaze;
	}

	/**
	 * This is a setter for the robot
	 * @param inRobot - the robot to be used
	 */
	public void setRobot(Robot inRobot)
	{
		robot = inRobot;
	}

	/**
	 * This is a getter for the robot
	 * @return - the robot
	 */
	public Robot getRobot()
	{
		return robot;
	}

	/**
	 *The paintComponent method gets overwritten to read the maze and set the walls to a blue rectangle and the open spaces to a white
	 *rectangle. The robot gets set to a red ball at the start position and will move through the maze.
	 *
	 * @param g 
	 */
	protected void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		if(maze != null)
		{
			//This will look through the maze array and paint a blue rectangle for the walls and a white rectangle
			//for the spaces
			try 
			{
				for(int r = 0; r< maze.getRows(); r++)
				{
					for(int c = 0; c< maze.getColumns(); c++)
					{
						if(maze.getCell(r, c) == '*')
							g.setColor(Color.BLUE);
						else if(maze.getCell(r, c) == 'S' || maze.getCell(r, c) == 'X' || maze.getCell(r, c) == ' ' ||  maze.getCell(r, c) == 'r')
							g.setColor(Color.WHITE);
						//else if(maze.getCell(r, c) == 'D')
						//g.setColor(Color.YELLOW);

						g.fillRect(c*recWidth,r*recHeight ,recWidth, recHeight);
					}
				}

				//This will create a red ball representing the robot. It will be placed at the beginning once the maze has been selected
				//And will follow the robot through the maze.

				g.setColor(Color.RED);

				//This would set a ball to the beginning space, but it will not delete
				//g.fillOval(maze.getStartCol()* recWidth + 3, maze.getStartRow()*recHeight + 3, robSize, robSize);


				//This will fill the robot in it's current position, deleting it's last one
				try
				{
					g.fillOval(robot.getCurrentColumn() * recWidth + 3, robot.getCurrentRow()*recHeight + 3, robSize, robSize);
				}
				catch(NullPointerException ex)
				{

				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}

			/**
			 * This will set a maze cell to yellow to represent the robot has detemined it to be a dead end cell
			 */
			g.setColor(Color.YELLOW);
			for(int r = 0; r < maze.getRows(); r++)
			{
				for(int c = 0; c<maze.getColumns(); c++)
				{
					if(maze.getCell(r, c) == 'D')
					{
						g.setColor(Color.YELLOW);
						g.fillRect(c*recWidth,r*recHeight ,recWidth, recHeight);
					}
				}
			}
		}
	}


}