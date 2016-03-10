/**
 * Program: Palindrome Sorter
 * Program Purpose: This program will read through a file, determine if each word or phrase is a palindrome, then sort and display the palindromes in alphabetical order
 * 
 * Author: Josh Jacobsen
 * Date: 4/29/2015
 * 
 * I took most of this code from my lab 4
 * 
 * Algorithm:
 * Read the file and add the palindromes to an array list
 * Sort through the list and display the palindromes in alphabetical order
 */
package lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Lab10 
{

	public static void main(String[] args) 
	{
		/**
		 * Create an array list and prepare file reading
		 */
		ArrayList<String> palindromeList = new ArrayList<String>();
		File file = new File (getFile().getName());
		Scanner inScan = null;
		try 
		{
			inScan = new Scanner(file);
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Error: A file was not chosen.");
			e.printStackTrace();
		}

		/**
		 * This will read through the file and determine if the words or phrases are a palindrome.
		 * If they are, the word or phrase will be added to an array list
		 */
		while(inScan.hasNext())
		{
			String word = inScan.nextLine();
			
			if(palindromeCheck(word) == true)
			{

				System.out.println(word + " is a palindrome.");
				palindromeList.add(word);
			}
			else
			{
				System.out.println(word + " is not a palindrome.");
			}
		}

		inScan.close();

		/**
		 * This sorts the palindrome into alphabetical order and displays the list
		 */
		Collections.sort(palindromeList);
		System.out.println("\nThe palindromes sorted in alphabetical order are as follows:"); 
		for(int i = 0; i < palindromeList.size(); i++)
		{
			System.out.println(palindromeList.get(i));
		}
	}

	/**
	 * This method will check if the word or phrase is a palindrome
	 * @param inString - the word or phrase to check
	 * @return - true or false
	 */
	public static boolean palindromeCheck(String inString)
	{
		String word = inString;
		int wordLength = word.length();
		int counter = -1;
		int lastChar = wordLength;
		boolean palindrome = false;
		do
		{
			/**
			 * If this is true the word or phrase is added to the list
			 */
			if(word.charAt(++counter) == word.charAt(--lastChar))
			{
				palindrome = true;
			}

			else
			{
				palindrome = false;
			}
		}while(counter < lastChar && palindrome == true);


		return palindrome;
	}

	/**
	 * This method will get the file the user selects
	 * @return - the selected file
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
