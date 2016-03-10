package project_euler_assignments.HW5;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Josh Jacobsen on 1/15/2016.
 */
public class Prob13 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Fresh\\Desktop\\Prob13.txt");
        try {
            Scanner inScan = new Scanner(file);
            BigInteger sum = BigInteger.ZERO;

            while (inScan.hasNextLine()) {
                sum = sum.add(new BigInteger(inScan.nextLine()));
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file you have tried to open has not been found.");
        }
    }
}

