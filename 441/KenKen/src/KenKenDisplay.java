import javax.swing.*;
import java.awt.*;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 */
public class KenKenDisplay extends JPanel {
    private KenKenPuzzle puzzle;
    private int cellSize = 75;
    private int divWid = 6;
    int start_X = 50;
    int start_Y = 50;
    int offSet_Y = 40;
    int offSet_X = 40;

    public KenKenDisplay(KenKenPuzzle p) {
        this.puzzle = p;
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(start_X, start_Y, (cellSize+divWid)*puzzle.getNumRows()+divWid, (cellSize+divWid)*puzzle.getNumRows()+divWid);

        /*
        if(puzzle.getNumRows()>1){
            g.setColor(Color.blue);
            for(int row = 0; row < puzzle.getNumRows(); row ++){
                for(int col = 0; col < puzzle.getNumRows(); col++){
                    g.fillRect(start_X+divWid+(cellSize+divWid)*col, start_Y+divWid + (cellSize+divWid)*row, cellSize ,cellSize);
                }
            }
        }
        else {
            System.out.println(puzzle.getNumRows());
        }
        */
        /*
        if(puzzle.getNumRows()>1){
            for(int row = 0; row < puzzle.getNumRows(); row ++){
                for(int col = 0; col < puzzle.getNumRows(); col++){
                    g.setColor(Color.lightGray);
                    g.fillRect(start_X+divWid+(cellSize+divWid)*col, start_Y+divWid + (cellSize+divWid)*row, cellSize ,cellSize);
                    g.drawString(""+puzzle.getVarList(row, col), start_X+
                                    divWid+(cellSize+divWid)*col+letterOffSet_X,
                            start_Y+divWid+(cellSize+divWid)*row+letterOffSet_Y);
                }
            }
        }
        */
    }
}
