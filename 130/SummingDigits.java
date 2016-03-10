/*Program will find the sum of the four digits of a four-digit number the user inputs
 * 
 * 	Author: Josh Jacobsen
 * Created: September 16 2014
 * 
 * Algorithm
 * 	1. Display program purpose 
 * 	2. Prompt user for a four-digit number
 * 	3. Convert numeric data type (int)
 *  4. Extract first number by dividing by 1000
 *  5. Extract 100's by mod 1000
 *  6. Extract second number by dividing by 100
 *  7. Extract 10's by mod 100
 *  8. Extract third number by dividing by 10
 *  9. Extract 1's by mod 10
 *  10. Extract fourth number by diving by 1
 *  11. Sum digits
 *  12. Form display
 *  13. Show display
 * 
 */

package exercises;

import javax.swing.JOptionPane;

public class summingDigits {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "This program will ask you to enter a positive 4 digit integer." + "\nIt will then sum all of the digits and display the sum", 
				"Summing Digits", 3);
		String number_string = JOptionPane.showInputDialog(null, "Enter a four-digit number: ", "Four-digit Number", 3);
		int num = Integer.parseInt(number_string);
		int num1 = num / 1000;
		int rem1 = num % 1000;
		int num2 = rem1 / 100;
		int rem2 = rem1 % 100;
		int num3 = rem2 / 10;
		int rem3 = rem2 % 10;
		int num4 = rem3 / 1;
		int sum = num1 + num2 + num3 + num4;
		JOptionPane.showMessageDialog(null, "The sum of the digits of the number " + num + " is\n " + num4 + " + " + num3 + " + " + num2 + " + " + num1 + " = " + sum
				+ "\n\nThis program will now terminate.", "Summing digits", 3);
	}

}
