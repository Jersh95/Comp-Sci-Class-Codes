/*
 *CSIS 150 Lab 1
 *Program:  Lab 1 - Temperatures 
 *Program Purpose: This program will read monthly temperatures for 6 years from a file and will then output monthly and 
 *				   yearly averages, as well as values for individually requested months 
 *Author: Josh Jacobsen
 *Date:   1-16-15
 *
 *Algorithm:
 *For the getAverage method:
 *Create this method to accept a single dimensional array as its argument
 *Search through the array and add all of the amounts to a running total
 *Return this total
 *
 *For the getColumnAverage method:
 *Create this method to accept a 2d array as its first argument and an integer as its second
 *This should start at 0 to find the first year's average and be incremented each time called to find all 6 averages
 *Find the column's average and return this value 
 *
 *For the getMonthValues method:
 *Create this method to accept a 2d array as its first argument and an integer as its second
 *This should start at 0 to find the first month's average and be incremented each time called to find all 12 averages
 *Find the row's average and return this value 
 *
 *For the readFile method:
 *Initialize a two dimensional method to hold the temperatures
 *Read through the file and, using a split, put each line into a single dimensional String array without the commas
 *Assign each amount to the appropriate index for the temperatures array
 *Return this array
 *
 *For the getFile method:
 *Assign the file name
 *Validate the file's existence
 *Return this file name
 *
 *For the main method:
 *Display purpose
 *Form the results by calling the methods
 *Display results
 */

package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class Lab1Temperatures 
{
	//Final variables for number of years and months
	final static int MONTHS = 12;
	final static int NUMYEARS = 6;
	

	/**
	 * This method will tell the program which file to use
	 * @return Scanner file for input, the file name is returned
	 * @throws IOException
	 */
	public static File getFile() throws FileNotFoundException
	{
		//Opening the file
		final String FILENAME = "newTempData.csv";
		File file = new File (FILENAME);
		
		//Checking to make sure file exists
		if(!file.exists())
        {
        	System.out.println("File "+FILENAME+" not found!");
            System.exit(0);
        }
		
		return file;
	}
	
	/**
	 * This method will get the monthly average
	 * @param rowArray, this is a one dimensional array of doubles to find the average
	 * @return, this will return the average from the row
	 */
	public static double getAverage(double[] rowArray)
	{
		double sum = 0;
		for (int row=0; row<rowArray.length; row++)
		{
			sum +=rowArray[row];
		}
		return sum/rowArray.length;
	}
	
	/**
	 * This method will find the yearly averages 
	 * @param tempArray, this is a two dimensional array holding all the temperatures
	 * @param colSub, this will determine which column to find the data in
	 * @return
	 */
	public static double getColumnAverage(double[][] tempArray, int colSub)
	{
		double sum = 0;
		for(int row = 0; row < MONTHS; row++)
		{
			sum += tempArray[row][colSub];
		}
		return sum/MONTHS;	
	}
	
	/**
	 * This method will find the monthly values
	 * @param tempsArray, this is a two dimensional array that stores all of the temperatures
	 * @param month, this will tell the method which month to find the data of
	 * @return, the monthly values are returned as a string
	 */
	public static String getMonthValues(double[][] tempsArray, int month)
	{
		String monthValues = "";
		for(int i = 0; i < tempsArray[month].length; i++)
		{
			monthValues+=tempsArray[month][i]+ "\t";
		}
		return monthValues;
	}

	/**
	 * This method will read in the file and assign the temperature values to the temperatures array
	 * @param inputFile, the file containing the data
	 * @return, the array containing the temperatures is returned
	 * @throws IOException
	 */
	public static double[][] readFile(File inputFile) throws IOException 
	{
		Scanner fileScan = new Scanner(inputFile);
		int m=0;//current month value to store temperatures
		double [][] temperatures = new double[MONTHS][NUMYEARS];
		while (fileScan.hasNext()&& m<MONTHS)
		{
			//read one month's data 
			String monthData = fileScan.nextLine();
			String[] splitData = monthData.split(",");
			for(int i = 0; i < NUMYEARS; i++)
			{
				temperatures[m][i] = Double.parseDouble(splitData[i+1]);
			}
			m++;	
		}
		fileScan.close();
		return temperatures;
	}

	/**
	 * In this method, the output is configured, formatted, and displayed
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		DecimalFormat decFor = new DecimalFormat("0.00");
		File inputFile = getFile();

		//Store the month names
		String[] months = {"January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October",
				"November", "December"};

		//Store the temperatures for the first day of the month for six years
		//into a two dimensional array, by calling the readFile method
		double[][] temperatures = readFile(inputFile);
		
		//This loop figures and prints out each month, it's data, and the average temperature
		System.out.println("Month\t\tTemperatures\t\t\t\t\t\tAverages");
		for(int i = 0; i < MONTHS; i++)
		{
			String thisMonth = months[i];
			String thisMonthData = getMonthValues(temperatures, i);
			double thisMonthAverage = getAverage(temperatures[i]);
			String formattedString = String.format("%-15s %s %15s", thisMonth, thisMonthData, decFor.format(thisMonthAverage));
			System.out.println(formattedString);
		}
		
		//This month figures and prints out the yearly averages
		System.out.print("Average column (Yearly) temperatures\n\t\t");
		for(int i = 0; i < NUMYEARS; i++)
		{
			double thisYearAverage = getColumnAverage(temperatures, i);
			String fomattedString = String.format("%-8s", decFor.format(thisYearAverage));
			System.out.print(fomattedString);
		}
		
		//A kind Thank You message
		System.out.println("\nThank you.");
	}	
}


