import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Josh Jacobsen on 3/2/2016.
 * Program Purpose:
 *  This program will take in a user chosen file representing a KenKen puzzle and solve it through node and arc consistency while displaying it with GUI
 *
 *  THe KenKenDisplay class handles painting everything onto the window
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

    /**
     * This is the constructor for the Display that assigns the puzzle to the puzzle passed inside the parameter
     * @param p - the puzzle
     */
    public KenKenDisplay(KenKenPuzzle p) {
        this.puzzle = p;
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                processClick(me);
            }
        });
    }

    /**
     * This will call the generateMove() method to display the next step of arc consistency
     * @param me - user clicking
     */
    public void processClick(MouseEvent me)
    {
        //System.out.println("\t" + selectedRow + "\t" + selectedCol);
        puzzle.generateMove();
        repaint();
    }

    /**
     * This method will create the display the the user will see inside the window
     * @param g - graphics component
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //This will draw the black background representing the borders
        g.setColor(Color.black);
        g.fillRect(start_X, start_Y, (cellSize+divWid)*puzzle.getNumRows()+divWid, (cellSize+divWid)*puzzle.getNumRows()+divWid);

        if(puzzle.getNumRows()>1){
            for(int row = 0; row < puzzle.getNumRows(); row ++){
                for(int col = 0; col < puzzle.getNumRows(); col++){

                    //This will draw the grid
                    g.setColor(Color.WHITE);
                    g.fillRect(start_X+divWid+(cellSize+divWid)*col, start_Y+divWid + (cellSize+divWid)*row, cellSize ,cellSize);

                    //create the thin line to represent constraint grouping
                    g.setColor(Color.WHITE);
                    for(int i = 0; i < puzzle.getConstraintList().size(); i++) {
                        if (!puzzle.getConstraintList().get(i).getArithSym().equals("!=")) {
                            if (puzzle.getConstraintList().get(i).getPoints().size() > 1) {
                                Variable var1 = puzzle.getConstraintList().get(i).getPoints().get(0);
                                Variable var2 = puzzle.getConstraintList().get(i).getPoints().get(1);
                                //System.out.println("got here");

                                //handles the verticle constraints
                                if (var2.getRow() > var1.getRow() && var1.getCol() == var2.getCol()) {
                                    g.fillRect(start_X + var1.getCol() * (cellSize + divWid) + divWid, start_Y + var2.getRow() * (cellSize + divWid), cellSize, divWid - 2);
                                    //g.fillRect(start_X + 2*(divWid+cellSize) + divWid, start_Y + 1 * (divWid+cellSize), cellSize, divWid-2);
                                }

                                //handles the horizontal constraints
                                if (var2.getCol() > var1.getCol() && var1.getRow() == var2.getRow()) {
                                    g.fillRect(start_X + var2.getCol() * (cellSize + divWid), start_Y + var2.getRow() * (cellSize + divWid) + divWid, divWid - 2, cellSize);
                                }
                            }
                        }
                    }

                    //This will detect and display the assignment in the lower right of each box
                    g.setColor(Color.BLACK);
                    g.setFont(bigFont);
                    for(int row1 = 0; row1 < puzzle.getNumRows(); row1++){
                        for(int col1 = 0; col1 < puzzle.getNumRows(); col1++){
                            if(puzzle.isAssigned(row1,col1)){
                                g.drawString("" + puzzle.returnAssignment(row1,col1), start_X +
                                                divWid + (cellSize + divWid) * col1 + offSet_Solution_X,
                                        start_Y + divWid + (cellSize + divWid) * row1 + offSet_Solution_Y);
                            }

//                            if(puzzle.getConstraintList().get(c).getPoints().get(p).isAssigned() && puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment() > 0) {
//                                g.drawString("" + puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment(), start_X +
//                                                divWid + (cellSize + divWid) * puzzle.getConstraintList().get(p).getPoints().get(p).getCol() + offSet_Solution_X,
//                                        start_Y + divWid + (cellSize + divWid) * puzzle.getConstraintList().get(p).getPoints().get(p).getRow() + offSet_Solution_Y);
                                //System.out.println(puzzle.getConstraintList().get(c).getPoints().get(p).getAssignment());
                            //}
                        }
                    }

                    //This will detect and display the constraint solution and symbol in the top left of the first box in the constraint list
                    g.setColor(Color.BLACK);
                    g.setFont(smallFont);
                    for(int i = 0; i < puzzle.getConstraintList().size(); i++) {
                        if (!puzzle.getConstraintList().get(i).getArithSym().equals("!=")) {
                            g.drawString("" + puzzle.getConstraintList().get(i).getArithSol() + puzzle.getConstraintList().get(i).getArithSym(),
                                    start_X + divWid + (cellSize + divWid) * puzzle.getConstraintList().get(i).getPoints().get(0).getCol(), start_Y + divWid + (cellSize + divWid) * puzzle.getConstraintList().get(i).getPoints().get(0).getRow() + offSet_Constr_Y);
                            //System.out.println(puzzle.getConstraintList().get(i).getArithSym() + puzzle.getConstraintList().get(i).getArithSol());
                        }
                    }
                }
            }
        }
    }
}
