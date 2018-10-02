package life;

/**
 * A grid object represents the grid part of a life simulation.
 * The grid object keeps track of the state of each square
 * (alive, dead), and allows the user to make one step in the
 * life simulation.
 * 
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 * 
 * @author Peter Jensen
 */
public class Grid
{
    // Instance variables here.
	boolean[][] grid;
    int width;
    int height;
    
    /**
     * Constructor - creates an empty grid of the
     * specified dimensions.
     * 
     * @param width The width of the new grid
     * @param height The height of the new grid
     */
    public Grid (int width, int height)
    {
    	// first block of a 2d arr with the [] being left to right and [] being top down
    	grid = new boolean[height][width];
    	this.width = width;
    	this.height = height;
    	
    }

    /**
     * Returns true if the specified cell in the grid
     * is alive, false otherwise.  If the coordinates
     * are illegal, false is returned.
     * 
     * @param row  a row number
     * @param column a column number
     * @return true iff that cell is alive
     */
    public boolean isAlive (int row, int column)
    {
    	if(row >= height || column >= width || row < 0 || column < 0) {
    		return false;
    	}
    	
    	return grid[column][row];
    }
    
    /**
     * Sets the state of the specified cell in the
     * grid.
     * 
     * @param row a row number
     * @param column a column number
     * @param isAlive true if the grid cell should be alive
     */
    public void setCellState(int row, int column, boolean isAlive)
    {
    	grid[column][row] = isAlive;
    }
    
 
    /** 
     * Returns the width of the grid.
     * 
     * @return the width of this grid
     */
    public int getWidth ()
    {
    	return width;
    }

    /** 
     * Returns the height of the grid.
     * 
     * @return the height of this grid
     */
    public int getHeight ()
    {
    	return height;
    }
    
    /**
     * Clears the grid, all cells marked as
     * dead.
     */
    public void clear ()
    {
//    	for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
//    		for(int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
//    			grid[rowIndex][colIndex] = false;
//        	}
//    	}
    	grid = new boolean[width][height];
    	
    }
    
    /**
     * Performs one 'life' step using the standard rules
     * of life:<p>
     * 
     * Any live cell with fewer than two neighbors dies, as if by loneliness. <br> 
     * Any live cell with more than three neighbors dies, as if by overcrowding. <br>
     * Any live cell with two or three neighbors lives, unchanged, to the next generation. <br>
     * Any dead cell with exactly three neighbors comes to life.<p> 
     * 
     * Care must be taken to make sure the next generation is kept separate from the 
     * current generation.
     */
    public boolean cellFate(int row, int col) {
    	switch (countNeigbors(row, col)) {
    		case 2:
    			return isAlive (row, col);
    		case 3:
    			return true;
    		default:
    	}		return false;
    }
    
    private int countNeigbors(int row, int col) {
		int count = 0;
		
		if (isAlive(row-1, col-1)) 
			count++;
		// ... for all the surrounding points
		return count;
	}

	public void stepOneGeneration ()
    {
    	boolean[][] newArr = new boolean[width][height];
    	
    	for(int row = 0; row < height ; row++) {
    		for(int col = 0; col < width; col++) {
    			newArr[col][row] = cellFate(row, col);
        	}
    	}
    	// checks all of its numbers helper methods countliving 
    	// check the status cell fate
    }
}
