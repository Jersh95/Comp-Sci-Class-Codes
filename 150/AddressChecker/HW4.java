/**
 *Author: Josh Jacobsen
 *Date: 3/11/2015
 *
 *Program: Addresses
 *Program Purpose: This program will read through a text file of addresses, pick out the valid addresses, write it to a binary file, then read the binary file
 *
 *I copied the method to pick the file from the Maze Driver class from Homeworks 2/3
 *
 *Algorithm:
 *pick the file containing the addresses
 *create the object to display the correct addresses from the binary file
 */
package assignment4;

import java.io.File;
import javax.swing.JFileChooser;

public class HW4 {

	/**
	 *this method will return the chosen file
	 * @return - this is the file that contains the addresses
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
	 *this will create the object to display the correct addresses from the binary file
	 */
	public static void main(String[] args) 
	{
		//Gets the file
		File fileName = getFile();

		//Read the addresses from file "address.txt"
		Address[] addrs = Utils.parse(fileName.getName());

		// Save these address objects into file "objects.dat"
		Utils.saveObjects(addrs, "objects.dat");

		// Read these objects back from "objects.dat"
		Object[] objs = Utils.readObjects("objects.dat");

		//Print the information about each address in the specified format
		for (int i=0; i<objs.length; i++) 
		{
			System.out.println((Address)objs[i]);
		}
		System.out.println("\nAuthor: Josh Jacobsen");
	}
}
