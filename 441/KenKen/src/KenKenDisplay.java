import javax.swing.*;
import java.awt.*;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 */
public class KenKenDisplay extends JPanel {
    private KenKenPuzzle puzzle;
    private int cellSize = 90;
    private int divWid = 6;
    int start_X = 50;
    int start_Y = 50;
    int offSet_Solution_Y = 70;
    int offSet_Solution_X = 50;
    int offSet_Constr_Y = 18;
    int offSet_Constr_X = 0;

    Font bigFont = new Font("Arial",1,40);
    Font smallFont = new Font("Arial",1,20);
    public KenKenDisplay(KenKenPuzzle p) {
        this.puzzle = p;
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(start_X, start_Y, (cellSize+divWid)*puzzle.getNumRows()+divWid, (cellSize+divWid)*puzzle.getNumRows()+divWid);

        if(puzzle.getNumRows()>1){
            for(int row = 0; row < puzzle.getNumRows(); row ++){
                for(int col = 0; col < puzzle.getNumRows(); col++){

                    g.setColor(Color.lightGray);
                    g.fillRect(start_X+divWid+(cellSize+divWid)*col, start_Y+divWid + (cellSize+divWid)*row, cellSize ,cellSize);



                    g.setColor(Color.RED);
                    g.setFont(bigFont);
                    for(int c = 0; c < puzzle.getConstraintList().size(); c++){
                        for(int p = 0; p < puzzle.getConstraintList().get(c).getPoints().size(); p++){
                            if(puzzle.getConstraintList().get(c).getPoints().get(p).isAssigned() && puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment() > 0) {
                                g.drawString("" + puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment(), start_X +
                                                divWid + (cellSize + divWid) * puzzle.getConstraintList().get(p).getPoints().get(p).getCol() + offSet_Solution_X,
                                        start_Y + divWid + (cellSize + divWid) * puzzle.getConstraintList().get(p).getPoints().get(p).getRow() + offSet_Solution_Y);
                                //System.out.println(puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment());
                            }
                        }
                    }

                    g.setColor(Color.BLUE);
                    g.setFont(smallFont);
                    for(int i = 0; i < puzzle.getConstraintList().size(); i++){
                        g.drawString(""+puzzle.getConstraintList().get(i).getArithSol()+puzzle.getConstraintList().get(i).getArithSym(),
                                start_X  + divWid+(cellSize+divWid)*puzzle.getConstraintList().get(i).getPoints().get(0).getCol(), start_Y+divWid+(cellSize+divWid)*puzzle.getConstraintList().get(i).getPoints().get(0).getRow()+offSet_Constr_Y);
                        //System.out.println(puzzle.getConstraintList().get(i).getArithSym() + puzzle.getConstraintList().get(i).getArithSol());
                    }
                }
            }
        }
    }
}
