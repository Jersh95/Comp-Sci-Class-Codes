/*Program: BonusCalculator
 *Program Purpose: This program will calculate the employee's year-end bonus based on their position
 *                 code, weekly salary, and their time employed.
 *Author: Josh Jacobsen
 *	      10-1-14
 *Algorithm:
 * 1.	Define the purpose
 * 2.	Enter the employee’s position code
 * 3.	Enter the employee’s weekly salary
 * 4.	Enter the employee’s time employed
 * 5.	Using if else statements, set determinations for the 3 position code salaries
 * 6.	If the employee has been with the company for less than two years, they only receive half of the bonus
 * 7.	If the employee has been with the company for more than 10 years, they receive an additional $100 on top of their bonus
 * 8.	Display results, showing each entered data and total bonus and end of program message
 * 
 */

package Exercises;

//Importing the JOptionPane and the DecimalFormat
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class BonusCalculator 
{

	public static void main(String[] args) 
	{
		
	//Introduction Message Box
	JOptionPane.showMessageDialog(null, "This program will calculate the year-end bonus each employee will receive.\n\n" +
			"First, you will be prompted to enter the employee's position code.\n" +
			"You will then be prompted to enter their weekly salary.\n" +
			"Finally, you will be prompted to enter their time employeed.\n\n" +
			"The program will then take the information entered and calculate what\ntheir year-end bonus will be " +
			"and display it along with the entered information.", "Bonus Calculator Introduction", 1);
	
	//Prompt for user to enter employee's position code
	String position_code_entry = JOptionPane.showInputDialog(null, "Please enter the employee's position code.\n" + 
			"(The code should be 1, 2, or 3)", "Position Code Entry", 1);
	int position_code = Integer.parseInt(position_code_entry);
	
	//Prompt for user to enter employee's weekly salary
	String weekly_salary_entry = JOptionPane.showInputDialog(null, "Please enter the employee's" +
			" weekly salary in a whole positive number.\n (e.g. 375, 500, 450)", "Weekly Salary Entry", 1);
	double weekly_salary = Double.parseDouble(weekly_salary_entry);
	
	//Prompt for user to enter the number of years the employee has been employed
	String number_of_years_entry = JOptionPane.showInputDialog(null, "Please enter the number of years" +
			" the employee has been employeed. Use two decimal points at most.\n" + 
			"(e.g. 2, 5.5, 3.75)", "Number of Years Employeed - Entry", 1);
	double number_of_years = Double.parseDouble(number_of_years_entry);

	//Defining variables to use in the next sections
	double position_code_result = 0;		
	double week_and_half = weekly_salary + (weekly_salary * .5);
	
	//Assigning tests for the position codes
	if (position_code == 1)
		position_code_result = (weekly_salary);
	else if( position_code == 2)
	{
		position_code_result = (weekly_salary * 2);
		if (position_code_result > 700)
		{		
			position_code_result = 700;
		}
	}
	else
		position_code_result = (week_and_half);
	
	//Assigning a variable for the total holiday bonus
	double holiday_bonus = position_code_result; 

	//Assigning tests for employees under two years or over ten
	if (number_of_years < 2)
		holiday_bonus = position_code_result / 2;
	if ( number_of_years > 10)
		holiday_bonus = position_code_result + 100;
	
	//Setting the decimal limit
	DecimalFormat bonus_formatter = new DecimalFormat("#0.00");

	//Final results message box displaying the position code, weekly salary, number of years employed,
	//and the final year-end bonus
	JOptionPane.showMessageDialog(null, "This person is a code " + position_code + " and their weekly salary" +
			" is " + weekly_salary + " and they have been employeed for " + number_of_years + " years." +
			"\nTherefore, their total year end bonus will be $" + bonus_formatter.format(holiday_bonus) +
			"\n\nThe program will now terminate.", "Total Year End Bonus", 1);
	
	
	

	
	
	}

}
