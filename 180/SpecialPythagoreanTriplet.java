package project_euler_assignments.HW5;

/**
 * Created by Fresh on 2/1/2016.
 */
public class Prob9{
    public static void main(String[] args) {

        for(int b = 1; b < 1000; b++){
            for(int a = 1; a < b; a++){
                int c2 = (int)Math.pow(a,2) + (int)Math.pow(b,2);
                double c = Math.sqrt(c2);
                if((a+b+c) == 1000) {
                    System.out.println("A: " + a + "B: " + b + "C: " + c);
                    System.out.println(a*b*c);
                    System.exit(0);
                }
            }
        }
    }
}