/**
 *Program: Drawing Rectangles
 *Program Purpose: This program will draw rectangles
 *
 *Author: Josh Jacobsen
 *Date: 4-3-15
 *
 *Algorithm:
 *Create the constructor
 *Create the method generateRecArray that will draw the given number of rectangles in the start spot and changes the size and coordinates by each one
 *
 */
package lab7b;

public class FormRecArray 
{
	int[][] recs;
    
    public FormRecArray(int rSeed)    
    {
        generateRecArray(rSeed);
    }
   
   
    private void generateRecArray(int numRecs)
    {
        recs = new int[numRecs][7];

        int startX = 20;
        int startY = 5;
        int width = 300;
        int height= 250;
        int colorNum1 = 10;
        int colorNum2 =50;
        int colorNum3 = 120;
       
        for(int dex = 0; dex < recs.length; dex++)
        {
            recs[dex][0] = startX;
            recs[dex][1] = startY;
            recs[dex][2] = width;
            recs[dex][3] = height;
            recs[dex][4] = colorNum1;
            recs[dex][5] = colorNum2;
            recs[dex][6] = colorNum3;
            
            startX = startX + 20;
            startY += 10;
            width += 0;
            height -= 20;
            colorNum1+= 5;
            if(colorNum1 >254)
                 colorNum1 = 10;
            colorNum2+= 6;
            if(colorNum2 >254)
                 colorNum2 = 10;
            colorNum3+= 9;
            if(colorNum3 >254)
                 colorNum3 = 10;
        }
    }
  
    public int[][] getRecs()
    {
        return recs;
    }
}
