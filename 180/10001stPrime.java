package project_euler_assignments.ProbSet7;

/**
 * Created by Josh Jacobsen on 2/17/2016.
 */
public class Prob7 {
    public static void main(String[] args) {
        int primeCount = 0;
        int count = 0;
        while(primeCount < 10001) {
            if (isPrime(count) == true) {
                primeCount++;
                //if (primeCount == 10001) {
                //    System.out.println("The 10,0001th prime num is: " + count);
                //}
                System.out.println("count: " + count + " --- prime: " + primeCount);
            }
            count++;
        }
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
