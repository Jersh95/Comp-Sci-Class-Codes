package ticTacToe;
import javax.swing.*;
/**
 *ticTacToe.java
 * Author: Josh Jacobsen
 * Date: 2-11-15
  
 * Represents a tictactoe gameboard
  
 * Algorithm:
 * 1) Assign variables and create a new gameboard object 
 * 2) Create playerMove method that will take in a int position and a Player p and 
 * 	  will then check if the move is valid, if so it'll make the move, if not, it
 * 	  won't make the move.
 * 3) Create checkForWinner method that will check for a winner of the game
 * 4) Create toString method to return the results for the GameBoard class
 */

/**
 * This class creates the default game board, makes the player's move, and checks for winners or if cat won
 * @author Josh Jacobsen
 *
 */
public class GameBoard 
{
	//Creates the array to hold the game board
	char[][] board = new char[3][3];
	
	/**
	 * This constructs the game board by setting the values 1-9 into their indexes
	 */
	public GameBoard()
	{
		char i = '1';
		for(char row = 0; row < board.length; row++)
		{
			for(char col = 0; col < board[row].length; col++)
			{
				board[row][col] = i;
				i++;
			}
		}
	}
	
	/**
	 * This method determines if a player can move to their requested position.
	 * If the move is valid then the move will be made.
	 * If the move is invalid then the move will not be made.
	 * @param position, this is the user requested position (index) to move to
	 * @param p, this is the player that the move is for
	 * @return true or false if the move is made
	 */
	public boolean playerMove(int position, Player p)
	{
		boolean moveMade = false;
		int row = (position-1)/ 3;
		int column = (position-1)%3;
		
		if(position <= 9 && position > 0 )
		{
			if(board[row][column] !='X' && board[row][column] != 'O')
			{
				board[row][column] = p.name;
				moveMade = true;	
			}
		}
		
		return moveMade;
	}
	
	/**
	 * This method will check if there is a winner in a row, a column, 
	 * diagonally from left to right, or diagonally from right to left.
	 * @return true or false if a winner is found
	 */
	public boolean checkForWinner()
	{
		boolean winnerFound = false;
		
		//This loop will test if a winner is found in a row
		for(int i = 0; i < board.length; i++)
		{
			if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
			{
				winnerFound = true;
			}
		}
		
		//This loop will test if a winner is found in a column
		for(int i = 0; i < board.length; i++)
		{
			if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
			{
				winnerFound = true;
			}
		}
		
		//This will test if a winner is found diagonally from left to right
		if(board[0][0] == board [1][1] && board[0][0] == board [2][2])
		{
			winnerFound = true;
		}
		
		//This will test if a winner is found diagonally from the right to left
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0])
		{
			winnerFound = true;
		}
		
		return winnerFound;
		
	}
	
	public boolean checkForCat()
	{
		boolean catWin = false;
		int counts = 0;
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				if(board[row][col] == 'X' || board[row][col] == 'O')
				{
					counts ++;
					if(counts == 9)
					{
						catWin = true;
					}
				}
			}
		}
		return catWin;
	}
	
	/**
	 * This method will reset the board to it's default value.
	 * This is to be used after a game is over and another is to be played.
	 */
	public void resetBoard()
	{
		char i = '1';
		for(char row = 0; row < board.length; row++)
		{
			for(char col = 0; col < board[row].length; col++)
			{
				board[row][col] = i;
				i++;
			}
		}
	}

	/**
	 * This displays the game board
	 */
	public String toString()
	{
		String results = "";
		for(char row = 0; row < board.length; row++)
		{
			for(char col = 0; col < board[row].length; col++)
			{
				results += board[row][col] + " ";
			}
		results += "\n";
		}
		return results;
		
	}
	
}
