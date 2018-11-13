package midterm2;

import java.util.Random;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

/*
 *  Performance test and summary of test results of comparing the merge and
 *  the merge slow class in java.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Henry Doan
 */
public class PerformanceTest {
	private static final Random rand = new Random();

	public static void main(String[] args) {
		StdOut.printf("%-12s  %-12s  %-12s %n", "number of", "time to", "time to");
		StdOut.printf("%-12s  %-12s  %-12s %n", "integers", "mergesort", "MergeSortSlow");
		StdOut.println("-------------------------------------------");

		for (int i = 1000; i <= 128000; i *= 2) {
			Integer[] numbers = getRandomIntArray(i);
			
			Stopwatch stopwatch = new Stopwatch();
			Merge.sort(numbers);
			double timeToSort = stopwatch.elapsedTime();
			
			Stopwatch stopwatch2 = new Stopwatch();
			MergeSlow.sort(numbers);
			double timeToSort2 = stopwatch2.elapsedTime();
			
			StdOut.printf("%-12d  %-12.3f %-12.3f %n", i, timeToSort, timeToSort2);
		}
		
		StdOut.println("T H E   E N D");
	}

	private static Integer[] getRandomIntArray(int size) {
		Integer[] array = new Integer[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(size);
		}
		return array;
	}
	
	/*
	 * We have the same set of numbers to merge for each test, the 
	 * regular merge class is faster than the merge slow. The reason being
	 * is because we took the auxiliary array into to the recursive
	 * function and the auxiliary array created in the recursive method
	 * every time, which takes in more performance. The regular merge sort
	 * class has the auxiliary array declared before hand in the sort and then 
	 * pass the same array into the recursive function. So we are only creating
	 * the auxiliary array once in the regular merge and multiple times in the
	 * merge slow. The performance of the merge sort slow quickly increases as
	 * there are more items to be sorted. On the other hand, the regular merge
	 * has a light growth that grows more slowly as the number of items increase.
	 */
}