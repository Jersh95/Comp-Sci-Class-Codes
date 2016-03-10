/**
 * Program: ArrayList 
 * Program Purpose: This program will create ArrayLists from a generic class and calculate and display the min and max values of the list
 * Author: Josh Jacobsen
 * Date: 4/20/2015
 * 
 * Algorithm:
 * Create an integer ArrayList from MyList
 * Have the user enter 5 integers and add those values into the integer array
 * Calculate the min and max of the integer ArrayList
 * Do the same steps for a double ArrayList
 * Print out the min and max values of each ArrayList
 */
package lab9;

import javax.swing.JOptionPane;

public class Lab9 {

	public static void main(String[] args)
	{
		int intMin;
		int intMax;
		double doubMin;
		double doubMax;
		
		//Create the integer ArrayList
		MyList <Integer> list = new MyList <Integer>();
		
		//Have the user enter the 5 values
		JOptionPane.showMessageDialog(null, "Please enter 5 integer values");
		String stringIntNum1 = JOptionPane.showInputDialog(null, "Enter the first integer");
		String stringIntNum2 = JOptionPane.showInputDialog(null, "Enter the second integer");
		String stringIntNum3 = JOptionPane.showInputDialog(null, "Enter the third integer");
		String stringIntNum4 = JOptionPane.showInputDialog(null, "Enter the fourth integer");
		String stringIntNum5 = JOptionPane.showInputDialog(null, "Enter the fifth integer");
		
		int intNum1 = Integer.parseInt(stringIntNum1);
		int intNum2 = Integer.parseInt(stringIntNum2);
		int intNum3 = Integer.parseInt(stringIntNum3);
		int intNum4 = Integer.parseInt(stringIntNum4);
		int intNum5 = Integer.parseInt(stringIntNum5);
		
		//Add the 5 values
		list.add(0,intNum1);
		list.add(1,intNum2);
		list.add(2,intNum3);
		list.add(3,intNum4);
		list.add(4,intNum5);
		
		//Calculate the min and max
		intMin = list.min();
		intMax = list.max();
		
		//Create the double ArrayList
		MyList <Double> doubList = new MyList <Double>();
		
		//Have the user enter the 5 values
		JOptionPane.showMessageDialog(null, "Please enter 5 integer values");
		String stringDoubNum1 = JOptionPane.showInputDialog(null, "Enter the first double");
		String stringDoubNum2 = JOptionPane.showInputDialog(null, "Enter the second double");
		String stringDoubNum3 = JOptionPane.showInputDialog(null, "Enter the third double");
		String stringDoubNum4 = JOptionPane.showInputDialog(null, "Enter the fourth double");
		String stringDoubNum5 = JOptionPane.showInputDialog(null, "Enter the fifth double");
		
		double doubNum1 = Integer.parseInt(stringDoubNum1);
		double doubNum2 = Integer.parseInt(stringDoubNum2);
		double doubNum3 = Integer.parseInt(stringDoubNum3);
		double doubNum4 = Integer.parseInt(stringDoubNum4);
		double doubNum5 = Integer.parseInt(stringDoubNum5);
		
		//Add the 5 values
		doubList.add(0, doubNum1);
		doubList.add(1, doubNum2);
		doubList.add(2, doubNum3);
		doubList.add(3, doubNum4);
		doubList.add(4, doubNum5);
		
		//Calculate the min and max
		doubMin = doubList.min();
		doubMax = doubList.max();
		
		//Trying to do the strings will not work since it is not a number type
		//MyList <String> stringList = new MyList <String>();
		//stringList.add(0,"String1");
		//stringList.add(1,"String2");
		//stringList.add(2,"String3");
		//stringList.add(3,"String4");
		//stringList.add(4,"String5");
		
		//Print out the min and max for integer
		System.out.println("Here are the min and max values for the integers you entered.");
		System.out.println(intMin);
		System.out.println(intMax);
		
		//Print out the min and max for double
		System.out.println("Here are the min and max values for the doubles you entered.");
		System.out.println(doubMin);
		System.out.println(doubMax);
	}

}
