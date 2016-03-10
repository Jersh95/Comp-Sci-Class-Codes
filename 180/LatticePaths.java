package project_euler_assignments;

/**
 * Created by Josh Jacobsen on 2/16/2016.
 */
public class Prob15 {
    public static void main(String[] args){
        //using a non-brute force mathmatical method to this problem

        //the grid will represent the graph and the values for each point will represent the possible
        //number of ways to reach the bottom right point from the current point
        double[][] grid = new double[21][21];

        //set each point in the bottom row to 1 since it can only go right
        for (int i = 0; i <= 19; i++){
            grid[20][i] = 1;
        }

        //set each point in the right column to 1 since it can only go down
        for (int i = 0; i <= 19; i++){
            grid[i][20] = 1;
        }

        //Make all other values equal to the value of point to the right + the value of the point below.
        //Start at position (20,20) and move up/to the left.
        //Start from the bottom right and not top left because this way we can calculate the number of
        //routes by starting at the (0,0) point

        for (int row = 19; row >= 0; row--)
        {
            for (int col = 19; col >= 0; col--)
            {
                grid[row][col] = grid[row+1][col] + grid[row][col+1];
            }
        }

        System.out.println("Number of possible routes: " + grid[0][0]);
    }
}