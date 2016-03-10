package project_euler_assignments.HW5;

/**
 * Created by Josh Jacobsen on 1/14/2016.
 */
public class Prob5 {
    public static void main(String [ ] args) {
        int smallestNum;
        boolean numFound;
        int count = 0;

        //Starting at 0, increase the count and check the number with the checkNum method until the correct number is found
        do{
            count++;
            numFound = checkNum(count);
            //System.out.println("Count: " + count + " numFound: " + numFound);

        }while(numFound == false);

        //once the correct number is found, set the smallestNum to the count and print it
        smallestNum = count;
        System.out.println(smallestNum);
    }

    /**
     * This method will be used to check if the number will be divisible evenly by 1-20
     * @param num - the number to be checked
     * @return - true or false, whether or not the number is divisible evenly by 1-20
     */
    public static boolean checkNum(int num){
        boolean numFound = false;
        int numCount = 0;
        int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        //loop through all of the values in the array and check if it the number is divisible evenly by all of these
        //if it is, return true
        for(int i = 0; i < values.length; i++){
            if(num%values[i] == 0)
                numCount++;
        }
        if(numCount == 20)
            numFound = true;

        return numFound;
    }
}
