package percolationPackage;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Class to display stats of the percolation process using the
 * percolation class.
 * 
 * @author Henry Doan
 * @version September 16, 2018
 */

public class PercolationStats {	
	
	// initial variables to start percolation calculations.
	private int size;
	private int count;
	private double[] parts;
	private Percolation grid;
	 
	/**
	 * Constructor perform T independent experiments on an N-by-N grid.
	 * 
	 * @param N -- a number for the grid size.
	 *        T -- a number for the experiment size.
	 * @throws IllegalArgumenException -- when N or T is less than or equal to zero.
	 * 
	 */
	public PercolationStats(int N, int T) {
		// reassign the variables for better meaning.
		size = N;
		count = T;
		
		// cover the case of N and T being less than 0.
		if (size <= 0 || count <= 0 ) {
			throw new IllegalArgumentException(" Incoming N or T has to be more than 0");
		}
		
		parts = new double[count];			 

		for (int numEx = 0; numEx < count; numEx++) {
			// make a grid with the percolation with size.
			grid = new Percolation(size);
			
			// intial open count
			int openCount = 0;
			
			// while the grid does not percolates.
			while(!grid.percolates()) {
				// row
				int row = StdRandom.uniform(1, size + 1);
				
				// col
				int col = StdRandom.uniform(1, size + 1);
				
				// while the grid is not open, open them.
				if (!grid.isOpen(row, col)) {
					grid.open(row, col);
					openCount++;
				}
			}
			
			// fill the parts array.
			double part = (double) openCount / (size * size);
			parts[numEx] = part;	
		}
	}
	
	/**
	 * sample the mean of the percolation threshold using the StdStats jar file.
	 * 
	 * @return mean -- a calculation from the StdStats jar to get the average of the parts array.
	 * 
	 */
	public double mean() {
		double results = StdStats.mean(parts);
		return results;
	} 
	
	/**
	 * sample the standard deviation of the percolation threshold using the StdStats jar file.
	 * 
	 * @return deviation -- a calculation from the StdStats jar to get the deviation of the parts array.
	 * 
	 */
	public double stddev() {
		double deviation = StdStats.stddev(parts);
		return deviation;
	} 
	
	/**
	 * low endpoint of 95% confidence interval of the percolation 
	 * threshold using the stdev jar file and the Math library.
	 * 
	 * @return lowEndpoint -- a calculation from the stdev jar and 
	 * 						  the math library to get the low end point.
	 * 
	 */
	public double confidenceLow() {
		double lowEndpoint = mean() - ((1.96 * stddev()) / Math.sqrt(count));
		return lowEndpoint;
	}
	
	/**
	 * high endpoint of 95% confidence interval of the percolation 
	 * threshold using the stdev jar file and the Math library.
	 * 
	 * @return highEndpoint -- a calculation from the stdev jar and 
	 * 						  the math library to get the high end point.
	 * 
	 */
	public double confidenceHigh() {
		double highEndpoint = mean() + ((1.96 * stddev()) / Math.sqrt(count));
		return highEndpoint;
	}
	
	/**
	 * Give a user friendly display of all the percolation stats with
	 * given size and count.
	 * 
	 */
	public static void main(String[] args) {
		int testForSize = new Integer(args[0]);
		int testForCount = new Integer(args[1]);
		
		PercolationStats testStats = new PercolationStats(testForSize, testForCount);
		
		System.out.println("Mean: " + testStats.mean());
		System.out.println("Standard Deviation: " + testStats.stddev());
		System.out.println("Low Endpoint: " + testStats.confidenceLow());
		System.out.println("High Endpoint: " + testStats.confidenceHigh());	
	}
}
