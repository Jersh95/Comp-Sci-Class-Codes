/*Program: State Data Analyzer
 *Program Purpose: This program will allow the user to select from a menu what task they would like to see performed. These tasks include finding a state with the
 *				   maximum or minimum land mass, maximum or minimum population, or the maximum or minimum average percapita income.
 *Authors:	Josh Jacobsen
 *		    Tyler Laudenklos
 *			Raemonn Seamon
 *Date:		December 3, 2014
 *
 *Algorithm:
 *Task 1.) Display purpose
 *Task 2.) Open the file containing the information
 *		   Create arrays for the state, population, average per capita, and land size
 *		   Assign each array its value using the file
 *Task 3.) Create findMaxIndex method that takes a double array as an argument and will return the maximum index
 *		   Set maximum index to 0
 *		   Search through the file by increasing the counter by one with each iteration until the maximum index is found
 *		   Return this max index
 *Task 4.)Create findMinIndex method that takes a double array as an argument and will return the maximum index
 *		  Set maximum index to 0
 *		  Search through the file by increasing the counter by one with each iteration until the minimum index is found
 *		  Return this min index
 *Task 5.)Form menu
 *		  Display the menu and prompt user to enter one of the choices
 *		  Depending on the user's entered choice, branch to the maximum or minimum index with a switch statement
 *Task 6.)Form results
 *		  Display results
 *		  Show end of program message
 *		  
 *		  
 *		   
 */


package exercises;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class  StateDataAnalyzer
{
    
    private static int NUMBER_STATES = 50;
    
    //Loads in and assigns the state names from the file to the the array
    public static String[] loadNamesFromFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        String[] array = new String[NUMBER_STATES];
        
        Scanner fileScan = new Scanner(file);
        for(int index = 0; index < NUMBER_STATES; index++)
        {
            array[index] = fileScan.next();
            fileScan.nextLine();
        }
        return array;
    }
    
    //Loads in and assigns the percapita from the file to the the array
    public static double[] loadPercapitaFromFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];
        
        Scanner fileScan = new Scanner(file);
        for(int index = 0; index < NUMBER_STATES; index++)
        {   fileScan.next();
            array[index] = fileScan.nextDouble();
            fileScan.nextLine();
        }
        return array;
    }
    
    //Loads in and assigns the population from the file to the the array
    public static double[] loadPopulationFromFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];
        
        Scanner fileScan = new Scanner(file);
        for(int index = 0; index < NUMBER_STATES; index++)
        {   fileScan.next();
            fileScan.next();
            array[index] = fileScan.nextInt();
            fileScan.nextLine();
        }
        return array;
    }
    
    //Loads in and assigns the land size from the file to the the array
    public static double[] loadLandSizeFromFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        double[] array = new double[NUMBER_STATES];
        
        Scanner fileScan = new Scanner(file);
        for(int index = 0; index < NUMBER_STATES; index++)
        {   fileScan.next();
            fileScan.next();
            fileScan.next();
            array[index] = fileScan.nextDouble();
        }
        return array;
    }
    
    //This method searches through the array that is passed as an argument and returns the index with the highest value
    public static int findMaxIndex(double[] array)
    {
    	double maxValue = array[0];
    	int maxIndex = 0;
    	for(int index = 1; index < array.length; index++)
    	{
    		if (array[index] > maxValue)
    		{
    			maxValue = array[index];
    			maxIndex = index;
    		}
    	}
    	return maxIndex;
    }
    
    //This method searches through the array that is passed as an argument and returns the index with the lowest value
    public static int findMinIndex(double[] array)
    {
    	double minValue = array[0];
    	int minIndex = 0;
    	for(int index = 1; index < array.length; index++)
    	{
    		if (array[index] < minValue)
    		{
    			minValue = array[index];
    			minIndex = index;
    		}
    	}
    	return minIndex;
    }
    
    public static void main(String[] args) throws Exception
    {
    	//The arrays used for the program
        String fileName        = "State_Data.csv";
        String[] stateNames    = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        double[] populationData   = loadPopulationFromFile(fileName);
        double[] landSizeData  = loadLandSizeFromFile(fileName);
    	
        String intro = "This program will allow the user to select from a menu what task they would like to see performed. These tasks include finding a state with\n"
    			+ "the maximum or minimum land mass, maximum or minimum population, or the maximum or minimum average percapita income.\n\n"
    			+ "There will be a menu available for the user to select a choice from that they would like to see the information for.\n\n"
    			+ "The program will then display the data for the user's selection and then return to the menu for more choices.\n\n";
        String menu = "Enter the letter corresponding to the task you would like to complete, or Q to quit.\n\n"
				+ "A - Find the state with the maximum land mass\n"
				+ "B - Find the state with the minimum land mass.\n"
				+ "C - Find the state with the maximum population.\n"
				+ "D - Find the state with the minimum population.\n"
				+ "E - Find the state with the maximum average percapita income.\n"
				+ "F - Find the state with the minimum average percapita income.\n\n"
				+ "Q - To quit.";
    	String entry = "";
    	String results = "";
    	
    	//This program will run until the user enters a Q to exit
    	do
        {
        	int indexResult = 0;
        	entry = JOptionPane.showInputDialog(null,intro +  menu, "State Data Analyzer - Menu", 1);	
        	DecimalFormat decFor = new DecimalFormat("0.00");
        	DecimalFormat decForPop = new DecimalFormat("#");
        	//This switch statement takes the user's entry as an argument and returns it's corresponding data    	
    		//If a letter is entered the program will display the state for the requested d, along with it's other values
        	//If Q is entered the program will quit
        	switch(entry)
			{
				case "A":
				case "a":
					indexResult = findMaxIndex(landSizeData);
					results = "The state with the largest land mass is " + stateNames[indexResult] + " with a land mass of " + decFor.format(landSizeData[indexResult]) + ".\n"
							+ "It also has a population of " + decForPop.format(populationData[indexResult]) + " along with an average percapita of " + decFor.format(percapitaData[indexResult]) + ".";
					break;
				case "B":
				case "b":
					indexResult = findMinIndex(landSizeData);
					results = "The state with the lowest land mass is " + stateNames[indexResult] + " with a land mass of " + decFor.format(landSizeData[indexResult]) + ".\n"
							+ "It also has a population of " + decForPop.format(populationData[indexResult]) + " along with an average percapita of " + decFor.format(percapitaData[indexResult]) + ".";
					break;	
				case "C":
				case "c":
					indexResult = findMaxIndex(populationData);
					results = "The state with the largest population is " + stateNames[indexResult] + " with a population of " + decForPop.format(populationData[indexResult]) + ".\n"
							+ "It also has a land mass of " + decFor.format(landSizeData[indexResult]) + " along with an average percapita of " + decFor.format(percapitaData[indexResult]) + ".";
					break;
				case "D":
				case "d":
					indexResult = findMinIndex(populationData);
					results = "The state with the lowest population is " + stateNames[indexResult] + " with a population of " + decForPop.format(populationData[indexResult]) + ".\n"
							+ "It also has a land mass of " + decFor.format(landSizeData[indexResult]) + " along with an average percapita of " + decFor.format(percapitaData[indexResult]) + ".";
					
					break;
				case "E":
				case "e":	
					indexResult = findMaxIndex(percapitaData);
					results = "The state with the largest average percapita income is " + stateNames[indexResult] + " with an average percapit income of " 
							+ decFor.format(percapitaData[indexResult]) + ".\nIt also has a land mass of " + decFor.format(landSizeData[indexResult]) + " along with a population of " 
							+ decForPop.format(populationData[indexResult]) + ".";
					
					break;				
				case "F":
				case "f":
					indexResult = findMinIndex(percapitaData);
					results = "The state with the largest average percapita income is " + stateNames[indexResult] + " with an average percapit income of " 
							+ decFor.format(percapitaData[indexResult]) + ".\nIt also has a land mass of " + decFor.format(landSizeData[indexResult]) + " along with a population of " 
							+ decForPop.format(populationData[indexResult]) + ".";
					
						break;					
				case "Q":
				case "q":	
					JOptionPane.showMessageDialog(null, "Program terminating", "State Data Analyzer - End", 1);
					System.exit(0);
					break;
			}
        	JOptionPane.showMessageDialog(null, results, "Test", 1);
        	intro = "";
        }while(!entry.toLowerCase().equals("q"));

        
    }
}