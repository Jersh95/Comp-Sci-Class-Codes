package project_euler_assignments;

/**
 * Created by Josh Jacobsen on 1/14/2016.
 */
public class Homework3 {
    public static void main(String [ ] args){
        int sumOfSquares = 0;
        double squaredSum = 0;
        for(int i=1; i<101; i++){
            sumOfSquares += Math.pow(i,2);
            squaredSum += i;
        }
        squaredSum = Math.pow(squaredSum,2);
        System.out.println(sumOfSquares);
        System.out.println(squaredSum);
        System.out.println(squaredSum-sumOfSquares);
    }
}
