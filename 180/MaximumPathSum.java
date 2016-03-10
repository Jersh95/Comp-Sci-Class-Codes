package project_euler_assignments.ProbSet7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Josh Jacobsen on 2/17/2016.
 */
public class Prob18 {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] bigTriangle = new int[15][15];
        int[][] smallTriangle = new int[4][4];
        String line = "";
        int scanNum = 0;
        int sum = 0;
        //int c = 0;
        String[] parts;
        File file = new File("C:\\Users\\Fresh\\Desktop\\big_triangle.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            line = scan.nextLine();
            parts = line.split(",");
            scanNum++;

            for (int i = 0; i < parts.length; i++) {
                bigTriangle[scanNum - 1][i] = Integer.parseInt(parts[i]);
            }
        }
        scan.close();

        /*This will calculate the highest path from the top down - this returns 1064
        for (int r = 0; r < bigTriangle.length; r++) {
            if (bigTriangle[r][c + 1] > bigTriangle[r][c]) {
                c++;
                sum += bigTriangle[r][c];
                System.out.println(bigTriangle[r][c] + "----- sum: " + sum);
            } else {
                sum += bigTriangle[r][c];
                System.out.println(bigTriangle[r][c] + "----- sum: " + sum);
            }
        }
        */

        //This will calculate the highest path from the bottom up - this returns 1074
        for(int r = bigTriangle.length-1; r >0; r--){
            for(int c = 0; c < bigTriangle[r].length-1; c++){
                bigTriangle[r-1][c] += Math.max(bigTriangle[r][c],bigTriangle[r][c+1]);
            }
        }
        System.out.println("The path with the max value returns a value of: " + bigTriangle[0][0]);
    }
}
