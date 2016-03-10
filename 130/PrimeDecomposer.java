/*Program: PrimeDecomposer
		 *Program Purpose: This program will determine whether a positive integer is a prime number or a composite number.
		 *Author: Tyler Laudenklos, Josh Jacobsen, Reamonn Seaman
		 *Date:   10-30-2014
		 *Algorithm:
		 *1.  Show intro
		 *2.  Until user requests to stop running program by entering Q
		 *3.    Repeat
		 *4.        Prompt user to enter a positive integer
		 *5.        Check for data validations
		 *6.        Check and see if the entered number can be divided by two evenly, if not, increase the dividing number by one until it can be divided
		 *7.        If the number cannot be divided, the number is prime
		 *8.		If the number can be divided, it is a composite number, each factor will be saved and displayed in the results
		 *9.    End Repeat
		 *10.  Form results   
		 *11.  Display results
		 */
package primeDecomposer;
import javax.swing.JOptionPane;
public class PrimeDecomposer 
{

	public static void main(String[] args) 
	{
		

			
			//Display introduction message
			String intro = "This program will determine whether a positive integer\nis a prime number or a composite number.\n\nThe"
					+ " user will be asked to enter a single positive integer.\n\nThe program will take this number and calculate if "
					+ "the number\nis prime or composite and display the results to include all factors\nif it is a composite number.";
			JOptionPane.showMessageDialog(null, intro, "Prime Decomposer - Intro", 1);
			
			//Variables for number entry and result
			String number_entry = "";
			String result = "";
			String number_entry_prompt = "";
			do
			{
				
					boolean isNotValid = false;
					String error_message = "";
				do
				{	

					//Prompting user to enter a single positive integer
					number_entry_prompt = error_message + "\n\n" + "Please enter a single positive integer.\n\n(Be sure not to enter any decimal points,\nnegative signs, " +
							"or non digit characters.)\n\n(ex. 12, 2790, 33900)\n\nOr press 'Q' to quit.";
					number_entry = JOptionPane.showInputDialog(null, number_entry_prompt, "Prime Decomposer - Number Entry", 1);
					
					isNotValid = false;
					error_message = "";
					
					//Data validation for number_entry returning null
					if(number_entry == null)
					{
						error_message = "User attempted to close program.";
						isNotValid = true;
					}
					
					//Data validation for number_entry returning empty
					else if(number_entry.equals(""))
					{
						error_message = "Nothing was entered into the number entry.";
						isNotValid = true;
					}
					
					//If q is entered, the program terminates
					else if(number_entry.toLowerCase().equals("q"))
					{
						String terminate = "Thank you for using the program.\nProgram will now terminate.";
						JOptionPane.showMessageDialog(null, terminate, "Prime Decomposer - End Program", 1);
						System.exit(1);
					}
					
					//Data validation for number_entry containing a decimal point
					else if(number_entry.contains("."))
					{
						error_message = "A decimal point was entered.";						
						isNotValid = true;
					}
					
					//Data validation for number_entry containing a negative sign
					else if(number_entry.contains("-"))
					{
						error_message = "A negative sign was entered.";
						isNotValid = true;
					}
					
					//Data validation for number_entry containing a non digit character
					else
					{
						for(int position = 0; position < number_entry.length(); position++)
						{
							char digit = number_entry.charAt(position);
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
				
				//Converts the entered string into integers
				//inumber is the initial number and number is the number that gets divided
				int inumber = Integer.parseInt(number_entry);
				int number = inumber;

				//Sets up the counter and variables for the prime factors
				int prime_counter = 2;
				String primeFactors = "";
				String isPrime = " is prime";
				
				//If the number can be divided evenly by the prime counter, it will divide to obtain the prime factor
				//If the number cannot be divided evenly by the prime counter, the prime counter will increase by one
				while (number > 1 && prime_counter < inumber)
				{
					if(number % prime_counter == 0)
					{
						number = number / prime_counter;
						primeFactors += prime_counter + " X ";
					}
					else
					{
						prime_counter ++;
					}	
				}
				
				//If the primeFactors variable returns empty, the result is that the number is prime
				//If the primeFactors variable returns with numbers, the result is the list of factors
				if(primeFactors.equals(""))
				{
					result = number + isPrime;
				}
				else
				{
					result = number_entry + " = " + primeFactors.substring(0, primeFactors.length()-2);
				}
				
				//Displaying the results message box
				JOptionPane.showMessageDialog(null, result, "Prime Decomposer - Results", 1);
				
			//Loops as long as the number_entry variable does not equal 'q'
			}while(!number_entry.toLowerCase().equals("q"));
		}
}
