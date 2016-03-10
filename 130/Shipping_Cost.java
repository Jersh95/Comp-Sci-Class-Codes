/*Program Assignment 2
 *Program Purpose: This program will calculate the shipping cost based on user information.
 *Author: Josh Jacobsen
 *		  9-27-14
 *Algorithm:
 *1.  State the purpose
 *2.  Prompt user to enter the weight
 *3.  Prompt the user to enter the distance
 *4.  Using if else statements, set the rate compared to the weight
 *5.  Calculate the rate per mile
 *6.  Multiply the rate by the distance
 *7.  Display results and end of program screen
 */

package Shipping_Assignment;

//Importing the JOptionPane and the DecimalFormaat
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class Assignment_2 
{

	public static void main(String[] args) 
	{
		//Introduction message box
		JOptionPane.showMessageDialog(null, "This program will calculate your shipping cost.\n\n" + 
				"First, you will be prompted to enter the weight of your package in pounds.\n" +
				"You will then be asked to enter the distance you wish to send the package.\n\n" +
				"The program will then take the information you enter will calculate your\n" +
				"shipping cost based on the weight and distance.", "Shipping Charge - Introduction",1);

		//Initializing variables
		double rate;
		double new_rate;
		double final_cost;
		double next_rate;
		double initial_rate;
		
		//User prompt for weight
		String weight_string= JOptionPane.showInputDialog(null, "Enter the weight of the package, in pounds, that you wish to send."
				+ "\n(eg. For 2lbs enter 2 and for 1.75lbs enter 1.75)",
				"Shipping Charge - Weight", 1);
		if (weight_string == null)
		{	
			JOptionPane.showMessageDialog(null, "Invalid entry protocol.\n\nProgram wil now terminate.", "Shipping Charge - Error", 1);
			System.exit(1);
		}
		
		//Exit error screen for weight for bonus
		if(weight_string.equals(""))
		{	
			JOptionPane.showMessageDialog(null, "Invalid entry protocol.\n\nProgramwill now terminate.", "Shipping Charge - Error", 1);
			System.exit(1);
		}
		double weight = Double.parseDouble(weight_string);

		//User prompt for distance
		String distance_string = JOptionPane.showInputDialog(null, "Enter the distance of the " + weight +
				" pound package you wish to send.\n(eg. For 1,200mi enter 1200.)", "Shipping Charge - Distance", 1);
		
		//Exit error screen for distance for bonus
		if (distance_string == null)
		{	
			JOptionPane.showMessageDialog(null, "Invalid entry protocol.\n\nProgram wil now terminate.", "Shipping Charge - Error", 1);
			System.exit(1);
		}
		if(distance_string.equals(""))
		{	
			JOptionPane.showMessageDialog(null, "Invalid entry protocol.\n\nProgramwill now terminate.", "Shipping Charge - Error", 1);
			System.exit(1);
		}
		int distance = Integer.parseInt(distance_string);
			
		//Determining the rate depending on the weight
		if (weight <= 2)
			rate = 1.10;
		else if (weight > 2 && weight <= 6)
			rate = 2.50;
		else if (weight > 6 && weight < 10)
			rate = 3.90;
		else if(weight == 10)
			rate = 4.00;
		else 
		{
			initial_rate = 4.00;
			new_rate = weight - 10;
			next_rate = new_rate * .50;
			rate = initial_rate + next_rate;
		}		
		//Formula to calculate distance charge
		int interval = distance / 500;
		if (distance % 500 > 0 )
		{
			interval++;
			
		}
		final_cost =  interval * rate;

		//Setting up the decimal limit
		DecimalFormat cost_per_500 = new DecimalFormat("#0.00");
		DecimalFormat distance_math_format = new DecimalFormat("#0.00");

		//Final results display
		JOptionPane.showMessageDialog(null, "Your package weight is " + weight +
			" pounds and \nyou are sending it " + distance + " miles which will\ncost you $"  + 
			cost_per_500.format(rate) + " per 500 miles.\n\nTherefore, your total cost will be $"
			+ distance_math_format.format(final_cost) +".\n\nThank you for choosing our company."
			+ "\n\nThis program will now terminate.", "Shipping Charge - Final Cost", 1);
		
	}

}



