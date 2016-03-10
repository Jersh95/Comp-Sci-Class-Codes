package project_euler_assignments;

/**
 * Created by Josh Jacobsen on 1/14/2016.
 */
public class Homework4 {
    public static void main(String [ ] args){

        int maxLength = 0;
        int length;
        int beginNum = 0;

        //loop through numbers beginning at 13 and not exceeding 1million
        for(int i = 13; i<1000000; i++)
        {
            //create a temp variable to hold the counter as a long instead of int
            long temp = i;
            length = 0;

            //check the temp variable to make sure it is not 1
            //if it is not 1 then it will check if it is odd or even based on the logic given via the assignment
            //it will loop through this logic until it equals 1
            while(temp!=1){
                if(temp%2==0)
                {
                    temp = temp/2;
                }
                else{
                    temp = temp*3+1;
                }
                length++;
            }

            //check the length of the current number iteration against the maxLength
            //if it is bigger than the maxLength, set the current length to the max and set the current iteration
            //  to the beginning number that we need to solve the problem
            if(length > maxLength){
                maxLength = length;
                beginNum = i;
            }
        }
        System.out.println(beginNum);
    }
}
