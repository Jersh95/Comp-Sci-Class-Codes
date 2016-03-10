package project_euler_assignments.HW5;

import java.math.BigInteger;

/**
 * Created by Josh Jacobsen on 2/1/2016.
 */
public class Prob20 {

    private static int sumMe(String s)
    {
        int sum = 0;

        for (int i = 0; i < s.length(); i++)
        {
            int j = Integer.parseInt(s.substring(i,i+1));
            sum += j;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        BigInteger bigI = BigInteger.valueOf(1);

        for (int i = 1; i <= 100; i++)
            bigI = bigI.multiply(BigInteger.valueOf(i));

        System.out.println(sumMe(bigI.toString()));
    }
}

