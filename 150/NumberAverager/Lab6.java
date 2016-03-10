/**
 *Author: Josh Jacobsen
 *Date: 3/9/2015
 *
 *I worked with Sujan to figure out this lab
 *
 *Algorithm:
 *create a method to choose the file
 *create a method to get the size for the array
 *create a method that will calculate and display the average of the numbers
 *in the main method read the file twice, once to get the size and the second to get the values
 */
package lab6;

import java.io.*;

import javax.swing.JFileChooser;

import java.text.DecimalFormat;
public class Lab6 {

	/**
	 * This method will get the chosen file
	 * @return - this will return the file
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
	 * This method returns the space or the size of the array
	 * @param dis
	 * @return
	 */
	public static int GetSpace(DataInputStream dis)
	{
		//counts the number of space that has to be given to the array variable
		boolean endofFile=false;
		int space=0;
		while(!endofFile)
		{
			try
			{
				System.out.println(dis.readDouble());
				space++;
			}
			catch(EOFException e)
			{					
				endofFile=true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return space;
	}

	/**
	 * This method will calculate and display the average of the array of numbers
	 * @param numbers - this is the array that the numbers read from the file is stored in
	 */
	public static void average(double[] numbers)
	{
		DecimalFormat decFor = new DecimalFormat("0.00");
		double average = 0;
		double sum = 0;
		for(int i = 0; i<numbers.length; i++)
		{
			sum += numbers[i];
		}
		average = sum/numbers.length;
		System.out.println("The average is: " + decFor.format(average));
	}

	/**
	 * Inside the main method the file is read and the array for the numbers is assigned the numbers from the file
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//variables
		boolean endofFile=false;
		DataInputStream dis=null;
		int count=0;
		int space;
		File nameFile;
		
		// calling the method getFile
		nameFile=getFile();

		/**
		 * This block will try to create a DataInputStream and catch any FileNotFoundExceptions
		 */
		try
		{
			dis=new DataInputStream(new FileInputStream(nameFile));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

		//Gets the size of the array
		space=GetSpace(dis);

		/**
		 * closes the dis and reopens it to read the file again while catching exceptions
		 */
		try
		{
			//Closing the file
			dis.close();
			dis=new DataInputStream( new FileInputStream(nameFile));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("FileNotFoundException was encountered.");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("IOException was encountered.");
			e.printStackTrace();
		}
		
		//Initializing and declaring the size of the array variable
		double [] numbers= new double[space];
		endofFile=false;
	
		/**
		 * this block assigns the numbers from the file to the array while catching exceptions
		 */
		while(!endofFile)
		{
			try
			{
				numbers[count]=dis.readDouble();
				count++;
			}
			catch(EOFException e)
			{					
				endofFile=true;
			}
			catch(IOException e)
			{
				System.out.println("IOException was encountered.");
				e.printStackTrace();
			}
		}
		
		/**
		 * closing the dis 
		 */
		try
		{
			dis.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("FileNotFoundException was encountered.");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("IOException was encountered.");
			e.printStackTrace();
		}
		
		//Calling the Average method to print the average of the numbers
		average(numbers);

	}
}

