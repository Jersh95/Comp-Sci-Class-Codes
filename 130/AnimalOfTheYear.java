/*Program: AnimalOfTheYear
 *Program purpose: This program will display the animal of the year for the year entered by the user
 *Author: Josh Jacobsen
 *		  10-8-14
 *Algorithm:
 *1.  Define the purpose
 *2.  Prompt user to enter the given year that they want to find the animal for (between 1972 to 2014)
 *3.  Set error messages and exit programs if user exits program or year entry is empty
 *4.  Set up formula to calculate the year entered modulus 12 to assign the remainder to each case
 *5.  Set up switch statement, defining 12 cases (0-11) with the default resulting in invalid entry message
 *6.  Display results, containing the year entered and what the animal is along with a End of Program Message
 */
package Exercises;
import javax.swing.JOptionPane;
public class AnimalOfTheYear 
{

	public static void main(String[] args) 
	{
		//Assigning the variable animal to be used later
		String animal = "";
		//Assigning the text for the introduction
		String intro = "This program will display the chinese animal of an entered year.\n\n " + 
				"You will be asked to enter the year that you wish to know what the animal " + 
				"was.\n(Between 1972-2014 only)\n\nThe program will take the entered number and use it to determine what the " +
				"\nanimal is for that year and display the result along with the year entered.";
		JOptionPane.showMessageDialog(null, intro, "Animal Of The Year - Intro", 1);
	
		//Prompting user to enter the year they wish to know the animal for
		String year_entry = JOptionPane.showInputDialog(null, "Please enter the year that you wish to know " +
				"the animal for.\n(Enter years only between 1972 to 2014, e.g. 1987, 1999, 2005).", 
				"Animal of the Year - Year Entry", 1);
		
		//Display error message and exits program if the user attempts to exit or quit program
		if (year_entry == null)
			{
			JOptionPane.showMessageDialog(null, "User has requested to terminate program.\n" +
					"Program terminating.","Error - Force Exit", 1);
			System.exit(1);
			}
		
		//Display error message and exits program if the user fails to put in a year
		if (year_entry.equals(""))
			{
			JOptionPane.showMessageDialog(null, "User has not entered a valid year entry.\n" +
					"Program terminating.","Error - Empty Year", 1);
			System.exit(2);
			}
		
		//Converting the String year entry into a Integer and performing the math to calculate the remainder
		int year_int = Integer.parseInt(year_entry);
		int year = (year_int - 1972) % 12;
		
		//Switch statement that has a given case for each remainder of the entered number and a default
		//invalid entry case
		switch(year)
		{
		case 0:
			animal = "Rat";
			break;
		case 1:
			animal = "Ox";
			break;
		case 2:
			animal = "Tiger";
			break;
		case 3:
			animal = "Rabbit";
			break;
		case 4:
			animal = "Dragon";
			break;
		case 5:
			animal = "Snake";
			break;
		case 6:
			animal = "Horse";
			break;
		case 7:
			animal = "Sheep";
			break;
		case 8:
			animal = "Monkey";
			break;
		case 9:
			animal = "Rooster";
			break;
		case 10:
			animal = "Dog";
			break;
		case 11:
			animal = "Pig";
			break;
		default:
			animal = "Invalid entry, please try again.";
			break;
		}	
		
		//Final results display box
		JOptionPane.showMessageDialog(null, "You entered the year " + year_entry +
				". Therefore, your animal of the year is a(n) " + animal + 
				"\n\nProgram will now terminate.", "Animal of the Year - Results", 1);
		
		
	}

}

