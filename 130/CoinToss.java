package exercises;
import java.util.*;
public class CoinToss 
{
	public static void tossCoin(int times)
	{
		Random randomGenerator = new Random();
		String toss = "";
		for (int dex = 0; dex < times; dex++)
		{
			int randomNumber = randomGenerator.nextInt(100);
			if (randomNumber < 50)
				toss = "heads";
			else
				toss = "tails";
			System.err.print("\ntoss: " + toss);
			
		}
		
	}
	public static void main(String[] args)
	{
		tossCoin(20);
	}
	
	
}
