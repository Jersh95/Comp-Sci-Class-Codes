/*Program: State Data Analyzer
 *Program Purpose: This program will allow the user to select from a menu what task they would like to see performed. These tasks include finding a state with the
 *				   maximum or minimum land mass, maximum or minimum population, or the maximum or minimum average percapita income.
 *Authors:	Josh Jacobsen
 *Date:		December 3, 2014
 *
 *Algorithm:
 *Task 1.) Display purpose
 *Task 2.) Open the file containing the information
 *		   Create arrays for the state, population, average per capita, and land size
 *		   Search through the file and assign each arrays subscript a cooperating values so that all arrays values share a common index
 *Task 3.) Create largestLandMass array
 */


package exercises;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

public class  AssociatedArraysExercise
{
    
    private static int NUMBER_STATES = 50;
    
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
    
    public static int[] loadPopulationFromFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        int[] array = new int[NUMBER_STATES];
        
        Scanner fileScan = new Scanner(file);
        for(int index = 0; index < NUMBER_STATES; index++)
        {   fileScan.next();
            fileScan.next();
            array[index] = fileScan.nextInt();
            fileScan.nextLine();
        }
        return array;
    }
    
    
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
    
    
    
    public static void main(String[] args) throws Exception
    {
        String fileName        = "State_Data.csv";
        String[] stateNames    = loadNamesFromFile(fileName);
        double[] percapitaData = loadPercapitaFromFile(fileName);
        int[] populationData   = loadPopulationFromFile(fileName);
        double[] landSizeData  = loadLandSizeFromFile(fileName);
        
        
        //This code will print the data to console to ensure you are reading
        //  the data in and that the arrays are loaded.
        //  This should be deleted once you have suceeded in laoding the data. 
        System.err.print("\nState data");
        for(int index = 0; index < NUMBER_STATES; index++)
        {
            System.err.print("\n"+stateNames[index]+"  "+percapitaData[index]+"  "+populationData[index]+"  "+landSizeData[index]);
        }
        
        //display introduction (by method)
        //create program loop with menu
        
        
    }
    
}