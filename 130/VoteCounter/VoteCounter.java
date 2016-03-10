/**Program: Vote Counter
 *Program Purpose: This program  will determine the results of an annual election.
 *
 *Date	12/09/2014
 *Authors:	Josh Jacobsen
 *			Tyler Laudenklos
 *			Reamonn Seamon
 *
 *Algorithm:
 *Task 1.)Create introduction method
 *		  Format introduction method
 *Task 2.)Create termination method
 *		  Format termination method
 *Task 3.)Create getFileName method
 *		  Format the method to take a file name entry as an argument and return the user entered file name for the corresponding file
 *Task 4.)Create getNumberOfCandidates method
 *		  Format the method to prompt the user to enter the number of candidates and returns this value.
 *Task 5.)Create an array for the candidates
 *		  This method will be used to store the candidate names
 *Task 6.)Read through the file
 *		  When each candidate's name is found, add a vote to their vote count
 *		  When the candidate's name is found, increase or un-change the amendment count depending on the vote for that candidate
 *Task 7.)Form the results
 *		  Display results
 * 
 **/
package assignment5;
import javax.swing.*;

import java.util.*;
import java.io.*;
public class VoteCounter 
{
	//This is to format and display the greeting
	public static void displayGreeting()
	{
		String intro = "This program will determine the results of an annual election.\n\n"
				+ "The user will be prompted to enter the file name for the candidates (candidateNames_6.txt or candidateNames_8.txt).\n"
				+ "Then, enter the number of candidates that are stored in that file. Finally, enter the file name for the votes\n"
				+ "(voteCounts_6.csv or voteCounts_8.csv.)\n\nThe program will then take this information and display the number "
				+ "of candidates, how many votes each candidate had,\nwho the winner was and how many votes they had, and finally\n"
				+ "Whether or not the amendment was passed.";
		JOptionPane.showMessageDialog(null, intro, "Vote Counter - Intro", 1);
	}
	
	//This is to format and display the termination message
	public static void displayTermination()
	{
		String termMessage = "Program now ending.";
		JOptionPane.showMessageDialog(null, termMessage, "Vote Counter - Termination", 1);
	}
	
	//This is to get the file that is entered and return it's name
	public static String getFileName(String dataInFile) throws FileNotFoundException
	{
		//Creates the file class for the file
		File file = new File (dataInFile);

		//Setting up the scanner for the file name
		Scanner fileScan = new Scanner(file);
	
		//Checking to make sure file exists
		if(!file.exists())
        {
        	JOptionPane.showMessageDialog(null, "File "+dataInFile+" not found!", "Most New Friends - File Not Found", 1);
            System.exit(0);
        }	
		return dataInFile;
	}
	
	//This is to get the number of candidates in the file
	public static int getNumberOfCandidates()
	{
		String candidatePrompt = "Please enter the number of candidates in the election.";
		String entry = JOptionPane.showInputDialog(null, candidatePrompt, "Vote Counter - Number Of Candidates", 1);
		int entryAmount = Integer.parseInt(entry);
		return entryAmount;
	}
	
	//This is to determine how many votes the candidate with the most votes has
	public static int findWinnersVotes(int[] array)
    {
    	int maxValue = array[0];
    	for(int index = 1; index < array.length; index++)
    	{
    		if (array[index] > maxValue)
    		{
    			maxValue = array[index];
    			
    		}
    	}
    	return maxValue;
    }
	
	//This is to determine who the winning candidate is
	public static String findWinner(int[] voteArray, String[] candidateArray)
    {
		int maxValue = voteArray[0];
    	int maxIndex = 0;
		String winner = candidateArray[maxIndex];
    	for(int index = 1; index < voteArray.length; index++)
    	{
    		if (voteArray[index] > maxValue)
    		{
    			maxValue = voteArray[index];
    			maxIndex = index;
    			winner = candidateArray[maxIndex];
    			
    		}
    	}
    	return winner;
    }
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		displayGreeting();
		String candidateName = "";
		do
		{
			//This will get the file name for the candidates
			String candidateNamePrompt = "Please enter the file name for the candidates.\n(candidateNames_6.txt or candidateNames_8.txt)";
			candidateName = JOptionPane.showInputDialog(null, candidateNamePrompt, "Vote Counter - Candidate File Entry", 1);
			
			//If the user enters q instead of a file name the program will end
			if(candidateName.toLowerCase().equals("q"))
			{
				displayTermination();
				System.exit(0);
			}
			
			String candidateNameFile = getFileName(candidateName);
			
			
			//This will get the number of candidates in the election and assign them to an array
			int numberOfCandidates = getNumberOfCandidates();
			File file = new File(candidateNameFile);
		    String[] candidateNamesArray = new String[numberOfCandidates];
		    
		    //This will get the file name for the vote counts
			String voteCountPrompt = "Please enter the file name for the vote count.\n(voteCounts_6.csv or voteCounts_8.csv.)";
			String voteCount = JOptionPane.showInputDialog(null, voteCountPrompt, "Vote Counter - Vote Count File Entry", 1);
			getFileName(voteCount);
		    
			//This reads the file and assigns the candidateNamesArray
		    Scanner fileScan = new Scanner(file);
		    while(fileScan.hasNext())
		    {	
			    for(int index = 0; index < numberOfCandidates; index++)
			    {
			        candidateNamesArray[index] = fileScan.nextLine();
			    }
		    }
		    
		    //This opens the voteFile
		    File voteFile = new File(voteCount);
		    Scanner voteFileScan = new Scanner(voteFile);
		    
		    //Assigns the arrays for amendment counts and the vote counts
		    int[] amendmentCount = new int[2];
		    int[] voteCounts = new int[numberOfCandidates];
		
		    //This will read through the votes file and increase the vote count for each candidate as well as the amendment vote count based on the votes
		    while(voteFileScan.hasNext())
			{
		    	int index = voteFileScan.nextInt()-1;
	    		voteCounts[index]++;
	    		int amendIndex = voteFileScan.nextInt();
	    		amendmentCount[amendIndex]++;
	    		
			}		
		    
		    //This determines whether to add a vote count to the amendment being passed or a vote being added to it not being passed
		    String amendmentResult = "";
			   if(amendmentCount[0] < amendmentCount[1])
			   	amendmentResult = "passed";
			   else
			   	amendmentResult = "did not pass";
		    
		    
		    String results = "";
		    for(int index = 0; index < numberOfCandidates; index++)
			{
				results+= voteCounts[index] + " votes: " + candidateNamesArray[index] + "\n";
			}
			JOptionPane.showMessageDialog(null, "For " + numberOfCandidates + ", the results\nof the vote are\n\n" + results 
					+ "And the election winner is " + findWinner(voteCounts, candidateNamesArray) + " with " + findWinnersVotes(voteCounts) + " votes!\n\n"
					+ "And the amendment issue " + amendmentResult + "\n" + amendmentCount[0] + " against and " + amendmentCount[1] + " for"
					, "Vote Counter - Results", 1);
	}while(true);
		
	}

}
