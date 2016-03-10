/*Program: Rock - Paper - Scissors
 *Program Purpose: This program will simulate a rock - paper - scissors game with the computer.
 *Authors:	Josh Jacobsen
 *			Tyler Laudenklos
 *Date:		November 13, 2014
 *Algorithm:
 *1.)Form methods: greeting(), generateComputersChoice(), enterPlayersChoice(int gameNumber)
 *2.)Format greeting() to display greeting
 *3.)Display greeting
 *4.)Format generateComputersChoice() to generate a random number to be 'rolled' between 0 and 3 that associates to rock, paper, or scissors and returns its choice
 *5.)Format enterPlayersChoice(int gameNumber) that prompts the user to enter a selection for rock, paper, or scissors and returns their choice 
 *6.)Form the scenario determining the winner, rock crushes scissors, paper wraps rock, scissors cuts paper
 *7.)Until the third game is played
 *8.)	Repeat
 *9.)		Prompt user to enter their choice
 *10.)		Form the results, showing the game number, what they entered, what the computer entered, what the scenario is, and who wins 
 *11.)		Display results
 *12.)	End Repeat
 *13.)Show end of program message
 */
package exercises;
import java.util.*;

import javax.swing.JOptionPane;
public class RPS_Game 
{

	public static void main(String[] args) 
	{
		//Display greeting
		greeting();
		String result = "";
		boolean youWin;
		boolean isTie;
		
		//Variables to count the wins, ties, and losses
				int wins = 0;
				int ties = 0;
				int compWins = 0;
				String outcome = "";
		
		//Prompts user entry, computer number generation, and outcome determination for the first entry
		String userChoice = enterPlayersChoice(1);
		String compChoice = generateComputersChoice();
			
		//Determinations for user winning
		if(userChoice.equals("rock") && compChoice.equals("scissors"))
		{
			youWin = true;
			result = "You win";
			outcome = "Rock crushes scissors!";
			wins++;
		}
		if(userChoice.equals("paper") && compChoice.equals("rock"))
		{
			youWin = true;
			result = "You win";
			outcome = "Paper wraps rock!";
			wins++;
		}
		if(userChoice.equals("scissors") && compChoice.equals("paper"))
		{
			youWin = true;
			result = "You win";
			outcome = "Scissors cuts paper!";
			wins++;
		}
		
		//Determination for user and computer tie
		if(userChoice.equals(compChoice))
		{
			isTie = true;
			result = "There is a tie";
			outcome = userChoice + " " + compChoice + " are the same thing";
			ties++;
		}
		
		//Determination for computer winning
		if(userChoice.equals("scissors") && compChoice.equals("rock"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Rock crushes scissors!";
			compWins++;
		}
		if(userChoice.equals("rock") && compChoice.equals("paper"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Paper wraps rock!";
			compWins++;
		}	
		if(userChoice.equals("paper") && compChoice.equals("scissors"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Scissors cuts paper!";
			compWins++;
		}
		
		//Displays the prompts for user entry for each of the three games and displays the results after each
		JOptionPane.showMessageDialog(null, "For game #1\n\nYou have played \"" + userChoice + "\" and\nComputer played \"" 
				+ compChoice + "\"\n\n" + outcome + "\n\n" + result, "Rock-Paper-Scissors - Game #1", 1);
		
		//Prompts user entry, computer number generation, and outcome determination for the second entry
		userChoice = enterPlayersChoice(2);
		compChoice = generateComputersChoice();
		//Determinations for user winning
		if(userChoice.equals("rock") && compChoice.equals("scissors"))
		{
			youWin = true;
			result = "You win";
			outcome = "Rock crushes scissors!";
			wins++;
		}
		if(userChoice.equals("paper") && compChoice.equals("rock"))
		{
			youWin = true;
			result = "You win";
			outcome = "Paper wraps rock!";
			wins++;
		}
		if(userChoice.equals("scissors") && compChoice.equals("paper"))
		{
			youWin = true;
			result = "You win";
			outcome = "Scissors cuts paper!";
			wins++;
		}
		
		//Determination for user and computer tie
		if(userChoice.equals(compChoice))
		{
			isTie = true;
			result = "There is a tie";
			outcome = userChoice + " " + compChoice + " are the same thing";
			ties++;
		}
		
		//Determination for computer winning
		if(userChoice.equals("scissors") && compChoice.equals("rock"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Rock crushes scissors!";
			compWins++;
		}
		if(userChoice.equals("rock") && compChoice.equals("paper"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Paper wraps rock!";
			compWins++;
		}	
		if(userChoice.equals("paper") && compChoice.equals("scissors"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Scissors cuts paper!";
			compWins++;
				}
		JOptionPane.showMessageDialog(null, "For game #2\n\nYou have played \"" + userChoice + "\" and\nComputer played \"" 
				+ compChoice + "\"\n\n" + outcome + "\n\n"  + result, "Rock-Paper-Scissors - Game #2", 1);
		
		//Prompts user entry, computer number generation, and outcome determination for the third entry
		userChoice = enterPlayersChoice(3);
		compChoice = generateComputersChoice();
		//Determinations for user winning
		if(userChoice.equals("rock") && compChoice.equals("scissors"))
		{
			youWin = true;
			result = "You win";
			outcome = "Rock crushes scissors!";
			wins++;
		}
		if(userChoice.equals("paper") && compChoice.equals("rock"))
		{
			youWin = true;
			result = "You win";
			outcome = "Paper wraps rock!";
			wins++;
		}
		if(userChoice.equals("scissors") && compChoice.equals("paper"))
		{
			youWin = true;
			result = "You win";
			outcome = "Scissors cuts paper!";
			wins++;
		}
		
		//Determination for user and computer tie
		if(userChoice.equals(compChoice))
		{
			isTie = true;
			result = "There is a tie";
			outcome = userChoice + " " + compChoice + " are the same thing";
			ties++;
		}
		
		//Determination for computer winning
		if(userChoice.equals("scissors") && compChoice.equals("rock"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Rock crushes scissors!";
			compWins++;
		}
		if(userChoice.equals("rock") && compChoice.equals("paper"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Paper wraps rock!";
			compWins++;
		}	
		if(userChoice.equals("paper") && compChoice.equals("scissors"))
		{
			youWin = false;
			result = "You lose";
			outcome = "Scissors cuts paper!";
			compWins++;
		}
		JOptionPane.showMessageDialog(null,"For game #3\n\nYou have played \"" + userChoice + "\" and\nComputer played \"" 
				+ compChoice + "\"\n\n" + outcome + "\n\n" + result, "Rock-Paper-Scissors - Game #3", 1);
		
		//Displays the ending total of wins, losses, and ties - WORK IN PROGRESS
		JOptionPane.showMessageDialog(null, "For a total of 3 games,\n\nThere were " + ties + " ties\nThere were " + wins + " wins for you\nThere were " + compWins
				+ " wins for the computer\n\nProgram will now terminate", "Rock-Paper-Scissors - Results", 1);
		
	}
	
	public static void greeting()
	{
		String greeting = "This program will simulate a rock - paper - scissors game that will be played against the computer.\n\n"
				+ "The user will be prompted to enter their choice of entry, rock, paper, or scissors.\n\n"
				+ "The program will then run and the user's choice will be tested against the choice generated by the computer.\n"
				+ "The results will be displayed and the game will continue for a total of three rounds.\n\nGood Luck!";
		JOptionPane.showMessageDialog(null, greeting, "Rock-Paper-Scissors - Greeting", 1);	
	}
	
	public static String generateComputersChoice()
	{
		//Generates the computer's choice
		Random randomGenerator = new Random();
		String compChoice = "";
		int randomNumber = randomGenerator.nextInt(3);
		if(randomNumber == 0)
			compChoice = "rock";
		if(randomNumber == 1)
			compChoice = "paper";
		if(randomNumber == 2) 
			compChoice = "scissors";	
		return compChoice;
	}
	
	public static String enterPlayersChoice(int gameNumber)
	{
		//Generates the user's choice
		
		String userChoice = "";
		String userEntry;	
		String error_message = "";   
     	do
     	{
     		
        	//Prompts user to enter the word and validates the data
     		String userPrompt = error_message + "\n\n" + "Please enter your choice for game #" + gameNumber + "\nEnter:\n"
				+ "          \"R\" for rock.\n" + "          \"P\" for paper.\n" + "          \"S\" for scissors.\n"
				+ "\nOr press 'Q' to exit program";
			userEntry = JOptionPane.showInputDialog(null, userPrompt, "Rock - Paper - Scissors - Selection", 1);
			
			error_message = "";
			if(userEntry == null)
			{
				error_message = "User requested to terminate program.";
				JOptionPane.showMessageDialog(null, "User has requested to terminate program.", "Rock - Paper - Scissors - End Program", 1);
				System.exit(0);
			}
			
			if(userEntry.equals(""))
			{
				error_message = "A selection has not been entered. Please try again.\n\n";
			}
			
			if(userEntry.toLowerCase().equals("q"))
			{
				error_message = "User has requested to terminate program.";
				JOptionPane.showMessageDialog(null, "User has requested to terminate program.", "Rock - Paper - Scissors - End Program", 1);
				System.exit(0);
			}
			
     	}while(!error_message.equals(""));
		
     	//Shows what the user's choice will be depending on what they enter
		if(userEntry.toLowerCase().equals("r"))
			userChoice = "rock";
		if(userEntry.toLowerCase().equals("p"))
			userChoice = "paper";
		if(userEntry.toLowerCase().equals("s"))
			userChoice = "scissors";
		return userChoice;	
	}
}
