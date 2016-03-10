package project_euler_assignments.HW5;

/**
 * Created by Josh Jacobsen on 1/15/2016.
 */
public class Prob4 {
    public static void main(String[] args) {
        int largestPalindrome = 0;
        int temp = 0;
        String tempString;
        for(int i = 100; i<1000; i++){
            for(int j = 100; j<1000; j++){
                temp = i*j;
                tempString = Integer.toString(temp);
                //System.out.println(tempString);
                String newString = new StringBuilder(tempString).reverse().toString();
                //System.out.println(newString);
                if(tempString.equals(newString) && temp > largestPalindrome){
                    largestPalindrome = temp;
                    System.out.println("The largest palindrome is: " + largestPalindrome + " which was made from " + i + "*" + j);

                }
            }
        }
    }
}
