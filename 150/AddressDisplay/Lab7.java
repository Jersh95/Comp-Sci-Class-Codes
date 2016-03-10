/**
 *Program: GUI Address 
 *Program Purpose: This program will display a GUI that prompts the user to enter the address information and save it to a binary file
 *Author: Josh Jacobsen
 *Date: 3/20/2015
 *
 *Algorithm:
 *Create the panel
 *Create and add the labels, text fields
 *Create a menu bar and menu items for save and exit
 *Create a listener for the save and exit menu items that will take the information in the text fields and save it to a chosen binary file using the Address 
 *	class's constructor if save is chosen and exit the program if exit is chosen
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Lab7 extends JFrame
{
	//Variables for panel use
	final private int width = 600;
	final private int height = 350;
	private String name = "";
	private JTextField nameTxt;
	private String address = "";
	private JTextField addressTxt;
	private String city = "";
	private JTextField cityTxt;
	private String state = "";
	private JTextField stateTxt;
	private String zip = "";
	private JTextField zipTxt;
	private String phone = "";
	private JTextField phoneTxt;
	private static Address addresses;

	JMenuItem saveMenuItem;
	JMenuItem exitMenuItem;
	JMenuItem clearMenuItem;

	/**
	 *This is the constructor for the GUI panel
	 */
	public Lab7()
	{
		this.setTitle("Addresses");
		this.setSize(width,height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
		this.setVisible(true);
	}

	/**
	 *This method will create the panel setting the buttons, labels, and text fields to their designated size and placement
	 */
	private void setPanel()
	{
		JPanel panel = new JPanel(new GridLayout(6,2));
		this.add(panel,BorderLayout.CENTER);

		//Creates the labels
		JLabel name = new JLabel("Name:");
		name.setForeground(Color.white);
		name.setFont(new Font("Courier New", Font.PLAIN, 15));
		JLabel address = new JLabel("Address:");
		address.setForeground(Color.white);
		address.setFont(new Font("Courier New", Font.PLAIN, 15));
		JLabel city = new JLabel("City:");
		city.setForeground(Color.white);
		city.setFont(new Font("Courier New", Font.PLAIN, 15));
		JLabel state = new JLabel("State:");
		state.setForeground(Color.white);
		state.setFont(new Font("Courier New", Font.PLAIN, 15));
		JLabel zip = new JLabel("Zip:");
		zip.setForeground(Color.white);
		zip.setFont(new Font("Courier New", Font.PLAIN, 15));
		JLabel phone = new JLabel("Phone:");
		phone.setForeground(Color.white);
		phone.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		//JLabel save = new JLabel("Save When Complete:");

		//Creates the text fields
		nameTxt = new JTextField(10);
		addressTxt = new JTextField(10);
		cityTxt = new JTextField(10);
		stateTxt = new JTextField(10);
		zipTxt = new JTextField(10);
		phoneTxt = new JTextField(10);

		//Adds the labels and text fields to the panel
		panel.add(name);
		panel.add(nameTxt);
		panel.add(address);
		panel.add(addressTxt);
		panel.add(city);
		panel.add(cityTxt);
		panel.add(state);
		panel.add(stateTxt);
		panel.add(zip);
		panel.add(zipTxt);
		panel.add(phone);
		panel.add(phoneTxt);
		//panel.add(save);
		panel.setBackground(Color.DARK_GRAY);
		JMenuBar bar = buildMenuBar();
		setJMenuBar(bar);

		//Creats and adds the save button and attaches the listener to the save button
		//JButton saveButton = new JButton("Save");
		//MyListener listener = new MyListener();
		//saveButton.addActionListener(listener);
		//panel.add(saveButton);

		//JPanel butPan = new JPanel();
		//butPan.add(saveButton);
		//panel.add(butPan);

	}

	/**
	 *I copied this method from the sample code MenuWindow from the Advanced GUI zip
	 *This method will create the items in the menu
	 * @return the created menu items
	 */
	private JMenu buildFileMenu(){
		// Create
		JMenu fileMenu = new JMenu("File");

		// Create the menu items
		saveMenuItem = new JMenuItem("Save");
		exitMenuItem = new JMenuItem("Exit");
		clearMenuItem = new JMenuItem("Clear Entries");
		
		// Add these menu items into fileMenu
		fileMenu.add(saveMenuItem);
		fileMenu.add(clearMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		// Hook up the menu items with the listener
		MyListener listener = new MyListener();
		exitMenuItem.addActionListener(listener);
		saveMenuItem.addActionListener(listener);
		clearMenuItem.addActionListener(listener);

		return fileMenu;
	}

	/**
	 *I copied this method from the sample code MenuWindow from the Advanced GUI zip
	 *This method will create the menu bar
	 * @return the created menu bar
	 */
	private JMenuBar buildMenuBar(){
		// Create a menu bar
		JMenuBar menuBar = new JMenuBar();

		// Call "buildFileMenu()" to create a menu and add it into the menu bar
		JMenu fileMenu = buildFileMenu();		
		menuBar.add(fileMenu);

		Label whiteSpace = new Label("                        ");
		menuBar.add(whiteSpace);
		menuBar.setBackground(Color.LIGHT_GRAY);
		return menuBar;
	}

	/**
	 * This method will choose which file the user wishes to save to
	 * @return - the file
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

	/**
	 * This method will save the information into a binary file chosen by the user
	 * @param objs - the Address object that contains the address information entered
	 * @param fileName - this is the file chosen by the user
	 */
	public static void Save(Object objs, String fileName)
	{
		ObjectOutputStream objectOutputFile = null;

		//try writing to the file while catching exceptions
		try
		{
			FileOutputStream outStream = new FileOutputStream(fileName);
			objectOutputFile = new ObjectOutputStream(outStream);

			//Here we are writing the object that has the addresses stored into the file
			objectOutputFile.writeObject(objs);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try 
		{
			objectOutputFile.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * This is the listener for the file menu items save and exit
	 * If save is selected then it will take the information from the text fields and create an Address object from them and save it to the file
	 * If exit is selected then the program will exit
	 * @author Josh Jacobsen
	 *
	 */
	private class MyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == exitMenuItem)
				System.exit(0);
			else if(e.getSource() == saveMenuItem)
			{
				String nameString = nameTxt.getText();
				String addressString = addressTxt.getText();
				String cityString = cityTxt.getText();
				String stateString = stateTxt.getText();
				String zipString = zipTxt.getText();
				String phoneString = phoneTxt.getText();
				Address addresses = new Address(nameString, addressString, cityString, stateString, zipString, phoneString);
				File file = getFile();
				Save(addresses, file.getPath());
				JOptionPane.showMessageDialog(null, "Your address has been saved.\n\nAuthor: Josh Jacobsen", "Address Saved", 1);
				System.exit(0);
			}
			else if(e.getSource() == clearMenuItem)
			{
				nameTxt.setText("");
				addressTxt.setText("");
				cityTxt.setText("");
				stateTxt.setText("");
				zipTxt.setText("");
				phoneTxt.setText("");
			}
		}
	}

	/**
	 *Main method that creates the GUI
	 */
	public static void main(String[] args) 
	{
		Lab7 nw = new Lab7();

	}

}
