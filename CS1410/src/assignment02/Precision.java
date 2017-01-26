package assignment02;

/**
 * This program has a variable of current which is initialized to 1.0 and has a while loop as 
 * current is less than one billion increment by one.
 * 
 * At the beginning of the program, it seems like the program never finishes and the system out 
 * print when the loop is finished will never print. With some debugging with the commented out code 
 * the number never actually reaches a billion and the highest number it reaches is 1.6777216E7. The reason
 * is that a float is only holds 4 bytes of storage in the system so the maximum number is 1.6777216E7 and will
 * never truly hit one billion.
 * 
 * @author  Henry Doan
 * @version January 24, 2017
 */

public class Precision {
	
	public static void main(String[] args) {
		float current = 1;
//		float largestNumber = current;
		
		while ( current < 1_000_000_000) {
			current = current + 1;
			
			// true to see the largest number
//			if (current > largestNumber) {
//				largestNumber = current;
//			}
			
//			System.out.println(largestNumber);

		}
		
		// output the results and message
		System.out.println("The loop has finshed");
	}
}
