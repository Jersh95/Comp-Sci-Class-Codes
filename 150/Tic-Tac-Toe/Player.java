package ticTacToe;
import javax.swing.*;
/**
 *Player.java
 * Author: Josh Jacobsen
 * Date: 2-11-15
  
 * Represents a Player to use in the game
  
 * Algorithm:
 * 1) Assign variables
 * 2) Create getGamesWon method that will return the games won for a player
 * 3) Create Player constructor for Player
 * 4) Create toString method to return the results for the Player class
 */

/**
 * This class creates the Players and stores their information
 * @author Josh Jacobsen
 *
 */
public class Player 
{
	//Variables for the Player class to use
	char name;
	int gamesWonCount;
	int gamesWon;
	/**
	 * This method will find how many games a given player has won
	 * @return the number of games won
	 */
	public int getGamesWon()
	{
		return gamesWonCount;
	}
	
	/**
	 * This is the constructor for the Player
	 * @param inName, this is the name of the player, x or o
	 */
	public Player (char inName)
	{
		name = inName;
		gamesWon = gamesWonCount;
	}
	
	/**
	 * This method will return how many games a given player has won
	 */
	public String toString()
	{
		String results = "";
		results += "player " + name + " has won " + getGamesWon() + " games";
		return results;
	}
	
}
