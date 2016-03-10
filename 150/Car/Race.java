package lab2;
/********************************************************************
  Race.java
  Author: Josh Jacobsen
  Date: 1-30-15

  Represents a car that can accelerate, brake, and move
  Used in the race program

  Algorithm:
  1) Create variables and array of cars
  2) Create accessor method for raceCars that will return a copy of the 
     array of Cars
  3) Create addCar method that take in a car and create a copy of the
  	 input car parameter in the race car array and add it to the next
  	  open spot in the array
  4) Create accessor and mutator methods for distance and race type
  5) Create runRace method that will simulate the race and set the winner
  6) Create toString method that will form and display the results of the race  
***********************************************************************/

public class Race 
{
	//Variables for the Race class to use
	static final int DEFAULTNUMBEROFCARS = 3;
	private Car[] cars = new Car[3];
	private double distance;
	private String raceType;
	private int carCount;
	private Car winner = null;
	
	/**
	 * Creates a copy of the cars array
	 * @return temp
	 */
	public Car[] getRaceCars()
	{
		Car[] temp = new Car[3];
		for (int i = 0; i < 3; i++)
		{
			temp[i] = new Car(cars[i]);
		}
		return temp;
	
	}
	
	/**
	 * Creates a copy of the input car parameter in the race car array and
	 * adds it in the next open spot in the array
	 * @param inCars; a car object
	 * @return temp; a copy of the car object
	 */
	public void addCar(Car inCar)
	{
		cars[carCount] = new Car(inCar);
		carCount++;
	}
	
	/**
	 * Gets the distance for the race
	 * @return distance
	 */
	public double getDistance()
	{
		return distance;
	}
	
	/**
	 * Sets the distance for the race
	 * @param inDistance; the distance input by user
	 */
	public void setDistance(double inDistance)
	{
		distance = inDistance;
	}
	
	/**
	 * Gets the type of the race
	 * @return raceType
	 */
	public String getRaceType()
	{
		return raceType;
	}
	
	/**
	 * Sets the type of the race
	 * @param inRaceType; the race type input by the user
	 */
	public void setRaceType(String inRaceType)
	{
		raceType = inRaceType;
	}
	
	/**
	 * This method sets the car object winner to the winner of the race
	 * @param inWinner, this is the car object to determine the winner
	 */
	private void setWinner(Car inWinner)
	{
		winner = inWinner;
	}
	
	/**
	 * This method will run the race simulation
	 */
	public void runRace()
	{
		int value = 0;
		Dice dice = new Dice(9);
		Car currentCar = null;
		do
		{
			value = dice.roll();
			currentCar = cars[(value-1)/3];
			if((value-1)%3 == 0)
			{
				currentCar.move();
			}
			if((value-1)%3 == 1)
			{
				currentCar.brake();
			}
			if((value-1)%3 == 2)
			{
				currentCar.accelerate();
			}
			//This should run until a car's distance traveled is less than the distance
		}	while(currentCar.getdistanceTraveled()<distance);
		setWinner(currentCar);
	}
	
	/**
	 * This method displays the results for the race
	 * @return report
	 */
	public String toString()
	{
		String report = "";
		report += "This race is a " + getRaceType() + " race\n";
		report += "The distance for the race is: " + getDistance() + ".\n\n";
		report += "The racers are: " + cars[0].getOwner() + ", " + cars[1].getOwner() + " and " + cars[2].getOwner() + "\n";
		report += cars[0] + "\n" + cars[1] + "\n" + cars[2] + "\n\n";
		report += "The winner of the race is: " + winner.getOwner() + " with a max speed of " + winner.getMaxSpeed() + " and a current speed of " + winner.getCurrentSpeed();
		return report;
	}
}


