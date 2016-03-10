package ticTacToe;

import javax.swing.*;

/**
 *TicTacToe.java
 * Author: Josh Jacobsen
 * Date: 2-11-15
  
 * This is the main driver for the Tic-Tac-Toe game
  
 * Algorithm:
 * Display purpose
 * Prompt player x to enter their move
 * Check if it is a valid move, if so, place the move, if not, have them enter another move
 * After a valid move is made, check if the player is a winner, if they are end the game and display who the winner is
 * Do these same steps for player o
 * After the game is over, prompt the players to enter 1 or 0 to play again or not
 * If 1 is entered, rerun program, otherwise exit and display the results containing the number of games and how many games each player won
 * 
 */

/**
 * This class is the main driver for the tic-tac-toe game
 * @author Josh Jacobsen
 *
 */
public class TicTacToeGameDriver 
{
	/**
	 * This is the main driver for the game, this runs the tic-tac-toe simulation
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Variables and objects to be used in this class
		//Creates the players for x, o, and c(cat)
		//Cat does not play, but is used to access the game wins if they win
		Player x = new Player('X');
		Player o = new Player('O');
		Player c = new Player ('C');
		
		//Creates the game board
		GameBoard board = new GameBoard();
		
		String intro = "";
		
		//Input and conversion variables for x and o moves
		String xMoveString = "";
		int xMove = 0;
		String oMoveString = "";
		int oMove = 0;
		
		int gameCount = 0;
		
		//Input and conversion variables for playing another game
		String againString = "";
		int again = 0;
		
		String error = "";
		
		boolean catWin = false;
		boolean moveOK = false;
		boolean winner = false;
	
		//Displays the introduction
		intro = "This program simulates a tic-tac-toe game. To play, enter the corresponding number of the space you\n"
				+ "would like to place your token during your turn. If you would like to quit the current game, enter q.\n"
				+ "However, if you do quit, you will lose the current game. After each game you will be asked\n"
				+ "if youwould like to play another, enter 1 if you would and 2 if you would not."
				+ "\n\nEnjoy!";
		JOptionPane.showMessageDialog(null,  intro, "Tic-Tac-Toe - Intro", 1);
		
		//The program will loop until they do not want to play another game
		outerloop:
		do
		{
			//The game will run until a winner is found
			winnerloop:
			do
			{
				//This asks for X's move and will determine if it is a valid move, if not it will re-ask for an entry
				do{
					//Displays the current board and asks Player X where they would like to move to
					xMoveString = JOptionPane.showInputDialog(null, board + error + "\nPlayer X, where would you like to place your token?\nEnter 1-9 or 0 to quit."
							, "Tic-Tac-Toe - Player X Move", 1);
					
					//If player X attempts to exit the program a confirmation message is displayed and program ends if user enters 1
					if(xMoveString == null)
					{
						String quitString = JOptionPane.showInputDialog(null, "Are you sure you want to quit?\nEnter 1 for yes or 0 for no", "Tic-Tac-Toe - Player X Quit", 1);
						int quit = Integer.parseInt(quitString);
						if(quit == 1)
						{
							JOptionPane.showMessageDialog(null, "Player X has quit the game.", "Tic-Tac-Toe - Player X Quit", 1);
							o.gamesWonCount ++;
							break outerloop;
						}
						else
						{
							moveOK = false;
						}
					}

					//If player X enters nothing
					else if(xMoveString.equals(""))
					{
						moveOK = false;
					}			
					
					//If player X enters 0 then the game will end and the player will lose the game
					else if(xMoveString.equals('0'))
					{
						JOptionPane.showMessageDialog(null, "Player X has quit the game.", "Tic-Tac-Toe - Player X Quit", 1);
						o.gamesWonCount ++;
						break outerloop;
					}
					
					else
					{
						xMove = Integer.parseInt(xMoveString);
					}
					
					error = "";
					moveOK = board.playerMove(xMove, x);
					
					//If player X's move is invalid it will return this error message and allow them to re-enter a move
					if(moveOK == false)
					{
						error += "There was an error with your entry, please try again";
					}	
				
				}while(moveOK == false);
				
				//Places player X's move and checks if they are a winner
				//If player X is a winner, the message prints out and updates their count of games won
				winner = board.checkForWinner();
				
				if(winner == true)
				{
					JOptionPane.showMessageDialog(null, "Player X is the winner of this game!", "Tic-Tac-Toe - Player X Wins!", 1);
					x.gamesWonCount ++;
					break;
				}
				
				if(winner == false)
				{
					catWin = board.checkForCat();
				}
				if(catWin == true)
				{
					JOptionPane.showMessageDialog(null, "Neither player has won, so the \"cat\" has beat you both!", "Tic-Tac-Toe - Cat wins!", 1);
					c.gamesWonCount++;
					break winnerloop;
				}
				
				//This loop is for player O's move
				do{
					//Displays the current board and asks Player X where they would like to move to
					oMoveString = JOptionPane.showInputDialog(null, board + error + "\nPlayer O, where would you like to place your token?\nEnter 1-9 or 0 to quit."
							, "Tic-Tac-Toe - Player O Move", 1);
					
					//If player X attempts to exit the program a confirmation message is displayed and program ends if user enters 1
					if(oMoveString == null)
					{
						String quitString = JOptionPane.showInputDialog(null, "Are you sure you want to quit?\nEnter 1 for yes or 0 for no", "Tic-Tac-Toe - Player O Quit", 1);
						int quit = Integer.parseInt(quitString);
						if(quit == 1)
						{
							JOptionPane.showMessageDialog(null, "Player O has quit the game.", "Tic-Tac-Toe - Player O Quit", 1);
							x.gamesWonCount ++;
							break outerloop;
						}
						else
						{
							moveOK = false;
						}
					}

					//If player X enters nothing
					else if(oMoveString.equals(""))
					{
						moveOK = false;
					}			
					
					//If player X enters 0 then the game will end and the player will lose the game
					else if(oMoveString.equals('0'))
					{
						JOptionPane.showMessageDialog(null, "Player O has quit the game.", "Tic-Tac-Toe - Player O Quit", 1);
						x.gamesWonCount ++;
						break outerloop;
					}
					
					else
					{
						oMove = Integer.parseInt(oMoveString);
					}
					
					error = "";
					moveOK = board.playerMove(oMove, o);
					
					//If player X's move is invalid it will return this error message and allow them to re-enter a move
					if(moveOK == false)
					{
						error += "There was an error with your entry, please try again";
					}	
				
				}while(moveOK == false);
				
				//Places player O's move and checks if they are a winner
				//If player O is a winner, the message prints out and updates their count of games won
				winner = board.checkForWinner();
				
				if(winner == true)
				{
					JOptionPane.showMessageDialog(null, "Player O is the winner of this game!", "Tic-Tac-Toe - Player O Wins!", 1);
					o.gamesWonCount ++;
					break;
				}
			
			//This loop will run until a winner is found
			}while(winner == false);
			
			//After a winner is found, the game count will increase and ask if another game is to be played. If so, program will loop.
			gameCount++;
			againString = JOptionPane.showInputDialog(null, "Would you like to play another game?\nEnter 1 for yes and 0 for no.", "Tic-Tac-Toe - Another Game?", 1);
			again = Integer.parseInt(againString);
			if(again == 1)
			{
				board.resetBoard();
			}
		
		//This loop will run until either user enters a 0 to quit the game
		}while(again == 1);
		
		//This is where the results for the total number of games and how many each player won is displayed
		String results = "";
		results += "For a total of " + gameCount + " game(s), " + x + ", " + o + ", \nand finally the cat has won " + c.getGamesWon() + " game(s)";
		JOptionPane.showMessageDialog(null, results + "\n\nProgram will now terminate\n\nAuthor: Josh Jacobsen", "Tic-Tac-Toe - Results", 1);

			
	}

}
