/**
 *Program: Drawing circles
 *Program Purpose: This program will draw a group of randomly colored circles when clicked
 *Author: Josh Jacobsen
 *Date: 4-6-2015
 *
 *Algorithm:
 *Create the constructor
 *Create the paintComponent method that will generate a random number and paint a circle based on that color
 */
package lab8;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ExerciseDisplay extends JPanel
{
	private ExerciseGame game; 
	private final int START_X = 200; 
	private final int START_Y = 100; 
	private final int START_Width = 50; 
	private final int START_Height= 100;
	private int number;
	private int random;
	private int numCircles = 100;

	/**
	 *This is the constructor
	 */
	public ExerciseDisplay()
	{
		//Initialize a new instance of the ExerciseGame
		game = new ExerciseGame(START_X,START_Y ,START_Width,START_Height );
		this.addMouseListener(new MouseListener(){

			/**
			 *This method will draw the circles when the mouse is clicked
			 *@param - this is the MouseEvent
			 */
			public void mouseClicked(MouseEvent me)
			{
				game.processMove(me.getX()-50,me.getY()-50);
				System.err.print("\n mouse clicked"); 
				repaint();
			}

			//We have to put these methods in otherwise the program will not run
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}


	/**
	 *In this method a random number is being generated and a circle is drawn with the color
	 *	based on the random number
	 *@param - this is the Graphics 
	 */
	public void paintComponent(Graphics g)
	{
		//This creates a random number
		Random randomNum = new Random();
		for(int i = 0; i<numCircles; i++)
		{	
			number = randomNum.nextInt(10) + 1;

			//This will set the color to each corresponding value
			switch(number)
			{
				case 1: g.setColor(Color.BLUE);
				break;
				case 2: g.setColor(Color.YELLOW);
				break;
				case 3: g.setColor(Color.GREEN);
				break;
				case 4: g.setColor(Color.BLACK);
				break;
				case 5: g.setColor(Color.CYAN);
				break;
				case 6: g.setColor(Color.RED);
				break;
				case 7: g.setColor(Color.GRAY);
				break;
				case 8: g.setColor(Color.PINK);
				break;
				case 9: g.setColor(Color.MAGENTA);
				break;
				case 10: g.setColor(Color.ORANGE);
				break;
			}

			//This will draw the circle based on the color and coordinates
			g.fillOval(game.getCircleX() + (i*5), game.getCircleY() - (i*5), game.getCircleWidth(), game.getCircleHeight());		
		}
	}




}
