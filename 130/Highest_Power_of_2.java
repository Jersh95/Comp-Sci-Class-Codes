package Exercises;
import javax.swing.JOptionPane;
public class Highest_Power_of_2 {

	public static void main(String[] args) 
	{
		JOptionPane.showMessageDialog(null, "This program will find the largest power of 2", "Intro Title", 1);
		String doagain = "";

		do
		{
			String enteredNumberInput = JOptionPane.showInputDialog(null, "Enter a positive integer", "Integer Input", 1);
			int enteredNumber = Integer.parseInt(enteredNumberInput);
			int power = 0;
			while (Math.pow(2, power) < enteredNumber)
			{
				power++;
			}
		
			power--;
		
			String results = "You have entered " + enteredNumber + "\n" +
				"and the highest power of 2 is " + Math.pow(2, power) + "\n" +
				"and whose exponent is " + power;
			JOptionPane.showMessageDialog(null, results, "Results", 1);
			doagain = JOptionPane.showInputDialog(null, "Would you like to rerun the program? Press Charlie for yes N for no", "Rerun?", 1);
		}
		while(doagain.toLowerCase().equals("charlie"));
		
		
		
	}

}
