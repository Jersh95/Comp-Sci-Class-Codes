/*Program: GpaCalculator
 *Program Purpose: This program will calculate the calculate the user's GPA based on the information they enter.
 *Author: Josh Jacobsen
 *Date:   10-22-2014
 *Algorithm:
 *1.  Define purpose
 *2.  Until user requests to end entering grades and credit hours by entering Q
 *3.	Repeat
 *4.		Prompt user to enter a letter grade
 *5.  		Prompt user to enter a credit hour
 *6.		After each entry, add the grade and hour entered to the list of grades and hours
 *7.  	End Repeat
 *8. 	Calculate the GPA by multiplying the credit by the hour entered and divide it by the total hours	
 *9.  Display results
 *10. Ask user if they want to enter another set of data
 *11. If they desire to enter more, repeat program
 *12. Display end of program message
 */

package Exercises;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class GpaCalculator 
{

	public static void main(String[] args) 
	{
		//Display introduction message
		String intro = "This program will determine the user's GPA based on information they enter. \n\n" +
				"The user will be prompted to enter a letter grade and then a credit hour for that class.\n\n" +
				"The program will then take the entered information and calculate the user's GPA and display it.";
		JOptionPane.showMessageDialog(null, intro, "GPA Calculator - Intro", 1);
		
		//Variable for repeating of entire program
		String again = "";		

		do	
		{
			//For letter entry
			String letter_enter_prompt = "Enter a letter grade or press 'Q' to quit program.\n(ex: A, B, C, D, F)";
			String letter_entry_string = "";
			
			//For hour entry
			String hour_enter_prompt = "Enter the credit hours for the same class as you previously\n" +
					"entered the letter grade for. Hours between 1-12 only.\n(ex: 3, 7, 11)";
			String hour_entry_string = "";
			int hour_entry_int = 0;
			
			//For use in extracting the hours entered and adding to total hours
			int hours = 0;
			double total_hours = 0;
			
			//Combines for display the letter entries and hour entries
			String letter_and_hour = "";
			
			//For use in error and retry message
			String retry_ask = "";
			String retry_string = "An error has occured, would you like to retry?";			
			
			//For use in calculating the GPA
			double quality_points = 0;
			double gpa = 0;
			DecimalFormat decFor = new DecimalFormat("0.0");
			
			do
			{
				//Prompting user to enter the letter grade for the desired class
				letter_entry_string = JOptionPane.showInputDialog(null, letter_enter_prompt, "GPA Calculator - Letter Entry", 1);
				
				//Error message for attempting to exit program
				while (letter_entry_string == null)
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						letter_entry_string = JOptionPane.showInputDialog(null, letter_enter_prompt, "GPA Calculator - Letter Entry", 1);
						break;	
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Error message for an empty string
				while (letter_entry_string.equals(""))
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						letter_entry_string = JOptionPane.showInputDialog(null, letter_enter_prompt, "GPA Calculator - Letter Entry", 1);
						break;
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Switch statement that will determine the credits based on the letter entered
				int credits = 0;
				switch(letter_entry_string)
				{
					case "a":
					case "A":
						credits += 4;
						break;
					case "b":
					case "B":
						credits += 3;
						break;
					case "c":
					case "C":
						credits += 2;
						break;
					case "d":
					case "D":
						credits += 1;
						break;
					case "f":
					case "F":
						credits += 0;
						break;
						
				}
				if(letter_entry_string.toLowerCase().equals("q"))
					break;
				
				//Prompting user to enter the credit hour for the same class as the entered letter grade
				hour_entry_string = JOptionPane.showInputDialog(null, hour_enter_prompt, "GPA Calculator - Hour Entry", 1);
				
				//Error message for attempting to exit program
				while (hour_entry_string == null)
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						hour_entry_string = JOptionPane.showInputDialog(null, hour_enter_prompt, "GPA Calculator - Letter Entry", 1);
						break;
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Error message for an empty string
				while (hour_entry_string.equals(""))
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						hour_entry_string = JOptionPane.showInputDialog(null, hour_enter_prompt, "GPA Calculator - Letter Entry", 1);
						break;
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Error message for if the hour entry contains a decimal point
				while (hour_entry_string.contains("."))
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						hour_entry_string = JOptionPane.showInputDialog(null, hour_enter_prompt, "GPA Calculator - Letter Entry", 1);
						hour_entry_int = Integer.parseInt(hour_entry_string);
						break;
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Converting the hour entry into a integer
				//Quality points was a variable defined to help determine the gpa
				hour_entry_int = Integer.parseInt(hour_entry_string);
				quality_points += credits * hour_entry_int;
				
				//Error message for invalid hour entry 
				while(hour_entry_int <1 || hour_entry_int > 12)
				{
					retry_ask = JOptionPane.showInputDialog(null, retry_string, "GPA Calculator - Error", 1);
					while (retry_ask.toLowerCase().equals("y"))
					{
						hour_entry_string = JOptionPane.showInputDialog(null, hour_enter_prompt, "GPA Calculator - Letter Entry", 1);
						hour_entry_int = Integer.parseInt(hour_entry_string);
						break;
					}
					while (retry_ask.toLowerCase().equals("n"))				
					{
						JOptionPane.showMessageDialog(null,"User requested to end program.\nProgram will now terminate.", 
								"GPA Calculator - Program End", 1);
						System.exit(1);
					}
				}
				
				//Converting the entered number into an integer to user to calculate the total hours
				hours = Integer.parseInt(hour_entry_string);
				total_hours += hours;
				
				//Adding the hours entered to the list and adding one to the number of classes
				letter_and_hour += letter_entry_string + "                      " + hour_entry_string + "\n";
				
				//Assigning the gpa variable to display the average by dividing the total number of hours by the number of classes
				gpa =  quality_points / total_hours;	

			//Setting the program to loop if the entered letter is not a q				
			}while(!letter_entry_string.toLowerCase().equals("q"));
			
			//Displaying the results
			String results = "The courses you entered are:\nGrade     Hours\n" + letter_and_hour + "Resulting in a GPA of: " + decFor.format(gpa);	
			JOptionPane.showMessageDialog(null, results, "GPA Calculator - Results", 1);
			
			//Asking the user if they want to enter another set of data
			again = JOptionPane.showInputDialog(null, "Would you like to enter another set of data?", "Again?", 1);
		
		//Looping the whole program if the user enters y after seeing the results
		}while(again.toLowerCase().equals("y"));
		
		//End of program message and termination
		JOptionPane.showMessageDialog(null, "Program will now terminate", "GPA Calculator - End", 1);
		System.exit(1);
	}

}
