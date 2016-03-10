import java.util.Random;

/**
 * Created by Josh on 2/25/2016.
 */
public class Puzzle {
    private int rows = 8;
    private int cols = 8;
    private int [][] assignments = { { -1,-1,-1,-1,4,-1,-1,-1 },
                                     { -1,-1,-1,-1,-1,-1,-1,-1 },
                                     { -1,-1,-1,-1,-1,9,-1,-1 },
                                     { -1,-1,-1,-1,-1,-1,-1,-1 },
                                     { -1,-1,8,-1,-1,-1,-1,-1 },
                                     { -1,-1,-1,-1,-1,-1,-1,-1 },
                                     { 6,-1,-1,-1,-1,-1,-1,-1 },
                                     { -1,-1,-1,-1,-1,-1,-1,-1 }};
    Random randGen;

    public Puzzle(int rows, int cols){
        randGen = new Random();
        this.rows =  rows;
        this.cols = cols;
        initAssignment();
    }

    public void initAssignment()
    {
        assignments = new int[rows][cols];
        for(int row = 0; row < getRows(); row++)
        {
            for(int col = 0; col < getCols(); col++)
            {
                int prob = randGen.nextInt(100);
                if(prob > 75)
                {
                    assignments[row][col] = randGen.nextInt(8)+1;
                }
                else
                {
                    assignments[row][col] = -1;
                }
            }
        }
    }


    public void generateMove(int r, int c)
    {
        int assign = randGen.nextInt(9)+1;
        assignments[r][c] = assign;
    }


    public int getAssignmnet (int r, int c){
        return assignments[r][c];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getAssignments() {
        return assignments;
    }

    public void setAssignments(int[][] assignments) {
        this.assignments = assignments;
    }
}
