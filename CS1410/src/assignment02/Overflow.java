package assignment02;

/**
 * This program has two integer variable and have one be initially assigned 0 and the other be -100.
 * The logic of the program is as the value of a is not equal to be, increment by 1. Then print out the 
 * time it take to have it be true. 
 * 
 * if we system out print the a as it increments, it seems like forever or it never gets to be negative
 * but as professor Jensen stated that the integers get stored in as binary numbers and in binary, as the
 * number increments, the binary for negative will eventually get hit and will reset from 0 in the negative 
 * direction and continue on incrementing. This whole program takes around 2 - 3 milliseconds on my computer to
 * run and all of this incrementing and logic is happening so fast, its more that the speed we can think
 * so that is why it seems to never run but it does because of binary representation.
 *
 * @author  Henry Doan
 * @version January 23, 2017
 */

public class Overflow {

	public static void main(String[] args) {
		calculation();
	}
	
	// calculation method
	public static void calculation() {
		// initialing the variables
		int a = 0;
		int b = -100;
		
		// starting the nano timer which is in nano seconds to be more accurate 
		final long start = System.nanoTime();
		
		// logic that when a is not the same value as b 
		while ( a != b) {
			// Increment a by one
			a = a + 1;
		}
		
		// end the timer outside when the loop is finished
		final long end = System.nanoTime();

		// output the results and message
		System.out.println("The loop has finshed \n");
		
		// do some math to convert the nano seconds into milliseconds
		System.out.println("The loop took: " + ((end - start) / 1_000_000) + " milliseconds to complete");
	}
}
