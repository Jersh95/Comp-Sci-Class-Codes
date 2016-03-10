/**
 * Program: Robot Maze
 * Program Purpose: This program will visually display the robot to navigate through the maze
 * Author: Josh Jacobsen
 * Date: 4-13-15
 * 
 * I worked with Sujan to figure out some details in the logic of the gui
 * 
 * Algorithm:
 * Create the constructor
 * Create a JMenuBar that will construct and display the menu bar with buttons Run Maze and Robot
 * Create the method for building the Run menu item and attach the RunActionListener
 * 	This button will contain solve and exit
 * Create the method for building the Maze menu item and attach the MazeActionListener
 * 	This button will contain load file
 * Create the method for building the Robot menu item and attach the RobotActionListener
 * 	This method will contain each robot
 * 
 * Create the RunActionListener that will exit the program if the exit button is clicked and will call the run method when solve is clicked
 * Create the MazeAcionListener that will select the file and set the size of the window based on the file and get the panel set up
 * Create the RobotActionListener that will choose the robot and display it at the start position
 * 
 * Create the run method that will move the robot through the maze
 * Create the resetMaze method that will reset the maze to be allowed to run again
 * Create the getFile method that will choose the file 
 * 
 */
package robotMaze;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.UIManager.*;
import javax.swing.*;

public class MazeFrame extends JFrame
{
	private File file;
	private Maze maze;
	private Robot robot;
	private boolean isTraveling;

	private int width = 200;
	private int height = 200;
	private int smallWidth = 300;
	private int smallHeight = 350;
	private int bigWidth = 400;
	private int bigHeight = 450;


	private MazePanel panel;

	private JMenu robotMenu;
	private JMenu runMenu;
	private JMenu mazeMenu;

	private JMenuBar menuBar;

	JMenuItem solve;
	JMenuItem exit;

	JMenuItem loadFile;

	JMenuItem random;
	JMenuItem righthand;
	JMenuItem lefthand;
	JMenuItem lookahead;
	JMenuItem memory;


	/**
	 * This is the constructor for the MazeFrame
	 */
	public MazeFrame()
	{
		setTitle("Robot Maze");
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		isTraveling = false;
		menuBar = buildMenuBar();
		setJMenuBar(menuBar);
		setVisible(true);

		//This sets the LookAndFeel of the window to the desired design, I chose windows
		try{
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			e.getStackTrace();
		}

	}
	/**
	 * This method will create the menu bar
	 * @return - the menu bar
	 */
	private JMenuBar buildMenuBar()
	{
		menuBar = new JMenuBar();

		buildRunMenu();		
		menuBar.add(runMenu);

		buildMazeMenu();
		menuBar.add(mazeMenu);

		buildRobotMenu();
		menuBar.add(robotMenu);
		robotMenu.setEnabled(false);

		return menuBar;
	}

	/**
	 * This method will create the Run menu item attaching the solve and exit buttons to the appropriate listener
	 */
	private void buildRunMenu(){
		runMenu = new JMenu("Run");

		// Create the menu items
		solve = new JMenuItem("Solve");
		solve.setEnabled(false);
		exit = new JMenuItem("Exit");

		// Add these menu items into fileMenu
		runMenu.add(solve);
		runMenu.add(exit);

		// Hook up the menu items with the listener
		RunListener listener = new RunListener();
		solve.addActionListener(listener);
		exit.addActionListener(listener);
	}

	/**
	 * This method will create the Maze menu item attaching the Load File buttons to the appropriate listener
	 */
	private void buildMazeMenu(){
		mazeMenu = new JMenu("Maze");

		loadFile = new JMenuItem("Load File");
		mazeMenu.add(loadFile);

		// Hook up the menu items with the listener
		MazeListener listener = new MazeListener();
		loadFile.addActionListener(listener);
	}

	/**
	 * This method will create the Robot menu item attaching each robot button to the appropriate listener
	 */
	private void buildRobotMenu(){
		robotMenu = new JMenu("Robot");

		// Create the menu items
		random = new JMenuItem("Random Robot");
		righthand = new JMenuItem("Righthand Robot");
		lefthand = new JMenuItem("Lefthand Robot");
		lookahead = new JMenuItem("Look Ahead Robot");
		memory = new JMenuItem("Memory Robot");

		// Add these menu items into fileMenu
		robotMenu.add(random);
		robotMenu.add(righthand);
		robotMenu.add(lefthand);
		robotMenu.add(lookahead);
		robotMenu.add(memory);

		// Hook up the menu items with the listener
		RobotListener listener = new RobotListener();
		random.addActionListener(listener);
		righthand.addActionListener(listener);
		lefthand.addActionListener(listener);
		lookahead.addActionListener(listener);
		memory.addActionListener(listener);
	}

	/**
	 * This is the action listener for the Run menu item
	 * This will exit the program if exit is chosen and will
	 * run the program if solve is chosen
	 *
	 */
	private class RunListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == exit)
				System.exit(0);
			if(e.getSource() == solve)
			{
				run();
				/*for (int k = 0; k < 1000000 && !robot.solved(); k++) 
					//this limits the robot's moves, in case it takes too long to find the exit.
					{
						int direction = robot.chooseMoveDirection();
						if (direction >=0)  //invalid direction is -1
							robot.move(direction);
						System.out.println(maze);
						System.out.println("\n");
					}*/

			}
		}
	}

	/**
	 * This is the action listener for the Maze menu item
	 * This will prompt the user to select a file which will adjust the window size based on the file
	 * The maze will then paint on the panel and allow for the user to select the robot
	 *
	 */
	private class MazeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(isTraveling == true && robot.solved() == false)
			{
				mazeMenu.setEnabled(false);
			}
			else if(e.getSource() == loadFile)
			{
				try
				{

					file = getFile();
					maze = new Maze(file);
					panel = new MazePanel();
					panel.setMaze(maze);
					
					/**
					 * I tried to use the following lines to get the window to display the size based on the rows and columns * the rec width and height,
					 * but it would not work
					 */
					//panel.setWidth(maze.getRows() * panel.getRecWidth());
					//panel.setHeight(maze.getColumns()* panel.getRecHeight());
					//width = panel.getWidth() + 40;
					//height = panel.getHeight() + 40;
					
					width = 500;
					height = 500;
					setSize(width, height);
					add(panel);
					robotMenu.setEnabled(true);	
					panel.repaint();
					/*
					file = getFile();
					if(file.getName().equals("biggermaze.txt"))
					{
						width = bigWidth;
						height = bigHeight;
						setSize(width, height);
					}
					else if(file.getName().equals("testmaze.txt"))
					{
						width = smallWidth;
						height = smallHeight;
						setSize(width, height);
					}
					 */	
					//resetMaze();
						
				}
				catch(Exception ex)
				{
					System.out.println("Exception: " + ex.getMessage());
					System.exit(0);
				}
			}
		}
	}

	/**
	 * This method will reset the maze to it's beginning position
	 */
	public void resetMaze() 
	{
		if(isTraveling == false && maze!= null)
		{
			maze = new Maze(file);	
			panel.setMaze(maze);
			repaint();
		}
	}

	/**
	 * This is the action listener for the Robot menu item
	 * This will load in the robot to be used to solve the maze depending on the robot the user selects
	 * The solve option will then be available
	 *
	 */
	private class RobotListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//This shouldn't be needed but it isn't hurting anything either
			if(isTraveling == true && robot.solved() == false)
			{
				random.setEnabled(false);
				righthand.setEnabled(false);
				lefthand.setEnabled(false);
				lookahead.setEnabled(false);
				memory.setEnabled(false);
			}

			//If the random robot is selected
			else if(e.getSource() == random)
			{
				robot = new RandomRobot(maze);
				panel.setRobot(robot);
				solve.setEnabled(true);
				panel.repaint();
				//resetMaze();
			}

			//If the righthand robot is selected
			else if(e.getSource() == righthand)
			{
				robot = new RightHandRobot(maze);
				panel.setRobot(robot);
				solve.setEnabled(true);
				panel.repaint();
				//resetMaze();
			}

			//If the lefthand robot is selected
			else if(e.getSource() == lefthand)
			{
				robot = new LeftHandRobot(maze);
				panel.setRobot(robot);
				solve.setEnabled(true);
				panel.repaint();
				//resetMaze();
			}

			//If the lookahead robot is selected
			else if(e.getSource() == lookahead)
			{
				robot = new LookAheadRobot(maze);
				panel.setRobot(robot);
				solve.setEnabled(true);
				panel.repaint();
				//resetMaze();
			}
			//If the memory robot is selected
			else if(e.getSource() == memory)
			{
				robot = new MemoryRobot(maze);
				panel.setRobot(robot);
				solve.setEnabled(true);
				panel.repaint();
				//resetMaze();
			}
		}
	}


	/**
	 * This method is what tells the robot to move through the maze
	 * It calls the chooseMoveDirection method to determine where the robot will move and then moves the robot's
	 * current location to that cell
	 * A message will appear when the robot solves the maze telling the user to select another combination
	 */
	public void run()
	{
		isTraveling = true;
		try 
		{
			Thread.sleep(500);
			for (int k = 0; k < 1000000 && !robot.solved(); k++) 
				//this limits the robot's moves, in case it takes too long to find the exit.
			{
				int direction = robot.chooseMoveDirection();
				if (direction >=0)  //invalid direction is -1
				{

					robot.move(direction);
					panel.paintImmediately(0,0,panel.getWidth(), panel.getHeight()); 
					Thread.sleep(1);

				}
			}
			//maze = null;
			isTraveling = false;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		if(robot.solved() == true)
		{
			JOptionPane.showMessageDialog(null, "The robot has completed the maze!\n"
					+ "Select the same or another maze as well as another robot.", "Robot Maze", 1);	
			resetMaze();
		}

		panel.setVisible(false);
	}


	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; 
	}


}
