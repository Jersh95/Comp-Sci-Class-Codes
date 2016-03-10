/**
 *Program: Drawing circles
 *Program Purpose: This program will draw a group of randomly colored circles when clicked
 *Author: Josh Jacobsen
 *Date: 4-6-2015
 *
 *Algorithm:
 *In the main only create an instance of the ExerciseWindow
 *Create the constructor
 *Create initializeWindow() that will create the window
 */
package lab8;
import javax.swing.*;
import java.awt.*;

public class ExerciseWindow extends JFrame
{
	private int win_width = 600;
	private int win_height = 500;
	private ExerciseDisplay panel;

	/**
	 * In this method the only thing being done is creating a new instance of the ExerciseWindow
	 */
	public static void main(String[] args)
	{
		ExerciseWindow ew = new ExerciseWindow();
	}

	/**
	 *This is the constructor
	 */
	public ExerciseWindow()
	{
		this.setTitle("Exercise Window");
		this.setSize(win_width,win_height); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inititalizeWindow();
		this.setVisible(true); 
	}

	/**
	 *This method creates the window
	 */
	public void inititalizeWindow()
	{
		panel = new ExerciseDisplay();
		this.add(panel, BorderLayout.CENTER);
	}
}
