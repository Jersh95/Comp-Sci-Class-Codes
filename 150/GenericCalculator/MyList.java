/**
 * Program: ArrayList 
 * Program Purpose: This program will create ArrayLists from a generic class and calculate and display the min and max values of the list
 * Author: Josh Jacobsen
 * Date: 4/20/2015
 * 
 * Algorithm:
 * Set the class header to allow only number values inside the ArrayList
 * Create a method for min and max to search through the array and find the min and max values each
 */
package lab9;

import java.util.*;

public class MyList <T extends Number> extends java.util.ArrayList <T>
{
	public MyList()
	{
		
	}
	
	/**
	 * This method will find the min value in the ArrayList
	 * @return
	 */
	public T min()
	{
		T min = this.get(0);
		
		for(int i = 0; i<super.size(); i++)
		{
			if(this.get(i).doubleValue()<min.doubleValue())
			{
				min = this.get(i);
			}
		}
		return min;
	}
	
	/**
	 * This method will find the max value in the ArrayList
	 * @return
	 */
	public T max()
	{
		T max = this.get(0);
		
		for(int i = 0; i<super.size(); i++)
		{
			if(this.get(i).doubleValue()>max.doubleValue())
			{
				max = this.get(i);
			}
		}
		return max;
	}
	
	
}
