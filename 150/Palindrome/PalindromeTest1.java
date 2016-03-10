/**
 *Author: Josh Jacobsen
 *Date: 2/20/15
 *
 *This program will look through a file and determine if the words are palindromes or not
 *
 *Algorithm:
 *Open the file
 *Scan the file
 *Create the iterative palindrome method
 *Create the recursive palindrome method
 *Call the iterative method and display the results
 *Call the recursive method and display the results
 */
package lab4;
import javax.swing.JFileChooser;

import java.io.*;
import java.util.Scanner;
public class Palindrome {

	/**
	 * This method determines if the word is a palindrome through iteration
	 * @param word - this is the word
	 * @param start - this is the start character of the word
	 * @param wordlength - this is the length of the word
	 * @return - true if the word is a palindrome or false if it is now
	 */
	public static boolean palindrome(String word, int start, int wordlength)
	{
		boolean isPalindrome = false;
		if(word.charAt(start) == word.charAt(--wordlength))
		{
			isPalindrome = true;
		}
		else
		{
			isPalindrome = false;
		}
		if(start<wordlength && isPalindrome == true)
		{
			palindrome(word,++start,wordlength);
		}
		return isPalindrome;
	}

	/**
	 * This method determines if the word is a palindrome through iteration
	 * @param inString, this is the word
	 * @return - true if the word is a palindrome or false if it is now
	 */
	public static boolean palindromeIterative(String inString)
	{
		String word = inString;
		int wordLength = word.length();
		int counter = -1;
		int lastChar = wordLength;
		boolean palindrome = false;
		do
		{
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


	public static void main(String[] args) throws FileNotFoundException 
	{
		JFileChooser chooser;
		chooser = new JFileChooser();
		int status = chooser.showOpenDialog(null);
		if (status != JFileChooser.APPROVE_OPTION)
		{
			System.exit(0);
		}
		File filename = chooser.getSelectedFile();
		Scanner fileScan = new Scanner (filename);


		//This block of code scans the file and uses the iterative method to display the words and whether or not they are a palindrome

		System.out.println("This is the results for the iterative palindrome check");
		while(fileScan.hasNext())
		{
			String word = fileScan.nextLine();


			if(palindromeIterative(word) == true)
			{

				System.out.println(word + " is a palindrome.");
			}
			else
			{
				System.out.println(word + " is not a palindrome.");
			}

		}
		fileScan.close();

		/**
		 * This block of code scans the file and uses the recursive method to display the words and whether or not they are a palindrome
		 * For some reason, it keeps displaying that not one ton is a palindrome even though we went through the debugger and it showed that it should
		 * have returned that it was not a palindrome
		 */
		//This scanner is for the recursive check
		Scanner fileScan2 = new Scanner (filename);

		//This block of code scans the file and uses the iterative method to display the words and whether or not they are a palindrome
		System.out.println("\nThis is the results for the recursive palindrome check");
		while(fileScan2.hasNext())
		{
			String word = fileScan2.nextLine();
			int start = 0;
			int wordlength = word.length();

			if(palindrome(word,start,wordlength) == true)
			{

				System.out.println(word + " is a palindrome.");
			}

			else
			{
				System.out.println(word + " is not a palindrome.");
			}
		}
		fileScan2.close();
	}










}
