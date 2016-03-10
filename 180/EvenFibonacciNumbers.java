package assign2;

public class Assignment2 {

	public static void main(String[] args) {
		int sum = 0;
		int temp = 0;
		int prev1 = 0;
		int prev2 = 1;
		
		do {
	        if (prev2 % 2 == 0) {
	            sum += prev2;
	        }
	        temp = prev1 + prev2;
	        prev1 = prev2;
	        prev2 = temp;
	    } while (prev2 < 4000000);
		
		System.out.println(sum);
		
	}
}
	



