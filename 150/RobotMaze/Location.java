package robotMaze;
import java.util.*;

public class Location 
{
	private int row;
	private int col;
	Location()
	{
		row = 0;
		col = 0;
	}
	
	Location(int inRow, int inCol)
	{
		row = inRow;
		col = inCol;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{	
		return col;
	}
	
	public void setLocation(int inRow, int inCol)
	{
		row = inRow;
		col = inCol;
	}
		
	
}
