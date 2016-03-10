/**
 *Author: Josh Jacobsen
 *Date: 2-27-2015
 *
 *Algorithm:
 *Display intro
 *Prompt user to enter username
 *Prompt user to enter password
 *Check if the password contains the following criteria:
 *1 uppercase
 *1 lowercase
 *1 special character
 *1 digit
 *at least 6 characters long
 *is not one of the unallowed passwords
 *Display the current username and password
 *Reverse the password and display the username and reversed password
 *Encrypt the password(change it to ***'s) and display the username and encrypted password
 *
 */
package lab5;
import javax.swing.JOptionPane;

public class Password 
{
	//This array holds the passwords that are unallowed
	private static String[] notAllowed = new String[] {"Password1", "Mypassw0rd", "Passmyw0rd"};
	
	/**
	 * This method checks to see if the password is the correct length
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the length is correct
	 */
	private static boolean hasLength(String inPassword)
	{
		boolean hasLength = false;
		if(inPassword.length() >= 6)
			hasLength = true;
		if(hasLength == false)
			JOptionPane.showMessageDialog(null, "Your password must be at least 6 characters long, try again.", "Password - Unallowed Entry", 1);
		return hasLength;
		
	}
	
	/**
	 * This method checks to see if the password has an uppercase letter
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the password has an uppercase letter
	 */
	private static boolean hasUpperCase(String inPassword)
	{
		boolean hasUpperCase = false;
		char ch = ' ';
		for(int i = 0; i < inPassword.length() && hasUpperCase == false; i++)
		{
			ch = inPassword.charAt(i);
			if(Character.isUpperCase(ch))
				hasUpperCase = true;
		}
		if(hasUpperCase == false)
			JOptionPane.showMessageDialog(null, "Your password must contain an uppercase, try again.", "Password - Unallowed Entry", 1);
		return hasUpperCase;
	}
	
	/**
	 * This method checks to see if the password has a lowercase letter
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the password has a lowercase letter
	 */
	private static boolean hasLowerCase(String inPassword)
	{
		boolean hasLowerCase = false;
		char ch = ' ';
		for(int i = 0; i < inPassword.length() && hasLowerCase == false; i++)
		{
			ch = inPassword.charAt(i);
			if(Character.isLowerCase(ch))
				hasLowerCase = true;
		}
		if(hasLowerCase == false)
			JOptionPane.showMessageDialog(null, "Your password must contain a lowercase letter, try again.", "Password - Unallowed Entry", 1);
		return hasLowerCase;
	}
	
	/**
	 * This method checks to see if the password has a special character
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the password has a special character
	 */
	private static boolean hasSpecial(String inPassword)
	{
		boolean hasSpecial = false;
		
		//Found this code online, it should check that anything that is not in this criteria will be counted as a special character
		if(!inPassword.matches("[A-Za-z0-9]*"))
			hasSpecial = true;
		
		if(hasSpecial == false)
			JOptionPane.showMessageDialog(null, "Your password must contain a digit, try again.", "Password - Unallowed Entry", 1);
		return hasSpecial;
	}
	
	/**
	 * This method checks to see if the password has a digit
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the password has a digit
	 */
	private static boolean hasDigit(String inPassword)
	{
		boolean hasDigit = false;
		for(int i = 0; i < inPassword.length() && hasDigit == false; i++)
		{
			if(Character.isDigit(inPassword.charAt(i)))
				hasDigit = true;	
		}
		
		if(hasDigit == false)
			JOptionPane.showMessageDialog(null, "Your password must contain a digit, try again.", "Password - Unallowed Entry", 1);
		return hasDigit;
	}
	
	/**
	 * THis method checks to see if the password is one of the unallowed passwords
	 * @param inPassword - this is the password entered by user
	 * @return - this returns true if the password is not one of the unallowed passwords
	 */
	private static boolean hasUnallowed(String inPassword)
	{
		boolean hasUnallowed = false;
		for(int i = 0; i < notAllowed.length && hasUnallowed == false; i++)
		{
			if(inPassword == notAllowed[i])
				hasUnallowed = true;
		}
		if(hasUnallowed == true)
		{
			JOptionPane.showMessageDialog(null, "You have entered one of the unallowed passwords, try another.", "Password - Unallowed Entry", 1);
		}
		return hasUnallowed;
	}
	
	public static void main(String[] args) 
	{
		//Displays the intro and password criteria
		String intro = "You will be prompted to enter your username and a password that contains the following criteria:\n"
				+ "1 uppercase letter\n"
				+ "1 lowercase letter\n"
				+ "1 digit\n"
				+ "1 special character\n"
				+ "Must be 6 characters or longer";
		JOptionPane.showMessageDialog(null, intro, "Password - Intro", 1);
		String password = "";
		String userString = "Enter your username:";
		String username = "";
		username = JOptionPane.showInputDialog(null, userString, "Password - Username", 1);
		
		do
		{	
			do
			{
				do
				{
					do
					{
						do
						{
							do
							{
								password = JOptionPane.showInputDialog(null, "Enter a password:", "Password - Entry", 1);
							}while(hasLength(password) == false);
						}while(hasUpperCase(password) == false);
					}while(hasLowerCase(password) == false);
				}while(hasSpecial(password) == false);
			}while(hasDigit(password) == false);
		}while(hasUnallowed(password) == true);
		
		//This displays the current username and password
		String display = "Your username is: " + username + "\nand your password is: " + password;
		JOptionPane.showMessageDialog(null, display, "Password - Results", 1);
		
		//This block reversed the password
		String reversePassword = "";
		for ( int i = password.length() - 1 ; i >= 0 ; i-- )
	         {
				reversePassword +=  password.charAt(i);
	         }
		String reverseDisplay = "Your username is: " + username + "\nand your reversed password is: " + reversePassword;
		JOptionPane.showMessageDialog(null, reverseDisplay, "Password - Reverse Results", 1);
		
		//This block will encrypt the password by changing all of the characters to *
		char ch = ' ';
		String encryptPassword = "";
		for(int i = 0; i < password.length(); i++)
		{
			ch = password.charAt(i);
			ch = '*';
			encryptPassword += ch;
		}
		String encryptDisplay = "Your username is: " + username + "\nand your encrypted password is: " + encryptPassword;
		JOptionPane.showMessageDialog(null, encryptDisplay + "\nAuthor: Josh Jacobsen", "Password - Encrypt Results", 1);

	}

}
