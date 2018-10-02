package programmingAssignment2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Sub set class to have the user input be the randomized queue
 * Assuming that 0 ≤ k ≤ N, where N is the number of string on 
 * standard input.
 * 
 * @author Henry Doan
 * @version September 27, 2018
 */

public class Subset {

	public static void main(String[] args) {
		RandomizedQueue<String> subQueue = new RandomizedQueue<String>();
		
		int k = Integer.parseInt(args[0]);
		
		// add on the queue
		while (StdIn.isEmpty() != false) {
			subQueue.enqueue(StdIn.readString());
		}
		
		// delete from queue
		for( int index = 0; index < k; index++) {
			StdOut.println(subQueue.dequeue());
		}
	}

}
