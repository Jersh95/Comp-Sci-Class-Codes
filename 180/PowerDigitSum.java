package project_euler_assignments.HW5;

import java.math.BigInteger;

/**
 * Created by Josh Jacobsen on 1/15/2016.
 */
public class Prob16 {
    public static void main(String[] args) {
        BigInteger expSum = new BigInteger("2");
        int exponent = 1000;
        String expSumString;
        int sum = 0;
        //int i;
        expSum = expSum.pow(exponent);
        System.out.println(expSum);
        expSumString = expSum.toString();
        System.out.println(expSumString);
        for(int i = 0; i < expSumString.length(); i++){
            System.out.println(expSumString.charAt(i));
            sum += Character.getNumericValue(expSumString.charAt(i));
        }
        System.out.print(sum);
    }
}