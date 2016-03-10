import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Josh on 2/25/2016.
 */
public class PuzzleDisplay extends JPanel{
    Puzzle puzzle;
    int cellSize = 50;
    int divWid = 6;
    int start_X = 50;
    int start_Y = 50;
    int letterOffSet_Y = 40;
    int letterOffSet_X = 10;

    Color[] colors = {Color.red,Color.green};

    Font bigFont = new Font("Arial",1,40);

    public PuzzleDisplay(Puzzle p){
        puzzle = p;

        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                processClick(me);
            }
        });

    }

    public void processClick(MouseEvent me)
    {
        int x = me.getX();
        int y = me.getY();

        int selectedRow = (y - start_Y-divWid)/(cellSize+divWid);
        int selectedCol = (x - start_X-divWid)/(cellSize+divWid);

        //System.out.println("\t" + selectedRow + "\t" + selectedCol);
        puzzle.generateMove(selectedRow, selectedCol);
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(start_X, start_Y, (cellSize+divWid)*puzzle.getCols()+divWid, (cellSize+divWid)*puzzle.getRows()+divWid);

        for(int row = 0; row < puzzle.getRows(); row ++){
            for(int col = 0; col < puzzle.getCols(); col++){
                int colorNum = (row+col)%2;
                g.setColor(colors[colorNum]);
                g.fillRect(start_X+divWid+(cellSize+divWid)*col, start_Y+divWid+
                        (cellSize+divWid)*row, cellSize ,cellSize);

                if( puzzle.getAssignmnet(row, col) > -1)
                {
                    g.setColor(Color.YELLOW);
                    g.setFont(bigFont);
                    g.drawString(""+puzzle.getAssignmnet(row, col), start_X+
                                    divWid+(cellSize+divWid)*col+letterOffSet_X,
                            start_Y+divWid+(cellSize+divWid)*row+letterOffSet_Y);
                }


            }
        }
    }


}
