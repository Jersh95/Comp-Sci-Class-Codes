/*
 * Authors:Josh Jacobsen
		  Tyler Laudenklos
 * Date:11/4/2014
 * Purpose: Input an English word, search dictionary, if a translation is found, translate that word into Spanish.
 *
 *Algorithm:
 *1.)Display introduction.
 *2.)Import text file of English and Spanish Dictionaries.
 *3.)Until user terminates program by entering 'Q'
 *4.)	Repeat
 *5.)		Allow user to input an English word.
 *6.)		Search English Word in the English Dictionary.
 *7.)		If found, find Spanish Translation.
 *8.)		If not found, tell user it isn't found
 *9.)		Form display.
 *10.)		Show display of Spanish Translation
 *12.)	End Repeat
 *12.)Exit Program
 */


package exercises;

import javax.swing.JOptionPane;

import java.util.Scanner;
import java.io.*;

public class SpanishDictionary 
{
	
	public static void main(String[] args) throws IOException
	{
        //Displays the introduction
		String intro = "This program will translate the user entered English word into its Spanish translation.\nThe user will be prompted to enter an English " +
						"word that they would like to be translated into Spanish.\nThe program will then search for and display the Spanish translation.";
		JOptionPane.showMessageDialog(null, intro, "Spanish Dictionary - Intro", 1);
		
		String translation = "";
		String wordEntry = "";
		String english = "";
		String results = "";
		boolean translationFound = false;
		boolean doLoop = true;
		do
		{
        	
        	//Opening the file
			final String FILENAME = "EnglishToSpanishDictionary.txt";
			File file = new File (FILENAME);
			
			//Checking to make sure file exists
			if(!file.exists())
		        {
		            JOptionPane.showMessageDialog(null,"File "+FILENAME+" not found!",
		                                            "Error Message", 1);
		            System.exit(0);
		        }
			Scanner filescan = new Scanner(file);
	       
			translationFound = false;
		    String error_message = "";   
        	do
        	{

	        	//Prompts user to enter the word and validates the data
				String wordPrompt = error_message + "\n\n" + "Enter an English word you would like to be translated into Spanish.\n(ex:boy, university, father)"
						+ "\nOr press 'Q' to exit program";
				wordEntry = JOptionPane.showInputDialog(null, wordPrompt, "Spanish Dictionary - Word Input", 1);
				
				error_message = "";
				if(wordEntry == null)
				{
					error_message = "User requested to terminate program.";
					JOptionPane.showMessageDialog(null, "User has requested to terminate program.", "Spanish Dictionary - End Program", 1);
					System.exit(0);
				}
				
				if(wordEntry.equals(""))
				{
					error_message = "A word has not been entered. Please try again.\n\n";
				}
				
				if(wordEntry.equals("q"))
				{
					error_message = "User has requested to terminate program.";
					JOptionPane.showMessageDialog(null, "User has requested to terminate program.", "Spanish Dictionary - End Program", 1);
					System.exit(0);
				}
        	}while(!error_message.equals(""));
			
			//Reading the file for the translation
			while(filescan.hasNext())
			{
				english = filescan.next();
				translation = filescan.nextLine();

				//If the word entry matches an English word in the text file, it will read and display it's Spanish translation
				if(wordEntry.equals(english))
				{
		        	results = "The English word \"" + wordEntry + "\" translated into Spanish is: \"" + translation + "\".";
					JOptionPane.showMessageDialog(null, results, "Spanish Dictionary", 1);
		        	translationFound = true;
				}
				
			}		
			
			//If the English word is not found, it will display an error error message saying the translation has not been found
			if(translationFound == false)
			{
				results = "Sorry, I could not find a translation for " + wordEntry + ". Please try another word.";
				JOptionPane.showMessageDialog(null, results, "Spanish Dictionary", 1);
			}
		
		//Program will loop if the word entry is not a q	
		filescan.close();

		//Program will loop if the doLoop variable remains true
		}while(doLoop == true);
	
	}		

}




