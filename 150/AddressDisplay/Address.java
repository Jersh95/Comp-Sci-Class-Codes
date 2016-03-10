/**
 *Author: Josh Jacobsen
 *Date: 3/11/2015
 *Program: Addresses
 *Program Purpose: This program will read through a text file of addresses, pick out the valid addresses, write it to a binary file, then read the binary file
 *
 *Algorithm:
 *create the constructor
 *
 */

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Address implements Serializable 
{
	//variables
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

	/**
	 * This is the constructor for the array of addresses
	 * @param name
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public Address(String name, String street, String city, String state,
			String zip, String phone) 
	{
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	/**
	 * Default constructor
	 */
	public Address()
	{
		name = "";
		street = "";
		city = "";
		state = "";
		zip = "";
		phone = "";
	}

	/**
	 *This will format how to display the addresses
	 */
	public String toString()
	{
		String display = "NAME:\t" + name + "\nSTREET:\t" + street + "\nCITY:\t"
				+ city + "\nSTATE:\t" + state + "\nZIP:\t" + zip + "\nPHONE:\t" + phone + "\n";
		return display;
	}


}
