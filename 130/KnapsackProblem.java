/*Program: KnapsackProblem
 *Program Purpose: This program will find the most efficient selection of four objects that will weigh the closest to the maximum weight that the user enters. 
 *Authors: Josh Jacobsen, Tyler Laudenklos, Reamonn Seaman
 *Date: 10/28/2014
 *
 * Algorithm:
 * 1.)Display introduction.
 * 2.)Until user presses Q to end program
 * 3.)	Repeat
 * 4.)		Prompt the user to input the maximum weight their knapsack can carry.
 * 3.)		Prompt the user to input the weight of each of the four items.
 * 4.)		Start the process for the following steps to be repeated:
 * 5.)		Start with any combination of the four items, and determine their weight.
 * 6.)		Determine if their combined weight is over the knapsack's max weight.  If so, throw it out.  If not, set it as the best combination. 
 * 7.)		Test every combination of the entered weights to determine which combination is the best weight.
 * 8.)		If a new combination fits more weight than the previous one, but less than the knapsack's maximum weight, this combination will be set as the best
 * 				combination. Store the total weight of what items can be placed,
 * 9.)		Repeat steps 5-7 until all possible combinations have been tested.
 * 10.)		Make the display using the max knapsack weight, the weight of the best combination, and the weight of the individual items
 * 				from the best combination.
 * 11.)		Show the display.
 * 12.)	End Repeat
 * 13.)End program
  **/
package exercises;
import javax.swing.*;
public class KnapsackProblem 
{

	public static void main(String[] args) 
	{
		//Display the Introduction
		String intro = "The purpose of this program is to find the most efficient selection of four objects\nthat will weigh the "
				+ "closest to the maximum weight that the user enters.\n\nThe user will be asked to enter the maximum weight that they want to carry.\n"
				+ "They will then be asked to enter the weight of four items they would like to bring.\n\n"
				+ "The program will then calculate the most efficient combination of the four items\nto achieve the closest to the maximum weight.";
		JOptionPane.showMessageDialog(null,intro, "Knapsack Problem - Intro", 1);
		
		//Variables for max weight carried by knapsack
		String maxWeightStringPrompt = "";
		String maxWeightString = "";
		
		//Variables for object weights
		String item_1_prompt = "";
		String item_2_prompt = "";
		String item_3_prompt = "";
		String item_4_prompt = "";
		String object1WeightString = "";
		String object2WeightString = "";
		String object3WeightString = "";
		String object4WeightString = "";
		
		//Program do while loop
		do
		{	
			String error_message = "";
			boolean isNotValid = false;

				//Inputs and validations for the max weight
				do
				{	
					
				
					//Inputting of the Data and conversions to Integers & Data Validation
					maxWeightStringPrompt = error_message + "\n\nWhat is the max weight your knapsack will hold in pounds?\n"
									+ "Enter the weight as a positive integer.\n(eg. 25, 50, 100)\n"
									+ "(Be sure not to enter any decimal points,\nnegative signs, " +
									"or non digit characters.)\n\nOr press 'Q' to quit.";
						
					maxWeightString = JOptionPane.showInputDialog(null, maxWeightStringPrompt, "Knapsack Problem - Max Weight Entry", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(maxWeightString == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(maxWeightString.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
						isNotValid = true;
					}
					
					//If q is entered, the program terminates
					else if(maxWeightString.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(maxWeightString.contains("."))
					{
						error_message = "A decimal point was entered.";						
						isNotValid = true;
					}
					
					//Data validation for number_entry containing a negative sign
					else if(maxWeightString.contains("-"))
					{
						error_message = "A negative sign was entered.";
						isNotValid = true;
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < maxWeightString.length(); position++)
						{
							char digit = maxWeightString.charAt(position);
							if(!Character.isDigit(digit))
							{
								isNotValid = true;
								break;
							}
						}
							if(isNotValid)
							{
								error_message = "A non digit character was entered";
							}
					}
				}while(!error_message.equals(""));
				int maxWeight = Integer.parseInt(maxWeightString);
				
				//Inputs and validations for the first item weight
				do
				{
					//Prompting user to enter the first item's weights
					item_1_prompt = error_message + "\n\nInput the weight, in pounds, of the first object.\nEnter the weight as a positive integer.\n(eg. 1, 25, 4)" +
							"(Be sure not to enter any decimal points,\nnegative signs, or non digit characters.)\n\nOr press 'Q' to quit.";
					object1WeightString = JOptionPane.showInputDialog(null, item_1_prompt, "Knapsack Program - Weight 1", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(object1WeightString == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(object1WeightString.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
					}
					
					//If q is entered, the program terminates
					else if(object1WeightString.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(object1WeightString.contains("."))
					{
						error_message = "A decimal point was entered.";
					}
					
					//Data validation for number_entry containing a negative sign
					else if(object1WeightString.contains("-"))
					{
						error_message = "A negative sign was entered.";
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < object1WeightString.length(); position++)
						{
							char digit = object1WeightString.charAt(position);
							if(!Character.isDigit(digit))
							{
								isNotValid = true;
								break;
							}
						}
							if(isNotValid)
							{
								error_message = "A non digit character was entered";
							}
					}
					
				}while(!error_message.equals(""));	
				int object1Weight = Integer.parseInt(object1WeightString);	
				
				//Inputs and validations for the second item's weight
				do
				{	
					//Prompting user to enter the first item's weights
					item_2_prompt = error_message + "\n\nInput the weight, in pounds, of the second object.\nEnter the weight as a positive integer.\n(eg. 1, 25, 4)" +
							"(Be sure not to enter any decimal points,\nnegative signs, or non digit characters.)\n\nOr press 'Q' to quit.";
					object2WeightString = JOptionPane.showInputDialog(null, item_2_prompt, "Knapsack Program - Weight 2", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(object2WeightString == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(object2WeightString.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
					}
					
					//If q is entered, the program terminates
					else if(object2WeightString.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(object2WeightString.contains("."))
					{
						error_message = "A decimal point was entered.";
					}
					
					//Data validation for number_entry containing a negative sign
					else if(object2WeightString.contains("-"))
					{
						error_message = "A negative sign was entered.";
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < object2WeightString.length(); position++)
						{
							char digit = object2WeightString.charAt(position);
							if(!Character.isDigit(digit))
							{
								isNotValid = true;
								break;
							}
						}
							if(isNotValid)
							{
								error_message = "A non digit character was entered";
							}
					}
					
				}while(!error_message.equals(""));
				int object2Weight = Integer.parseInt(object2WeightString);
				
				//Inputs and validations for the second item's weight
				do
				{	
					//Prompting user to enter the first item's weights
					item_3_prompt = error_message + "\n\nInput the weight, in pounds, of the first object.\nEnter the weight as a positive integer.\n(eg. 1, 25, 4)" +
							"(Be sure not to enter any decimal points,\nnegative signs, or non digit characters.)\n\nOr press 'Q' to quit.";
					object3WeightString = JOptionPane.showInputDialog(null, item_3_prompt, "Knapsack Program - Weight 3", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(object3WeightString == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(object3WeightString.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
					}
					
					//If q is entered, the program terminates
					else if(object3WeightString.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(object3WeightString.contains("."))
					{
						error_message = "A decimal point was entered.";
					}
					
					//Data validation for number_entry containing a negative sign
					else if(object3WeightString.contains("-"))
					{
						error_message = "A negative sign was entered.";
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < object3WeightString.length(); position++)
						{
							char digit = object3WeightString.charAt(position);
							if(!Character.isDigit(digit))
							{
								isNotValid = true;
								break;
							}
						}
							if(isNotValid)
							{
								error_message = "A non digit character was entered";
							}
					}
					
				}while(!error_message.equals(""));
				int object3Weight = Integer.parseInt(object3WeightString);
		
				//Inputs and validations for the second item's weight
				do
				{	
					//Prompting user to enter the first item's weights
					item_4_prompt = error_message + "\n\nInput the weight, in pounds, of the first object.\nEnter the weight as a positive integer.\n(eg. 1, 25, 4)" +
							"(Be sure not to enter any decimal points,\nnegative signs, or non digit characters.)\n\nOr press 'Q' to quit.";
					object4WeightString = JOptionPane.showInputDialog(null, item_4_prompt, "Knapsack Program - Weight 4", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(object4WeightString == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(object4WeightString.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
					}
					
					//If q is entered, the program terminates
					else if(object4WeightString.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(object4WeightString.contains("."))
					{
						error_message = "A decimal point was entered.";
					}
					
					//Data validation for number_entry containing a negative sign
					else if(object4WeightString.contains("-"))
					{
						error_message = "A negative sign was entered.";
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < object4WeightString.length(); position++)
						{
							char digit = object4WeightString.charAt(position);
							if(!Character.isDigit(digit))
							{
								isNotValid = true;
								break;
							}
						}
							if(isNotValid)
							{
								error_message = "A non digit character was entered";
							}
					}
				}while(!error_message.equals(""));
				int object4Weight = Integer.parseInt(object4WeightString);
				
				//Declaring variables needed for calculation
				int bestTotalWeight = 0;
				int triedTotalWeight = 0;
				int bestWeight1 = 0;
				int bestWeight2 = 0;
				int bestWeight3 = 0;
				int bestWeight4 = 0;
				
				//Calculations
				for(int i = 0; i<2; i++) 
				{
					for(int j = 0; j<2; j++) 
					{
						for(int k = 0; k<2; k++) 
						{
							for(int l = 0; l<2; l++) 
							{
								triedTotalWeight = (i * object1Weight) + (j * object2Weight) + (k * object3Weight) + (l * object4Weight);
								if(triedTotalWeight > bestTotalWeight && triedTotalWeight <= maxWeight) 
								{
									bestTotalWeight = triedTotalWeight;
									bestWeight1 = (i * object1Weight);
									bestWeight2 = (j * object2Weight);
									bestWeight3 = (k * object3Weight);
									bestWeight4 = (l * object4Weight);
								}
							}		
						}
					}	
				}
				
				//Forming the results
				String results = "For a maximum weight of " + maxWeight + " pounds,\nand from objects for the following weights:\n\n" + 
						object1Weight + "lbs, " + object2Weight + "lbs ," + object3Weight + "lbs, " + object4Weight + "lbs\n\n" + "The hiker can carry the following\nweights:\n\n";
				
				//Determines whether or not there should be a comma at the end.
				int commaTest = 0;
				if(bestWeight1 > 0)
				{
					results += bestWeight1 + "lbs";
					commaTest += bestWeight1;
						if(commaTest != bestTotalWeight){
							results += ", ";
						} else {
							results += " ";
						}
								
				}
	
				//Determines whether or not there should be a comma at the end.
				if(bestWeight2 > 0)
				{
					results += bestWeight2 + "lbs";
					commaTest += bestWeight2;
					if(commaTest != bestTotalWeight){
						results += ", ";
					} else {
						results += " ";
					}
							
				}
				
				//Determines whether or not there should be a comma at the end.
				if(bestWeight3 > 0)
				{
					results += bestWeight3 + "lbs";
					commaTest += bestWeight3;
					if(commaTest != bestTotalWeight){
						results += ", ";
					} else {
						results += " ";
					}
							
				}
				
				//Determines whether or not there should be a comma at the end.
				if(bestWeight4 > 0)
					results += bestWeight4 + "lbs ";
				results += " for a total of " + bestTotalWeight + " pounds";
				
				//Displaying the results
				JOptionPane.showMessageDialog(null, results, "Knapsack Problems - results", 1);

		}while(!maxWeightString.toLowerCase().equals("q"));
	}
	
}
	
