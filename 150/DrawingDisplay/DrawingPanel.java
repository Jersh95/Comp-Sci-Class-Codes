package lab7b;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawingPanel extends JPanel
{
	int [][] recs;

	public DrawingPanel(int [][] r)
	{
		recs = r;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.LIGHT_GRAY);
		for(int dex = 0; dex < recs.length; dex++)
		{

			g.setColor(new Color(recs[dex][4],recs[dex][5],(recs[dex][6])));
			g.fillRect(recs[dex][0],recs[dex][1]+200,recs[dex][2],recs[dex][3]); 
		}
		
}


}
