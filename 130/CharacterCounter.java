/*Program: CharacterCounter
 *Program purpose: This program will count the number of times a entered character appears
 *				   in a entered string.
 *Author:	Josh Jacobsen
 *Date:     10-15-2014
 *Algorithm:
 *1.  Define purpose
 *2.  Until user wants to quit
 *3.	Prompt user to enter a string
 *4.  	Prompt user to enter a character
 *5.  	Calculate how many times the entered character appears in the entered string by looping through each character and increasing
 *			the count if the character is found
 *6.  	Display results, showing the entered string, the entered character, and the results of how many times the character appears
 *7.  	Ask user if they want to enter another set of data
 *8.  End repeat 
 *9.  Display end of program message and end program
 * 
 */
package Exercises;
import javax.swing.JOptionPane;
public class CharacterCounter 
{

	public static void main(String[] args) 
	{
		//Defining variables
		String retry_ask = "";
		String retry_string = "Error has occured, would you like to retry?\nEnter "
				+ "'Y' for yes or 'N' for no.";
		String repeat_ask = "";
		String repeat_prompt = "Would you like to enter another set of data?\nEnter 'Y' for yes and " + 
				"'N' for no.";
		
		
		//Setting up the intro string and the intro message box
		String intro = "This program will count the number of times a entered character appears in an entered string.\n\n" +
				"The user will be prompted to enter a string of characters (a single word or set of characters). The user will then be\n" +
				"prompted to enter a single character to see how many times it appears in the entered string.\n\n" +
				"The program will then take the entered information and display the string, the character, and how many\n" +
				"times the character appears in the string.";
		
		JOptionPane.showMessageDialog(null, intro, "CharacterCounter - Intro", 1);
		
		//Running the program at least once; program will be looped at the end if user desires
		//User prompt for string entry
		do
		{
		//User prompt for string entry
			String string_input_prompt = "Please enter a string of characters without any spaces.\n\n(Alphabet letters only)" +
					"\n\n(e.g. dog, hello, abcdefg)";
			String string_input = "";
			
			string_input = JOptionPane.showInputDialog(null, string_input_prompt,"CharacterCounter - String Enter", 1);
		
		//Error message for exit attempt
			while (string_input == null)
			{
				retry_ask = JOptionPane.showInputDialog(null, retry_string, "CharacterCounter - Error", 1);
				while (retry_ask.toLowerCase().equals("y"))
				{
					string_input = JOptionPane.showInputDialog(null, "Please enter a string of characters.\n\n(Alphabet letters only)" +
							"\n\n(e.g. dog, hello, abcdefg)","CharacterCounter - String Enter", 1);
					break;
					
				}
				while (retry_ask.toLowerCase().equals("n"))				
				{
					JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
							"CharacterCounter - Program End", 1);
					System.exit(1);
				}
			}
		
		//Error message for empty string
			while(string_input.equals(""))
			{
				retry_ask = JOptionPane.showInputDialog(null, "Error has occured, would you like to retry?\nEnter "
						+ "'Y' for yes or 'N' for no.", "CharacterCounter - Error", 1);
				while (retry_ask.toLowerCase().equals("y"))
				{
					string_input = JOptionPane.showInputDialog(null, "Please enter a string of characters.\n\n(Alphabet letters only)" +
							"\n\n(e.g. dog, hello, abcdefg)","CharacterCounter - String Enter", 1);
					break;
					
				}
				while (retry_ask.toLowerCase().equals("n"))				
				{
					JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
							"CharacterCounter - Program End", 1);
					System.exit(1);
				}
			}	
		
		
		//User prompt for character entry
			String char_input_prompt = "Please enter a single character you wish to see the\nnumber of times " +
					"it appears in the string.\n\n(Alphabet letters only)\n\n(e.g. a, b, c).";
			String char_input = "";
			
			char_input =  JOptionPane.showInputDialog(null, char_input_prompt, "CharacterCounter - Character Entry", 1);
		
		//Error message for exit attempt
			while (char_input == null)
			{
				retry_ask = JOptionPane.showInputDialog(null, "Error has occured, would you like to retry?\nEnter "
						+ "'Y' for yes or 'N' for no.", "CharacterCounter - Error", 1);
				while (retry_ask.toLowerCase().equals("y"))
				{
					char_input =  JOptionPane.showInputDialog(null, "Please enter a single character you wish to see the\nnumber of times " +
							"it appears in the string.\n\n(Alphabet letters only)\n\n(e.g. a, b, c).", "CharacterCounter - Character Entry", 1);
					break;
					
				}
				while (retry_ask.toLowerCase().equals("n"))				
				{
					JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
							"CharacterCounter - Program End", 1);
					System.exit(1);
				}
	
			}
			
			//Error message for entering more than a single character.
			while (char_input.length() > 1)
			{
				retry_ask = JOptionPane.showInputDialog(null, "Error has occured, would you like to retry?\nEnter "
						+ "'Y' for yes or 'N' for no.", "CharacterCounter - Error", 1);
				while (retry_ask.toLowerCase().equals("y"))
				{
					char_input =  JOptionPane.showInputDialog(null, "Please enter a character you wish to see the\nnumber of times " +
							"it appears in the string.\n\n(Alphabet letters only)\n\n(e.g. a, b, c).", "CharacterCounter - Character Entry", 1);
					break;
					
				}
				while (retry_ask.toLowerCase().equals("n"))				
				{
					JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
							"CharacterCounter - Program End", 1);
					System.exit(1);
				}
			}
			
			//Error message for empty character
			while (char_input.equals(""))
			{
				retry_ask = JOptionPane.showInputDialog(null, "Error has occured, would you like to retry?\nEnter "
						+ "'Y' for yes or 'N' for no.", "CharacterCounter - Error", 1);
				while (retry_ask.toLowerCase().equals("y"))
				{
					char_input =  JOptionPane.showInputDialog(null, "Please enter a character you wish to see the\nnumber of times " +
							"it appears in the string.\n\n(Alphabet letters only)\n\n(e.g. a, b, c).", "CharacterCounter - Character Entry", 1);
					break;
					
				}
				while (retry_ask.toLowerCase().equals("n"))				
				{
					JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
							"CharacterCounter - Program End", 1);
					System.exit(1);
				}
			}	
		
		//Calculates how many times the entered character appears in the entered string
			int counter = 0;
			int current_position = 0;
			char letter = char_input.charAt(0);
			while (current_position < string_input.length())
			{
			if (letter == string_input.charAt(current_position))
					counter++;
			current_position++;
			}
			
		//Display results
			JOptionPane.showMessageDialog(null,  "'" + char_input + "'" + " appears " + counter + " time(s) in the string " 
					+ "''" + string_input + "''", "CharacterCounter - Results", 1);
				
		//Asking user if they desire to re-run the program and re-enter data
			repeat_ask = JOptionPane.showInputDialog(null, repeat_prompt, "CharacterCounter - Re-Run?", 1);
		
		//End of the loop; if user enters 'Y' then the program will re-run
		}
		while (repeat_ask.toLowerCase().equals("y"));
		JOptionPane.showMessageDialog(null, "Program will now terminate.", "CharacterCounter - End", 1);
		
		
		
		

	
	}

}
