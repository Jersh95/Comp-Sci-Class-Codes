package project_euler_assignments.ProbSet7;

/**
 * Created by Josh Jacobsen on 2/17/2016.
 */
public class Prob10 {
    public static void main(String[] args) {
        long primeSum = 0;
        int primeCount = 0;
        int count = 2;
        while(count < 2000000){
            if(isPrime(count) == true){
                primeCount++;
                primeSum += count;
            }
            count++;
        }
        System.out.println("count: "+count+" --- primeCount: "+primeCount+" --- primeSum: "+primeSum);
    }

    public static boolean isPrime(int n)
    {
        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
