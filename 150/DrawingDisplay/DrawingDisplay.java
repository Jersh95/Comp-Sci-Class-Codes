/**
 *Program: Drawing Rectangles
 *Program Purpose: This program will draw rectangles
 *
 *Author: Josh Jacobsen
 *Date: 4-3-15
 *
 *Algorithm:
 *Create the window
 */
package lab7b;
import java.awt.GridLayout;

import javax.swing.*;


public class DrawingDisplay extends JFrame
{
	 int WINDOW_WIDTH = 1200;
	    int WINDOW_HEIGHT = 600;
	    int ROWS = 1;
	    int COLUMNS = 2;
	    
	    public DrawingDisplay()
	    {
	        this.setTitle("Rectangle Pyramid Like Thing");
	        this.setLayout(new GridLayout(ROWS,COLUMNS));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        FormRecArray fra = new FormRecArray(13);
	        int[][] recs = fra.getRecs();
	        
	        DrawingPanel panel = new DrawingPanel(recs);
	        
	        add(panel);
	        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
	        setVisible(true); 
	       
	    }
	    
	    public static void main(String[] args)
	    {
	        DrawingDisplay dd = new DrawingDisplay();
	    }
	
}
