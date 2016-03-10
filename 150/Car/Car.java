package lab2;

/********************************************************************
  Car.java
  Author: Josh Jacobsen
  Date: 1-30-15
  
  Represents a car that can accelerate, brake, and move
  Used in the race program
  
  Algorithm:
  1) Assign variables
  2) Create Car method that will take in a owner and max speed arguments and 
  	 assign the car's specs
  3) Create move method that will move the car the distance of it's current speed
  	 for a minute's time
  4) Create accelerate method that will add 5 to the car's current speed as long 
  	 as it does not exceed the car's max speed
  5) Create brake method that will subtract 5 from the car's current speed as 
   	 long as it does not reach below 0
  6) Create accessor and mutator methods for currentSpeed, owner, distance traveled,
     and max speed
  7) Create to string method to form and display results
  8) Create method to reset distance and current speed   
 ***********************************************************************/

public class Car 
{
	//Variables for the Car class to use
	private String owner;
	private int currentSpeed;  //in terms of mph
	private int distanceTraveled;  // in terms of miles
	private int maxSpeed; //in terms of mph
	private static final int DEFAULTMAXSPEED = 100;

	/**
	 * Constructor initializes a car
	 * @param newOwner - owner of the car
	 * @param newMaxSpeed - max speed of the car
	 */
	public Car(String newOwner, int newMaxSpeed)
	{
		owner = newOwner;
		currentSpeed = 0;
		maxSpeed = newMaxSpeed;
		distanceTraveled = 0;
	}

	/**
	 * Default constructor
	 
	public Car()
	{
		this("no owner",DEFAULTMAXSPEED);
	}
	 */
	
	public Car(Car copy)
	{
		this(copy.getOwner(), copy.getMaxSpeed());
		distanceTraveled = copy.getdistanceTraveled();
		currentSpeed = copy.getCurrentSpeed();
	}
	
	/**
	 * Simulates the car moving 
	 * Move the car the distance it can travel at its current speed for 1 minute
	 * (update the distance traveled variable)
	 */
	public void move()
	{
		distanceTraveled += currentSpeed/60;
	}

	/**
	 * Simulates the car accelerating
	 * Add 5 miles per hour to current speed 
	 * Remember: The most the current speed can be is the maxSpeed of the car
	 */
	public void accelerate()
	{
		currentSpeed += 5;
			if(currentSpeed > maxSpeed)
			{
				currentSpeed = maxSpeed;
			}
	}	


	/**
	 * Simulates the car braking
	 * Subtracts 5 miles per hour from current speed
	 * Remember: The minimum speed for the current speed is 0
	 */
	public void brake()
	{
		currentSpeed -= 5;
			if(currentSpeed < 0)
			{
				currentSpeed = 0;
			}
	}	


	/**	Gets the current speed
	 * @return the current speed of the car
	 */
	public int getCurrentSpeed()
	{
		return currentSpeed;
	}

	/**
	 * Sets the max speed of the car
	 * @param inMaxSpeed; max speed the user inputs
	 */
	public void setMaxSpeed(int inMaxSpeed)
	{
		maxSpeed = inMaxSpeed;
	}
	
	/**	Gets the max speed
	 * @return the max speed of the car
	 */
	public int getMaxSpeed()
	{
		return maxSpeed;
	}

	/**	Gets the distance traveled
	 * @return the distance traveled for the car
	 */
	public int getdistanceTraveled()
	{
		return distanceTraveled;
	}
	
	/**
	 * Sets the owner's name
	 * @param inOwner; the name the user inputs
	 */
	public void setOwner(String inOwner)
	{
		owner = inOwner;
	}
	
	/**
	 * Gets the owner of a car
	 * @return the owner's name
	 */
	public String getOwner()
	{
		return owner;
	}


	/** 	
	 * @return the car values as a String
	 */
	public String toString()
	{
		String carValue = owner+"'s car current speed: "+currentSpeed + 
				" MPH, distance traveled: "+distanceTraveled+ " miles.";
		return carValue;
	}

	/**
	 * reset the distance traveled, to start a new race.
	 */
	public void resetDistance()
	{
		distanceTraveled = 0;
	}

	/**
	 * reset the speed, to start a new race.
	 */
	public void resetCurrentSpeed()
	{
		currentSpeed = 0;
	}
}
