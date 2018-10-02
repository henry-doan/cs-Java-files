package percolationPackage;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Class to model the percolation proces with helper methods 
 * to percolate.
 * 
 * @author Henry Doan
 * @version September 16, 2018
 */

public class Percolation {
	// initial variables to start percolation
	private int size;
	private boolean[][] grid;
	private WeightedQuickUnionUF wqf;
	private int virtualTopIndex = 0;
	private int virtualBottomIndex;
	
	/**
	 * Constructor taking in a grid size and create N­by­N grid, with all sites
	 * as well as setting initial variables base on N.
	 * 
	 * @param N -- a number for the grid size.
	 * @throws IllegalArgumenException -- when N is less than or equal to zero.
	 * 
	 */
	public Percolation(int N) {
		if (N <= 0) {
			throw new IllegalArgumentException("Incoming N has to be more than 0");
		}
		size = N;
		grid = new boolean[size][size];
		wqf = new WeightedQuickUnionUF((size * size) + 1);
		virtualBottomIndex = size * size;    
	} 
	
	/**
	 * Open the incoming site from the row and col if not open already.
	 * 
	 * @param i -- a number for the row.
	 * 		  j -- a number for the col.
	 * 
	 */
	public void open(int i, int j) {
		// reassign the variables for better meaning.
	    int row = i;
	    int col = j;
	    grid[row - 1][col - 1] = true;
	    int siteIndex = getSiteIndex(row, col);
	    
	    // open the site at the virtual top
	    if (row == 1) {
	    	wqf.union(siteIndex, virtualTopIndex); 
	    }
	    
	    // open the site at the virtual bottom
	    if (row == size) {
	    	 wqf.union(siteIndex, virtualBottomIndex);
	    }
	    	    
	    // Top of site
	    if (col > 1 && isOpen(row, col - 1)) {
	    	wqf.union(siteIndex, getSiteIndex(row, col - 1));
	    }
	    
	    // Right of site
	    if (row < size && isOpen(row + 1, col)) {
	    	wqf.union(siteIndex, getSiteIndex(row + 1, col));
	    }
	    
	    // Bottom of site
	    if (col < size && isOpen(row, col + 1)) {
	    	wqf.union(siteIndex, getSiteIndex(row, col + 1));
	    }
	    
	    // Left of site
	     if (row > 1 && isOpen(row - 1, col)) {
	     	wqf.union(siteIndex, getSiteIndex(row - 1, col));
	    }
	} 
	
	/**
	 * With the given row and col, see if the site is open.
	 * 
	 * @param i -- a number for the row.
	 * 		  j -- a number for the col.
	 * @return true -- the site is open.
	 *         false -- the site isn't open.
	 * 
	 */
	public boolean isOpen(int i, int j) {
		// reassign the variables for better meaning.
	  	int row = i;
	    int col = j;
	    
	    // return if the site is open.
	    return grid[row - 1][col - 1];
	  }
	
	/**
	 * With the given row and col, see if the site is full.
	 * 
	 * @param i -- a number for the row.
	 * 		  j -- a number for the col.
	 * @return true -- the site is full.
	 *         false -- the site is empty.
	 * 
	 */
	public boolean isFull(int i, int j) {
		// reassign the variables for better meaning.
	    int row = i;
	    int col = j;
	    
	    // check to see if the site is full
	    if (isOpen(row, col)) {
	    	for (int k = 0; k < size; k++) {
		    	if (wqf.connected(getSiteIndex(row, col) , k)) {
		    		return true;
		    	}
	    	}
	    }
	    
	    // else return false
	    return false;   
	  }
	
	/**
	 * if the virtual top and bottom are connected to see of the system 
	 * percolates.
	 * 
	 * @return if a system percolates -- boolean on if the top and bottom are connected.
	 * 
	 */
	public boolean percolates() {
		return wqf.connected(virtualTopIndex, virtualBottomIndex);
	}
	
	/**
	 * helper method with the incoming row and col, it will do the 
	 * calculation for the site's index.
	 * 
	 * @param incomingRow -- a number for the incoming row.
	 *        incomingCol -- a number for the incoming col. 
	 * @return the site Index -- a calculation from the row and col to get the site's index.
	 * 
	 */
	private int getSiteIndex(int incomingRow, int incomingCol) {
		return size * (incomingRow - 1) + incomingCol;
	}  

}
