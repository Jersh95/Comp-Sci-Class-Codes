/*Program: Daily Sales Report
 *Purpose: This program will create a report for the daily total sales for each department and sort those transactions through cash, check, and credit card, as 
 *		   well as the total for the department.
 *Authors: Josh Jacobsen
 *		   Tyler Laudenklos
 *
 *Last Modified Date:    11/17/2014
 *Algorithm:
 *1.)Format method for displayGreeting
 *2.)Format method for formDepartmentTableRow
 *3.)Format method for formPaymentSummary
 *4.)Form greeting screen to display the greeting
 *5.)Call displayGreeting to main method
 *6.)Have user enter the file they want to open and then open the entered file
 *7.)Until the file does not have a next field
 *8.) Repeat
 *9.)	Search the file for a department name
 *10.)	Set the payment type for that department type to what follows the department name in the file
 *11.)	Add the amount that follows to the correct payment type total
 *12.)End Repeat
 *13.)Form formDepartmentTableRow to display the totals of the payment types as well as the total for the department
 *14.)Form formPaymentSummary to display the totals of each payment type for all departments as well as an overall total for everything
 *15.)
 *16.)Call formDepartmentTableRow to main method
 *17.)Call formPaymentSummary to main method
 *18.)Form results
 *19.)Display results
 *20.)Close file
 */
package assignment4;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DailySalesGenerator
{	
	public static void displayGreeting()
	{
		//This method will format the greeting that will be displayed
		String greeting = "This program will create and display a report for the daily sales showing the totals for the following departments:\n"
				+ "Kitchen Goods (kg), Clothing CL), Furniture (FU), Electronics (EL), and Miscellaneous Goods (MG).\n\n"
				+ "The user will be asked to enter one of the two available files.\n(eg. dailySales_1.csv or dailySales_2.csv)\n\n"
				+ "The program will then display the totals for each department, as well as, the overall total.";
		System.out.println(greeting);
	}
	
	public static String formDepartmentTableRow(String deptCode, double cashSales, double checkSales, double creditSales)
	{
		//This method will display each department row which displays the department name, the cash total, check total, credit total, and overall total
		double total = cashSales + checkSales + creditSales;
		String row = String.format("%-15s\t%8.2f\t%8.2f\t%8.2f\t%8.2f", deptCode, cashSales, checkSales, creditSales, total);
		return row;
	}
	
	public static String formPaymentSummary(double cashTotal, double checkTotal, double creditTotal)
	{
		//This method will format the totals row of the table which displays the totals for each payment type
		double total = cashTotal + checkTotal + creditTotal;
		String row = String.format("%18s\t%8.2f\t%8.2f\t%8.2f", cashTotal, checkTotal, creditTotal, total);
		return row;
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Display the greeting message
		displayGreeting();
	
		//Prompts the user to enter the file they want to use
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\n\nEnter the name of the file you would like the computer to use.\n");
		String fileNameEntry = keyboard.next(); 
		
		
		//Opening the file
		final String FILENAME = fileNameEntry;
		File file = new File (FILENAME);
		Scanner fileScan = new  Scanner(file);

		//Checking to make sure file exists
		if(!file.exists())
        {
        	System.out.println("File "+FILENAME+" not found!");
            System.exit(0);
        }
		
		//Searching for the Kitchen goods values
		String deptCode = "";
		String paymentType = "";
		String fileSearch = "";
		
		//For kitchen goods
		double kgCashTotal = 0;
		double kgCheckTotal = 0;
		double kgCreditTotal = 0;
		
		//For clothing
		double clCashTotal = 0;
		double clCheckTotal = 0;
		double clCreditTotal = 0;

		//For furniture
		double fuCashTotal = 0;
		double fuCheckTotal = 0;
		double fuCreditTotal = 0;
		
		//For electronics
		double elCashTotal = 0;
		double elCheckTotal = 0;
		double elCreditTotal = 0;
		
		//For misc. goods
		double mgCashTotal = 0;
		double mgCheckTotal = 0;
		double mgCreditTotal = 0;
		
		//While there is another field, the program will look for the department code(the first two characters)
		//If the department code matches KG, CL, FU, EL, or MG, it will take the rest of the line and match that as the payment type
		//If the payment type matches cash, check, or credit, the program will take the next double(the amount) and add it to the correct payment type total
		while (fileScan.hasNext())
		{
			deptCode = fileScan.next();
			if(deptCode.length()>1)
			{
				paymentType = fileScan.next();

				//For the kitchen goods totals
				if(deptCode.equals("KG"))
				{
					if(paymentType.equals("cash"))
					{
						kgCashTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("check"))
					{
						kgCheckTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("credit"))
					{
						kgCreditTotal += fileScan.nextDouble();
					}
					else
					{
						break;
					}
				}
				
				//For the clothing totals
				if(deptCode.equals("CL"))
				{
					if(paymentType.equals("cash"))
					{
						clCashTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("check"))
					{
						clCheckTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("credit"))
					{
						clCreditTotal += fileScan.nextDouble();
					}
					else
					{
						break;
					}
				}
				
				//For the furniture totals
				if(deptCode.equals("FU"))
				{
					if(paymentType.equals("cash"))
					{
						fuCashTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("check"))
					{
						fuCheckTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("credit"))
					{
						fuCreditTotal += fileScan.nextDouble();
					}
					else
					{
						break;
					}
				}
				
				//For the electronics totals
				if(deptCode.equals("EL"))
				{
					if(paymentType.equals("cash"))
					{
						elCashTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("check"))
					{
						elCheckTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("credit"))
					{
						elCreditTotal += fileScan.nextDouble();
					}
					else
					{
						break;
					}
				}
				
				//For the misc. goods totals
				if(deptCode.equals("MG"))
				{
					if(paymentType.equals("cash"))
					{
						mgCashTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("check"))
					{
						mgCheckTotal += fileScan.nextDouble();
					}
					else if(paymentType.equals("credit"))
					{
						mgCreditTotal += fileScan.nextDouble();
					}
					else
					{
						break;
					}
				}
				fileScan.nextLine();
			}
		}
		
		//Sums the totals for each department as well as an overall total
		double cashTotal = kgCashTotal + clCashTotal + fuCashTotal + elCashTotal + mgCashTotal;
		double checkTotal = kgCheckTotal + clCheckTotal + fuCheckTotal + elCheckTotal + mgCheckTotal;
		double creditTotal = kgCreditTotal + clCreditTotal + fuCreditTotal + elCreditTotal + mgCreditTotal;

		//Displays the department header row
		String header = "\n\ndepartment        cash           check           credit          total";
		System.out.println(header);
		
		//Displays the results for kitchen goods
		String kitchenGoods = formDepartmentTableRow("Kitchen goods", kgCashTotal, kgCheckTotal, kgCreditTotal);
		System.out.println(kitchenGoods);
		
		//Displays the results for clothing
		String clothing = formDepartmentTableRow("Clothing    ", clCashTotal, clCheckTotal, clCreditTotal);
		System.out.println(clothing);
		
		//Displays the results for furniture
		String furniture = formDepartmentTableRow("Furniture   ", fuCashTotal, fuCheckTotal, fuCreditTotal);
		System.out.println(furniture);
		
		//Displays the results for electronics
		String electronics = formDepartmentTableRow("Electronics ", elCashTotal, elCheckTotal, elCreditTotal);
		System.out.println(electronics);
		
		//Displays the results for misc. goods
		String miscGoods = formDepartmentTableRow("Misc. goods  ", mgCashTotal, mgCheckTotal, mgCreditTotal);
		System.out.println(miscGoods);
		
		//Displays dashed line
		String line = "----------------------------------------------------------------------------";
		System.out.println(line);
		
		////Displays the results for the totals
		String totalsWord = "totals";
		String totals = formPaymentSummary(cashTotal, checkTotal, creditTotal);
		System.out.println(totalsWord + totals);
		
		//Displays program now terminating message
		String terminateMessage = "\n\nThe program will now terminate";
		System.out.println(terminateMessage);
		
		//Closes the file
		fileScan.close();
	}
}

