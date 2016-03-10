/**
 *Author: Josh Jacobsen
 *Date: 3/11/2015
 *
 *Program: Addresses
 *Program Purpose: This program will read through a text file of addresses, pick out the valid addresses, write it to a binary file, then read the binary file
 *
 *I coordinated with Sujan on how to figure the logic behind reading and writing the binary files
 *
 *Algorithm:
 *create the parse method that will read the file and assign the addresses to the array
 *create the scanners
 *create the checkPhone method that will look at the phone number and determine if the phone number is valid or not
 *read through the file the first time and update the array index counter if the phone number is valid
 *assign the array index to the number of valid phone numbers
 *read through the file again and assign the address to the array
 *create the saveObjects method that will write the array to a binary file
 *create the readObjects method that will read the binary file and return the array of addresses
 */

package assignment4;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils
{
	//variables for the Utils class
	private static String name;
	private static String street;
	private static String city;
	private static String state;
	private static String zip;
	private static String phone;
	private static Address[] addresses;
	private static int addressIndex = 0;

	/**
	 * this method will read a file twice, once to count the number of valid addresses and the second to save the addresses to an array
	 * @param fileName - this is the file containing the addresses
	 * @return - the array containing the addresses
	 */
	public static Address[] parse(String fileName)
	{
		//Set up a counter and scanners
		int lineCount = 0;
		Scanner lineCountScan = null;
		Scanner fileScan = null;

		//This will try and open the file assigning it to the scanners and catch a FileNotFoundException
		try
		{
			File file = new File(fileName);
			lineCountScan = new Scanner(file);
			fileScan = new Scanner(file);

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(0);
		}

		//This block will read the file and update the counter if the phone number matches the valid formats
		while(lineCountScan.hasNext())
		{
			//String lineDataCount = lineCountScan.nextLine();
			//lineCount++;

			boolean phoneCheck = false;
			String lineDataCount = lineCountScan.nextLine();
			StringTokenizer lineTokenCount = new StringTokenizer(lineDataCount,":,");

			//Read in the the files until we reach the phone number token
			lineTokenCount.nextToken();
			lineTokenCount.nextToken();
			lineTokenCount.nextToken();
			StringTokenizer splitStateZip = new StringTokenizer (lineTokenCount.nextToken()," ");
			splitStateZip.nextToken();
			splitStateZip.nextToken();

			//Test the phone number's format, if it is valid then it will return true and update the counter
			String phoneTest = lineTokenCount.nextToken();
			phoneCheck = checkPhone(phoneTest);
			if(phoneCheck == true)
			{
				lineCount ++;
			}


		}
		lineCountScan.close();

		//Initialize the addresses array with the number of valid lines in the file
		addresses = new Address[lineCount];

		//Reads the file again, this time assigning each address to an index in the addresses array
		while(fileScan.hasNext())
		{
			String lineData = fileScan.nextLine();
			StringTokenizer splitData = new StringTokenizer(lineData,":,");

			//Assign each field to it's token
			name = splitData.nextToken();
			street = splitData.nextToken();
			city = splitData.nextToken();
			StringTokenizer splitStateZip = new StringTokenizer (splitData.nextToken()," ");
			state = splitStateZip.nextToken();
			zip = splitStateZip.nextToken();
			boolean phoneCheck = false;
			String phoneToken = splitData.nextToken();

			//Test the phone number's format, if it is valid then it will return true and update the array
			phoneCheck = checkPhone(phoneToken);
			if(phoneCheck == true)
			{
				phone = phoneToken;
				Address addressObject = new Address(name,street,city,state,zip,phone);
				addresses[addressIndex] = addressObject;
				addressIndex++;
			}

		}
		fileScan.close();
		return addresses;
	}

	/**
	 * This method will check the format of the phone and return true if it matches one of the following formats:
	 * 1)xxxxxxxxxx
	 * 2)(xxx)xxx-xxxx
	 * 3)xxx-xxx-xxxx
	 * I could have tokenized the phone number and tested the length and digits only, but doing it this way, be it is longer, tests the specific formats of each phone number
	 * @param inPhone - this is the phone number we are testing
	 * @return - true if the phone number matches one of the correct formats
	 */
	public static boolean checkPhone (String inPhone)
	{
		int validCount = 0;
		boolean isValid = false;

		//This first if statement will check the phone number format xxxxxxxxxx
		if(inPhone.length() == 10)
		{
			for(int i = 0; i<inPhone.length(); i++)
			{
				if(Character.isDigit(inPhone.charAt(i)))
				{
					validCount++;
				}
				else
					isValid = false;

			}
			if(validCount == 10)
			{
				isValid = true;
			}
			else
			{
				isValid = false;
				validCount = 0;
			}
		}

		//The second if statement will check the phone number format (xxx)xxx-xxxx
		else if(inPhone.charAt(0) == '(')
		{
			for(int c = 1; c < 4; c++)
			{
				if(Character.isDigit(inPhone.charAt(c)))
				{
					validCount++;
				}
				else 
					isValid = false;
			}
			if(inPhone.charAt(4) == ')')
			{
				for(int a = 5; a < 8; a++)
				{
					if(Character.isDigit(inPhone.charAt(a)))
					{
						validCount++;
					}
					else
						isValid = false;
				}
			}
			else
				isValid = false;
			if(inPhone.charAt(8) == '-')
			{
				for(int a = 9; a < inPhone.length(); a++)
				{
					if(Character.isDigit(inPhone.charAt(a)))
					{
						validCount++;
					}
					else
						isValid = false;
				}
			}
			if(validCount == 10)
			{
				isValid = true;
			}

			else
			{	
				isValid = false;
				validCount = 0;
			}
		}

		//The third if statement will check the phone number format xxx-xxx-xxxx
		else if(Character.isDigit(inPhone.charAt(0)) && Character.isDigit(inPhone.charAt(1)) && Character.isDigit(inPhone.charAt(2)))
		{
			validCount+=3;
			if(inPhone.charAt(3) == '-')
			{
				for(int i = 4; i<7; i++)
				{
					if(Character.isDigit(inPhone.charAt(i)))
					{
						validCount++;
					}
					else
						isValid = false;
				}
				if(inPhone.charAt(7) == '-')
				{
					for(int a = 8; a<inPhone.length(); a++)
					{
						if(Character.isDigit(inPhone.charAt(a)))
						{
							validCount++;
						}
						else
							isValid = false;
					}
					if(validCount == 10)
					{
						isValid = true;
					}
				}
				else
					isValid = false;
			}
			else
				isValid = false;
		}
		//Last resort, if none of the formats are matched
		else
		{
			isValid = false;
			validCount = 0;
		}

		return isValid;
	}

	/**
	 * This method is not used after I changed my program, but it will test that the length of the phone number is 10 digits
	 * @param inPhone - this is the phone number being tested
	 * @return - true if the phone number has 10 digits in it
	 */
	public static boolean checkLength(String inPhone)
	{
		boolean isLength = false;
		if(inPhone.length() == 10)
		{
			isLength = true;
		}
		return isLength;
	}

	/**
	 * this method will write the array of objects to the given file
	 * @param objs - this is the array of addresses
	 * @param fileName - this is the file to write the addresses to
	 */
	public static void saveObjects(Object[] objs, String fileName)
	{
		ObjectOutputStream objectOutputFile = null;
		//try writing to the file while catching exceptions
		try
		{
			FileOutputStream outStream = new FileOutputStream(fileName);
			objectOutputFile = new ObjectOutputStream(outStream);

			//Here we are writing the array of objects that has the addresses stored into the file
			for(Object i: objs)
			{	
				objectOutputFile.writeObject(i);
			}

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
	 * this method will read the file that contains the addresses
	 * @param fileName - this is the file that contains the addresses
	 * @return - this will return the array of addresses
	 */
	public static Object[] readObjects(String fileName)
	{

		//This is where we read the file for the first time to count how many lines are in the file to set in our array limit
		ObjectInputStream objectCountFile = null;
		Object[] objs;
		int count = 0;
		boolean endOfFile = false;

		//try to open the file while catching exceptions
		try
		{
			FileInputStream inStream = new FileInputStream(fileName);
			objectCountFile = new ObjectInputStream(inStream);
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

		//read the file while there is another line to read and update the counter when a valid phone number is found
		while (!endOfFile)
		{
			try
			{
				objectCountFile.readObject();

				count ++;
			}
			catch(EOFException e)
			{//let the exception happen
				endOfFile = true;
			}catch(IOException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}//end while
		try
		{
			objectCountFile.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}

		//This is where we read the file the second time, this time to actually assign the information into the array
		endOfFile = false;
		int counter = 0;
		ObjectInputStream objectInputFile = null;
		objs = new Object[count];

		//try to open the file while catching exceptions
		try
		{
			FileInputStream inStream = new FileInputStream(fileName);
			objectInputFile = new ObjectInputStream(inStream);
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

		//read the file while there is another line to read and update the counter when a valid phone number is found
		while (!endOfFile)
		{
			try
			{
				objs[counter] = objectInputFile.readObject();
				counter++;

			}
			catch(EOFException e)
			{
				endOfFile = true;
			}catch(IOException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}//end while
		try
		{
			objectInputFile.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return objs;
	}
}
